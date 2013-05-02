/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.entity.Perfilgasto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Naoual Amasri
 */
@Stateless
public class PerfilgastoFacade extends AbstractFacade<Perfilgasto> implements PerfilgastoFacadeLocal {
    @PersistenceContext(unitName = "GUC_-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PerfilgastoFacade() {
        super(Perfilgasto.class);
    }

  @Override
    public List<Perfilgasto> findByIdPerfilGasto(Integer idpg) {
        
        return em.createNamedQuery("SELECT p FROM Perfilgasto p WHERE p.idPerfilGasto = :idPerfilGasto and p.borrado = 0")
                .setParameter("idPerfilGasto", idpg).getResultList();
              
    }

    @Override
    public List<Perfilgasto> findByTipoSaldo(String saldo) {
        return em.createNamedQuery("SELECT p FROM Perfilgasto p WHERE p.tipoSaldo = :tipoSaldo and p.borrado = 0")
                .setParameter("tipoSaldo", saldo).getResultList();
    }

    @Override
    public List<Perfilgasto> findByNoDelete() {
        return em.createNamedQuery("SELECT p FROM Perfilgasto p WHERE p.borrado = 0").getResultList();
    }
    
}
