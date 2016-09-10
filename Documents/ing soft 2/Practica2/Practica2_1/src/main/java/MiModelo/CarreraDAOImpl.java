/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiModelo;

import MiMapeo.Carrera;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Salvador
 */
public class CarreraDAOImpl extends CarreraDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public String da_ID_Carrera(String nombreCarrera){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        //List<Grupo> list_grupos=null;
        List<Carrera> list_carr=null;
        String fin="XD";
        try {
            tx = session.beginTransaction();    
            
            String hql=
                //nombre de la clase como esta escrito en el Mapeo
                    "FROM Carrera  "
                    +"WHERE nombrecarrera  =:var";
                Query query=session.createQuery(hql);
                query.setParameter("var",nombreCarrera );
                list_carr= query.list();
                fin=Long.toString(list_carr.get(0).getId_carrera());
                System.out.println("------------------------ "+fin);
            
           
            
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
        return fin;
    }
}
