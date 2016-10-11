/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;



import MapeoBD.Cliente;
import MapeoBD.Proyecto;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



/**
 *
 * @author Salvador
 */
public class ProyectoDAO {
     private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public List<Proyecto> getProyectos(){
         Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Proyecto> lista = new LinkedList<>();
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Proyecto");
            lista = query.list();
        }catch(Exception e){
            e.printStackTrace(); 
        }finally{
            session.close();
        }
        return lista;   
     }
    public List<Proyecto> getProyecto(Long id){
         Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Proyecto> lista = new LinkedList<>();
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Proyecto where cliente_id = :var");
             query.setParameter("var",id);
            lista = query.list();
        }catch(Exception e){
            e.printStackTrace(); 
        }finally{
            session.close();
        }
        return lista;   
     }
     
     public void crearProyecto(Proyecto pro){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        
        try {
           tx = session.beginTransaction();
            session.save(pro);
             
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
     
     public void modificaProyecto(Proyecto pro,Long id){
         Session session = sessionFactory.openSession();
         Transaction tx = null;
         Proyecto viejo;
         
          try {
           
            tx = session.beginTransaction();
            viejo = (Proyecto) session.get(Proyecto.class, id);
            viejo.setDescripcion(pro.getDescripcion());
            viejo.setFecha_fin(pro.getFecha_fin() );
            viejo.setFecha_inicio(pro.getFecha_inicio() );
            viejo.setHabilitado(pro.getHabilitado() );
            viejo.setCliente_id(pro.getCliente_id());  
            viejo.setNombre_proyecto(pro.getNombre_proyecto());
            session.update(viejo);
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
     
    public void borrarProyecto(String nom){
     Session session = sessionFactory.openSession();
        Transaction tx = null;
        Proyecto pro = null;
         List<Proyecto> lista=null; 
        try {
           tx = session.beginTransaction();
            Query query = session.createQuery("from Proyecto "
                   + "where nombre_proyecto = :var");
           query.setParameter("var",nom );
           lista = query.list(); 
           pro=lista.get(0);    
           pro.setHabilitado(0);
           session.update(pro);
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
     
    public Proyecto consultaProyecto(String nom){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Proyecto pro = null;
        List<Proyecto> lista=null; 
        
        try {
           
           tx = session.beginTransaction();
           Query query = session.createQuery("from Proyecto "
                   + "where nombre_proyecto = :var");
           query.setParameter("var",nom );
           lista = query.list(); 
           pro=lista.get(0);
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
        return pro;
    }
     
    public Proyecto verProyecto(Long id){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Proyecto pro = null;
        List<Proyecto> lista=null; 
        
        try {
           
           tx = session.beginTransaction();
           pro = (Proyecto) session.get(Proyecto.class, id);
           
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
        return pro;
    }
}
