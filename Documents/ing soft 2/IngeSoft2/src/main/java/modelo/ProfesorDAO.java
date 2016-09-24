/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapeoBD.Alumno;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Marco
 */
public class ProfesorDAO implements ProfesorDAOint{
     private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<Alumno> getAlumnos(Long id){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List a = null;
        try {
            tx = session.beginTransaction();
            SQLQuery q = session.createSQLQuery("SELECT a.nombrealumno, g.nombregrupo FROM profesor p JOIN grupo g ON p.idprofesor = g.profesorgrupo JOIN inscripcion i ON i.grupoinscripcion = g.idgrupo JOIN alumno a ON a.idalumno = i.alumnoinscripcion WHERE p.idprofesor = " + id);
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
