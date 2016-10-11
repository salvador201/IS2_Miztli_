/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import MapeoBD.Cliente;
import MapeoBD.Proyecto;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import modelo.ClienteDAO;
import modelo.ProyectoDAO;
import static org.apache.commons.codec.digest.DigestUtils.md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    
    @Autowired
    private ProyectoDAO proyecto_bd;
    
    

 




@RequestMapping(value = "/administrador/prueba", method=RequestMethod.GET)
public String prueba(ModelMap model, HttpServletRequest a){
   
    return "prueba";
}

@RequestMapping(value = "/crear", method=RequestMethod.GET)
public String crear(HttpServletRequest a){
     
    return "crear";
}


@RequestMapping(value = "/administrador/show", method=RequestMethod.GET)
public ModelAndView mostrarc(ModelMap model, HttpServletRequest a, RedirectAttributes redirect){
    Cliente cliente = cliente_bd.verCliente(Long.parseLong(a.getParameter("id")));
    if(cliente.getHabilitado() == 1){
        model.addAttribute("checado", "checked");
    }
    model.addAttribute("cliente", cliente);
    return new ModelAndView("cliente", model);
    
}

@RequestMapping(value = "/cliente/show", method=RequestMethod.GET)
public ModelAndView perfil(ModelMap model, HttpServletRequest a, RedirectAttributes redirect){
    Cliente cliente = cliente_bd.porCorreo(a.getParameter("correo")).get(0);
    model.addAttribute("cliente", cliente);
    return new ModelAndView("clientec", model);
    
}


@RequestMapping(value = "home", method=RequestMethod.GET)
public ModelAndView home(ModelMap model, HttpServletRequest a, RedirectAttributes redirect){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentPrincipalName = authentication.getName();
     System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
    System.out.println("hola");
  if(String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities()).equals("[ROLE_ADMIN]")){
    System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
    System.out.println("hola");
    List b = cliente_bd.getClientes();
    b.remove(0);
    model.addAttribute("clientes", b);
    model.addAttribute("username", currentPrincipalName);
    return new ModelAndView("home", model);
   }else{
      List c = cliente_bd.porCorreo(currentPrincipalName);
       Cliente aa = (Cliente) c.get(0);
       long f = aa.getId_cliente();
       List b = proyecto_bd.getProyecto(f);
       model.addAttribute("proyectos", b);
       model.addAttribute("username", currentPrincipalName);
       return new ModelAndView("homec", model);
   }
}





    
     @RequestMapping(value = "/administrador/borraCliente", method = RequestMethod.POST)
    public ModelAndView borrarCliente(ModelMap model,HttpServletRequest request){

       String id_cliente = request.getParameter("id_cliente"); 
       cliente_bd.borrarCliente(Long.parseLong(id_cliente));
     
       model.addAttribute("id_cliente", id_cliente);
       
   
       return new ModelAndView("confirmacion",model);   
   }
    
     @RequestMapping(value = "/administrador/crearCliente", method = RequestMethod.POST)
    public String creaCliente(ModelMap model,HttpServletRequest request) throws UnsupportedEncodingException{
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
       c.setRol("ROLE_CLIENTE");
       cliente_bd.crearCliente(c);
   
       return "redirect:/home";   
   }

    
    
    
     @RequestMapping(value = "/administrador/modificarCliente", method = RequestMethod.POST)
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
       return new ModelAndView("redirect:/administrador/show?id="+id_cliente);   
   }
    
    
    @RequestMapping(value = "/cliente/modificarCliente", method = RequestMethod.POST)
    public ModelAndView modificarClie(ModelMap model,HttpServletRequest request){

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
       int habilitado = 1;
       
       
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
       return new ModelAndView("redirect:/home");   
   }
        
  @RequestMapping(value = "/")
  public String index(ModelMap model){
      return "index";
  }
}
