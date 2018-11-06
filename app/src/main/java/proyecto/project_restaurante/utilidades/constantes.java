package proyecto.project_restaurante.utilidades;

public class constantes {


    //CONSTANTE DE LA TABLA USUARIO PARA LA REUTILIZACIÓN DE CODIGO
    public static final String TABLA_USUARIO = "usuario";
    public static final String CAMPO_ID_USUARIO = "idUsuario";
    public static final String CAMPO_NOMBRE = "nombres";
    public static final String CAMPO_APELLIDO = "apellidos";
    public static final String CAMPO_TOKEN  = "token";

    public static final String CREATE_TABLE_USUARIO = "create table"+ TABLA_USUARIO +"("+ CAMPO_ID_USUARIO +" int primary key, "+ CAMPO_NOMBRE +" text, "+ CAMPO_APELLIDO + " text,"+ CAMPO_TOKEN+" text)";
}
