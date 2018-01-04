package org.profamilia.registro.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.profamilia.registro.model.dtos.Chconsutarif;
import org.profamilia.registro.model.dtos.Chconocprofa;
import org.profamilia.registro.model.dtos.Chestadociv;
import org.profamilia.registro.model.dtos.Chtipoafilia;
import org.profamilia.registro.model.dtos.Chtipovincu;
import org.profamilia.registro.model.entities.Chetnia;
import org.profamilia.registro.model.entities.Chniveleduca;
import org.profamilia.registro.model.entities.Chsexo;
import org.profamilia.registro.model.entities.Chusuario;
import org.profamilia.registro.model.entities.Chzona;
import org.profamilia.registro.model.entities.Cpclinica;
import org.profamilia.registro.model.entities.Cpcontrato;
import org.profamilia.registro.model.entities.Cpdepadane;
import org.profamilia.registro.model.entities.Cpentidadadm;
import org.profamilia.registro.model.entities.Cpmunidane;
import org.profamilia.registro.model.entities.Cpocupacio;
import org.profamilia.registro.model.entities.Cpservicio;
import org.profamilia.registro.model.entities.Cptipoiden;
import org.profamilia.registro.model.entities.Cpusuario;
import org.profamilia.registro.model.exception.ModelException;
import org.profamilia.registro.model.repository.ClinicoDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Service("clinicoProService")
@Transactional
public class ClinicoProService {

    private static final Logger logger = LoggerFactory.getLogger(ClinicoProService.class);

    @Autowired
    ClinicoDao clinicoDAO;

    public List<Cpmunidane> getMunicipios(Short idDepto) throws ModelException {
        return clinicoDAO.getMunicipios(idDepto);
    }

    public Cpentidadadm getAseguradoraPorCodigo(String ceaccodigo) throws ModelException {
        return clinicoDAO.getAseguradoraPorCodigo(ceaccodigo);
    }

    public Cpocupacio getOcupacionPorCodigo(Integer cocncodigo) throws ModelException {
        return clinicoDAO.getOcupacionPorCodigo(cocncodigo);
    }

    public List<Cptipoiden> getTipoIdentificacion() throws ModelException {
        return clinicoDAO.getTipoIdentificacion();
    }

    public List<Cpdepadane> getDepartamentos() throws ModelException {
        return clinicoDAO.getDepartamentos();
    }

    public List<Cpocupacio> getOcupaciones() throws ModelException {
        return clinicoDAO.getOcupaciones();
    }

    public List getTipoafiliado() throws ModelException {
        List tipoAfiliado = new ArrayList<Chtipoafilia>();
        Chtipoafilia afiliado = new Chtipoafilia();

        afiliado.setCtaecodigo("C");
        afiliado.setCtacdescripcio("CONTRIBUTIVO");
        afiliado.setCtaeestado("VG");
        tipoAfiliado.add(afiliado);

        afiliado = new Chtipoafilia();
        afiliado.setCtaecodigo("E");
        afiliado.setCtacdescripcio("ESPECIAL");
        afiliado.setCtaeestado("VG");
        tipoAfiliado.add(afiliado);

        afiliado = new Chtipoafilia();
        afiliado.setCtaecodigo("R");
        afiliado.setCtacdescripcio("SUBSIDIO PARCIAL");
        afiliado.setCtaeestado("VG");
        tipoAfiliado.add(afiliado);

        afiliado = new Chtipoafilia();
        afiliado.setCtaecodigo("S");
        afiliado.setCtacdescripcio("SUBSIDIADO");
        afiliado.setCtaeestado("VG");
        tipoAfiliado.add(afiliado);

        afiliado = new Chtipoafilia();
        afiliado.setCtaecodigo("V");
        afiliado.setCtacdescripcio("VINCULADO");
        afiliado.setCtaeestado("VG");
        tipoAfiliado.add(afiliado);

        afiliado = new Chtipoafilia();
        afiliado.setCtaecodigo("X");
        afiliado.setCtacdescripcio("NINGUNO");
        afiliado.setCtaeestado("VG");
        tipoAfiliado.add(afiliado);

        return tipoAfiliado;

    }

