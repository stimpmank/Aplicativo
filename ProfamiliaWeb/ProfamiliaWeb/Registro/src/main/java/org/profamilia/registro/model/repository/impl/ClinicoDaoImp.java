package org.profamilia.registro.model.repository.impl;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.profamilia.registro.model.dtos.Chconsutarif;
import org.profamilia.registro.constants.IConstantes;
import org.profamilia.registro.model.entities.Ccdescempl;
import org.profamilia.registro.model.entities.Chusuario;
import org.profamilia.registro.model.entities.Cicotizsap;
import org.profamilia.registro.model.entities.Cpclinica;
import org.profamilia.registro.model.entities.Cpcontrato;
import org.profamilia.registro.model.entities.Cpentidadadm;
import org.profamilia.registro.model.entities.Cpmunidane;
import org.profamilia.registro.model.entities.Cpocupacio;
import org.profamilia.registro.model.entities.Cprestxcon;
import org.profamilia.registro.model.entities.Cpservicio;
import org.profamilia.registro.model.entities.Cpusuario;
import org.profamilia.registro.model.entities.legacy.dao.BaseDao;
import org.profamilia.registro.model.repository.ClinicoDao;
import org.profamilia.registro.model.exception.ModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository("ClinicoDao")
public class ClinicoDaoImp extends BaseDao implements ClinicoDao {

    private static final Logger logger = LoggerFactory.getLogger(ClinicoDaoImp.class);

    @Autowired
    public ClinicoDaoImp(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    /**
     * @param idDepto
     * @return
     * @throws ModelException
     */
    @Override
    public List getMunicipios(Short idDepto) throws ModelException {
        List resultList = null;
        try {

            StringBuilder sb = new StringBuilder();
            sb.append(" select c from Cpmunidane as c ");
            sb.append(" where c.id.cmdncoddep = ").append(idDepto);
            sb.append(" ORDER BY c.cmdcnommun ");
            resultList = this.getHibernateTemplate().find(sb.toString());

        } catch (HibernateException e) {
            throw new ModelException("Error consultando municipios:"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando municipios:"
                    + e.getMessage(), e);
        }
        return resultList;
    }

    /**
     * @param ceaccodigo
     * @return
     * @throws ModelException
     */
    @Override
    public Cpentidadadm getAseguradoraPorCodigo(String ceaccodigo) throws ModelException {
        Cpentidadadm entidad = null;

        try {
            if (ceaccodigo != null) {
                entidad = this.getHibernateTemplate().get(Cpentidadadm.class, ceaccodigo);
            }

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Entidad Administradora:"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Entidad Administradora:"
                    + e.getMessage(), e);
        }

        return entidad;
    }

    /**
     * Obtener una Clinica.
     *
     * @param cclncodigo Codigo de la clinica a consultar
     * @return La clinica consultada
     * @throws org.profamilia.registro.model.exception.ModelException
     */
    @Override
    public Cpclinica getClinica(Integer cclncodigo) throws ModelException {
        Cpclinica entidad = new Cpclinica();
        try {

            entidad
                    = this.getHibernateTemplate().get(Cpclinica.class, cclncodigo.shortValue());

        } catch (HibernateException e) {
            throw new ModelException("Error consultando clinica:"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando clinica:"
                    + e.getMessage(), e);
        }
        return entidad;
    }

