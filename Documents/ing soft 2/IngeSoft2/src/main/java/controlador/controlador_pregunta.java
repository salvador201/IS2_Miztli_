/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import MapeoBD.Pregunta;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modelo.PreguntaDAO;
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
public class controlador_pregunta {
    @Autowired
    private PreguntaDAO pregunta_bd;
    
    @RequestMapping(value = "/administrador/show_pregunta", method=RequestMethod.GET)
    public ModelAndView show_pregunta(ModelMap model, HttpServletRequest a, RedirectAttributes redirect){
    Pregunta pregunta = pregunta_bd.verPregunta(Long.parseLong(a.getParameter("id")));
    if(pregunta.getHabilitado() == 1){
        model.addAttribute("checado", "checked");
    }
    model.addAttribute("pregunta", pregunta);
    return new ModelAndView("remoPregunta", model);
    
}
    
    @RequestMapping(value = "/administrador/pregunta", method=RequestMethod.GET)
    public ModelAndView admin_pregunta(HttpServletRequest a, ModelMap b){
     
     List c = pregunta_bd.getPreguntas();
     b.addAttribute("pregunta", c);
     return new ModelAndView("datos_pregunta",b);
}
    
    @RequestMapping(value = "/verifica1", method=RequestMethod.GET)
    public String crearPregunta(HttpServletRequest a){
     
    return "crearpregunta";
}
    
    @RequestMapping(value = "/verPregunta", method = RequestMethod.POST)
    public ModelAndView ConsultarPregunta(ModelMap model,HttpServletRequest request){
        String id_pre = request.getParameter("id_pregunta"); 
       Pregunta pregunta=(Pregunta) pregunta_bd.verPregunta(Long.parseLong(id_pre));
       
       long id_pregunta=pregunta.getId_pregunta();
       String nombre_pregunta=pregunta.getNombre_pregunta();
       int habilitado=pregunta.getHabilitado();
       
       model.addAttribute("id_pregunta",id_pregunta);
       model.addAttribute("nombre_pregunta",nombre_pregunta);
       model.addAttribute("habilitado",habilitado);
       
       return new ModelAndView("datos_pregunta",model);   
    }
    
    @RequestMapping(value = "/crearPregunta", method = RequestMethod.POST)
        public String creaPregunta(ModelMap model,HttpServletRequest request){
            
            String id_pregunta= request.getParameter("id_pregunta");
            String nombre_pregunta= request.getParameter("nombre_pregunta");            
            String habilitado= request.getParameter("habilitado");
            
            Pregunta p=new Pregunta(Long.parseLong(id_pregunta), 
                    nombre_pregunta,                    
                    Integer.parseInt(habilitado));
            
            pregunta_bd.crearPrueba(p);
       
            return "home";
       
        }
        
    @RequestMapping(value = "/remodificaPregunta", method = RequestMethod.POST)
    public ModelAndView remodificaPregunta(ModelMap model,HttpServletRequest request){
        String id_pregunta=request.getParameter("id_pregunta");
        
        
       Pregunta ve=(Pregunta) pregunta_bd.verPregunta(Long.parseLong(id_pregunta));
       model.addAttribute("id_pregunta",ve.getId_pregunta());
       model.addAttribute("nombre_pregunta",ve.getNombre_pregunta());
       model.addAttribute("habilitado",ve.getHabilitado());
       
       
      return new ModelAndView("remo_Pregunta",model);   
    }
    
    @RequestMapping(value = "/modificaPregunta", method = RequestMethod.POST)
    public ModelAndView modificaCliente(ModelMap model,HttpServletRequest request){
            String id_pregunta= request.getParameter("id_pregunta");
            String nombre_pregunta= request.getParameter("nombre_pregunta");
            String habilitado= request.getParameter("habilitado");
            
            Pregunta p= new Pregunta(Long.parseLong(id_pregunta), 
                    nombre_pregunta,
                    Integer.parseInt(habilitado));
            pregunta_bd.modificaPregunta(p, Long.parseLong(id_pregunta));
             return new ModelAndView("home",model);  
    }
       
}
