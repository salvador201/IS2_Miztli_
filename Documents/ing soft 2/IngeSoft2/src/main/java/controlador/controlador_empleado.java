/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import MapeoBD.Cliente;
import MapeoBD.Empleado;
import MapeoBD.Proyecto;
import MapeoBD.Usuario;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import modelo.ClienteDAO;
import modelo.EmpleadoDAO;
import modelo.UsuarioDAO;
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
 private UsuarioDAO usuario_bd;
 @Autowired
 private EmpleadoDAO empleado_bd;
 @Autowired
 private ClienteDAO cliente_bd;
 @RequestMapping(value = "/empleados", method=RequestMethod.GET)
public ModelAndView listaEmpleados(HttpServletRequest a, ModelMap b){
     if(a.getSession().getAttribute("login") == null){
         return new ModelAndView("redirect:/");
     }
     List c = empleado_bd.getEmpleados();
     b.addAttribute("empleados", c);
     return new ModelAndView("datos_empleado",b);   
}

@RequestMapping(value = "/verificaEmpleado", method=RequestMethod.GET)
public String crearEmpleado(HttpServletRequest a){
     
    return "crearEm";
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
       String antiguedad=empleado.getAntiguedad();
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
    public ModelAndView creaEmpleado(ModelMap model,HttpServletRequest request){
        
       SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
       String Login = request.getParameter("login_usuario");
       String password_usuario = request.getParameter("password_usuario");
       String rol_usuario = request.getParameter("rol_usuario");
       
         String password= null;
       MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(password_usuario.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
                } 
            password=sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
       Usuario usuario=new Usuario(Login,password, rol_usuario);
  
       usuario_bd.crearUsuario(usuario);
       
       String correo = request.getParameter("correo");
       String nombre_cliente = request.getParameter("nombre_cliente");
       String apellido_paterno_cliente = request.getParameter("apellido_paterno_cliente");
       String apellido_materno_cliente = request.getParameter("apellido_materno_cliente");
       String telefono_local = request.getParameter("telefono_local");
       String telefono_movil = request.getParameter("telefono_movil");
       String area = request.getParameter("area");
       String puesto = request.getParameter("puesto");
       String nombre_empresa=request.getParameter("Nombre_Empresa");
       
       Cliente cliente=new Cliente(usuario,
               correo,
               nombre_cliente,
               apellido_paterno_cliente,
               apellido_materno_cliente,
               telefono_local,
               telefono_movil,
               area,
               puesto,
               nombre_empresa,
               1 );
       
       cliente_bd.crearCliente(cliente);
       
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
               cliente.getId_cliente(),
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
       List<Empleado> empleados=empleado_bd.getEmpleados();
       List<Cliente> datos_e= new LinkedList<>();
       
       for(Empleado em:empleados){
           datos_e.add(cliente_bd.verCliente(em.getCliente_id()));
       }
       model.addAttribute("datos_e", datos_e);
       return new ModelAndView("cliente",model); 
       
    }
    @RequestMapping(value = "/dEmpleado", method=RequestMethod.GET)
    public ModelAndView ver(HttpServletRequest a, ModelMap b){
     
        
     String id=a.getParameter("id");
     Cliente cliente=cliente_bd.verCliente(Long.parseLong(id));
     Empleado empleado = empleado_bd.getEmpleadosP(cliente.getId_cliente());
     
     Usuario usuario=usuario_bd.verCliente(cliente.getUsuario_id().getId_usuario());
     b.addAttribute("empleado",empleado );
     b.addAttribute("cliente",cliente );
     b.addAttribute("usuario",usuario );
     return new ModelAndView("verEmpleado",b);   
}

    @RequestMapping(value = "/mEmpleado", method = RequestMethod.POST)
    public ModelAndView modificaEmpleado(ModelMap model,HttpServletRequest request){
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
     String id=request.getParameter("id");
     
     Cliente cliente=cliente_bd.verCliente(Long.parseLong(id));
     Empleado empleado = empleado_bd.getEmpleadosP(cliente.getId_cliente());
     Usuario usuario=usuario_bd.verCliente(cliente.getUsuario_id().getId_usuario());
     
     String correo = request.getParameter("correo");  
     String Nombre_Cliente = request.getParameter("Nombre_Cliente");
     String ape_pa=request.getParameter("apellidop");
     String ape_ma=request.getParameter("apellidom");
     String Telefono_Local = request.getParameter("Telefono_Local"); 
     String Telefono_Movil = request.getParameter("Telefono_Movil"); 
     String Area = request.getParameter("Area"); 
     String Puesto = request.getParameter("Puesto"); 
     String Nombre_Empresa = request.getParameter("Nombre_Empresa");
     String habilitado = request.getParameter("habilitado");
     
     Cliente nc= new Cliente(
             usuario,
             correo,
             Nombre_Cliente,
             ape_pa,
             ape_ma,
             Telefono_Local,
             Telefono_Movil,
             Area,
             Puesto,
             Nombre_Empresa,
             Integer.parseInt(habilitado)
             
             
     );
     cliente_bd.modificaCliente(nc, cliente.getId_cliente(), usuario);
     
     String Direccion = request.getParameter("Direccion");
     String horas_x_semana = request.getParameter("horas_x_semana");
     String carrera = request.getParameter("carrera");
     String estado_civil = request.getParameter("estado_civil");
     String numero_hijos = request.getParameter("numero_hijos");
     String fecha_nacimiento = request.getParameter("fecha_nacimiento");
     
  
     Date nacimiento=null;
       
       try {
       nacimiento= formatter.parse(fecha_nacimiento);
       
       } catch (ParseException ex) {
         Logger.getLogger(controlador_empleado.class.getName()).log(Level.SEVERE, null, ex);
       }
     String antiguedad = request.getParameter("antiguedad");
     String sueldo_mensual = request.getParameter("sueldo_mensual");
     String sexo = request.getParameter("sexo");
     String candidato = request.getParameter("candidato");
     
     Empleado emp=new Empleado(
             cliente.getId_cliente(),
             Direccion,
             Integer.parseInt(horas_x_semana) ,
             carrera,
             estado_civil,
             Integer.parseInt(numero_hijos),
             nacimiento,
             antiguedad,
             sueldo_mensual,
             sexo,
             candidato,
             Integer.parseInt(habilitado)
     );
//     empleado_bd.modificaEmpleado(emp, empleado.getCliente_id());
     
     model.addAttribute("empleado",empleado );
     model.addAttribute("cliente",cliente );
     model.addAttribute("usuario",usuario );
    return new ModelAndView("verEmpleado",model);  
    }
}
