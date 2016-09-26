/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import MapeoBD.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Salvador
 */
public class ClienteDAOImpl {
      private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
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
           cli = (Cliente) session.save(cli);
             
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
