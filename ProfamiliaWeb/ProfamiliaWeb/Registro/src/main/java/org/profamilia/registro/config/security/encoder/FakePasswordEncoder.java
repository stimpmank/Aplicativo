package org.profamilia.registro.config.security.encoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

public class FakePasswordEncoder implements PasswordEncoder {
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String encode(CharSequence cs) {
        return String.valueOf(cs);
    }

    @Override
    public boolean matches(CharSequence cs, String string) {
        return true;
    }
    
}
