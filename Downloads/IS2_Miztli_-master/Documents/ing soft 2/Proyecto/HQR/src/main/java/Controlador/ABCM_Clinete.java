/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import MapeoBD.Cliente;
import Modelo.ClienteDAOImpl;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Salvador
 */
@Controller 
public class ABCM_Clinete {
    @Autowired
    private ClienteDAOImpl cliente_bd;
    
    @RequestMapping(value = "/")
    public String index(){
     
        //Cliente c=new Cliente(1, "correo","pass","nomc",
              //  "tel_L","tel_m","nom_u","area","puesto","empresa");
        
        //cliente_bd.crearCliente(c);
        System.out.println("-__-");
        
        return "index";
    }
    
     @RequestMapping(value = "/verCliente", method = RequestMethod.POST)
    public ModelAndView ConsultarCliente(ModelMap model,HttpServletRequest request){

       String id_cliente = request.getParameter("id_cliente"); 
       Cliente un_cliente= cliente_bd.verCliente(Long.parseLong(id_cliente));
     
       String c=un_cliente.getCorreo();
       model.addAttribute("id_cliente", id_cliente);
       model.addAttribute("grupos", c);
   
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
    public ModelAndView creaCliente(ModelMap model,HttpServletRequest request){

       String id_cliente = request.getParameter("id_cliente"); 
       String correo = request.getParameter("correo"); 
       String password = request.getParameter("password"); 
       String Nombre_Cliente = request.getParameter("Nombre_Cliente"); 
       String Telefono_Local = request.getParameter("Telefono_Local"); 
       String Telefono_Movil = request.getParameter("Telefono_Movil"); 
       String Nombre_Usuario = request.getParameter("Nombre_Usuario"); 
       String Area = request.getParameter("Area"); 
       String Puesto = request.getParameter("Puesto"); 
       String Nombre_Empresa = request.getParameter("Nombre_Empresa"); 
       Cliente c =new Cliente(Long.parseLong(id_cliente),correo,password,Nombre_Cliente,Telefono_Local,
       Telefono_Movil,Nombre_Usuario,Area,Puesto,Nombre_Empresa);
       cliente_bd.crearCliente(c);
     
       model.addAttribute("id_cliente", id_cliente);
       
   
       return new ModelAndView("agregado",model);   
   }
}
