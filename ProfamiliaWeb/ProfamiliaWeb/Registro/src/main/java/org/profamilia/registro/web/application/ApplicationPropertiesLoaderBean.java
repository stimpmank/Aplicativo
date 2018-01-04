/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.profamilia.registro.web.application;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.profamilia.registro.model.dtos.Chestadociv;
import org.profamilia.registro.model.dtos.Chtipoafilia;
import org.profamilia.registro.model.entities.Chetnia;
import org.profamilia.registro.model.entities.Chniveleduca;
import org.profamilia.registro.model.entities.Chsexo;
import org.profamilia.registro.model.entities.Chzona;
import org.profamilia.registro.model.entities.Cpdepadane;
import org.profamilia.registro.model.entities.Cpentidadadm;
import org.profamilia.registro.model.entities.Cpocupacio;
import org.profamilia.registro.model.entities.Cptipoiden;
import org.profamilia.registro.service.ClinicoProService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author czambrano
 */
@ManagedBean(name = "loaderBean")
@ApplicationScoped

public class ApplicationPropertiesLoaderBean {

    protected static final Logger logger = LoggerFactory.getLogger(ApplicationPropertiesLoaderBean.class);

    @ManagedProperty(value = "#{clinicoProService}")
    ClinicoProService clinicoProService;

    List<Chestadociv> entityListEstadoCivil;
    List<Cptipoiden> entityListTipoIdentificacion;
    List<Chsexo> entityListSexo;
    List<Chniveleduca> entityListNivelEducativo;
    List<Chetnia> entityListEtnia;
    List<Cpdepadane> entityListDepto;
    List<Chzona> entityListZona;
    List<Cpocupacio> entityListOcupacion;
    List<Cpentidadadm> entityListEps;
    List<Chtipoafilia> entityListTipoAfiliacion;

    @PostConstruct
    public void init() {

        try {
            getEntityListEstadoCivil();
        } catch (Exception ex) {
            logger.error("Error al inicializar lista estado civil", ex);
        }

        try {
            this.getEntityListTipoIdentificacion();
        } catch (Exception ex) {
            logger.error("Error al inicializar lista estado civil", ex);
        }

        try {
            this.getEntityListSexo();
        } catch (Exception ex) {
            logger.error("Error al inicializar lista estado civil", ex);
        }

        try {
            this.getEntityListNivelEducativo();
        } catch (Exception ex) {
            logger.error("Error al inicializar lista estado civil", ex);
        }

        try {
            this.getEntityListEtnia();
        } catch (Exception ex) {
            logger.error("Error al inicializar lista estado civil", ex);
        }

        try {
            this.getEntityListDepto();
        } catch (Exception ex) {
            logger.error("Error al inicializar lista estado civil", ex);
        }

        try {
            this.getEntityListZona();
        } catch (Exception ex) {
            logger.error("Error al inicializar lista estado civil", ex);
        }
        
        
        try {
            this.getEntityListOcupacion();
        } catch (Exception ex) {
            logger.error("Error al inicializar lista estado civil", ex);
        }
        
        try {
            this.getEntityListEps();
        } catch (Exception ex) {
            logger.error("Error al inicializar lista estado civil", ex);
        }
        
        try {
            this.getEntityListTipoAfiliacion();
        } catch (Exception ex) {
            logger.error("Error al inicializar lista estado civil", ex);
        }
        
    }

    public List<Chestadociv> getEntityListEstadoCivil() throws Exception {
        if (entityListEstadoCivil == null || entityListEstadoCivil.isEmpty()) {
            try {
                entityListEstadoCivil = (ArrayList<Chestadociv>) this.clinicoProService.getEstadoCivil();
            } catch (Exception e) {
                logger.error("Error consultando la lista de Estado Civil");
                throw new Exception("Error consultando la lista de Estado Civil:" + e.getMessage(), e);
            }
        }
        return entityListEstadoCivil;
    }

    public void setEntityListEstadoCivil(List<Chestadociv> entityListEstadoCivil) {
        this.entityListEstadoCivil = entityListEstadoCivil;
    }

    public List<Cptipoiden> getEntityListTipoIdentificacion() throws Exception {
        if (entityListTipoIdentificacion == null || entityListTipoIdentificacion.isEmpty()) {
            try {
                entityListTipoIdentificacion = (ArrayList<Cptipoiden>) this.clinicoProService.getTipoIdentificacion();
            } catch (Exception e) {
                logger.error("Error consultando la lista de tipos de identificacion");
                throw new Exception("Error consultando la lista de tipos de identificacion:" + e.getMessage(), e);
            }
        }
        return entityListTipoIdentificacion;
    }

    public void setEntityListTipoIdentificacion(List<Cptipoiden> entityListTipoIdentificacion) {
        this.entityListTipoIdentificacion = entityListTipoIdentificacion;
    }

