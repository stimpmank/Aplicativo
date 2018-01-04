package org.profamilia.registro.model.entities.legacy.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class BaseDao extends HibernateDaoSupport {

    public BaseDao(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

}