    public List getSexoSap() {
        List tipoSexo = new ArrayList<Chsexo>();
        Chsexo sexo = new Chsexo();

        sexo.setCsxecodigo("F");
        sexo.setCsxcdescripcio("FEMENINO");
        sexo.setCsxeestado("VG");
        tipoSexo.add(sexo);

        sexo = new Chsexo();
        sexo.setCsxecodigo("M");
        sexo.setCsxcdescripcio("MASCULINO");
        sexo.setCsxeestado("VG");
        tipoSexo.add(sexo);

        sexo = new Chsexo();
        sexo.setCsxecodigo("I");
        sexo.setCsxcdescripcio("INDETERMINADO");
        sexo.setCsxeestado("VG");
        tipoSexo.add(sexo);

        return tipoSexo;
    }

    public List<Chzona> getZona() throws ModelException {
        List<Chzona> zonas;
        zonas = new ArrayList<Chzona>();
        Chzona zona = new Chzona();
        zona.setId("R");
        zona.setDescripcion("RURAL");
        zonas.add(zona);
        zona = new Chzona();
        zona.setId("U");
        zona.setDescripcion("URBANA");
        zonas.add(zona);

        return zonas;
    }

    public List getEstadoCivil() {
        List tipoEstadoCivil = new ArrayList<Chestadociv>();
        Chestadociv estadoCivil = new Chestadociv();

        estadoCivil.setCececodigo("C");
        estadoCivil.setCeccdescripcio("CASADO");
        estadoCivil.setCeceestado("VG");
        tipoEstadoCivil.add(estadoCivil);

        estadoCivil = new Chestadociv();
        estadoCivil.setCececodigo("D");
        estadoCivil.setCeccdescripcio("DIVORCIADO");
        estadoCivil.setCeceestado("VG");
        tipoEstadoCivil.add(estadoCivil);

        estadoCivil = new Chestadociv();
        estadoCivil.setCececodigo("S");
        estadoCivil.setCeccdescripcio("SOLTERO");
        estadoCivil.setCeceestado("VG");
        tipoEstadoCivil.add(estadoCivil);

        estadoCivil = new Chestadociv();
        estadoCivil.setCececodigo("U");
        estadoCivil.setCeccdescripcio("UNION LIBRE");
        estadoCivil.setCeceestado("VG");
        tipoEstadoCivil.add(estadoCivil);

        estadoCivil = new Chestadociv();
        estadoCivil.setCececodigo("V");
        estadoCivil.setCeccdescripcio("VIUDO");
        estadoCivil.setCeceestado("VG");
        tipoEstadoCivil.add(estadoCivil);

        return tipoEstadoCivil;
    }

    public List<Cpentidadadm> getEntidadAdm() throws ModelException {
        return clinicoDAO.getEntidadAdm();
    }

    public List<Chetnia> getListaEtnia()
            throws ModelException {
        List<Chetnia> lstEtnia;
        lstEtnia = new ArrayList<Chetnia>();

        Chetnia etniaObject = new Chetnia();
        etniaObject.setCetecodigo("1");
        etniaObject.setCetcdescripcio("Indígena");
        lstEtnia.add(etniaObject);

        etniaObject = new Chetnia();
        etniaObject.setCetecodigo("2");
        etniaObject.setCetcdescripcio("ROM (gitano)");
        lstEtnia.add(etniaObject);

        etniaObject = new Chetnia();
        etniaObject.setCetecodigo("3");
        etniaObject.setCetcdescripcio("Raizal (archipiélago de San Andrés y Providencia)");
        lstEtnia.add(etniaObject);

        etniaObject = new Chetnia();
        etniaObject.setCetecodigo("4");
        etniaObject.setCetcdescripcio("Palanquero de San Basilio");
        lstEtnia.add(etniaObject);

        etniaObject = new Chetnia();
        etniaObject.setCetecodigo("5");
        etniaObject.setCetcdescripcio("Negro(a), Mulato(a), Afrocolombiano(a) Afro descendiente");
        lstEtnia.add(etniaObject);

        etniaObject = new Chetnia();
        etniaObject.setCetecodigo("6");
        etniaObject.setCetcdescripcio("Ninguno de los anteriores");
        lstEtnia.add(etniaObject);

        return lstEtnia;
    }

