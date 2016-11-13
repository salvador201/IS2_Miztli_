/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import ExcelView.ClientesExcelView;
import MapeoBD.Cliente;
import MapeoBD.Empleado;
import MapeoBD.Proyecto;
import MapeoBD.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import modelo.ClienteDAO;
import modelo.EmpleadoDAO;
import modelo.ProyectoDAO;
import modelo.UsuarioDAO;
import static org.apache.commons.codec.digest.DigestUtils.md5;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Marco
 */
@Controller
public class controlador {
    
    @Autowired
    private ClienteDAO cliente_bd;
    
    @Autowired
    private ProyectoDAO proyecto_bd;

    @Autowired
    private UsuarioDAO usuario_bd;
    
    @Autowired
    private EmpleadoDAO empleado_bd;
    
@RequestMapping(value = "/administrador/prueba", method=RequestMethod.GET)
public String prueba(ModelMap model, HttpServletRequest a){
   
    return "prueba";
}

@RequestMapping(value = "/crear", method=RequestMethod.GET)
public String crear(HttpServletRequest a){
     
    return "crear";
}


@RequestMapping(value = "/administrador/show", method=RequestMethod.GET)
public ModelAndView mostrarc(ModelMap model, HttpServletRequest a, RedirectAttributes redirect){
    Cliente cliente = cliente_bd.verCliente(Long.parseLong(a.getParameter("id")));
    if(cliente.getHabilitado() == 1){
        model.addAttribute("checado", "checked");
    }
    model.addAttribute("cliente", cliente);
    return new ModelAndView("cliente", model);
    
}

@RequestMapping(value = "/cliente/show", method=RequestMethod.GET)
public ModelAndView perfil(ModelMap model, HttpServletRequest a, RedirectAttributes redirect){
    Cliente cliente = cliente_bd.porCorreo(a.getParameter("correo")).get(0);
    model.addAttribute("cliente", cliente);
    return new ModelAndView("clientec", model);
    
}


@RequestMapping(value = "home", method=RequestMethod.GET)
public ModelAndView home(ModelMap model, HttpServletRequest a, RedirectAttributes redirect){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentPrincipalName = authentication.getName();
     System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
    System.out.println("hola");
  if(String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities()).equals("[ROLE_ADMIN]")){
    System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
    System.out.println("hola");
    List b = cliente_bd.getClientes();
    b.remove(0);
    model.addAttribute("clientes", b);
    model.addAttribute("username", currentPrincipalName);
    return new ModelAndView("home", model);
   }else{
      List c = cliente_bd.porCorreo(currentPrincipalName);
       Cliente aa = (Cliente) c.get(0);
       long f = aa.getId_cliente();
       List b = proyecto_bd.getProyecto(f);
       model.addAttribute("proyectos", b);
       model.addAttribute("username", currentPrincipalName);
       return new ModelAndView("homec", model);
   }
}

 @RequestMapping(value="/exportarExcelCliente", method = RequestMethod.GET)
    public ClientesExcelView exportarExcelAlumnoNombre(Model model, HttpServletRequest request, RedirectAttributes redirect){
       
        model.addAttribute("clientes", cliente_bd.getClientes());    
        
        return new ClientesExcelView();
    }



    
     @RequestMapping(value = "/administrador/borraCliente", method = RequestMethod.POST)
    public ModelAndView borrarCliente(ModelMap model,HttpServletRequest request){

       String id_cliente = request.getParameter("id_cliente"); 
       cliente_bd.borrarCliente(Long.parseLong(id_cliente));
     
       model.addAttribute("id_cliente", id_cliente);
       
   
       return new ModelAndView("confirmacion",model);   
   }
    
     @RequestMapping(value = "/administrador/crearCliente", method = RequestMethod.POST)
    public String creaCliente(ModelMap model,HttpServletRequest request) throws UnsupportedEncodingException{
       String correo = request.getParameter("correo"); 
       
       String Nombre_Cliente = request.getParameter("Nombre_Cliente"); 
       String Telefono_Local = request.getParameter("Telefono_Local"); 
       String Telefono_Movil = request.getParameter("Telefono_Movil"); 
       String Area = request.getParameter("Area"); 
       String Puesto = request.getParameter("Puesto"); 
       String Nombre_Empresa = request.getParameter("Nombre_Empresa"); 
       String ape_pa=request.getParameter("apellidop");
       String ape_ma=request.getParameter("apellidom");
       
       String pass = request.getParameter("password");
       String rol="ROLE_CLIENTE";
       String login_u = request.getParameter("Nombre_Usuario"); 
       String password= null;
       MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(pass.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
                } 
            password=sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Usuario u= new Usuario(login_u,password,rol);
        usuario_bd.crearUsuario(u);
       
       Cliente c =new Cliente(u,correo, 
               Nombre_Cliente,ape_pa,ape_ma,Telefono_Local,Telefono_Movil,Area,Puesto,Nombre_Empresa,1);
       cliente_bd.crearCliente(c);
        List b = cliente_bd.getClientes();
        b.remove(0);
        model.addAttribute("clientes", b);
       return "redirect:/home";   
   }

    
    
    
     @RequestMapping(value = "/administrador/modificarCliente", method = RequestMethod.POST)
    public ModelAndView modificarCliente(ModelMap model,HttpServletRequest request){

       String id_cliente = request.getParameter("id_cliente"); 
       String correo = request.getParameter("correo");  
       String password = "hola"; 
       String Nombre_Cliente = request.getParameter("Nombre_Cliente");
       String ape_pa=request.getParameter("apellidop");
       String ape_ma=request.getParameter("apellidom");
       String Telefono_Local = request.getParameter("Telefono_Local"); 
       String Telefono_Movil = request.getParameter("Telefono_Movil"); 
       String login_u = request.getParameter("Nombre_Usuario"); 
       String Area = request.getParameter("Area"); 
       String Puesto = request.getParameter("Puesto"); 
       String Nombre_Empresa = request.getParameter("Nombre_Empresa");
       String Rol = request.getParameter("ROL");
       
       int habilitado;
       if (request.getParameter("habilitado") == null ){
           habilitado = 0;
           
       }else{
           habilitado = 1;
       }
       
       Usuario u=new Usuario (login_u,password,Rol);
       
       Long id_user=u.getId_usuario();
       Cliente c =new Cliente(u,
               correo,
               Nombre_Cliente,
               ape_pa,
               ape_ma,
               Telefono_Local,
               Telefono_Movil,
               Area,Puesto,Nombre_Empresa,habilitado
               );
       
       cliente_bd.modificaCliente(c,Long.parseLong(id_cliente),u);
       model.addAttribute("id_cliente", id_cliente);
       return new ModelAndView("redirect:/administrador/show?id="+id_cliente);   
   }
    
    
    @RequestMapping(value = "/cliente/modificarCliente", method = RequestMethod.POST)
    public ModelAndView modificarClie(ModelMap model,HttpServletRequest request){
        String id_cliente = request.getParameter("id_cliente"); 
       String correo = request.getParameter("correo");  
       String password = "hola"; 
       String Nombre_Cliente = request.getParameter("Nombre_Cliente");
       String ape_pa=request.getParameter("apellidop");
       String ape_ma=request.getParameter("apellidom");
       String Telefono_Local = request.getParameter("Telefono_Local"); 
       String Telefono_Movil = request.getParameter("Telefono_Movil"); 
       String login_u = request.getParameter("Nombre_Usuario"); 
       String Area = request.getParameter("Area"); 
       String Puesto = request.getParameter("Puesto"); 
       String Nombre_Empresa = request.getParameter("Nombre_Empresa");
       String Rol = request.getParameter("ROL");
       
       int habilitado;
       if (request.getParameter("habilitado") == null ){
           habilitado = 0;
           
       }else{
           habilitado = 1;
       }
       
       Usuario u=new Usuario (login_u,password,Rol);
       
       Long id_user=u.getId_usuario();
       Cliente c =new Cliente(u,
               correo,
               Nombre_Cliente,
               ape_pa,
               ape_ma,
               Telefono_Local,
               Telefono_Movil,
               Area,Puesto,Nombre_Empresa,habilitado
               );
       model.addAttribute("id_cliente", id_cliente);
        List b = cliente_bd.getClientes();
        b.remove(0);
        model.addAttribute("clientes", b);
       return new ModelAndView("redirect:/home");   
   }
        
  @RequestMapping(value = "/")
  public String index(ModelMap model){
      return "index";
  }
  
  //nota solo sirve con windows y el excel debe estar en C:\\
    @RequestMapping(value = "/administrador/abreExcel", method = RequestMethod.POST)
   public ModelAndView abreExcel(ModelMap model,
            @RequestParam("archivo") File archivo) {
      
       try{
        String var="C:\\"+archivo.getPath();   
        System.out.print(var);

        File objeto=new File (var);
        Workbook wb;
        //wb= WorkbookFactory.create(new FileInputStream(objeto));
        FileInputStream inp=new FileInputStream(var);
        HSSFWorkbook workbook = new HSSFWorkbook(inp);
        
        HSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        Row row;

        if(rowIterator.hasNext()){
            row=rowIterator.next();
        }
        
	while (rowIterator.hasNext()) {
                row=rowIterator.next();
                Usuario u=new Usuario();      
		Cliente cliente ;            
                Empleado empleado;
                
                String pass =row.getCell(9).getStringCellValue() ;
                String rol=row.getCell(10).getStringCellValue();
                String login_u = row.getCell(11).getStringCellValue(); 
                String password=null;
                MessageDigest md;
                try {
                md = MessageDigest.getInstance("MD5");
                md.update(pass.getBytes());
                byte[] digest = md.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                   sb.append(String.format("%02x", b & 0xff));
                } 
                password=sb.toString();
                } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                u.setLogin_usuario(login_u);
                u.setPassword_usuario(password);
                u.setRol_usuario(rol);
                usuario_bd.crearUsuario(u);
                
                Usuario usu=usuario_bd.daID(login_u);
                System.out.print(usu.getId_usuario() +"  "+ login_u);
                cliente = new Cliente (usu,
                row.getCell(0).getStringCellValue(),
                row.getCell(1).getStringCellValue(),
                row.getCell(2).getStringCellValue(),
                row.getCell(3).getStringCellValue(),
                row.getCell(4).getStringCellValue(),
                row.getCell(5).getStringCellValue(),
                row.getCell(6).getStringCellValue(),
                row.getCell(7).getStringCellValue(),
                row.getCell(8).getStringCellValue(),
                1);
                
                cliente_bd.crearCliente(cliente);
                List clientes=cliente_bd.porCorreo(row.getCell(0).getStringCellValue());
                Cliente auxCli=(Cliente) clientes.get(0);
                
                System.out.print(row.getCell(13));
                int horas=(int)(row.getCell(13).getNumericCellValue());
                int hijos=(int)(row.getCell(16).getNumericCellValue());
                int sueldo=(int)( row.getCell(19).getNumericCellValue());
                int candidato=(int)( row.getCell(21).getNumericCellValue());
                Date fecha=row.getCell(17).getDateCellValue();

                empleado=new Empleado(auxCli.getId_cliente(),
                row.getCell(12).getStringCellValue(),
                horas,
                row.getCell(14).getStringCellValue(),
                row.getCell(15).getStringCellValue(),
                hijos,
                fecha,
                row.getCell(18).getStringCellValue(),
                String.valueOf(sueldo),
                row.getCell(20).getStringCellValue(),
                String.valueOf(candidato),
                1);
                
                empleado_bd.crearEmpleado(empleado);
                
			}			
			
       }catch (Exception e) {
	e.printStackTrace();
	}
       //workbook.close();
       model.addAttribute("clientes",cliente_bd.getClientes());
       return new ModelAndView("redirect:/home",model);    
   }
}
