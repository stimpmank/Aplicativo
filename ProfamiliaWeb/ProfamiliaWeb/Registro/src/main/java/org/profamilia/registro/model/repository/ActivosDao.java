/*
 * Profamilia
 * 2016  * 
 */
package org.profamilia.registro.model.repository;

import java.util.List;
import org.profamilia.registro.model.entities.Sapermiso;
import org.profamilia.registro.model.entities.Sapermrol;
import org.profamilia.registro.model.entities.Sausuario;
import org.profamilia.registro.model.exception.ModelException;

/**
 *
 * @author Jhon Carranza Silva <jcarranzas@outlook.com>
 */
public interface ActivosDao {

    public Sausuario getSausuario(String login) throws ModelException;

    public List<Sapermiso> getPermisosUsuario(String login) throws ModelException;

    public List<Sapermrol> getPermisosUsuarioRol(String login) throws ModelException;

    public void changePassword(String username, String oldPassword, String newPassword) throws ModelException;

}
