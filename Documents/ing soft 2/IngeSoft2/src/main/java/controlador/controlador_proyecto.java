/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import MapeoBD.Cliente;
import MapeoBD.Empleado;
import MapeoBD.Proyecto;
import MapeoBD.Prueba;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import modelo.ProyectoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Salvador
 */
@Controller
public class controlador_proyecto {
 @Autowired
 private ProyectoDAO proyecto_bd;
 
 
@RequestMapping(value = "/administrador/show_p", method=RequestMethod.GET)
public ModelAndView show_proyecto(ModelMap model, HttpServletRequest a, RedirectAttributes redirect){
    Proyecto proyecto = proyecto_bd.verProyecto(Long.parseLong(a.getParameter("id")));
    if(proyecto.getHabilitado() == 1){
        model.addAttribute("checado", "checked");
    }
    model.addAttribute("proyecto", proyecto);
    return new ModelAndView("remodificadoPro", model);
    
}
 
 @RequestMapping(value = "/administrador/proyectos", method=RequestMethod.GET)
public ModelAndView admin_proyecto(HttpServletRequest a, ModelMap b){
     
     List c = proyecto_bd.getProyectos();
     b.addAttribute("proyectos", c);
     return new ModelAndView("datos_proyecto",b);   
}
 
@RequestMapping(value = "/verificaProyecto", method=RequestMethod.GET)
public String crearProyecto(HttpServletRequest a){
     
    return "crearpro";
}
 @RequestMapping(value = "/verProyecto", method = RequestMethod.POST)
    public ModelAndView ConsultarProyecto(ModelMap model,HttpServletRequest request){
        String id_proyecto = request.getParameter("nom_pro"); 
       Proyecto pro= proyecto_bd.consultaProyecto(id_proyecto);
       
       long id_pro=pro.getId_proyecto();
       long cli_id=pro.getCliente_id();
       String nom_pro=pro.getNombre_proyecto();
       String descripcion=pro.getDescripcion();
       Date fecha_inicio=pro.getFecha_inicio();
       Date fecha_fin=pro.getFecha_fin();
       int habilitado=pro.getHabilitado();
       
       model.addAttribute("id_pro", id_pro);
       model.addAttribute("cli_id", cli_id);
       model.addAttribute("nom_pro", nom_pro);
       model.addAttribute("descripcion", descripcion);
       model.addAttribute("fecha_inicio", fecha_inicio);
       model.addAttribute("fecha_fin", fecha_fin);
       model.addAttribute("habilitado", habilitado);
       
       return new ModelAndView("datos_proyecto",model);   
       
       
    }
    /**
     * Consulta A 
     * todos los proyectos que son de un cliente por id
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value = "/verProyectos_cliente", method = RequestMethod.POST)
    public ModelAndView ConsultarProyectos_cliente(ModelMap model,HttpServletRequest request){
        String id_cliente = request.getParameter("id_cliente"); 
       List<Proyecto> proyectos= proyecto_bd.getProyecto(Long.parseLong(id_cliente));
       
       model.addAttribute("proyectos", proyectos);
       
       return new ModelAndView("proyectos_cliente",model);   
    }
    
    /**
     * Consulta B
     * obtener el cliente dado un proyecto por id
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value = "/clientede_proyecto", method = RequestMethod.POST)
    public ModelAndView ConsultarCliente_proyecto(ModelMap model,HttpServletRequest request){
        String id_proyecto = request.getParameter("id_proyecto");
        Cliente cliente=proyecto_bd.dameCliente(Long.parseLong(id_proyecto));
        
        model.addAttribute("cliente", cliente);
       
       return new ModelAndView("cliente_proyecto",model);   
        
    }
    
    /**
     * Consulta C
     * dado un proyecto obtener las pruebas asociadas a el
     * @param model
     * @param request
     * @return 
     */
     @RequestMapping(value = "/proyecto_pruebas", method = RequestMethod.POST)
    public ModelAndView proyecto_pruebas(ModelMap model,HttpServletRequest request){
        String id_proyecto = request.getParameter("id_proyecto");
        List<Prueba> pruebas=proyecto_bd.damePruebas(Long.parseLong(id_proyecto));
        model.addAttribute("pruebas", pruebas);
       
       return new ModelAndView("verproyecto_pruebas",model);  
    }
    