    public List<Chniveleduca>
            getListaNivelEducativo() throws ModelException {
        List<Chniveleduca> lstNivelEducativo;
        lstNivelEducativo = new ArrayList<Chniveleduca>();

        Chniveleduca nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(1);
        nivelEducativoObject.setCnecdescripcio("No Definido");
        lstNivelEducativo.add(nivelEducativoObject);

        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(2);
        nivelEducativoObject.setCnecdescripcio("Preescolar");
        lstNivelEducativo.add(nivelEducativoObject);

        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(3);
        nivelEducativoObject.setCnecdescripcio("Básica Primaria");
        lstNivelEducativo.add(nivelEducativoObject);

        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(4);
        nivelEducativoObject.setCnecdescripcio("Básica Secundaria (Bachillerato Básico)");
        lstNivelEducativo.add(nivelEducativoObject);

        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(5);
        nivelEducativoObject.setCnecdescripcio("Media Académica o Clásica(Bachillerato Básico)");
        lstNivelEducativo.add(nivelEducativoObject);

        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(6);
        nivelEducativoObject.setCnecdescripcio("Media Técnica (Bachillerato Técnico)");
        lstNivelEducativo.add(nivelEducativoObject);

        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(7);
        nivelEducativoObject.setCnecdescripcio("Normalista");
        lstNivelEducativo.add(nivelEducativoObject);

        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(8);
        nivelEducativoObject.setCnecdescripcio("Técnica Profesional");
        lstNivelEducativo.add(nivelEducativoObject);

        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(9);
        nivelEducativoObject.setCnecdescripcio("Tecnológica");
        lstNivelEducativo.add(nivelEducativoObject);

        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(10);
        nivelEducativoObject.setCnecdescripcio("Profesional");
        lstNivelEducativo.add(nivelEducativoObject);

        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(11);
        nivelEducativoObject.setCnecdescripcio("Especialización");
        lstNivelEducativo.add(nivelEducativoObject);

        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(12);
        nivelEducativoObject.setCnecdescripcio("Maestría");
        lstNivelEducativo.add(nivelEducativoObject);

        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(13);
        nivelEducativoObject.setCnecdescripcio("Doctorado");
        lstNivelEducativo.add(nivelEducativoObject);

        return lstNivelEducativo;
    }

    public List<Chtipovincu>
            getTipoVinculacion() throws ModelException {
        List<Chtipovincu> lstTipoVinculacion;
        lstTipoVinculacion = new ArrayList<Chtipovincu>();

        Chtipovincu tipoVinculacionObject = new Chtipovincu();
        tipoVinculacionObject.setCtvecodigo("C");
        tipoVinculacionObject.setCtvcdescripcio("Cotizante");
        lstTipoVinculacion.add(tipoVinculacionObject);

        tipoVinculacionObject = new Chtipovincu();
        tipoVinculacionObject.setCtvecodigo("B");
        tipoVinculacionObject.setCtvcdescripcio("Beneficiario");
        lstTipoVinculacion.add(tipoVinculacionObject);

        return lstTipoVinculacion;
    }

    public List<Chconocprofa>
            getListaConoceProfamilia() throws ModelException {
        List<Chconocprofa> lstConocProfa;
        lstConocProfa = new ArrayList<Chconocprofa>();

        Chconocprofa conocimientoObject = new Chconocprofa();
        conocimientoObject.setCcpecodigo(1);
        conocimientoObject.setCcpcdescripcio("Radio");
        lstConocProfa.add(conocimientoObject);

        conocimientoObject = new Chconocprofa();
        conocimientoObject.setCcpecodigo(2);
        conocimientoObject.setCcpcdescripcio("TV");
        lstConocProfa.add(conocimientoObject);

        conocimientoObject = new Chconocprofa();
        conocimientoObject.setCcpecodigo(3);
        conocimientoObject.setCcpcdescripcio("Internet");
        lstConocProfa.add(conocimientoObject);

        conocimientoObject = new Chconocprofa();
        conocimientoObject.setCcpecodigo(4);
        conocimientoObject.setCcpcdescripcio("Revistas");
        lstConocProfa.add(conocimientoObject);

        conocimientoObject = new Chconocprofa();
        conocimientoObject.setCcpecodigo(5);
        conocimientoObject.setCcpcdescripcio("Conocido");
        lstConocProfa.add(conocimientoObject);

        conocimientoObject = new Chconocprofa();
        conocimientoObject.setCcpecodigo(6);
        conocimientoObject.setCcpcdescripcio("Otro");
        lstConocProfa.add(conocimientoObject);

        conocimientoObject = new Chconocprofa();
        conocimientoObject.setCcpecodigo(7);
        conocimientoObject.setCcpcdescripcio("Redes Sociales");
        lstConocProfa.add(conocimientoObject);

        conocimientoObject = new Chconocprofa();
        conocimientoObject.setCcpecodigo(8);
        conocimientoObject.setCcpcdescripcio("Linea 01-8000");
        lstConocProfa.add(conocimientoObject);

        conocimientoObject = new Chconocprofa();
        conocimientoObject.setCcpecodigo(9);
        conocimientoObject.setCcpcdescripcio("Plegables");
        lstConocProfa.add(conocimientoObject);

        conocimientoObject = new Chconocprofa();
        conocimientoObject.setCcpecodigo(10);
        conocimientoObject.setCcpcdescripcio("Remitido por Entidad");
        lstConocProfa.add(conocimientoObject);

        return lstConocProfa;
    }

