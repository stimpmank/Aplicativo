package org.profamilia.registro.model.repository;

import java.math.BigDecimal;

import java.util.List;
import org.profamilia.registro.model.dtos.Chconsutarif;
import org.profamilia.registro.model.entities.Chusuario;

import org.profamilia.registro.model.entities.Cpclinica;
import org.profamilia.registro.model.entities.Cpcontrato;
import org.profamilia.registro.model.entities.Cpdepadane;
import org.profamilia.registro.model.entities.Cpentidadadm;
import org.profamilia.registro.model.entities.Cpmunidane;
import org.profamilia.registro.model.entities.Cpocupacio;
import org.profamilia.registro.model.entities.Cprestxcon;
import org.profamilia.registro.model.entities.Cpservicio;
import org.profamilia.registro.model.entities.Cptipoiden;
import org.profamilia.registro.model.entities.Cpusuario;
import org.profamilia.registro.model.exception.ModelException;


public interface ClinicoDao {

    public List<Cpmunidane> getMunicipios(Short idDepto) throws ModelException;

    public Cpentidadadm getAseguradoraPorCodigo(String ceaccodigo) throws ModelException;
    
    public Cpclinica getClinica(Integer cclncodigo) throws ModelException;

    public Cpusuario getUsuarioPorId(String curcusuari) throws ModelException;

    public List<Chusuario> getUsuariosClienteActivo(String tipoIdentificacion, BigDecimal numeroIdentificacion) throws ModelException;

    public List<Chusuario> getUsuariosClienteInactivo(String tipoIdentificacion, BigDecimal numeroIdentificacion) throws ModelException;

    public BigDecimal getDescuentoEmpleado(String servicio, String tipIdent,
            BigDecimal numIdent) throws ModelException;

    public String getDescripcionOcupacion(Short cocncodigo) throws ModelException;

    public String getDescripcionEntidadByCodigo(String codigo) throws ModelException;

    public List<Cptipoiden> getTipoIdentificacion() throws ModelException;

    public List<Cpdepadane> getDepartamentos() throws ModelException;

    public List<Cpocupacio> getOcupaciones() throws ModelException;

    public List<Cpentidadadm> getEntidadAdm() throws ModelException;

    public void saveUsuarioSap(final Chusuario usuario, final String userName,
            final List<Chconsutarif> ltsTarifaServicio,
            final Short clinica,
            String tipoVenta) throws ModelException;

    public List<Cprestxcon> getValidarContrato(Integer clinic, Integer contra,
            String servicio) throws ModelException;

    public Cpocupacio getOcupacionPorCodigo(Integer cocncodigo) throws ModelException;

    public List<Cpcontrato> getContrato(Cpcontrato contrato, Short clinica) throws ModelException;

    public Cpcontrato getContratoSelec(Cpcontrato contrato, Short clinica) throws ModelException;

    public Cpmunidane getMunicipiosSap(Short departamento,
            Short municipio) throws ModelException;

    public List<Cpentidadadm> getEntidadEps(Cpentidadadm eps) throws ModelException;

    public List<Cpocupacio> getOcupacion(Cpocupacio ocupacion) throws ModelException;

    public Cpservicio getDescripcionServicioSapXCodigo(final String servicio) throws ModelException;

    public List<Cpservicio> getServicioSap(Cpservicio servicio) throws ModelException;

    public List<Object[]> getContratosxServicio(Short clinic, Integer contra,
            String servicio) throws ModelException;

    public List<Object[]> getContratosxServicioDetalle(Short clinic, Integer contra,
            String wcnstlnr, String wutiliza) throws ModelException;

}
