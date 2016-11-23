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
import MapeoBD.Prueba_Proyecto;
import MapeoBD.Prueba_cliente;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modelo.ClienteDAO;
import modelo.ProyectoDAO;

import modelo.PruebaDAO;
import modelo.Prueba_ProyectoDAO;
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
     @Autowired
 private ProyectoDAO proyecto_bd;
 
  @Autowired
 private ClienteDAO cliente_bd;
 
  @Autowired
 private Prueba_ProyectoDAO prueba_proyecto_bd;
    
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
    
   @RequestMapping(value = "/asignarPrueba", method = RequestMethod.POST)
    public ModelAndView asignarPrueba(ModelMap model,HttpServletRequest request){
            
            String id_pru= request.getParameter("proyecto_id");
            String id_cli= request.getParameter("cli_id");
           System.out.print(" ////////// " + id_pru );
            
            Prueba_cliente p=new Prueba_cliente(Long.parseLong(id_pru), 
                    Long.parseLong(id_cli),1);
            
           // prueba_bd.crearPrueba_cliente(p);
       
            Proyecto proyecto = proyecto_bd.verProyecto(Long.parseLong(request.getParameter("id")));
    if(proyecto.getHabilitado() == 1){
        model.addAttribute("checado", "checked");
    }
    Cliente e = proyecto_bd.dameCliente(proyecto.getCliente_id());
    List<Prueba> pruebas = proyecto_bd.damePruebas(proyecto.getId_proyecto());
    List<Empleado> empleados = proyecto_bd.dameEmpleados(proyecto.getId_proyecto());
    List<Cliente> clientes=cliente_bd.getClientes();
    model.addAttribute("pruebas", pruebas);
    model.addAttribute("cliente",e);
    model.addAttribute("proyecto", proyecto);
    model.addAttribute("empleados", empleados);
    model.addAttribute("clientes", clientes);
    return new ModelAndView("remodificadoPro", model);
       
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
    
     @RequestMapping(value = "/ClientePruebas", method = RequestMethod.POST)
    public ModelAndView daPruebasCliente(ModelMap model,HttpServletRequest request){
        String id_cliente=request.getParameter("id");
        model.addAttribute("pruebas",cliente_bd.daPruebas(Long.parseLong(id_cliente)));
        return new ModelAndView("Lista_pruebas",model);  
        
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

    @RequestMapping(value = "/pruebaProyecto", method=RequestMethod.GET)
    public ModelAndView prueba_proyecto(ModelMap model,HttpServletRequest request){
        List<Prueba> pruebas=prueba_bd.getPruebas();
        List<Proyecto> proyecto=proyecto_bd.getProyectos();
        
        model.addAttribute("pp", prueba_proyecto_bd.getPruebas_todas());
        model.addAttribute("pruebas",pruebas);
        model.addAttribute("proyectos",proyecto);
        
     return new ModelAndView("prueba_proyecto",model);
   
    }

    @RequestMapping(value = "/asignarPruebaProyecto", method = RequestMethod.POST)
    public ModelAndView pruebaproyecto(ModelMap model,HttpServletRequest request){
        
        return new ModelAndView("prueba_proyecto",model);  
      
    }
    
}