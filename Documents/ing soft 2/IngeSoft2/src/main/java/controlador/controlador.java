/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.AlumnoDAO;
import MapeoBD.Alumno;
import MapeoBD.Grupo;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import modelo.CarreraDAO;
import modelo.ProfesorDAO;
import modelo.SalonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Marco
 */
@Controller
public class controlador {
    @Autowired
    private AlumnoDAO alumno_bd;
    
    @Autowired
    private CarreraDAO carrera_bd;
    
    @Autowired
    private SalonDAO salon_bd;
    
    @Autowired
    private ProfesorDAO profesor_bd;
    
  @RequestMapping(value = "/")
  public ModelAndView index(ModelMap model){
      List<Alumno> alumnos= alumno_bd.getAlumnos();
      System.out.println("AQUI ESTA EL NOMBRE DEL ALUMNO = " + alumnos.get(1).getNombrealumno());
       model.addAttribute("alumnos", alumnos);
      return new ModelAndView("ogdi",model);
  }
  @RequestMapping(value = "/alumno", method=RequestMethod.POST)
  public ModelAndView proces(ModelMap model, HttpServletRequest a){
      String alumno = a.getParameter("alumno");
      String carrera  = a.getParameter("carrera");
      String semestre = a.getParameter("semestre");
      
      
      
      model.addAttribute("alumno", alumno);
      model.addAttribute("carrera", carrera);
      model.addAttribute("semestre", semestre);
      return new ModelAndView("alumno",model);
  }
  
  @RequestMapping(value="/profesor", method=RequestMethod.GET)
@ResponseBody
public ModelAndView metodo(ModelMap model, @RequestParam("profesor") String profesor, @RequestParam("carrera") String carrera, @RequestParam("materia") String materia ){
        
 model.addAttribute("profesor", profesor);
      model.addAttribute("carrera", carrera);
      model.addAttribute("materia", materia);
      return new ModelAndView("profesor",model);
}

@RequestMapping(value = "/consulta1", method=RequestMethod.POST)
public ModelAndView consulta1(ModelMap model, HttpServletRequest a){
    
    String carrera  = String.valueOf(a.getParameter("carrera"));
    Set<Grupo> b = carrera_bd.getGrupos(carrera);
    model.addAttribute("lista", b);
    return new ModelAndView("consulta1", model);
}

@RequestMapping(value = "/consulta2", method=RequestMethod.POST)
public ModelAndView consulta2(ModelMap model, HttpServletRequest a){
    
    Long salon = Long.parseLong(a.getParameter("salon"));
    String b = alumno_bd.UpdateAlumnos(salon);
    model.addAttribute("lista", b);
    return new ModelAndView("consulta2", model);
}

@RequestMapping(value = "/consulta3", method=RequestMethod.POST)
public ModelAndView consulta3(ModelMap model, HttpServletRequest a){
    
    String salon = String.valueOf(a.getParameter("nombre_alumno"));
    List b = alumno_bd.getGrupos(salon);
    model.addAttribute("lista", b);
    return new ModelAndView("consulta3", model);
}
@RequestMapping(value = "/consulta4", method=RequestMethod.POST)
public ModelAndView consulta4(ModelMap model, HttpServletRequest a){
    
    Long salon = Long.parseLong(a.getParameter("id"));
    List b = alumno_bd.getSalones(salon);
    model.addAttribute("lista", b);
    return new ModelAndView("consulta4", model);
}

@RequestMapping(value = "/consulta5", method=RequestMethod.POST)
public ModelAndView consulta5(ModelMap model, HttpServletRequest a){
    
    Long profe = Long.parseLong(a.getParameter("id"));
    List b = profesor_bd.getAlumnos(profe);
    model.addAttribute("lista", b);
    return new ModelAndView("consulta5", model);
}

}