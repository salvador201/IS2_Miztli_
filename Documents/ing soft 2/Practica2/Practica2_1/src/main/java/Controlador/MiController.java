/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import MiMapeo.Alumno;
import MiMapeo.Carrera;

import MiModelo.AlumnoDAOImpl;
import MiModelo.CarreraDAOImpl;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MiController {
    @Autowired
    private AlumnoDAOImpl alumno_bd;
    
    @Autowired
    private CarreraDAOImpl carrera_bd;
     
    @RequestMapping(value = "/")
    public ModelAndView index(ModelMap model){
     
        return new ModelAndView("index",model);
    }

    @RequestMapping(value = "/muestraAlumno", method = RequestMethod.POST)
    public ModelAndView muestraAlumno(ModelMap model,HttpServletRequest request){

       String idalumno = request.getParameter("idalumno"); 
       String nombre=alumno_bd.sacarAlumno(Long.valueOf(idalumno));
       model.addAttribute("idalumno", idalumno);
       model.addAttribute("nombre", nombre);
       return new ModelAndView("datos",model);   
   }

   
    @RequestMapping(value= "/preguntaA", method = RequestMethod.POST)
    public ModelAndView pregunta_A(ModelMap model,HttpServletRequest request){
       
       String nomCarrera = request.getParameter("nombreCarrera"); 
        String list_g = carrera_bd.da_ID_Carrera(nomCarrera);
       
        model.addAttribute("grupos", list_g);
       
       return new ModelAndView("datos",model); 
       
   }
}
