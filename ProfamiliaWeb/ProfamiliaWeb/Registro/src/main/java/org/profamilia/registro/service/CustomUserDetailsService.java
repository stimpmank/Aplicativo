package org.profamilia.registro.service;

import java.util.ArrayList;
import java.util.List;
import org.profamilia.registro.model.entities.Sarolsusua;
import org.profamilia.registro.model.entities.Sausuario;
import org.profamilia.registro.model.exception.ModelException;
import org.profamilia.registro.model.repository.ActivosDao;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetailsService implements UserDetailsService {

    protected final static Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    private ActivosDao activosDao;

    public CustomUserDetailsService(ActivosDao activosDao) {
        this.activosDao = activosDao;
    }

    private User createUser(final Sausuario usuario) {
        return new User(
                usuario.getSusclogin(),
                "---",
                true,// estado
                true,
                true,
                true,
                getGrantedAuthorities(usuario));
    }

    private List<GrantedAuthority> getGrantedAuthorities(final Sausuario usuario) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_ALLACCESS"));

        if (usuario.getSarolsusuaCollection() != null) {
            for (Sarolsusua rol : usuario.getSarolsusuaCollection()) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + rol.getSarolsusuaPK().getSrucrol().toUpperCase()));

            }
        }
        return authorities;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {
        Sausuario usuario = null;
        try {
            usuario = activosDao.getSausuario(username);            
        } catch (ModelException ex) {
            logger.error("Error consultando usuario en login", ex);
        }
        if (usuario == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        return createUser(usuario);

    }

    public ActivosDao getActivosDao() {
        return activosDao;
    }

    public void setActivosDao(ActivosDao activosDao) {
        this.activosDao = activosDao;
    }

}