    public List<Chsexo> getEntityListSexo() throws Exception {
        if (entityListSexo == null || entityListSexo.isEmpty()) {
            try {
                entityListSexo = (ArrayList<Chsexo>) this.clinicoProService.getSexoSap();
            } catch (Exception e) {
                logger.error("Error consultando la lista de Generos");
                throw new Exception("Error consultando la lista de Generos:" + e.getMessage(), e);
            }
        }
        return entityListSexo;
    }

    public void setEntityListSexo(List<Chsexo> entityListSexo) {
        this.entityListSexo = entityListSexo;
    }

    public List<Chniveleduca> getEntityListNivelEducativo() throws Exception {
        if (entityListNivelEducativo == null || entityListNivelEducativo.isEmpty()) {
            try {
                entityListNivelEducativo = (ArrayList<Chniveleduca>) this.clinicoProService.getListaNivelEducativo();
            } catch (Exception e) {
                logger.error("Error consultando la lista de Generos");
                throw new Exception("Error consultando la lista de Generos:" + e.getMessage(), e);
            }
        }
        return entityListNivelEducativo;
    }

    public void setEntityListNivelEducativo(List<Chniveleduca> entityListNivelEducativo) {
        this.entityListNivelEducativo = entityListNivelEducativo;
    }

    public List<Chetnia> getEntityListEtnia() throws Exception {
        if (entityListEtnia == null || entityListEtnia.isEmpty()) {
            try {
                entityListEtnia = (ArrayList<Chetnia>) this.clinicoProService.getListaEtnia();
            } catch (Exception e) {
                logger.error("Error consultando la lista de Etnia");
                throw new Exception("Error consultando la lista de Etnia:" + e.getMessage(), e);
            }

        }
        return entityListEtnia;
    }

    public void setEntityListEtnia(List<Chetnia> entityListEtnia) {
        this.entityListEtnia = entityListEtnia;
    }

    public List<Cpdepadane> getEntityListDepto() throws Exception {
        if (entityListDepto == null || entityListDepto.isEmpty()) {
            try {
                entityListDepto = (ArrayList<Cpdepadane>) this.clinicoProService.getDepartamentos();
            } catch (Exception e) {
                logger.error("Error consultando la lista de Departamentos");
                throw new Exception("Error consultando la lista de Departamentos:" + e.getMessage(), e);
            }
        }
        return entityListDepto;
    }

    public void setEntityListDepto(List<Cpdepadane> entityListDepto) {
        this.entityListDepto = entityListDepto;
    }

    public List<Chzona> getEntityListZona() throws Exception {
        if (entityListZona == null || entityListZona.isEmpty()) {
            try {
                entityListZona = (ArrayList<Chzona>) this.clinicoProService.getZona();
            } catch (Exception e) {
                logger.error("Error consultando la lista de Zonas");
                throw new Exception("Error consultando la lista de Zonas:" + e.getMessage(), e);
            }
        }
        return entityListZona;
    }

    public void setEntityListZona(List<Chzona> entityListZona) {
        this.entityListZona = entityListZona;
    }

    public List<Cpocupacio> getEntityListOcupacion() throws Exception {
        if (entityListOcupacion == null || entityListOcupacion.isEmpty()) {
            try {
                entityListOcupacion = this.clinicoProService.getOcupaciones();
            } catch (Exception e) {
                logger.error("Error consultando la lista de Zonas");
                throw new Exception("Error consultando la lista de Zonas:" + e.getMessage(), e);
            }
        }
        return entityListOcupacion;
    }

    public void setEntityListOcupacion(List<Cpocupacio> entityListOcupacion) {
        this.entityListOcupacion = entityListOcupacion;
    }

    public List<Cpentidadadm> getEntityListEps() throws Exception {
        if (entityListEps == null || entityListEps.isEmpty()) {
            try {
                entityListEps = this.clinicoProService.getEntidadAdm();
            } catch (Exception e) {
                logger.error("Error consultando la lista de Zonas");
                throw new Exception("Error consultando la lista de Zonas:" + e.getMessage(), e);
            }
        }
        return entityListEps;
    }

    public void setEntityListEps(List<Cpentidadadm> entityListEps) {
        this.entityListEps = entityListEps;
    }

    public List<Chtipoafilia> getEntityListTipoAfiliacion() throws Exception{
        if (entityListTipoAfiliacion == null || entityListTipoAfiliacion.isEmpty()) {
            try {
                entityListTipoAfiliacion = (ArrayList<Chtipoafilia>) this.clinicoProService.getTipoafiliado();
            } catch (Exception e) {
                logger.error("Error consultando la lista de tipo de Afiliación");
                throw new Exception("Error consultando la lista de tipo de Afiliación:" + e.getMessage(), e);
            }
        }
        return entityListTipoAfiliacion;
    }

    public void setEntityListTipoAfiliacion(List<Chtipoafilia> entityListTipoAfiliacion) {
        this.entityListTipoAfiliacion = entityListTipoAfiliacion;
    }

    public ClinicoProService getClinicoProService() {
        return clinicoProService;
    }

    public void setClinicoProService(ClinicoProService clinicoProService) {
        this.clinicoProService = clinicoProService;
    }

}
