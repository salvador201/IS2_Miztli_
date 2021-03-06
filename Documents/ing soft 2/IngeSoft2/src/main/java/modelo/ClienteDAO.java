/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapeoBD.Cliente;
import MapeoBD.Empleado;
import MapeoBD.Prueba;
import MapeoBD.Prueba_cliente;
import MapeoBD.Usuario;
import java.util.LinkedList;
import java.util.List;
import javafx.beans.binding.Bindings;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Marco
 */
public class ClienteDAO implements ClienteDAOint {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public List<Cliente> porCorreo(String correo){
         Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Cliente> lista = new LinkedList<>();
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Cliente where correo = :var");
            query.setParameter("var",correo);
            lista = query.list();
        }catch(Exception e){
            e.printStackTrace(); 
        }finally{
            session.close();
        }
        return lista;   
     }
    
    public Cliente porEmpresa(String empresa){
         Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Cliente> lista = new LinkedList<>();
        Cliente cli=null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Cliente where nombre_empresa = :var");
            query.setParameter("var",empresa);
            lista = query.list();
            cli=lista.get(0);
        }catch(Exception e){
            e.printStackTrace(); 
        }finally{
            session.close();
        }
        return cli;   
     }
   
    public List<Cliente> getClientes(){
         Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Cliente> lista = new LinkedList<>();
        List<Cliente> resultado = new LinkedList<>();
        List<Empleado> lista1 = new LinkedList<>();
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Cliente");
            lista = query.list();
            Query query1 = session.createQuery("from Empleado");
            lista1 = query1.list();
            
            for (Cliente c :lista){
                if(es_solo_cliente(c,lista1)==1){
                    resultado.add(c);
                }
            }
        }catch(Exception e){
            e.printStackTrace(); 
        }finally{
            session.close();
        }
        return resultado;   
     }
     
    public int es_solo_cliente(Cliente c,List<Empleado> em){
        for (Empleado aux:em){
            if(c.getId_cliente()==aux.getCliente_id()){
                return 0;
            }
        }
        return 1;
    }
    
    
     public Cliente verCliente(long numero){
      Session session = sessionFactory.openSession();
        Transaction tx = null;
        Cliente cli = null;
        try {
           tx = session.beginTransaction();
           cli = (Cliente) session.get(Cliente.class, numero);
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
     
     public void borrarCliente(long numero){
      Session session = sessionFactory.openSession();
        Transaction tx = null;
        Cliente cli = null;
        try {
           tx = session.beginTransaction();
           cli = (Cliente) session.get(Cliente.class, numero);
           cli.setHabilitado(0);
           session.update(cli);
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
     
     public void crearCliente(Cliente cliente){
      Session session = sessionFactory.openSession();
        Transaction tx = null;
        Cliente cli = cliente;
        try {
           tx = session.beginTransaction();
            session.save(cli);
             
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
     
      public void modificaCliente(Cliente un_cliente,long id, Usuario usu){
      Session session = sessionFactory.openSession();
        Transaction tx = null;
        Cliente cli =null;
        Usuario user =null;
         try {
           tx = session.beginTransaction();
           cli=(Cliente) session.get(Cliente.class, id );
           cli.setCorreo(un_cliente.getCorreo());
           cli.setNombre_cliente(un_cliente.getNombre_cliente());
           cli.setApellido_paterno_cliente(un_cliente.getApellido_paterno_cliente());
           cli.setApellido_materno_cliente(un_cliente.getApellido_materno_cliente());
           cli.setTelefono_local(un_cliente.getTelefono_local());
           cli.setTelefono_movil(un_cliente.getTelefono_movil());
           cli.setArea(un_cliente.getArea());
           cli.setPuesto(un_cliente.getPuesto());
           cli.setNombre_empresa(un_cliente.getNombre_empresa());
           cli.setHabilitado(un_cliente.getHabilitado());
           
           user = (Usuario) session.get(Usuario.class, cli.getUsuario_id().getId_usuario());
           user.setLogin_usuario(usu.getLogin_usuario());
           
                
           session.update(user);
           session.update(cli);
             
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
    /**
     * Consulta E
     * las pruebas de un cliente disponibles apartir del ID del cliente
     * @param id
     * @return 
     */
      public List<Prueba> daPruebas(long id){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Prueba_cliente pc= null;
        List<Prueba_cliente> lista = new LinkedList<>();
        List<Prueba> pruebas=new LinkedList<>();
        try {
           tx = session.beginTransaction();
           Query query = session.createQuery("from Prueba_Cliente where cliente_id = :var");
           query.setParameter("var",id);
           lista = query.list();
           for(int i=0;i<lista.size();i++){
               pc =lista.get(i);
               pruebas.add((Prueba) session.get(Prueba.class, pc.getPrueba_id()));
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
        
        return pruebas;
      }
}
