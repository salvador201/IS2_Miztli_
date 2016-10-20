/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;



import MapeoBD.Cliente;
import MapeoBD.Empleado;
import MapeoBD.Empleado_proyecto;
import MapeoBD.Proyecto;
import MapeoBD.Prueba;
import MapeoBD.Prueba_Proyecto;
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
    
    /**
     * Consulta A
     * @param id
     * @return 
     */
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
    
    /**
     * Consulta B
     * @param id_proyecto
     * @return 
     */
     public Cliente dameCliente(Long id_proyecto){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Cliente> lista=null;
        Cliente dueno=null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Proyecto where id_proyecto = :var");
            query.setParameter("var",id_proyecto);
            lista = query.list();
            dueno = (Cliente) session.get(Proyecto.class,lista.get(0).getId_cliente());
        }catch(Exception e){
            e.printStackTrace(); 
        }finally{
            session.close();
        }
        return dueno;
     }
    
     /**
      * Consulta C
      * @param id_proyecto
      * @return 
      */
     public List<Prueba> damePruebas(Long id_proyecto){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Prueba_Proyecto> lista=new LinkedList<>();
        List<Prueba> pruebas=new LinkedList<>();
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Prueba_Proyecto where prueba_id = :var");
            query.setParameter("var",id_proyecto);
            lista = query.list();
            Query query_prueba = session.createQuery("from Prueba where id_prueba = :var");
            query_prueba.setParameter("var",lista.get(0).getPrueba_id());
            pruebas= query_prueba.list();
            
        }catch(Exception e){
            e.printStackTrace(); 
        }finally{
            session.close();
        }
        return pruebas;  
         
     }
     
     /**
      * Consulta D
      * @param id_proyecto
      * @return 
      */
     public List<Empleado> dameEmpleados(Long id_proyecto){
         Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Empleado_proyecto> lista=new LinkedList<>();
        List<Empleado> empleados=new LinkedList<>();
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Empleado_proyecto where proyecto_id = :var");
            query.setParameter("var",id_proyecto);
            lista = query.list();
            Query query_empleado = session.createQuery("from Empleado where id_empleado = :var");
            query_empleado.setParameter("var",lista.get(0).getEmpleado_id());
            empleados= query_empleado.list();
            
        }catch(Exception e){
            e.printStackTrace(); 
        }finally{
            session.close();
        }
        return empleados;  
         
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
