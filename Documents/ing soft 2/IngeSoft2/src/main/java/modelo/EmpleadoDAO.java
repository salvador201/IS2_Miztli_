/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapeoBD.Cliente;
import MapeoBD.Empleado;

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
public class EmpleadoDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    
    public Empleado getEmpleadosP(long id_empleado){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Empleado> lista = new LinkedList<>();
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Empleado where id_empleado = :var");
            query.setParameter("var",id_empleado);
            lista = query.list();
        }catch(Exception e){
            e.printStackTrace(); 
        }finally{
            session.close();
        }
        return lista.get(0);
    }
    
    public List<Empleado> getEmpleados(){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Empleado> lista = new LinkedList<>();
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Empleado");
            lista = query.list();
        }catch(Exception e){
            e.printStackTrace(); 
        }finally{
            session.close();
        }
        return lista;
    }
    
    public void crearEmpleado(Empleado em){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        
        try {
           tx = session.beginTransaction();
            session.save(em);
             
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
    
    public void modificaEmpleado(Empleado em,long id){
         Session session = sessionFactory.openSession();
         Transaction tx = null;
         Empleado viejo=null;
          try {
           tx = session.beginTransaction();
            viejo=(Empleado) session.get(Empleado.class,id);
            
            viejo.setCliente_id(em.getCliente_id());
            viejo.setDireccion(em.getDireccion());
            viejo.setHoras_x_semana(em.getHoras_x_semana());
            viejo.setCarrera(em.getCarrera());
            viejo.setEstado_civil(em.getEstado_civil());
            viejo.setNumero_hijos(em.getNumero_hijos());
            viejo.setFecha_nacimiento(em.getFecha_nacimiento());
            viejo.setAntiguiedad(em.getAntiguedad());
            viejo.setSueldo_mensual(em.getSueldo_mensual());
            viejo.setSexo(em.getSexo());
            viejo.setCandidato(em.getCandidato());
            viejo.setHabilitado(em.getHabilitado());
            
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

    public void modificaEmpleadoNom(Empleado em,String nombre){
         Session session = sessionFactory.openSession();
         Transaction tx = null;
         List<Cliente> lista=null; 
         List<Empleado> lista_1=null;
         Empleado viejo=null;
         Cliente aux=null;
          try {
           tx = session.beginTransaction();
           Query query = session.createQuery("from Cliente "
                   + "where nombre_cliente = :var");
           query.setParameter("var",nombre );
           lista = query.list(); 
           aux=lista.get(0);
           
           Query query_1 = session.createQuery("from Empleado "
                   + "where cliente_id = :var");
           query.setParameter("var",aux.getId_cliente() );
           lista_1=query_1.list();
           viejo=lista_1.get(0);
           
           viejo.setCliente_id(em.getCliente_id());
            viejo.setDireccion(em.getDireccion());
            viejo.setHoras_x_semana(em.getHoras_x_semana());
            viejo.setCarrera(em.getCarrera());
            viejo.setEstado_civil(em.getEstado_civil());
            viejo.setNumero_hijos(em.getNumero_hijos());
            viejo.setFecha_nacimiento(em.getFecha_nacimiento());
            viejo.setAntiguiedad(em.getAntiguedad());
            viejo.setSueldo_mensual(em.getSueldo_mensual());
            viejo.setSexo(em.getSexo());
            viejo.setCandidato(em.getCandidato());
            viejo.setHabilitado(em.getHabilitado());
            
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
  
    public void borrarEmpleado(long num){
     Session session = sessionFactory.openSession();
        Transaction tx = null;
        Empleado em = null;
        try {
           tx = session.beginTransaction();
           em = (Empleado) session.get(Empleado.class, num);
           em.setHabilitado(0);
           session.update(em);
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

    public void borrarEmpleadoNom(String nombre){
     Session session = sessionFactory.openSession();
         Transaction tx = null;
         List<Cliente> lista=null; 
         List<Empleado> lista_1=null;
         Empleado viejo=null;
         Cliente aux=null;
          try {
           tx = session.beginTransaction();
           Query query = session.createQuery("from Cliente "
                   + "where nombre_cliente = :var");
           query.setParameter("var",nombre );
           lista = query.list(); 
           aux=lista.get(0);
           
           Query query_1 = session.createQuery("from Empleado "
                   + "where cliente_id = :var");
           query.setParameter("var",aux.getId_cliente() );
           lista_1=query_1.list();
           viejo=lista_1.get(0);
         
           viejo.setHabilitado(0);
           aux.setHabilitado(0);
           session.update(viejo);
           session.update(aux);
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
   
    public Empleado consultaEmpleado(Long id){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Empleado em = null;
        
        
        try {
           tx = session.beginTransaction();
           em = (Empleado) session.get(Empleado.class, id);
             
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
        return em;
    }
    
    public Empleado consultaEmpleadoNom(String nombre){
        Session session = sessionFactory.openSession();
         Transaction tx = null;
         List<Cliente> lista=null; 
         List<Empleado> lista_1=null;
         Empleado viejo=null;
         Cliente aux=null;
          try {
           tx = session.beginTransaction();
           Query query = session.createQuery("from Cliente "
                   + "where nombre_cliente = :var");
           query.setParameter("var",nombre );
           lista = query.list(); 
           aux=lista.get(0);
           
           Query query_1 = session.createQuery("from Empleado "
                   + "where cliente_id = :var");
           query.setParameter("var",aux.getId_cliente() );
           lista_1=query_1.list();
           viejo=lista_1.get(0);
             
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
        return viejo;
    }
}