    /**
     * Obtener una Usuario.
     *
     * @throws org.profamilia.registro.model.exception.ModelException
     */
    @Override
    public Cpusuario getUsuarioPorId(String curcusuari) throws ModelException {
        Cpusuario entidad = new Cpusuario();
        List resultList = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(" select o from ").append(Cpusuario.class.getName()).append(" o left join fetch o.curnclinic where o.curcusuari = :curcusuari");

            resultList
                    = this.getHibernateTemplate().findByNamedParam(sb.toString(), new String[]{"curcusuari"}, new Object[]{curcusuari});
            if (!resultList.isEmpty()) {
                entidad = (Cpusuario) resultList.get(0);
            }

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Usuario:"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Usuario:"
                    + e.getMessage(), e);
        }
        return entidad;
    }

    /**
     * @param cocncodigo
     * @return
     * @throws ModelException
     */
    @Override
    public Cpocupacio getOcupacionPorCodigo(Integer cocncodigo) throws ModelException {
        Cpocupacio entidad = null;

        try {
            if (cocncodigo != null) {

                entidad
                        = this.getHibernateTemplate().get(Cpocupacio.class, cocncodigo.shortValue());
            }

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Ocupacion:"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Ocupacion:"
                    + e.getMessage(), e);
        }
        return entidad;

    }

    /**
     * @param tipoIdentificacion
     * @param numeroIdentificacion
     *
     * @return
     * @throws ModelException
     */
    public List<Chusuario> getUsuariosClienteActivo(String tipoIdentificacion,
            BigDecimal numeroIdentificacion) throws ModelException {
        List<Chusuario> resultList = null;
        try {

            if (tipoIdentificacion != null && numeroIdentificacion != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(" select chus from ").append(Chusuario.class.getName()).append(" chus  where chus.husetipoiden = :tipoIdentificacion and chus.husanumeiden = :numeroIdentificacion and huseestado not in ('SM')  order by  chus.huslnumero ");

                resultList
                        = (List<Chusuario>) getHibernateTemplate().findByNamedParam(sb.toString(), new String[]{"tipoIdentificacion", "numeroIdentificacion"}, new Object[]{tipoIdentificacion, numeroIdentificacion});

            }

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Usuario:"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Usuario :"
                    + e.getMessage(), e);
        }

        return resultList;

    }

    @Override
    public List<Chusuario> getUsuariosClienteInactivo(String tipoIdentificacion,
            BigDecimal numeroIdentificacion) throws ModelException {
        List<Chusuario> resultList = null;
        try {

            if (tipoIdentificacion != null && numeroIdentificacion != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(" select chus from ").append(Chusuario.class.getName()).append(" chus  where chus.husetipoiden = :tipoIdentificacion and chus.husanumeiden = :numeroIdentificacion and huseestado = :estado order by  chus.huslnumero ");

                resultList
                        = (List<Chusuario>) getHibernateTemplate().findByNamedParam(sb.toString(), new String[]{"tipoIdentificacion", "numeroIdentificacion", "estado"}, new Object[]{tipoIdentificacion, numeroIdentificacion, IConstantes.ESTADO_SIN_MOVIMIENTO});
            }

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Usuario:"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Usuario :"
                    + e.getMessage(), e);
        }

        return resultList;

    }

    public BigDecimal getDescuentoEmpleado(String servicio, String tipIdent,
            BigDecimal numIdent) throws ModelException {
        BigDecimal resultList = new BigDecimal(0);
        Cpservicio resultList2 = null;
        Ccdescempl resultList3 = null;
        List<Ccdescempl> resultList4 = null;
        Ccdescempl resultList5 = null;

        Short grupo = null;
        Short subgrupo = null;
        Long grupo2 = null;
        Long subgrupo2 = null;
        String servici = null;
        BigDecimal grpcmp = null;
        BigDecimal cantidad = null;
        BigDecimal porcedescu = null;
        Long anno = null;
        Long grupo3 = null;
        Long subgrupo3 = null;
        String servicio2 = null;
        BigDecimal cantidad2 = null;
        BigDecimal cantidad3 = null;
        BigDecimal wporgrp = new BigDecimal(0);
        try {

            if (servicio != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select cpse from " + Cpservicio.class.getName());
                sb.append(" cpse ");
                sb.append(" WHERE cpse.csvccodigo = :servicio ");

                Query sqlquery
                        = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("servicio", servicio);

                resultList2 = (Cpservicio) sqlquery.uniqueResult();
                if (resultList2 != null) {

                    grupo = resultList2.getCsvngrupo();
                    subgrupo = resultList2.getCsvnsubgru();

                    //    return resultList;
                }
            }

            if (servicio != null && !servicio.equals("")
                    && resultList2 != null && grupo != null && subgrupo != null) {
                StringBuffer sf = new StringBuffer();
                sf.append(" select ccde");
                sf.append(" FROM " + Ccdescempl.class.getName());
                sf.append(" ccde ");
                sf.append(" WHERE ccde.id.cdenanno = 2011 AND ccde.id.cdectipide = 'CC' ");
                sf.append(" AND ccde.id.cdeanumide = 0 AND ccde.id.cdengrupo = :grupo ");
                sf.append(" AND (ccde.id.cdensubgru = 0 OR ccde.id.cdensubgru = :subgrupo) ");
                sf.append(" AND (ccde.id.cdecservic = :servicio) ");
                sf.append(" ORDER BY ccde.id.cdecservic DESC ");

                Query sqlquery2
                        = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sf.toString());
                sqlquery2.setParameter("grupo", grupo);
                sqlquery2.setParameter("subgrupo", subgrupo);
                sqlquery2.setParameter("servicio", servicio);

                resultList3 = (Ccdescempl) sqlquery2.uniqueResult();
                if (resultList3 != null) {
                    grupo2 = resultList3.getId().getCdengrupo();
                    subgrupo2 = resultList3.getId().getCdensubgru();
                    servici = resultList3.getId().getCdecservic();
                    grpcmp = resultList3.getCdengrpcmp();
                    cantidad = resultList3.getCdencantid();
                    porcedescu = resultList3.getCdeapordsc();
                    anno = resultList3.getId().getCdenanno();

                }

            }

            Calendar calen = Calendar.getInstance();
            Integer wanoreg = calen.get(Calendar.YEAR);

            if (servicio != null && !servicio.equals("")
                    && resultList3 != null) {
                StringBuffer sd = new StringBuffer();
                sd.append(" SELECT ccde ");
                sd.append(" from " + Ccdescempl.class.getName());
                sd.append(" ccde ");
                sd.append(" WHERE ccde.id.cdenanno = :wanoreg AND ccde.id.cdectipide = :tipIdent  ");
                sd.append(" AND ccde.id.cdeanumide = :numIndent AND ccde.cdengrpcmp = :grpcmp ");

                Query sqlquery3
                        = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sd.toString());
                sqlquery3.setParameter("wanoreg", wanoreg);
                sqlquery3.setParameter("tipIdent", tipIdent);
                sqlquery3.setParameter("numIndent", numIdent);
                sqlquery3.setParameter("grpcmp", grpcmp);

                resultList4 = (List<Ccdescempl>) sqlquery3.list();
                if (resultList4 != null) {
                    for (Ccdescempl papaito : resultList4) {
                        grupo3 = papaito.getId().getCdengrupo();
                        subgrupo3 = papaito.getId().getCdensubgru();
                        servicio2 = papaito.getId().getCdecservic();
                        cantidad2 = papaito.getCdencantid();

                        if (servicio != null && !servicio.equals("")
                                && grupo3 != null && subgrupo3 != null
                                && servicio2 != null) {
                            StringBuffer se = new StringBuffer();
                            se.append(" SELECT ccde ");
                            se.append(" from " + Ccdescempl.class.getName());
                            se.append(" ccde ");
                            se.append(" WHERE ccde.id.cdenanno = 2011 AND ccde.id.cdectipide = 'CC' ");
                            se.append(" AND ccde.id.cdeanumide = 0 AND ccde.id.cdengrupo = :grupo3 ");
                            se.append(" AND ccde.id.cdensubgru = :subgrupo3 AND ccde.id.cdecservic = :servicio2 ");

                            Query sqlquery4
                                    = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(se.toString());
                            sqlquery4.setParameter("grupo3", grupo3);
                            sqlquery4.setParameter("subgrupo3", subgrupo3);
                            sqlquery4.setParameter("servicio2", servicio2);
                            resultList5 = (Ccdescempl) sqlquery4.uniqueResult();
                            if (resultList5 != null) {
                                cantidad3 = resultList5.getCdencantid();
                            }
                            if (cantidad3 != null && cantidad2 != null
                                    && cantidad != null) {
                                wporgrp
                                        = wporgrp.add(cantidad2.multiply(new BigDecimal(100)).divide(cantidad,
                                                        2,
                                                        BigDecimal.ROUND_HALF_DOWN));
                                System.out.println("" + wporgrp);
                            }
                            if (wporgrp != null) {
                                resultList = wporgrp;
                            }

                        }

                    }

                }
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Descuentos de Empleado:"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Descuentos de Empleado:"
                    + e.getMessage(), e);
        }

    }

    @Override
    public List<Cprestxcon> getValidarContrato(Integer clinic, Integer contra,
            String servicio) throws ModelException {
        List<Cprestxcon> resultList = null;
        Integer contrato = null;
        List<Cprestxcon> resultList2 = null;
        Object estado = null;
        Object regimen = null;
        Object servic = null;
        Object sexo = null;
        Object edadmin = null;
        Object edadmax = null;
        Object tideex = null;
        try {
            if (contra != null && clinic != null && servicio != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(" SELECT cpre ")
                        .append(" from ")
                        .append(Cprestxcon.class.getName())
                        .append(" cpre ")
                        .append(" WHERE cpre.id.crxnclinic = :clinic AND cpre.id.crxncontra = :contra ")
                        .append(" AND cpre.crxcservic = :servicio AND cpre.crxcestado = 'VG' ")
                        .append(" ORDER BY cpre.crxnedamin, cpre.crxnedamax ");

                Query sqlquery
                        = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("clinic", clinic);
                sqlquery.setParameter("contra", contra);
                sqlquery.setParameter("servicio", servicio);

                resultList2 = (List<Cprestxcon>) sqlquery.list();
                if (resultList2 != null) {
                    for (Cprestxcon restricc : resultList2) {
                        estado = restricc.getCrxcestado();
                        regimen = restricc.getCrxcregime();
                        servic = restricc.getCrxcservic();
                        sexo = restricc.getCrxcsexo();
                        edadmin = restricc.getCrxnedamin();
                        edadmax = restricc.getCrxnedamax();
                        tideex = restricc.getCrxctideex();
                    }
                }
            }

            return resultList2;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Otras Asesorias:"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Otras Asesorias:"
                    + e.getMessage(), e);
        }

    }

    /**
     * @param cocncodigo
     * @return
     * @throws org.profamilia.registro.model.exception.ModelException
     */
    @Override
    public String getDescripcionOcupacion(Short cocncodigo) throws ModelException {
        List<String> resultList = null;
        List parametros = new ArrayList();
        try {
            if (cocncodigo != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("select cpoc.coccdescri FROM ")
                        .append(Cpocupacio.class.getName())
                        .append(" cpoc where cpoc.cocncodigo = ? ");
                parametros.add(cocncodigo);

                resultList
                        = (List<String>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }

            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Descripcion Ocupacion:"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Descripcion Ocupacion:"
                    + e.getMessage(), e);
        }

    }

    @Override
    public String getDescripcionEntidadByCodigo(String codigo)
            throws ModelException {
        List<String> resultList = null;
        List parametros
                = new ArrayList();

        try {
            if (codigo != null) {

                StringBuilder sb = new StringBuilder();
                sb.append(" select cpea.ceacnombre from " + Cpentidadadm.class.getName() + " cpea ");
                sb.append(" where cpea.ceaccodigo = ? ");
                parametros.add(codigo);
                resultList = (List<String>) this.getHibernateTemplate().find(sb.toString(),
                        parametros.toArray());

                if (!resultList.isEmpty() && resultList.get(0) != null) {
                    return resultList.get(0);
                }
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException(
                    "Error consultando Descripcion Entidad Administradora:" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException(
                    "Error consultando Descripcion Entidad Administradora:" + e.getMessage(), e);
        }

    }

    /**
     * @return @throws ModelException
     */
    @Override
    public List getTipoIdentificacion() throws ModelException {
        List resultList = null;
        try {
            resultList
                    = this.currentSession().createQuery("SELECT c " + "FROM Cptipoiden AS c "
                            + "ORDER BY c.cticdescri ").list();
        } catch (HibernateException e) {
            throw new ModelException("Error consultando tipo identificación:"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando tipo identificación:"
                    + e.getMessage(), e);
        }
        return resultList;
    }

    /**
     * @return @throws ModelException
     */
    @Override
    public List getDepartamentos() throws ModelException {
        List resultList = null;
        try {
            resultList
                    = this.currentSession().createQuery("SELECT c " + "FROM Cpdepadane AS c "
                            + "ORDER BY c.cddcdescri ").list();
        } catch (HibernateException e) {
            throw new ModelException("Error consultando departamentos:"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando departamentos:"
                    + e.getMessage(), e);
        }
        return resultList;
    }

    /**
     * @return @throws ModelException
     */
    @Override
    public List getOcupaciones() throws ModelException {
        List resultList = null;
        try {
            resultList
                    = this.currentSession().createQuery("SELECT c " + "FROM Cpocupacio AS c where c.coccestado = 'VG' "
                            + "ORDER BY c.coccdescri ").list();
        } catch (HibernateException e) {
            throw new ModelException("Error consultando ocupaciones:"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando ocupaciones:"
                    + e.getMessage(), e);
        }
        return resultList;
    }

    /**
     * @return @throws ModelException
     */
    public List getEntidadAdm() throws ModelException {
        List resultList = null;
        try {
            resultList
                    = this.currentSession().createQuery("SELECT c " + "FROM Cpentidadadm AS c "
                            + "ORDER BY c.ceacnombre ").list();
        } catch (HibernateException e) {
            throw new ModelException("Error consultando entidad administradora:"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando entidad administradora:"
                    + e.getMessage(), e);
        }
        return resultList;
    }

    /**
     * @param usuario
     * @throws ModelException / public void saveUsuarioSap(final Chusuario
     * usuario, final String userName, final List<Chconsutarif>
     * ltsTarifaServicio, final Integer clinica, final String tipoVenta) throws
     * ModelException {
     *
     * try { this.getHibernateTemplate().execute(new HibernateCallback() {
     * public Object doInHibernate(Session session) { Date fechaRegistro = new
     * Date(); if (usuario != null) { Long huslnumero = null;
     *
     * if (usuario != null && usuario.getHuslnumero() == null) { BigDecimal
     * secuenciaActual = (BigDecimal)session.createSQLQuery("SELECT
     * cpco.connnumero FROM clinico.Cpconsec cpco where cpco.conncodigo = " +
     * IConstantes.CCONUSUA + " FOR UPDATE nowait").uniqueResult();
     *
     * if (secuenciaActual != null) { huslnumero = secuenciaActual.longValue();
     * }
     *
     * session.createSQLQuery("update clinico.Cpconsec set connnumero =
     * connnumero + 1 where conncodigo = " + IConstantes.CCONUSUA + "
     * ").executeUpdate();
     *
     *
     * usuario.setHuslnumero(huslnumero); usuario.setHusnfolioactua(0);
     * usuario.setHusehistoria("N");
     *
     *
     * }
     * if (usuario != null && usuario.getHuslnumero() != null &&
     * usuario.getHusanumeiden() != null && usuario.getHusetipoiden() != null) {
     * StringBuffer sb = new StringBuffer(); sb.append(" update
     * historia.chusuario" + " set huseestado = 'SM' " + " where husanumeiden =
     * :wusuari " + " and husetipoiden = :wtipiden " + " and huslnumero !=
     * :wnumero "); Query query = session.createSQLQuery(sb.toString());
     * query.setParameter("wusuari", usuario.getHusanumeiden());
     * query.setParameter("wtipiden", usuario.getHusetipoiden());
     * query.setParameter("wnumero", usuario.getHuslnumero());
     * query.executeUpdate(); }
     *
     *
     * usuario.setHusdfecregistr(new Date()); usuario.setHuscoperador(userName);
     * usuario.setHuseestado(IConstantes.ESTADO_CON_MOVIMIENTO);
     *
     * session.saveOrUpdate(usuario);
     *
     * // Guardamos la cotizacion
     *
     * if (ltsTarifaServicio != null && !ltsTarifaServicio.isEmpty()) { for
     * (Chconsutarif sap: ltsTarifaServicio) { Cicotizsap cotiza = new
     * Cicotizsap(); cotiza.setCcsanumerident(usuario.getHusanumeiden());
     * cotiza.setCcsclugarservi(sap.getLugarServicio());
     * cotiza.setCcscservicio(sap.getMaterial());
     * cotiza.setCcsctipoident(usuario.getHusetipoiden());
     * cotiza.setCcsdfechacotiz(fechaRegistro);
     * cotiza.setCcsdhoracotiz(fechaRegistro);
     * cotiza.setCcslusuario(usuario.getHuslnumero());
     * cotiza.setCcsncantidad(sap.getCantidadMaterial());
     * cotiza.setCcsnclinica(clinica); cotiza.setCcsctipoventa(tipoVenta);
     *
     * session.saveOrUpdate(cotiza); }
     *
     *
     * }
     * }
     *
     *
     * return usuario; } }); } catch (HibernateException e) { throw new
     * ModelException("Error Insertando :" + e.getMessage(), e); } catch
     * (Exception e) { throw new ModelException("Error Insertando :" +
     * e.getMessage(), e); } }
     */
    /**
     * @param municipio
     * @return
     * @throws ModelException
     */
    @Override
    public Cpmunidane getMunicipiosSap(Short departamento,
            Short municipio) throws ModelException {
        List<Cpmunidane> resultList = null;
        List parametros = new ArrayList();

        try {
            StringBuilder sb = new StringBuilder();
            sb.append(" select cpmd from ")
                    .append(Cpmunidane.class.getName())
                    .append(" cpmd where cpmd.id.cmdncodmun =  ? and cpmd.id.cmdncoddep = ? ");

            parametros.add(municipio);
            parametros.add(departamento);

            resultList
                    = (List<Cpmunidane>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList.get(0);
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Servicios:"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Servicios:"
                    + e.getMessage(), e);
        }

    }

    /**
     * @param eps
     * @return
     * @throws ModelException
     */
    @Override
    public List<Cpentidadadm> getEntidadEps(Cpentidadadm eps) throws ModelException {
        List<Cpentidadadm> resultList = null;
        List parametros = new ArrayList();

        try {
            StringBuilder sb = new StringBuilder();
            sb.append(" select cpea from ").append(Cpentidadadm.class.getName()).append(" cpea where upper(cpea.ceacnombre) like upper(?) ");

            parametros.add("%" + eps.getCeacnombre() + "%");

            if (eps.getCeaccodigo() != null && !eps.getCeaccodigo().isEmpty()) {
                sb.append(" and upper(cpea.ceaccodigo)  like upper(?)  ");
                parametros.add("%" + eps.getCeaccodigo() + "%");
            }

            resultList
                    = (List<Cpentidadadm>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Servicios:"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Servicios:"
                    + e.getMessage(), e);
        }

    }

    /**
     * @param ocupacion
     * @return
     * @throws ModelException
     */
    @Override
    public List<Cpocupacio> getOcupacion(Cpocupacio ocupacion) throws ModelException {
        List<Cpocupacio> resultList = null;
        List parametros = new ArrayList();

        try {
            StringBuilder sb = new StringBuilder();
            sb.append(" select cpoc from ")
                    .append(Cpocupacio.class.getName())
                    .append(" cpoc where upper(cpoc.coccdescri) like upper(?) ");

            parametros.add("%" + ocupacion.getCoccdescri() + "%");

            if (ocupacion.getCocncodigo() != null) {
                sb.append(" and upper(cpoc.cocncodigo)  = ?  ");
                parametros.add(ocupacion.getCocncodigo());
            }

            resultList
                    = (List<Cpocupacio>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Servicios:"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Servicios:"
                    + e.getMessage(), e);
        }

    }

    /**
     * @param contrato
     * @return
     * @throws ModelException
     */
    @Override
    public List<Cpcontrato> getContrato(Cpcontrato contrato, Short clinica) throws ModelException {
        List<Cpcontrato> resultList = null;
        List parametros = new ArrayList();

        try {
            StringBuilder sb = new StringBuilder();
            sb.append(" select cpco from ")
                    .append(Cpcontrato.class.getName())
                    .append(" cpco where  cpco.ccncestado = 'VG' and (cpco.id.ccnnclinic = ? OR cpco.id.ccnnclinic = 9) ");
            parametros.add(clinica);

            if (contrato.getCcncdescri() != null) {
                logger.warn("desc:" + contrato.getCcncdescri());
                sb.append(" and upper(cpco.ccncdescri) like upper(?)  ");
                parametros.add("%" + contrato.getCcncdescri() + "%");
            }

            if (contrato.getCpcontratoPK() != null && contrato.getCpcontratoPK().getCcnnnumero() != null) {
                logger.warn("numero:" + contrato.getCpcontratoPK().getCcnnnumero());
                sb.append(" and cpco.id.ccnnnumero  = ?  ");
                parametros.add(contrato.getCpcontratoPK().getCcnnnumero());
            }

            resultList
                    = (List<Cpcontrato>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                logger.warn("Contratos Encontrados!!!!!!!!!!!!!");
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Contratos:"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Contratos:"
                    + e.getMessage(), e);
        }

    }

    /**
     * @param contrato
     * @return
     * @throws ModelException
     */
    @Override
    public Cpcontrato getContratoSelec(Cpcontrato contrato, Short clinica) throws ModelException {
        logger.error("getContratoSelec: [contrato] " + contrato);
        logger.error("getContratoSelec: [clinica] " + clinica);
        List<Cpcontrato> resultList = null;
        List parametros = new ArrayList();

        try {
            StringBuilder sb = new StringBuilder();
            sb.append(" select cpco from ")
                    .append(Cpcontrato.class.getName())
                    .append(" cpco where  cpco.ccncestado = 'VG' and (cpco.id.ccnnclinic = ? OR cpco.id.ccnnclinic = 9) ");
            parametros.add(clinica);

            if (contrato.getCcncdescri() != null) {
                sb.append(" and upper(cpco.ccncdescri) like upper(?)  ");
                parametros.add("%" + contrato.getCcncdescri() + "%");
            }

            if (contrato.getCpcontratoPK() != null) {
                sb.append(" and cpco.id.ccnnnumero  = ?  ");
                parametros.add(contrato.getCpcontratoPK().getCcnnnumero());
            }

            resultList
                    = (List<Cpcontrato>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList.get(0);
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Contratos:"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Contratos:"
                    + e.getMessage(), e);
        }

    }

    @Override
    public Cpservicio getDescripcionServicioSapXCodigo(final String servicio) throws ModelException {

        logger.error("getDescripcionServicioSapXCodigo: " + servicio);

        String sb = " select cpse from " + Cpservicio.class.getName() + " cpse " + "  where upper(cpse.csvccodigo) = :codigo and cpse.csvcestado = 'VG' ";
        List resultList = null;
        Cpservicio pis = null;

        try {
            logger.error("getDescripcionServicioSapXCodigo: 1");
            resultList = getHibernateTemplate().findByNamedParam(sb, new String[]{"codigo"}, new Object[]{servicio.toUpperCase()});

            logger.error("getDescripcionServicioSapXCodigo: 2");
            if (!resultList.isEmpty()) {
                pis = (Cpservicio) resultList.get(0);
                logger.error("getDescripcionServicioSapXCodigo: 3");
            }
        } catch (HibernateException e) {
            throw new ModelException("Error consultando Usuario:"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Usuario:"
                    + e.getMessage(), e);
        }
        logger.error("getDescripcionServicioSapXCodigo: 4 " + pis);
        return pis;

    }

    /**
     * @param servicio
     * @return
     * @throws ModelException
     */
    @Override
    public List<Cpservicio> getServicioSap(Cpservicio servicio) throws ModelException {
        List<Cpservicio> resultList = null;
        List parametros = new ArrayList();

        try {
            StringBuilder sb = new StringBuilder()
                    .append(" select cpse from ")
                    .append(Cpservicio.class.getName())
                    .append(" cpse where upper(cpse.csvccodigo) like upper(?) and cpse.csvcestado = 'VG' ");

            parametros.add("%" + servicio.getCsvccodigo() + "%");

            if (servicio.getCsvcnombre() != null
                    && servicio.getCsvcnombre() != null
                    && !servicio.getCsvcnombre().isEmpty()) {
                sb.append(" and upper(cpse.csvcnombre)  like upper(?)  ");
                parametros.add("%" + servicio.getCsvcnombre() + "%");
            }

            resultList
                    = (List<Cpservicio>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Servicios:"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Servicios:"
                    + e.getMessage(), e);
        }

    }

    @Override
    public List<Object[]> getContratosxServicio(Short clinic, Integer contra,
            String servicio) throws ModelException {
        List resultList = null;
        logger.error("clinic: " + clinic);
        logger.error("contra: " + contra);
        logger.error("servicio: " + servicio);
        try {

            if (contra != null && clinic != null && servicio != null) {

                StringBuilder sb = new StringBuilder()
                        .append(" select numero, fechainI, fechafin, CSCNSTLNR, CSVCCODIGO, CSCCTIPOPOSC, nombreservi, (case when tabla2.valortotal is null then CSCAVALSER else tabla2.valortotal END  )valor, utiliza ")
                        .append(" from (select cpco.CCNNNUMERO numero, cpco.CCNDFECINI fechainI, cpco.CCNDFECFIN fechafin ,  cpsx.CSCNSTLNR CSCNSTLNR ,cpse.CSVCCODIGO CSVCCODIGO,cpsx.CSCAVALSER CSCAVALSER,cpsx.CSCCTIPOPOSC, cpse.csvcnombre nombreservi, cpsx.CSCCUTILIZA utiliza ")
                        .append(" from clinico.cpcontrato cpco, clinico.cpserxcon cpsx, clinico.cpservicio cpse ")
                        .append(" where cpco.CCNNNUMERO = cpsx.CSCNNUMERO ")
                        .append(" and cpsx.CSCCSERVIC = cpse.CSVCCODIGO ")
                        .append(" and cpco.CCNNCLINIC = cpsx.CSCNCLINIC ")
                        .append(" and cpco.CCNCESTADO =  'VG' ")
                        .append(" and cpsx.CSCNSTLNR IS NOT NULL ")
                        .append(" and (cpco.ccnnclinic = :wclinic OR cpco.ccnnclinic = 9) ");

                if (!servicio.isEmpty()) {
                    sb.append(" and cpsx.csccservic = :wservi ");
                }

                sb.append(" and cpco.CCNNNUMERO = :wcontra ")
                        .append(" and cpsx.CSCCTIPOPOSC = 'TAP' ")
                        .append(" union all ")
                        .append(" select cpco.CCNNNUMERO numero, cpco.CCNDFECINI fechainI, cpco.CCNDFECFIN fechafin, cpsx.CSCNSTLNR CSCNSTLNR, cpse.CSVCCODIGO CSVCCODIGO, cpsx.CSCAVALSER CSCAVALSER, cpsx.CSCCTIPOPOSC CSCCTIPOPOSC, cpse.csvcnombre nombreservi, cpsx.CSCCUTILIZA utiliza ")
                        .append(" from clinico.cpcontrato cpco, clinico.cpserxcon cpsx, clinico.cpservicio cpse ")
                        .append(" where cpco.CCNNNUMERO = cpsx.CSCNNUMERO ")
                        .append(" and cpsx.CSCCSERVIC = cpse.CSVCCODIGO ")
                        .append(" and cpco.CCNNCLINIC = cpsx.CSCNCLINIC ")
                        .append(" and cpco.CCNCESTADO =  'VG' ")
                        .append(" and cpsx.CSCNSTLNR IS  NULL ")
                        .append(" and cpco.CCNNNUMERO = :wcontra ")
                        .append(" and (cpco.ccnnclinic = :wclinic OR cpco.ccnnclinic = 9) ");

                if (!servicio.isEmpty()) {
                    sb.append(" and cpsx.csccservic = :wservi ");
                }

                sb.append(" and cpsx.CSCCTIPOPOSC <>  'TAP') tabla ")
                        .append(" LEFT JOIN (select cpsx.CSCNSTLNR cosito2, sum(cpsx.CSCAVALSER) valortotal ")
                        .append(" from  clinico.cpserxcon cpsx ")
                        .append(" where cpsx.CSCNNUMERO = :wcontra ")
                        .append(" and cpsx.CSCNSTLNR is not null ")
                        .append(" group by cpsx.CSCNSTLNR ) tabla2 ON tabla2.cosito2 = tabla.CSCNSTLNR ");

                Query sqlquery
                        = this.currentSession().createSQLQuery(sb.toString());

                sqlquery.setParameter("wclinic", clinic);
                sqlquery.setParameter("wcontra", contra);

                if (!servicio.isEmpty()) {
                    sqlquery.setParameter("wservi", servicio);
                }

                resultList = sqlquery.list();

                if (!resultList.isEmpty()) {
                    logger.error("EEEEXITO: " + resultList);
                    return resultList;
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Contratos: "
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Contratos: "
                    + e.getMessage(), e);
        }

    }

    @Override
    public List<Object[]> getContratosxServicioDetalle(Short clinic, Integer contra,
            String wcnstlnr, String wutiliza) throws ModelException {
        List resultList = null;

        try {
            if (contra != null && clinic != null && wcnstlnr != null) {

                StringBuilder sb = new StringBuilder()
                        .append(" select cpco.CCNNNUMERO numero, cpse.CSVCCODIGO CSVCCODIGO, cpse.CSVCNOMBRE CSVCNOMBRE, cpsx.CSCAVALSER CSCAVALSER ")
                        .append(" from clinico.cpcontrato cpco, clinico.cpserxcon cpsx, clinico.cpservicio cpse ")
                        .append(" where cpco.CCNNNUMERO = cpsx.CSCNNUMERO ")
                        .append(" and cpsx.CSCCSERVIC = cpse.CSVCCODIGO ")
                        .append(" and cpco.CCNNCLINIC = cpsx.CSCNCLINIC ")
                        .append(" and cpco.CCNCESTADO =  'VG' ")
                        .append(" and cpsx.CSCNSTLNR IS NOT NULL ")
                        .append(" and (cpco.ccnnclinic = :wclinic  OR cpco.ccnnclinic = 9)  ")
                        .append(" and cpco.CCNNNUMERO = :wcontra ")
                        .append(" and cpsx.CSCNSTLNR = :wcnstlnr ")
                        .append(" and cpsx.CSCCTIPOPOSC != 'TAP' ")
                        .append(" and cpsx.CSCCUTILIZA = :wutiliza ");

                Query sqlquery
                        = this.currentSession().createSQLQuery(sb.toString());

                sqlquery.setParameter("wclinic", clinic);
                sqlquery.setParameter("wcontra", contra);
                sqlquery.setParameter("wcnstlnr", wcnstlnr);
                sqlquery.setParameter("wutiliza", wutiliza);

                resultList = sqlquery.list();

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Detalle de Contratos: "
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Detalle de Contratos: "
                    + e.getMessage(), e);
        }

    }

    @Override
    public void saveUsuarioSap(Chusuario usuario, String userName, List<Chconsutarif> ltsTarifaServicio, Short clinica, String tipoVenta) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                public Object doInHibernate(Session session) {
                    Date fechaRegistro = new Date();
                    if (usuario != null) {
                        Long huslnumero = null;
                        
                        if (usuario != null
                                && usuario.getHuslnumero() <= 0) {
                            BigDecimal secuenciaActual
                                    = (BigDecimal) session.createSQLQuery("SELECT cpco.connnumero FROM clinico.Cpconsec cpco where cpco.conncodigo = "
                                            + IConstantes.CCONUSUA
                                            + " FOR UPDATE nowait").uniqueResult();
                            if (secuenciaActual != null) {
                                huslnumero
                                        = secuenciaActual.longValue();
                            }
                            session.createSQLQuery("update clinico.Cpconsec set connnumero = connnumero + 1  where conncodigo = "
                                    + IConstantes.CCONUSUA
                                    + " ").executeUpdate();

                            usuario.setHuslnumero(huslnumero);
                            usuario.setHusnfolioactua(BigDecimal.ZERO);
                            usuario.setHusehistoria("N");

                        }
                        if (usuario != null
                                && usuario.getHuslnumero() > 0
                                && usuario.getHusanumeiden() != null
                                && usuario.getHusetipoiden() != null) {
                            StringBuffer sb = new StringBuffer();
                            sb.append(" update historia.chusuario"
                                    + " set huseestado = 'SM' "
                                    + " where husanumeiden = :wusuari "
                                    + " and husetipoiden = :wtipiden "
                                    + " and huslnumero != :wnumero ");
                            Query query
                                    = session.createSQLQuery(sb.toString());
                            query.setParameter("wusuari",
                                    usuario.getHusanumeiden());
                            query.setParameter("wtipiden",
                                    usuario.getHusetipoiden());
                            query.setParameter("wnumero",
                                    usuario.getHuslnumero());
                            query.executeUpdate();
                        }

                        usuario.setHusdfecregistr(new Date());
                        usuario.setHuscoperador(userName);
                        usuario.setHuseestado(IConstantes.ESTADO_CON_MOVIMIENTO);
                        session.saveOrUpdate(usuario);
                                // Guardamos la cotizacion

                        // ya no se utiliza antes 2 roles y se enviaba a sap, esto ya o se realiza
                        if (ltsTarifaServicio != null
                                && !ltsTarifaServicio.isEmpty()) {
                            for (Chconsutarif sap : ltsTarifaServicio) {
                                Cicotizsap cotiza = new Cicotizsap();
                                cotiza.setCcsanumerident(usuario.getHusanumeiden());
                                cotiza.setCcsclugarservi(sap.getLugarServicio());
                                cotiza.setCcscservicio(sap.getMaterial());
                                cotiza.setCcsctipoident(usuario.getHusetipoiden());
                                cotiza.setCcsdfechacotiz(fechaRegistro);
                                cotiza.setCcsdhoracotiz(fechaRegistro);
                                cotiza.setCcslusuario(usuario.getHuslnumero());
                                cotiza.setCcsncantidad(sap.getCantidadMaterial().shortValue());
                                //cotiza.setCcsnclinica(clinica);
                                cotiza.setCcsctipoventa(tipoVenta);

                                session.saveOrUpdate(cotiza);
                            }

                        }
                    }

                    return usuario;
                }
            });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }

}
