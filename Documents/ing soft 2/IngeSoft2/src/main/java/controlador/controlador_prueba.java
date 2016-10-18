/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import MapeoBD.Prueba;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import modelo.PruebaDAO;
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
public class controlador_prueba {
    @Autowired
    private PruebaDAO prueba_bd;
    
    @RequestMapping(value = "/administrador/show_prueba", method=RequestMethod.GET)
    public ModelAndView show_prueba(ModelMap model, HttpServletRequest a, RedirectAttributes redirect){
    Prueba prueba = prueba_bd.verPrueba(Long.parseLong(a.getParameter("id")));
    if(prueba.getHabilitado() == 1){
        model.addAttribute("checado", "checked");
    }
    model.addAttribute("prueba", prueba);
    return new ModelAndView("remodificadoPrueba", model);
    
}
 
    @RequestMapping(value = "/administrador/pruebas", method=RequestMethod.GET)
    public ModelAndView admin_prueba(HttpServletRequest a, ModelMap b){
     
     List c = prueba_bd.getPruebas();
     b.addAttribute("prueba", c);
     return new ModelAndView("datos_prueba",b);
}

    @RequestMapping(value = "/verificaPrueba", method=RequestMethod.GET)
    public String crearPreba(HttpServletRequest a){
     
    return "crearprueba";
}

@RequestMapping(value = "/verPrueba", method = RequestMethod.POST)
    public ModelAndView ConsultarPrueba(ModelMap model,HttpServletRequest request){
        String nom_prueba = request.getParameter("nombre_prueba"); 
       Prueba pru= prueba_bd.consultaPrueba(nom_prueba);
       
       long id_prueba=pru.getId_prueba();
       String nombre_prueba=pru.getNombre_prueba();
       String descripcion_prueba=pru.getDescripcion_prueba() ;
       int habilitado =pru.getHabilitado();
       
       
       model.addAttribute("id_prueba",id_prueba);
       model.addAttribute("nombre_prueba",nombre_prueba);
       model.addAttribute("descripcion_prueba",descripcion_prueba);
       model.addAttribute("habilitado",habilitado);
       
       return new ModelAndView("datos_prueba",model);   
       }
    
   @RequestMapping(value = "/crearPrueba", method = RequestMethod.POST)
    public String creaPrueba(ModelMap model,HttpServletRequest request){
            
            String id_prueba= request.getParameter("id_prueba");
            String nombre_prueba= request.getParameter("nombre_prueba");
            String descripcion_prueba= request.getParameter("descripcion_prueba");
            String habilitado= request.getParameter("habilitado");
            
            Prueba p=new Prueba(Long.parseLong(id_prueba), 
                    nombre_prueba, descripcion_prueba, 
                    Integer.parseInt(habilitado));
            
            prueba_bd.crearPrueba(p);
       
            return "home";
       
        }
        
        @RequestMapping(value = "/remodificaPrueba", method = RequestMethod.POST)
    public ModelAndView remodificaPrueba(ModelMap model,HttpServletRequest request){
        String nom_Pro=request.getParameter("nombre_prueba");
        
        
        Prueba ve=(Prueba) prueba_bd.consultaPrueba(nom_Pro);
       model.addAttribute("id_prueba",ve.getId_prueba() );
       model.addAttribute("nombre_prueba",ve.getNombre_prueba() );
       model.addAttribute("descripcion_prueba",ve.getDescripcion_prueba() );
       model.addAttribute("habilitado", ve.getHabilitado());
       
       
      return new ModelAndView("remo_Prueba",model);   
    }
    
     @RequestMapping(value = "/modificaPrueba", method = RequestMethod.POST)
    public ModelAndView modificaPrueba(ModelMap model,HttpServletRequest request){
            String id_prueba= request.getParameter("id_prueba");
            String nombre_prueba= request.getParameter("nombre_prueba");
            String descripcion_prueba= request.getParameter("descripcion_prueba");
            String habilitado= request.getParameter("habilitado");
            Prueba p= new Prueba(Long.parseLong(id_prueba), 
                    nombre_prueba, descripcion_prueba, 
                    Integer.parseInt(habilitado));
            prueba_bd.modificaPrueba(p, Long.parseLong(id_prueba));
             return new ModelAndView("home",model);  
    }
}