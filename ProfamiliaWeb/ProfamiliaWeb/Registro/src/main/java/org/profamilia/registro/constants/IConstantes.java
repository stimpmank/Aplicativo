package org.profamilia.registro.constants;

public abstract interface IConstantes extends IMsg
{
  public static final Integer SIZE_DATATABLE = 20;
  public static final int OFFSET_DATATABLE = 0;
  public static final String TIME_ZONE = "America/Bogota";
  public static final String COUNTRY = "CO";
  public static final String LANGUAGE = "es";
  public static final String VARIANT = "";
  public static final String JSF_SERVICIO_BEAN = "ServicioBean";
  public static final String JSF_DIRECTORIO_CON_BEAN = "DirectorioConBean";
  public static final String JSF_DIRECTORIO_BEAN = "DirectorioBean";
  public static final String JSF_INFORMACION_CLINICA_BEAN = "InformacionClinicaBean";
  public static final String JSF_REGISTRO_LLAMADA_BEAN = "RegistroLlamadaBean";
  public static final Integer SERVICIO_NIVEL_DE_USO_ALTO = 0;
  public static final String SERVICIO_TIPO_DE_SERVICIO_LABORATORIO = "S";
  public static final Integer TIPO_USUARIO_PARTICULAR = 1;
  public static final Integer TIPO_USUARIO_JOVEN = 9;
  public static final Integer TIPO_USUARIO_PROFAMILIA = 2;
  public static final int TIPO_USUARIO_PART_UNID_FERTILIDAD = 320;
  public static final Integer TIPO_SERVICIO = 1;
  public static final String ESTADO_VIGENTE = "VG";
  public static final String ESTADO_SI = "S";
  public static final String ESTADO_ACTIVO = "AC";
  public static final Integer TIPO_PARTICULAR = 0;

  public static final Integer CPTIPOPROF_TIPO_POR_DEFECTO = 0;
  public static final Integer CPTIPOPROF_AUXILIARES_DE_ENFERMERIA = 4;
  public static final Integer CPTIPOPROF_FISIOTERAPEUTAS = 8;
  public static final Integer CPTIPOPROF_INSTRUMENTADOR_QCO = 12;
  public static final Integer CPTIPOPROF_TRABAJADORA_SOCIAL = 14;
  public static final Integer CPTIPOPROF_INSTRUMENTADOR = 16;

  public static final Integer CPGRUPO_APOYO_DIAGNOSTICO = 81;
  public static final Integer CPGRUPO_OTROS_SERVICIOS = 93;

  public static final Integer CPSUBGRUPO_LAB_CLINICO = 4;
  public static final String SPGCNOMBRE_SERVICIO = "servicio";
  public static final String SPGCNOMBRE_TIPOSCONTACTO = "tiposcontacto";
  public static final String SPGCNOMBRE_CONSULTAHORARIOS = "consultahorarios";
  public static final String SPGCNOMBRE_INFOCLINICA = "infoclinica";
  public static final String SPGCNOMBRE_HORARIOMES = "horariomes";
  public static final String SPGCNOMBRE_HORARIOPROF = "horarioprof";
  public static final String SPGCNOMBRE_HORARIOSEM = "horariosem";
  public static final String SPGCNOMBRE_CONSULEVENTUALIDAD = "consuleventualidad";
  public static final String SPGCNOMBRE_CONSULDIRECTORIO = "consuldirectorio";
  public static final String SPGCNOMBRE_ADMINDIRECTORIO = "admindirectorio";
  public static final String SPGCNOMBRE_TIPOSERVICIO = "tiposervicio";
  public static final String SPGCNOMBRE_REGISTROLLAMADA = "registrollamada";
  public static final String SPGCNOMBRE_REP_REGISTROLLAMADA = "repregllamada";
  public static final String SPGCNOMBRE_REP_LOGMODIFICACION = "logmodificacion";
  public static final String ID_TIPO_PREGUNTA_PRECIO = "1";
  public static final String ID_TIPO_PREGUNTA_PREPARACION = "3";
  public static final String ID_TIPO_PREGUNTA_OPORTUNIDAD = "4";
  public static final String ID_TIPO_PREGUNTA_TIEMPO_ENTREGA = "5";
  public static final String TIPO_PREGUNTA_PRECIO = "Precio";
  public static final String TIPO_PREGUNTA_PREPARACION = "Preparaci�n";
  public static final String TIPO_PREGUNTA_OPORTUNIDAD = "Oportunidad";
  public static final String TIPO_PREGUNTA_TIEMPO_ENTREGA = "Tiempo de Entrega";
  public static final String ID_APOYO_DIAGNOSTICO = "4";
  public static final String ID_LLAMADAS_PERDIDAS = "8";
  public static final String NAV_REGISTRO_LLAMADAS = "recargar";
  public static final String CPDEPADANE_BOGOTA = "11";
  public static final int CPCLINICA_BOGOTA = 1;
  public static final String NO_EXISTEN_CONSULTAS_PARA_LA_FECHA = "No existen consultas para: ";
  
    Integer CONSECUTIVO_AGENDA= 10;
    String ESTADO_INACTIVO = "IN";
    
    
    //CONSTANTES PARA WEBSERVICE SAP CREACION CLIENTE 

      String DATOS_GENERAL_CLASIFICACION_DEUDOR = "1";
      String DATOS_GENERAL_PERSONA_FISICA = "X";
      String DATOS_GENERAL_CLAVE_PAIS = "CO";
      String DATOS_LIS = "PN";
      String DATOS_SOCIEDAD_SOCIEDAD = "PRFI";
      String DATOS_SOCIEDAD_CLAVE_COND_PAGO = "D01A";
      String DATOS_SOCIEDAD_CUENTA_ASOCIADA = "1302250505";
      String DATOS_SOCIEDAD_GRUPO_TESORERIA = "5101";
      String DATOS_SOCIEDAD_CLAVE_ASIG = "031";
      String DATOS_COMERCIAL_ORG_VENTAS = "1100";
      String DATOS_COMERCIAL_CANALDIST = "00";
      String DATOS_COMERCIAL_SECTOR = "00";
      String DATOS_COMERCIAL_ESQUEMA_CLIENTE = "1";
      String DATOS_COMERCIAL_COND_EXPEDICION = "01";
      String DATOS_COMERCIAL_GRUP_IMPUT_CLIENTE = "01";
      String DATOS_COMERCIAL_CLAVE_COND_PAGO = "D01A";
      String DATOS_COMERCIAL_GRUPO_CLIENTES = "17";
      String DATOS_COMERCIAL_CLAVE_MONEDA = "COP";
      String CLIENTE_CONTACTO_FUNCION_CONTACTO = "00";



    String ESTADO_SIN_MOVIMIENTO = "SM";
    String ESTADO_CON_MOVIMIENTO = "CM";
     
    int CCONCITO = 13;
    int CCONUSUA = 15;

}