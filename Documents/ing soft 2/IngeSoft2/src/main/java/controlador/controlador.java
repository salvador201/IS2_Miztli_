/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import MapeoBD.Cliente;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import modelo.ClienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Marco
 */
@Controller
public class controlador {
    
    @Autowired
    private ClienteDAO cliente_bd;
    
    
    
  @RequestMapping(value = "/")
  public String index(ModelMap model){
      return "index";
  }
 


@RequestMapping(value = "/salir", method=RequestMethod.GET)
public String salir(ModelMap model, HttpServletRequest a){
    a.getSession().invalidate();
    return "redirect:/";
}

@RequestMapping(value = "/prueba", method=RequestMethod.GET)
public String prueba(ModelMap model, HttpServletRequest a){
    if(a.getSession().getAttribute("login") == null){
         return "redirect:/";
     }
    return "prueba";
}

@RequestMapping(value = "/crear", method=RequestMethod.GET)
public String crear(HttpServletRequest a){
     if(a.getSession().getAttribute("login") == null){
         return "redirect:/";
     }
    return "crear";
}


@RequestMapping(value = "/show", method=RequestMethod.GET)
public ModelAndView mostrarc(ModelMap model, HttpServletRequest a, RedirectAttributes redirect){
    Cliente cliente = cliente_bd.verCliente(Long.parseLong(a.getParameter("id")));
    if(cliente.getHabilitado() == 1){
        model.addAttribute("checado", "checked");
    }
    model.addAttribute("cliente", cliente);
    return new ModelAndView("cliente", model);
    
}

@RequestMapping(value = "/home", method=RequestMethod.GET)
public ModelAndView home(ModelMap model, HttpServletRequest a, RedirectAttributes redirect){
    List b = cliente_bd.getClientes();
    if(a.getSession().getAttribute("login") != null){
        model.addAttribute("clientes",b);
        model.addAttribute("login", a.getSession().getAttribute("login"));
    return new ModelAndView("home", model);
    }else{
        if((String) (redirect.getFlashAttributes().get("login")) !=null){
        a.getSession(true).invalidate();
        a.getSession(true).setAttribute("login", (String) (redirect.getFlashAttributes().get("login")));
        model.addAttribute("clientes",b);
        model.addAttribute("login", a.getSession().getAttribute("login"));
        return new ModelAndView("home", model);
        }
    }
    return new ModelAndView("redirect:/");
}

@RequestMapping(value = "/login", method=RequestMethod.POST)
public ModelAndView login(ModelMap model, HttpServletRequest a, RedirectAttributes redirect){
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String email = String.valueOf(a.getParameter("email"));
    System.out.println(email);
    String pass = String.valueOf(a.getParameter("passw"));
    System.out.println(pass);
    if(email.equals("hqr@hqr.com")){
        if(pass.equals("hqr")){
            redirect.addFlashAttribute("login", "Admin");
        a.getSession(true).setAttribute("login", "Admin");
        
        return new ModelAndView("redirect:/home");
        }
    }
    model.addAttribute("no", "Usuario no valido!" );
    return new ModelAndView("index", model);
}



    
     @RequestMapping(value = "/borraCliente", method = RequestMethod.POST)
    public ModelAndView borrarCliente(ModelMap model,HttpServletRequest request){

       String id_cliente = request.getParameter("id_cliente"); 
       cliente_bd.borrarCliente(Long.parseLong(id_cliente));
     
       model.addAttribute("id_cliente", id_cliente);
       
   
       return new ModelAndView("confirmacion",model);   
   }
    
     @RequestMapping(value = "/crearCliente", method = RequestMethod.POST)
    public String creaCliente(ModelMap model,HttpServletRequest request){
       String correo = request.getParameter("correo"); 
       String password = request.getParameter("password"); 
       String Nombre_Cliente = request.getParameter("Nombre_Cliente"); 
       String Telefono_Local = request.getParameter("Telefono_Local"); 
       String Telefono_Movil = request.getParameter("Telefono_Movil"); 
       String Nombre_Usuario = request.getParameter("Nombre_Usuario"); 
       String Area = request.getParameter("Area"); 
       String Puesto = request.getParameter("Puesto"); 
       String Nombre_Empresa = request.getParameter("Nombre_Empresa"); 
       String ape_pa=request.getParameter("apellidop");
       String ape_ma=request.getParameter("apellidom");
       
       Cliente c =new Cliente(correo,password,Nombre_Cliente,ape_pa,ape_ma,Telefono_Local,Telefono_Movil,Nombre_Usuario,Area,Puesto,Nombre_Empresa,1);
       c.setRol("ROL_CLIENTE");
       cliente_bd.crearCliente(c);
   
       return "redirect:/home";   
   }

     @RequestMapping(value = "/modificarCliente", method = RequestMethod.POST)
    public ModelAndView modificarCliente(ModelMap model,HttpServletRequest request){

       String id_cliente = request.getParameter("id_cliente"); 
       String correo = request.getParameter("correo"); 
       String password = "hola"; 
       String Nombre_Cliente = request.getParameter("Nombre_Cliente");
       String ape_pa=request.getParameter("apellidop");
       String ape_ma=request.getParameter("apellidom");
       String Telefono_Local = request.getParameter("Telefono_Local"); 
       String Telefono_Movil = request.getParameter("Telefono_Movil"); 
       String Nombre_Usuario = request.getParameter("Nombre_Usuario"); 
       String Area = request.getParameter("Area"); 
       String Puesto = request.getParameter("Puesto"); 
       String Nombre_Empresa = request.getParameter("Nombre_Empresa");
       int habilitado;
       if (request.getParameter("habilitado") == null ){
           habilitado = 0;
           
       }else{
           habilitado = 1;
       }
       
       
       Cliente c =new Cliente(correo,
               password,
               Nombre_Cliente,
               ape_pa,
               ape_ma,
               Telefono_Local,
               Telefono_Movil,
               Nombre_Usuario,Area,Puesto,Nombre_Empresa,habilitado);
       
       cliente_bd.modificaCliente(c,Long.parseLong(id_cliente));
       model.addAttribute("id_cliente", id_cliente);
       return new ModelAndView("redirect:/show?id="+id_cliente);   
   }
}
