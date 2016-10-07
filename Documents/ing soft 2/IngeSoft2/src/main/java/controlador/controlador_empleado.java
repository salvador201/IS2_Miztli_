/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import MapeoBD.Empleado;
import MapeoBD.Proyecto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import modelo.EmpleadoDAO;
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

public class controlador_empleado {

 @Autowired
 private EmpleadoDAO empleado_bd;
 
 @RequestMapping(value = "/empleados", method=RequestMethod.GET)
public ModelAndView listaEmpleados(HttpServletRequest a, ModelMap b){
     if(a.getSession().getAttribute("login") == null){
         return new ModelAndView("redirect:/");
     }
     List c = empleado_bd.getEmpleados();
     b.addAttribute("empleados", c);
     return new ModelAndView("datos_empleado",b);   
}

@RequestMapping(value = "/verificaempleado", method=RequestMethod.GET)
public String crearEmpleado(HttpServletRequest a){
     if(a.getSession().getAttribute("login") == null){
         return "redirect:/";
     }
    return "crear_empleado";
}

@RequestMapping(value = "/verEmpleado", method = RequestMethod.POST)
    public ModelAndView consultarEmpleado(ModelMap model,HttpServletRequest request){
        String nombre = request.getParameter("nombre_cliente"); 
        Empleado empleado= empleado_bd.consultaEmpleadoNom(nombre);
       
       Long id_empleado=empleado.getId_empleado();
       Long cliente_id=empleado.getCliente_id();
       String direcciones=empleado.getDireccion();
       int h_x_s=empleado.getHoras_x_semana();
       String carrera=empleado.getCarrera();
       String edo_civil=empleado.getEstado_civil();
       int numero_hijos=empleado.getNumero_hijos();
       Date fecha_nac=empleado.getFecha_nacimiento();
       String antiguedad=empleado.getAntiguiedad();
       String sueldo=empleado.getSueldo_mensual();
       String sexo=empleado.getSexo();
       String candidato=empleado.getCandidato();
       int habilitado=empleado.getHabilitado();
       
       model.addAttribute("id_empleado",id_empleado);
       model.addAttribute("cliente_id",cliente_id);
       model.addAttribute("direccion",direcciones);
       model.addAttribute("horas_x_semana",h_x_s);
       model.addAttribute("carrera",carrera);
       model.addAttribute("estado_civil",edo_civil);
       model.addAttribute("numero_hijos",numero_hijos);
       model.addAttribute("fecha_nacimiento",fecha_nac);
       model.addAttribute("antiguiedad",antiguedad);
       model.addAttribute("sueldo_mensual",sueldo);
       model.addAttribute("sexo",sexo);
       model.addAttribute("candidato",candidato );
       model.addAttribute("habilitado", habilitado);
       
       return new ModelAndView("datos_empleado",model);   
       
       
    }
    
     @RequestMapping(value = "/borraEmpleado", method = RequestMethod.POST)
    public ModelAndView borrarEmpleado(ModelMap model,HttpServletRequest request){
         String nombre_empleado = request.getParameter("nombre_empleado"); 
         empleado_bd.borrarEmpleadoNom(nombre_empleado);
         
         model.addAttribute("nombre_empleado", nombre_empleado);
     
       return new ModelAndView("modificadoEmpleado",model);   
       
    }
    
    
    @RequestMapping(value = "/crearEmpleado", method = RequestMethod.POST)
    public String creaEmpleado(ModelMap model,HttpServletRequest request){
        
       SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
       
       
       String cliente_id=request.getParameter("cliente_id");
       String direcciones=request.getParameter("direccion");
       String h_x_s=request.getParameter("horas_x_semana");
       String carrera=request.getParameter("carrera");
       String edo_civil=request.getParameter("estado_civil");
       String numero_hijos=request.getParameter("numero_hijos");
       String fecha_nac=request.getParameter("fecha_nacimiento");
       String antiguedad=request.getParameter("antiguiedad");
       String sueldo=request.getParameter("sueldo_mensual");
       String sexo=request.getParameter("sexo");
       String candidato=request.getParameter("candidato");
       
       
       
       Date nacimiento=null;
       
       try {
       nacimiento= formatter.parse(fecha_nac);
       
       } catch (ParseException ex) {
         Logger.getLogger(controlador_empleado.class.getName()).log(Level.SEVERE, null, ex);
       }
       Empleado e=new Empleado(
               Long.parseLong(cliente_id),
               direcciones,
               Integer.parseInt(h_x_s),
               carrera,
               edo_civil,
               Integer.parseInt(numero_hijos),
               nacimiento,
               antiguedad,
               sueldo,
               sexo,
               candidato,
               1);
       
       empleado_bd.crearEmpleado(e);
       
       return "home";
       
    }
}
