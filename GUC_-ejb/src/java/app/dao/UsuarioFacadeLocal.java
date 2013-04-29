/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Naoual Amasri
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();
    
    List<Usuario> findByName(String nombre);
    
    List<Usuario> findByLastName(String apellidos);
    
    List<Usuario> findByNif(String nif);
    
    List<Usuario> findByRol(String rol);

    List<Usuario> findRange(int[] range);

    int count();
    
}