    /**
     * Consulta D
     * dado un proyecto obtener las pruebas asociadas a el 
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value = "/proyecto_empleados", method = RequestMethod.POST)
    public ModelAndView proyecto_empleados(ModelMap model,HttpServletRequest request){
        String id_proyecto = request.getParameter("id_proyecto");
        List<Empleado> empleados=proyecto_bd.dameEmpleados(Long.parseLong(id_proyecto));
        model.addAttribute("pruebas", empleados);
       
       return new ModelAndView("verproyecto_empleado",model);  
        
    }
     @RequestMapping(value = "/borraProyecto", method = RequestMethod.POST)
    public ModelAndView borrarProyecto(ModelMap model,HttpServletRequest request){
         String nom_Pro = request.getParameter("nom_Pro"); 
         proyecto_bd.borrarProyecto(nom_Pro);
         
         model.addAttribute("nom_Pro", nom_Pro);
     
       return new ModelAndView("modificadoPro",model);   
       
    }
    
    @RequestMapping(value = "/crearProyecto", method = RequestMethod.POST)
    public String creaProyecto(ModelMap model,HttpServletRequest request){
        
       SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
       
       String id_pro=request.getParameter("id_proyecto");
       String cli_id=request.getParameter("cli_id");
       String prueba_id=request.getParameter("prueba_id");
       String descripcion=request.getParameter("descripcion");
       String nom_Pro=request.getParameter("nom_pro");
       String fecha_inicio=request.getParameter("fecha_inicio");
       String fecha_fin=request.getParameter("fecha_fin");
       
       Date inicio=null;
       Date fin=null;
       try {
       inicio= formatter.parse(fecha_inicio);
       fin=formatter.parse(fecha_fin);
       } catch (ParseException ex) {
         Logger.getLogger(controlador_proyecto.class.getName()).log(Level.SEVERE, null, ex);
       }
       Proyecto p=new Proyecto(
               Long.parseLong(cli_id),
               nom_Pro, 
               descripcion,
               inicio,
               fin, 
               1);
       
       proyecto_bd.crearProyecto(p);
       
       return "home";
       
    }
    
    
    @RequestMapping(value = "/remodificaProyecto", method = RequestMethod.POST)
    public ModelAndView remodificaProyecto(ModelMap model,HttpServletRequest request){
        String nom_Pro=request.getParameter("nom_Pro");
        
        
        Proyecto ve=(Proyecto) proyecto_bd.consultaProyecto(nom_Pro);
       model.addAttribute("id_pro", ve.getId_proyecto());
       model.addAttribute("cli_id", ve.getCliente_id());
       model.addAttribute("nom_pro", ve.getNombre_proyecto());
       model.addAttribute("descripcion", ve.getDescripcion());
       model.addAttribute("fecha_inicio", ve.getFecha_inicio());
       model.addAttribute("fecha_fin", ve.getFecha_fin());
       model.addAttribute("habilitado", ve.getHabilitado());
       
      return new ModelAndView("remodificadoPro",model);   
    }
       
    
    @RequestMapping(value = "/modificaProyecto", method = RequestMethod.POST)
    public ModelAndView modificaProyecto(ModelMap model,HttpServletRequest request){
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
       
       String id_proyecto=request.getParameter("id_proyecto");
       String cli_id=request.getParameter("cli_id");
       String prueba_id=request.getParameter("prueba_id");
       String descripcion=request.getParameter("descripcion");
       String nom_Pro=request.getParameter("nom_pro");
       String fecha_inicio=request.getParameter("fecha_inicio");
       String fecha_fin=request.getParameter("fecha_fin");
       String habilitado=request.getParameter("habilitado");
       Date inicio=null;
       Date fin=null;
       try {
       inicio= format.parse(fecha_inicio);
       fin=format.parse(fecha_fin);
       } catch (ParseException ex) {
         Logger.getLogger(controlador_proyecto.class.getName()).log(Level.SEVERE, null, ex);
       }
       Proyecto p;
     
         p = new Proyecto(
                 Long.parseLong(cli_id),
                 Long.parseLong(prueba_id),
                 nom_Pro,
                 descripcion,
                 inicio,
                 fin,
                 Integer.parseInt(habilitado));
     
       
       proyecto_bd.modificaProyecto(p,Long.parseLong(id_proyecto));
       
       model.addAttribute("nom_Pro", nom_Pro);
       return new ModelAndView("home",model);   
       
       
    }
    
    
       
}
