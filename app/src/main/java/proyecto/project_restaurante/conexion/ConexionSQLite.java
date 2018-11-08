package proyecto.project_restaurante.conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import proyecto.project_restaurante.utilidades.constantes;

public class ConexionSQLite extends SQLiteOpenHelper {

    public ConexionSQLite(Context context ) {
        super(context, constantes.NOMBRE_DATABASE, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase BDRestaurante) {
        BDRestaurante.execSQL(constantes.CREATE_TABLE_USUARIO);
    }
    @Override
    public void onUpgrade(SQLiteDatabase BDRestaurante, int oldVersion, int newVersion) {
        BDRestaurante.execSQL("DROP TABLE IF EXISTS usuario");
        onCreate(BDRestaurante);
    }
}