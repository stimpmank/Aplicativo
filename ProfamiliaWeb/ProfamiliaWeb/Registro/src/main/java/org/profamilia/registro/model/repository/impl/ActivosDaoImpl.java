/*
 * Profamilia
 * 2016  * 
 */
package org.profamilia.registro.model.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.profamilia.registro.model.repository.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.profamilia.registro.model.entities.Sapermiso;
import org.profamilia.registro.model.entities.Sapermrol;
import org.profamilia.registro.model.entities.Sausuario;
import org.profamilia.registro.model.entities.legacy.dao.BaseDao;
import org.profamilia.registro.model.exception.ModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jhon Carranza Silva <jcarranzas@outlook.com>
 */
@Repository("ActivosDao")
public class ActivosDaoImpl extends BaseDao implements ActivosDao {

    private static final Logger logger = LoggerFactory.getLogger(ActivosDaoImpl.class);
    private static final String SQL_GET_SAUSUARIO = "SELECT a FROM Sausuario a LEFT JOIN FETCH a.sarolsusuaCollection  WHERE a.susclogin = :username";
    
    @Autowired
    public ActivosDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Sausuario getSausuario(String login) throws ModelException {
        List resultList = null;
        Sausuario sausuario = new Sausuario();
        try {
            resultList = getHibernateTemplate().findByNamedParam(SQL_GET_SAUSUARIO, new String[]{"username"}, new Object[]{login});
            if (!resultList.isEmpty()) {
                sausuario = (Sausuario) resultList.get(0);
            }

        } catch (HibernateException e) {
            logger.error("HibernateException", e);
            throw new ModelException("Error consultando Sausuario:"
                    + e.getMessage() + " Causa: "
                    + e.getCause().getMessage(), e);
        } catch (Exception e) {
            logger.error("Exception", e);
            throw new ModelException("Error consultando Sausuario:"
                    + e.getMessage() + " Causa: "
                    + e.getCause().getMessage(), e);
        }
        return sausuario;
    }

    @Override

    public List<Sapermiso> getPermisosUsuario(String login) throws ModelException {
        List resultList = null;
        try {
            String sb = "SELECT a FROM Sapermiso a WHERE a.sapermisoPK.spmcusuari = (SELECT b.suscgrulog FROM Sausuario b WHERE b.susclogin = :username )";
            resultList = getHibernateTemplate().findByNamedParam(sb, new String[]{"username"}, new Object[]{login});
        } catch (HibernateException e) {
            throw new ModelException("Error consultando Permisos:"
                    + e.getMessage() + " Causa: "
                    + e.getCause().getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Permisos:"
                    + e.getMessage() + " Causa: "
                    + e.getCause().getMessage(), e);
        }

        return resultList;
    }

    @Override
    public List<Sapermrol> getPermisosUsuarioRol(String login) throws ModelException {
        List resultList = null;
        Date wtoday = new Date();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT sapr ");
            sb.append(" FROM Sarolsusua saru, Sarol saro, Sapermrol sapr ");
            sb.append(" WHERE saru.id.srucusuari = :srucusuari AND saru.srucetapa = 'AC'");
            sb.append(" AND saru.srudfecini <= :srudfecini  ");
            sb.append(" AND (saru.srudfecfin IS NULL or saru.srudfecfin > :srudfecfin )  ");
            sb.append(" AND saru.id.srucaplica = saro.id.srocaplica ");
            sb.append(" AND saru.id.srucrol = saro.id.srocnombre AND saro.srocetapa = 'AC'  ");
            sb.append(" AND sapr.id.sprcrol = saro.id.srocnombre ");
            sb.append(" AND sapr.id.sprcaplica = saro.id.srocaplica ");
            sb.append(" AND  sapr.sprcetapa = 'AC'  ");
            sb.append(" AND  sapr.saprograma.spgcetapa = 'AC'  ");
            sb.append(" AND  sapr.saprograma.spgcnombre NOT IN  ");
            sb.append(" (SELECT sapu.id.spucprogra FROM Sapermusua sapu ");
            sb.append(" WHERE sapu.id.spucusuari = :srucusuari2 AND sapu.id.spucprogra = sapr.saprograma.spgcnombre ");
            sb.append(" AND sapu.spucetapa = 'AC' AND sapu.spuchabili = 'N' ");
            sb.append(" AND sapu.spudfecini <= :srudfecini2 ");
            sb.append(" AND (sapu.spudfecfin IS NULL OR sapu.spudfecfin > :srudfecfin2) ");
            sb.append(" ) order by sapr.saprograma.spgcdescri asc");
            
            resultList
                    = getHibernateTemplate()
                            //.find(sb.toString(), parametros.toArray());
                              .findByNamedParam(
                                      sb.toString(), 
                                      new String[]{"srucusuari","srudfecini","srudfecfin","srucusuari2","srudfecini2","srudfecfin2"}, 
                                      new Object[]{login,wtoday,wtoday,login,wtoday,wtoday});
        } catch (HibernateException e) {
            throw new ModelException("Error consultando Permisos:"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Permisos:"
                    + e.getMessage(), e);
        }

        return resultList;
    }


    @Override
    public void changePassword(String username, String oldPassword,
            String newPassword) throws ModelException {

        getHibernateTemplate().execute((Session session) -> {
            NativeQuery q = session.createNativeQuery("ALTER USER " + username + " IDENTIFIED BY " + newPassword);
            q.executeUpdate();

            q = session.createNativeQuery("UPDATE activos.sausuario SET susndiexp = 30 WHERE susclogin = :username");
            q.setParameter("username", username);
            q.executeUpdate();

            return null;

        });
    }

}
