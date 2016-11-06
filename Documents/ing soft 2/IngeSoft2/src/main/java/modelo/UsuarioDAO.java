/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import MapeoBD.Usuario;
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
public class UsuarioDAO {
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public List<Usuario> getUsuario(){
         Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Usuario> lista = new LinkedList<>();
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Usuario usuario order by usuario.id_usuario");
            lista = query.list();
        }catch(Exception e){
            e.printStackTrace(); 
        }finally{
            session.close();
        }
        return lista;   
     }
    
    public Usuario verCliente(long numero){
      Session session = sessionFactory.openSession();
        Transaction tx = null;
        Usuario cli = null;
        try {
           tx = session.beginTransaction();
           cli = (Usuario) session.get(Usuario.class, numero);
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
      
    public void modificaCliente(Usuario usu,long id){
      Session session = sessionFactory.openSession();
        Transaction tx = null;
        Usuario user =null;
        try {
          
           user.setId_cliente(id);
           user.setLogin_usuario(usu.getLogin_usuario());
           user.setPassword_usuario(usu.getPassword_usuario());
           user.setRol_usuario(usu.getRol_usuario());
                
           session.update(user);
             
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
     
    public void crearUsuario(Usuario usu){
      Session session = sessionFactory.openSession();
        Transaction tx = null;
        Usuario usuario = usu;
        try {
           tx = session.beginTransaction();
            session.save(usuario);
             
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
