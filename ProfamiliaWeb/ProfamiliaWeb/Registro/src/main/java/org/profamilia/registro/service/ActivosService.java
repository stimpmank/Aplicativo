package org.profamilia.registro.service;

import java.util.List;
import org.profamilia.registro.model.entities.Sapermiso;
import org.profamilia.registro.model.entities.Sapermrol;
import org.profamilia.registro.model.entities.Sausuario;
import org.profamilia.registro.model.exception.ModelException;
import org.profamilia.registro.model.repository.ActivosDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("activosService")
@Transactional
public class ActivosService {
    
    private static final Logger logger = LoggerFactory.getLogger(ActivosService.class);
    
    @Autowired
    ActivosDao activosDao;
    
    public Sausuario getSausuario(String login) throws ModelException{
        return activosDao.getSausuario(login);
    }
    
    public List<Sapermiso> getPermisosUsuario(String login) throws ModelException {
        return activosDao.getPermisosUsuario(login);
    }
    public List<Sapermrol> getPermisosUsuarioRol(String login) throws ModelException {
        return activosDao.getPermisosUsuarioRol(login);
    }
        
    public void changePassword(String username, String oldPassword, String newPassword) throws ModelException{
        activosDao.changePassword(username, oldPassword, newPassword);
    }
    
}
