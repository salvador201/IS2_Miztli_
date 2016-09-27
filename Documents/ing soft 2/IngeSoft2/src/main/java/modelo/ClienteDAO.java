/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapeoBD.Cliente;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Marco
 */
public class ClienteDAO implements ClienteDAOint {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
     public List<Cliente> getClientes(){
         Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Cliente> lista = new LinkedList<>();
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Cliente");
            lista = query.list();
        }catch(Exception e){
            e.printStackTrace(); 
        }finally{
            session.close();
        }
        return lista;   
     }
     
     public Cliente verCliente(long numero){
      Session session = sessionFactory.openSession();
        Transaction tx = null;
        Cliente cli = null;
        
        
        try {
           tx = session.beginTransaction();
           
           
           cli = (Cliente) session.get(Cliente.class, numero);
             
           tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        
        return cli;
      
}
     
     public void borrarCliente(long numero){
      Session session = sessionFactory.openSession();
        Transaction tx = null;
        Cliente cli = null;
        try {
           tx = session.beginTransaction();
           cli = (Cliente) session.get(Cliente.class, numero);
             session.delete(cli);
           tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
}
     
     public void crearCliente(Cliente cliente){
      Session session = sessionFactory.openSession();
        Transaction tx = null;
        Cliente cli = cliente;
        try {
           tx = session.beginTransaction();
            session.save(cli);
             
           tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
}
     
      public void modificaCliente(Cliente un_cliente){
      Session session = sessionFactory.openSession();
        Transaction tx = null;
       String correo=un_cliente.getCorreo();
       String pass=un_cliente.getPassword();
       String nombre_cliente=un_cliente.getNombre_cliente();
       String telefono_local=un_cliente.getTelefono_local();
       String telefono_movil=un_cliente.getTelefono_movil();
       String nombre_usuario=un_cliente.getNombre_usuario();
       String area=un_cliente.getArea();
       String puesto=un_cliente.getPuesto();
       String nombre_empresa=un_cliente.getNombre_empresa();
       long id_c=un_cliente.getId_cliente();
       Cliente cli = new Cliente(id_c,
               correo,
               pass,
               nombre_cliente,
               telefono_local,
               telefono_movil,
               nombre_usuario,
               area,
               puesto,
               nombre_empresa);   
         try {
           tx = session.beginTransaction();
            session.update(cli);
             
           tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
    }
    
}
