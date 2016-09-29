/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;



import MapeoBD.Proyecto;
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
     
     public void modificaProyecto(Proyecto pro,long id){
         Session session = sessionFactory.openSession();
         Transaction tx = null;
         Proyecto viejo=null;
          try {
           tx = session.beginTransaction();
            viejo=(Proyecto) session.get(Proyecto.class,id);
            viejo.setDescripcion(pro.getDescripcion());
            viejo.setFecha_fin(pro.getFecha_fin() );
            viejo.setFecha_inicio(pro.getFecha_inicio() );
            viejo.setHabilitado(pro.getHabilitado() );
            viejo.setCliente_id(pro.getCliente_id());
            viejo.setPrueba_id(pro.getPrueba_id());
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
     
    public void borrarProyecto(long num){
     Session session = sessionFactory.openSession();
        Transaction tx = null;
        Proyecto pro = null;
        try {
           tx = session.beginTransaction();
           pro = (Proyecto) session.get(Proyecto.class, num);
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
     
    public Proyecto consultaProyecto(long id){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Proyecto pro = null;
        
        
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
