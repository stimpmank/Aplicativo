package org.profamilia.registro.constants;

public abstract interface IMsg
{
  public static final String MSG_VALIDACION_REQUERIDO = "Error de Validaci�n: Valor es necesario.";
  public static final String MSG_VALIDACION_NUMERICO = "El campo debe ser numerico.";
  public static final String MSG_VALIDACION_FECHA = "Formato de fecha incorrecta.";
  public static final String MSG_VALIDACION_ANYO = "Formato de A�o incorrecto (tama�o 4 digitos).";
  public static final String MSG_VALIDACION_EMAIL = "Formato de email incorrecto.";
  public static final String MSG_VALIDACION_SELECCION_REQUERIDO = "Seleccione por lo menos un dato.";
  public static final String MSG_VALIDACION_RANGO_FECHAS = "La fecha Inicial debe se menor que la Final.";
  public static final String MSG_EVENTULIDAD = "No hay ninguna programaci�n en el rango de fechas especificado.";
  public static final String MSG_VALIDACION_RANGO_EDAD_FINAL = "Es necesario ingresar el rango de edad final.";
  public static final String MSG_VALIDACION_RANGO_EDAD_FINAL_MAYOR = "El rango de edad final debe ser mayor que el inicial.";
  public static final String MSG_ADICION = "Se adiciono satisfactoriamente.";
  public static final String MSG_MODIFICACION = "Se modific� el usuario satisfactoriamente.";
  public static final String MSG_ELIMINACION = "Se elimino satisfactoriamente.";
  public static final String MSG_ACTUALIZACION = "La actualizaci�n se ha realizado satisfactoriamente.";
  public static final String MSG_CAMBIO_INTERNO = "El cambio interno se ha realizado satisfactoriamente.";
  public static final String MSG_DESVINCULACION = "La desvinculaci�n se ha realizado satisfactoriamente.";
  public static final String MSG_NO_ADICION = "Adicion no realizada.";
  public static final String MSG_NO_ELIMINACION = "Eliminacion no realizada.";
  public static final String MSG_NO_ACTUALIZACION = "Actualizacion no realizada.";
  public static final String MSG_NO_APERTURA = "Apertura no realizada.";
  public static final String MSG_NO_CONSULTA = "No se realizo la consulta correctamente.";
  public static final String MSG_CONSULTA_POR_FILTROS = "Agregue al menos un campo para filtrar la consulta.";
  public static final String MSG_NO_RESULTADO_CONSULTA = "No hay resultados para la consulta especificada.";
  public static final String MSG_CODIGO_EXISTE = "El c�digo especificado ya existe.";
  public static final String MSG_NO_RESULTADOS = "No existen resultados con esos criterios de busqueda.";
  public static final String MSG_ANULACION = "Anulaci�n realizada satisfactoriamente.";
  public static final String MSG_NO_ANULACION = "Anulaci�n no realizada.";
  public static final String MSG_OBJETO_NO_EXISTE = "No existe.";
  public static final String MSG_FECHAS_OBLIGATORIAS = "Debe ingresar fecha inicial y final";
  public static final String MSG_CLAVE_CAMBIADA = "La clave se cambio exitosamente.";
  public static final String MSG_CLAVE_NO_CAMBIADA = "La clave No fue cambiada.";
  public static final String MSG_CLAVES = "La clave nueva no coincide con su confirmaci�n.";
  public static final String MSG_DESCUENTO_EXISTE = "El servicio ya posee un descuento parametrizado.";
    String MSG_CAMPO_OBLIGATORIO = "El campo es obligatorio";
    
    String MSG_CARACTER_INVALIDO = "Se detecto carater invalido '|' � '_'";
}