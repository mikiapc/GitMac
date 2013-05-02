/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.entity.Terminal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Naoual Amasri
 */
@Local
public interface TerminalFacadeLocal {

    void create(Terminal terminal);

    void edit(Terminal terminal);

    void remove(Terminal terminal);

    Terminal find(Object id);

    List<Terminal> findAll();
    
    Terminal findById(String i);

    List<Terminal> findRange(int[] range);

    int count();
    
}
