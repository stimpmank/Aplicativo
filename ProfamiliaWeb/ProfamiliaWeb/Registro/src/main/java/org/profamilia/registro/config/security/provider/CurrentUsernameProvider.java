package org.profamilia.registro.config.security.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jdbc.support.ConnectionUsernameProvider;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CurrentUsernameProvider implements ConnectionUsernameProvider {

    private static final Logger logger = LoggerFactory.getLogger(CurrentUsernameProvider.class);

    @Override
    public String getUserName() {
        String username = null;
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            logger.debug("Security context user exists");
            Object principal
                    = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                logger.debug("principal is instanceof UserDetails");
                username = ((UserDetails) principal).getUsername();
            } else {
                logger.debug("principal is not instanceof UserDetails");
                username = principal.toString();
            }
        }
        return username;
    }

}
