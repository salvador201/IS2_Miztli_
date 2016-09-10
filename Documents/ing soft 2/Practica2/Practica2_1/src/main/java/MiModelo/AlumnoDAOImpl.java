/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiModelo;

import MiMapeo.Alumno;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author Salvador
 */
public class AlumnoDAOImpl extends AlumnoDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    public String sacarAlumno(long id_alumno){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Alumno alum;
        String var="--";
        try {
           tx = session.beginTransaction();
           
           alum = (Alumno) session.get(Alumno.class, id_alumno);
           
           if(alum != null){
               //Profesor profesor=(Profesor)session.get(profesor.class,101);
               var=alum.getNombre_alumno();
       
           }
           
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
        return var;
    }
}
