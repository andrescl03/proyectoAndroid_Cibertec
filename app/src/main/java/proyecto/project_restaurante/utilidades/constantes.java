package proyecto.project_restaurante.utilidades;

import java.util.regex.Pattern;

public class constantes {

    //CONSTANTE DE LA TABLA USUARIO PARA LA REUTILIZACIÓN DE CODIGO
    public static final String TABLA_USUARIO = "usuario";
    public static final String CAMPO_ID_USUARIO = "idUsuario";
    public static final String CAMPO_NOMBRE = "nombres";
    public static final String CAMPO_APELLIDO = "apellidos";
    public static final String CAMPO_CORREO = "correo";
    public static final String CAMPO_CLAVE = "clave";
    public static final String CAMPO_DNI = "dni";
    public static final String CAMPO_EDAD = "edad";
    public static final String CAMPO_SEXO = "sexo";
    public static final String CAMPO_TOKEN  = "token";
    public static final String NOMBRE_DATABASE = "BDRestaurante";

    public static final String CAMPO_PREGUNTA1  = "1º ¿Cómo califica la calidad nuestros platos?";
    public static final String CAMPO_PREGUNTA2  = "2º ¿Cómo califica la espera para ser atendido?";
    public static final String CAMPO_PREGUNTA3  = "3º ¿Cómo califica la relación calidad-precio?";
    public static final String CAMPO_PREGUNTA4  = "4º ¿La carta presenta la sufiente variedad de platos?";
    public static final String CAMPO_PREGUNTA5  = "5º ¿Los platos presentan la suficiente variedad de productos?";
    public static final String CAMPO_PREGUNTA6  = "6º ¿Considera que el restaurante cumple con el estandar apropiado?";
    public static final String CAMPO_PREGUNTA7  = "7º ¿Cómo califica La rapidez con la que le fue otorgado el servicio?";
    public static final String CAMPO_PREGUNTA8  = "8º ¿Cómo califica la calidad de nuestro personal?";
    public static final String CAMPO_PREGUNTA9  = "9º ¿Cuáles son las probabilidades de que nos recomiende a otras personas?";
    public static final String CAMPO_PREGUNTA10 = "10º ¿La calidad del servicio recibido en general ha sido buena?";


    public static final String TABLA_ENCUESTA = "encuesta";
    public static final String CAMPO_ID_ENCUESTA  = "idEncuesta";
    public static final String CAMPO_ENCUESTA1  = "primera_pregunta";
    public static final String CAMPO_ENCUESTA2  = "segunda_pregunta";
    public static final String CAMPO_ENCUESTA3  = "tercera_pregunta";
    public static final String CAMPO_ENCUESTA4  = "cuarta_pregunta";
    public static final String CAMPO_ENCUESTA5  = "quinta_pregunta";
    public static final String CAMPO_ENCUESTA6  = "sexta_pregunta";
    public static final String CAMPO_ENCUESTA7  = "septima_pregunta";
    public static final String CAMPO_ENCUESTA8  = "octava_pregunta";
    public static final String CAMPO_ENCUESTA9  = "novena_pregunta";
    public static final String CAMPO_ENCUESTA10 = "primera_pregunta";



    public static final Pattern VALIDACION_CORREO = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");



    public static final String CREATE_TABLE_USUARIO = "create table "+ TABLA_USUARIO +" ("
            + CAMPO_ID_USUARIO +" integer primary key autoincrement, "
            + CAMPO_NOMBRE +" text, "
            + CAMPO_APELLIDO + " text, "
            + CAMPO_CORREO + " text, "
            + CAMPO_CLAVE + " text, "
            + CAMPO_DNI + " integer, "
            + CAMPO_EDAD + " integer, "
            + CAMPO_SEXO + " text, "
            + CAMPO_TOKEN+" text)";

    public static final String CREATE_TABLE_ENCUESTA = "create table " +  TABLA_ENCUESTA + " ("
            + CAMPO_ID_ENCUESTA + " integer primary key autoincrement, "
            + CAMPO_ENCUESTA1 + " integer, "
            + CAMPO_ENCUESTA2 + " integer, "
            + CAMPO_ENCUESTA3 + " integer, "
            + CAMPO_ENCUESTA4 + " integer, "
            + CAMPO_ENCUESTA5 + " integer, "
            + CAMPO_ENCUESTA6 + " integer, "
            + CAMPO_ENCUESTA6 + " integer, "
            + CAMPO_ENCUESTA7 + " integer, "
            + CAMPO_ENCUESTA8 + " integer, "
            + CAMPO_ENCUESTA9 + " integer, "
            + CAMPO_ENCUESTA10 + " integer )";

    public static final String CREATE_QUERY_LOGIN_USUARIO = "SELECT "
            + CAMPO_NOMBRE + " , "
            + CAMPO_APELLIDO + " , "
            + CAMPO_CORREO + " , "
            + CAMPO_CLAVE + " , "
            + CAMPO_DNI + " , "
            + CAMPO_EDAD + " , "
            + CAMPO_SEXO + " , "
            + CAMPO_TOKEN +
            " from " +
           TABLA_USUARIO + " where "
            + CAMPO_CORREO + " =? AND "
            + CAMPO_CLAVE + " =?" ;

}