/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapeoBD.Alumno;
import MapeoBD.Grupo;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author Marco
 */
public class AlumnoDAO implements AlumnoDAOint {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    @Override
    public List<Alumno> getAlumnos(){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Alumno> lista = new LinkedList<>();
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Alumno");
            lista = query.list();
        }catch(Exception e){
            e.printStackTrace(); 
        }finally{
            session.close();
        }
        return lista;        
        
    }
    
    public String UpdateAlumnos(Long id){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Alumno> lista = new LinkedList<>();
        Alumno a = null;
        try {
            tx = session.beginTransaction();
            a = (Alumno) session.get(Alumno.class, id);
              a.setNombrealumno("Panfilo 4to");
              session.save(a);
              tx.commit();
               
              
           
        }catch(Exception e){
            e.printStackTrace(); 
        }finally{
            session.close();
        }
        return "aparentemente se modificó";    
        
    }
    
    
    public List getGrupos(String nombre){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List a = null;
        try {
            tx = session.beginTransaction();
            SQLQuery q = session.createSQLQuery("SELECT g.nombregrupo FROM inscripcion as i JOIN alumno as a ON i.alumnoinscripcion = a.idalumno JOIN Grupo g ON g.idgrupo = i.grupoinscripcion WHERE a.nombrealumno like '"+ nombre +"%'");
            q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            a = q.list();
           // Fuerza a obtener la lista con los grupos
        }catch(Exception e){
           if (tx!=null){
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally{
            session.close();
        }
        
        if(a.isEmpty()){
            return null;
        }
        
        return a;
    }
    
    public List getSalones(Long id){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List a = null;
        try {
            tx = session.beginTransaction();
            SQLQuery q = session.createSQLQuery("SELECT s.nombresalon FROM inscripcion as i JOIN alumno as a ON i.alumnoinscripcion = a.idalumno JOIN Grupo g ON g.idgrupo = i.grupoinscripcion JOIN salon s ON s.idsalon = g.salongrupo WHERE a.idalumno = " + id);
            q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            a = q.list();
           // Fuerza a obtener la lista con los grupos
        }catch(Exception e){
           if (tx!=null){
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally{
            session.close();
        }
        
        if(a.isEmpty()){
            return null;
        }
        
        return a;
    } 
}
    
    
    