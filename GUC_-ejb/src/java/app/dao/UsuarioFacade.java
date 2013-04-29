/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Naoual Amasri
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {
    @PersistenceContext(unitName = "GUC_-ejbPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    /**
     *
     * @param name
     * @return
     */
    @Override
     public List<Usuario> findByName(String name) {
        return em.createQuery("SELECT u FROM Usuario u WHERE u.nombre LIKE :custName")
                .setParameter("custName", name)
                .getResultList();
    }
     @Override
    public List<Usuario> findByLastName(String apellidos) {
        return em.createQuery("SELECT u FROM Usuario u WHERE u.apellidos LIKE :custApellidos")
                .setParameter("custApellidos", apellidos)
                .getResultList();
    }
    @Override
    public List<Usuario> findByNif(String nif) {
        return em.createQuery("SELECT u FROM Usuario u WHERE u.nif LIKE :custNif")
                .setParameter("custNif", nif)
                .getResultList();
    }
    @Override
    public List<Usuario> findByRol(String rol) {
        return em.createQuery("SELECT u FROM Usuario u WHERE u.rol LIKE :custRol")
                .setParameter("custRol", rol)
                .getResultList();
    }

    

 


    
   
}
