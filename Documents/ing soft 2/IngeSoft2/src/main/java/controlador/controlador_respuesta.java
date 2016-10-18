/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import MapeoBD.Respuesta;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modelo.PruebaDAO;
import modelo.RespuestaDAO;
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
public class controlador_respuesta {
    @Autowired
    private RespuestaDAO respuesta_bd;
    
    @RequestMapping(value = "/administrador/show_respuesta", method=RequestMethod.GET)
    public ModelAndView show_respuesta(ModelMap model, HttpServletRequest a, RedirectAttributes redirect){
    Respuesta respuesta =  respuesta_bd.verRespuesta(Long.parseLong(a.getParameter("id")));
    if(respuesta.getHabilitado() == 1){
        model.addAttribute("checado", "checked");
    }
    model.addAttribute("respuesta", respuesta);
    return new ModelAndView("remodificadoPrueba", model);
    
}
    @RequestMapping(value = "/administrador/respuesta", method=RequestMethod.GET)
    public ModelAndView admin_respuesta(HttpServletRequest a, ModelMap b){
     
     List c = respuesta_bd.getRespuestas();
     b.addAttribute("prueba", c);
     return new ModelAndView("datos_prueba",b);
}

    @RequestMapping(value = "/verifica", method=RequestMethod.GET)
    public String crear(HttpServletRequest a){
     
    return "crearpro";
}
    
    @RequestMapping(value = "/verRespuestas", method = RequestMethod.POST)
    public ModelAndView ConsultarRespuesta(ModelMap model,HttpServletRequest request){
        String nom_respuesta = request.getParameter("nombre_respuestas"); 
       Respuesta res= respuesta_bd.consultaRespuesta(nom_respuesta);
       
       long id_respuesta=res.getId_repuesta();
       String nombre_respuesta=res.getNombre_respuesta();
       int habilitado=res.getHabilitado();
       
       model.addAttribute("id_respuesta",id_respuesta);
       model.addAttribute("nombre_respuesta",nombre_respuesta);
       model.addAttribute("habilitado",habilitado);
       
       return new ModelAndView("datos_respuesta",model);   
    }
    
    @RequestMapping(value = "/crearRespuesta", method = RequestMethod.POST)
        public String creaRespuesta(ModelMap model,HttpServletRequest request){
            
            String id_respuesta=request.getParameter("id_respuesta");          
            String nombre_respuesta=request.getParameter("nombre_respuesta");
            String habilitado= request.getParameter("habilitado");
            
            Respuesta p=new Respuesta(Long.parseLong(id_respuesta), 
                    nombre_respuesta, 
                    Integer.parseInt(habilitado));
            
            respuesta_bd.crearRespuesta(p);
       
            return "home";
       
        }
        
         @RequestMapping(value = "/remoRespuesta", method = RequestMethod.POST)
    public ModelAndView remodificaRespuesta(ModelMap model,HttpServletRequest request){
        String nom_Pro=request.getParameter("nombre_respuesta");
        
        
        Respuesta ve=(Respuesta) respuesta_bd.consultaRespuesta(nom_Pro);
       model.addAttribute("id_respuesta",ve.getId_repuesta());       
       model.addAttribute("nombre_respuesta",ve.getNombre_respuesta());
       model.addAttribute("habilitado", ve.getHabilitado());
       
       
      return new ModelAndView("remo_Respuesta",model);   
    }
    
    @RequestMapping(value = "/modificaRespuesta", method = RequestMethod.POST)
    public ModelAndView modificaRespuesta(ModelMap model,HttpServletRequest request){
            String id_respuesta=request.getParameter("id_respuesta");
            String nombre_respuesta=request.getParameter("nombre_respuesta");
            String habilitado= request.getParameter("habilitado");
            
            
             Respuesta p=new Respuesta( 
                    nombre_respuesta, 
                    Integer.parseInt(habilitado));
            
            respuesta_bd.modificaRespuesta(p,Long.parseLong(id_respuesta));
       
             return new ModelAndView("home",model);
    }
    
    
}
