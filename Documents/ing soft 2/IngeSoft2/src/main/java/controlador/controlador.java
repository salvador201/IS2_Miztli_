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


@RequestMapping(value = "/verCliente", method = RequestMethod.POST)
    public ModelAndView ConsultarCliente(ModelMap model,HttpServletRequest request){

       String id_cliente = request.getParameter("id_cliente"); 
       Cliente un_cliente= cliente_bd.verCliente(Long.parseLong(id_cliente));
     
       String correo=un_cliente.getCorreo();
       String pass=un_cliente.getPassword();
       String nom_cli=un_cliente.getNombre_cliente();
       String nombre_cliente=un_cliente.getNombre_cliente();
       String telefono_local=un_cliente.getTelefono_local();
       String telefono_movil=un_cliente.getTelefono_movil();
       String nombre_usuario=un_cliente.getNombre_usuario();
       String area=un_cliente.getArea();
       String puesto=un_cliente.getPuesto();
       String nombre_empresa=un_cliente.getNombre_empresa();
       int habilitado=un_cliente.getHabilitado();
       
       
       model.addAttribute("id_cliente", id_cliente);
       model.addAttribute("correo", correo);
       model.addAttribute("pass", pass);
       model.addAttribute("nom_cli", nom_cli);
       model.addAttribute("nombre_cliente", nombre_cliente);
       model.addAttribute("telefono_local", telefono_local );
       model.addAttribute("telefono_movil", telefono_movil);
       model.addAttribute("nombre_usuario", nombre_usuario);
       model.addAttribute("area", area);
       model.addAttribute("puesto", puesto);
       model.addAttribute("nombre_empresa", nombre_empresa);
       model.addAttribute("habilitado",habilitado);
       return new ModelAndView("datos",model);   
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
    
       
       Cliente c =new Cliente(correo,password,Nombre_Cliente,Telefono_Local,Telefono_Movil,Nombre_Usuario,Area,Puesto,Nombre_Empresa,1);
       cliente_bd.crearCliente(c);
   
       return "redirect:/home";   
   }

}
