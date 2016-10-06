/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapeoBD.Empleado;
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
            viejo.setAntiguiedad(em.getAntiguiedad());
            viejo.setSueldo_mensual(em.getSueldo_mensual());
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

    public Empleado consultaEmpleado(long id){
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
}
