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
           cli.setHabilitado(0);
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
     
      public void modificaCliente(Cliente un_cliente,long id){
      Session session = sessionFactory.openSession();
        Transaction tx = null;
        Cliente cli =null;
         try {
           tx = session.beginTransaction();
           cli=(Cliente) session.get(Cliente.class, id );
           cli.setCorreo(un_cliente.getCorreo());
           cli.setPassword(un_cliente.getPassword());
           cli.setNombre_cliente(un_cliente.getNombre_cliente());
           cli.setApellido_paterno_cliente(un_cliente.getApellido_paterno_cliente());
           cli.setApellido_materno_cliente(un_cliente.getApellido_materno_cliente());
           cli.setTelefono_local(un_cliente.getTelefono_local());
           cli.setTelefono_movil(un_cliente.getTelefono_movil());
           cli.setNombre_usuario(un_cliente.getNombre_usuario());
           cli.setArea(un_cliente.getArea());
           cli.setPuesto(un_cliente.getPuesto());
           cli.setNombre_empresa(un_cliente.getNombre_empresa());
           cli.setHabilitado(un_cliente.getHabilitado());
           
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
