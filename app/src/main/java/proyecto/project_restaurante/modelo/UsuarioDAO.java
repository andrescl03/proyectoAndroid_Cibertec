package proyecto.project_restaurante.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import proyecto.project_restaurante.conexion.ConexionSQLite;
import proyecto.project_restaurante.entidades.Usuario;
import proyecto.project_restaurante.utilidades.constantes;

public class UsuarioDAO implements  UsuarioDAOImpl{

    ConexionSQLite objCon;


    @Override
    public void  registrarUsuario(Usuario objUsuario) {
        SQLiteDatabase BaseDeDatos = objCon.getWritableDatabase();
         objUsuario = new Usuario(objUsuario.getIdUsuario(),objUsuario.getNombres(),objUsuario.getApellidos(),objUsuario.getCorreo(),
                 objUsuario.getClave(),objUsuario.getDni(),objUsuario.getEdad(),objUsuario.getSexo(),objUsuario.getTokenUsuario());

        ContentValues registro = new ContentValues();
        registro.put(constantes.CAMPO_ID_USUARIO, objUsuario.getIdUsuario());
        registro.put(constantes.CAMPO_NOMBRE, objUsuario.getNombres());
        registro.put(constantes.CAMPO_APELLIDO, objUsuario.getApellidos());
        registro.put(constantes.CAMPO_CORREO,objUsuario.getCorreo());
        registro.put(constantes.CAMPO_CLAVE,objUsuario.getClave());
        registro.put(constantes.CAMPO_DNI,objUsuario.getDni());
        registro.put(constantes.CAMPO_EDAD,objUsuario.getEdad());
        registro.put(constantes.CAMPO_SEXO,objUsuario.getSexo());
        registro.put(constantes.CAMPO_TOKEN,objUsuario.getTokenUsuario());


        objCon.close();

    }
}