    public Cpmunidane getMunicipiosSap(Short departamento, Short municipio) throws ModelException {
        return clinicoDAO.getMunicipiosSap(departamento, municipio);
    }

    //*****************************************************************************+
    public List<Chusuario> getUsuariosClienteActivo(String tipoIdentificacion, BigDecimal numeroIdentificacion) throws ModelException {
        return clinicoDAO.getUsuariosClienteActivo(tipoIdentificacion,
                numeroIdentificacion);
    }

    public List<Chusuario> getUsuariosClienteInactivo(String tipoIdentificacion, BigDecimal numeroIdentificacion) throws ModelException {
        return clinicoDAO.getUsuariosClienteInactivo(tipoIdentificacion,
                numeroIdentificacion);
    }

    public String getDescripcionOcupacion(Short cocncodigo) throws ModelException {
        return clinicoDAO.getDescripcionOcupacion(cocncodigo);
    }

    public String getDescripcionEntidadByCodigo(String codigo) throws ModelException {
        return clinicoDAO.getDescripcionEntidadByCodigo(codigo);
    }

    public List<Cpocupacio> getOcupacion(Cpocupacio ocupacion) throws ModelException {
        return clinicoDAO.getOcupacion(ocupacion);
    }

    public void saveUsuarioSap(final Chusuario usuario, final String userName,
            final List<Chconsutarif> ltsTarifaServicio,
            Short clinica,
            String tipoVenta) throws ModelException {
        clinicoDAO.saveUsuarioSap(usuario, userName, ltsTarifaServicio,
                clinica, tipoVenta);

    }

    public Cpclinica getClinica(Integer cclncodigo) throws ModelException {
        return clinicoDAO.getClinica(cclncodigo);
    }

    /**
     *
     * @param contrato
     * @return
     * @throws ModelException
     */
    public List<Cpcontrato> getContrato(Cpcontrato contrato, Short clinica) throws ModelException {
        logger.warn("contrato:  " + contrato);
        return clinicoDAO.getContrato(contrato, clinica);
    }

    /**
     *
     * @param contrato
     * @return
     * @throws ModelException
     */
    public Cpcontrato getContratoSelec(Cpcontrato contrato, Short clinica) throws ModelException {
        return clinicoDAO.getContratoSelec(contrato, clinica);
    }

    public List<Cpservicio> getServicioSap(Cpservicio servicio) throws ModelException {
        return clinicoDAO.getServicioSap(servicio);
    }

    public List<Object[]> getContratosxServicio(Short clinic, Integer contra,
            String servicio) throws ModelException {
        return clinicoDAO.getContratosxServicio(clinic, contra, servicio);

    }

    public List<Object[]> getContratosxServicioDetalle(Short clinic, Integer contra,
            String wcnstlnr, String wutiliza) throws ModelException {
        return clinicoDAO.getContratosxServicioDetalle(clinic, contra, wcnstlnr, wutiliza);
    }

    public Cpusuario getUsuarioPorId(String curcusuari) throws ModelException {
        return clinicoDAO.getUsuarioPorId(curcusuari);
    }

    public Cpservicio getDescripcionServicioSapXCodigo(String servicio) throws ModelException {
        return clinicoDAO.getDescripcionServicioSapXCodigo(servicio);
    }

    public List<Cpentidadadm>
            getEntidadEps(Cpentidadadm eps) throws ModelException {
        return clinicoDAO.getEntidadEps(eps);
    }

}
