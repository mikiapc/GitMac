/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.entity.Lineapedido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Naoual Amasri
 */
@Stateless
public class LineapedidoFacade extends AbstractFacade<Lineapedido> implements LineapedidoFacadeLocal {
    @PersistenceContext(unitName = "GUC_-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineapedidoFacade() {
        super(Lineapedido.class);
    }
    
}
