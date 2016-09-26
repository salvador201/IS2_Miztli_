/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import MapeoBD.Cliente;
import Modelo.ClienteDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Salvador
 */
@Controller
public class ABCM_Clinete {
    @Autowired
    private ClienteDAOImpl cliente_bd;
    
    @RequestMapping(value = "/")
    public String index(){
     
        Cliente c=new Cliente();
        c.setArea("Area");
        c.setCorreo("correo");
        c.setID_Cliente(1);
        c.setNombre_Cliente("Nombre_Cliente");
        c.setNombre_Empresa("Nombre_Empresa");
        c.setPassword("Password");
        c.setPuesto("Puesto");
        c.setTelefono_Local("Telefono_Local");
        c.setTelefono_Movil("Telefono_Movil");
        cliente_bd.crearCliente(c);
        System.out.println("Telefono_Movil");
        
        return "index";
    }
}
