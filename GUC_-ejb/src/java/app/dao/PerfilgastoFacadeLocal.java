/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.entity.Perfilgasto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Naoual Amasri
 */
@Local
public interface PerfilgastoFacadeLocal {

    void create(Perfilgasto perfilgasto);

    void edit(Perfilgasto perfilgasto);

    void remove(Perfilgasto perfilgasto);

    Perfilgasto find(Object id);

    List<Perfilgasto> findAll();

    List<Perfilgasto> findRange(int[] range);

    int count();

    List<Perfilgasto> findByNoDelete();
    List<Perfilgasto> findByIdPerfilGasto(Integer idpg);
    List<Perfilgasto> findByTipoSaldo(String saldo);
    
}
