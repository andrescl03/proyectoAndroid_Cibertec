package proyecto.project_restaurante;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Random;

import proyecto.project_restaurante.conexion.ConexionSQLite;
import proyecto.project_restaurante.modelo.Usuario;
import proyecto.project_restaurante.utilidades.constantes;

public class registroActivity extends AppCompatActivity implements  View.OnClickListener {

        Spinner spnSexo;
        EditText txtRNombre,txtRApellido,txtRCorreo,txtRClave,txtRDni,txtREdad;
        Button btnRRegistroU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        llamadaElementos();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.combo_sexo,android.R.layout.simple_spinner_item);
        spnSexo.setAdapter(adapter);

        btnRRegistroU.setOnClickListener(this);
    }



    public void llamadaElementos(){

        spnSexo = findViewById(R.id.spnRSexo);
        txtRNombre  = findViewById(R.id.txtRNombre);
        txtRApellido = findViewById(R.id.txtRApellido);
        txtRCorreo = findViewById(R.id.txtRCorreo);
        txtRClave = findViewById(R.id.txtClave);
        txtRDni = findViewById(R.id.txtRDni);
        txtREdad = findViewById(R.id.txtREdad);
        btnRRegistroU = findViewById(R.id.btnRRegistroU);

    }

    public void Registrar(View view) {
        ConexionSQLite objCon = new ConexionSQLite(this, "BDRestaurante", null, 1);

        SQLiteDatabase BaseDeDatos = objCon.getWritableDatabase();

        String nombre = txtRNombre.getText().toString();
        String apellido = txtRApellido.getText().toString();
//        String correo = txtRCorreo.getText().toString();
//        String clave = txtRClave.getText().toString();
//        String dni = txtRDni.getText().toString();
//        String edad = txtREdad.getText().toString();
        Usuario objUsuario = new Usuario();
        objUsuario.setIdUsuario(9);
        objUsuario.setNombres(nombre);
        objUsuario.setApellidos(apellido);
        objUsuario.setTokenUsuario(codigoAutogenerado());

        ContentValues registro = new ContentValues();
        registro.put(constantes.CAMPO_ID_USUARIO, objUsuario.getIdUsuario());
        registro.put(constantes.CAMPO_NOMBRE, objUsuario.getNombres());
        registro.put(constantes.CAMPO_APELLIDO, objUsuario.getApellidos());
        registro.put(constantes.CAMPO_TOKEN,objUsuario.getTokenUsuario());

//        registro.put("correo", correo);
//        registro.put("clave", clave);
//        registro.put("dni", dni);
//        registro.put("edad", edad);

       long idResultante = BaseDeDatos.insert(constantes.TABLA_USUARIO, constantes.CAMPO_ID_USUARIO, registro);

        Toast.makeText(this,"ID REGISTRO:" + idResultante,Toast.LENGTH_SHORT).show();

        objCon.close();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnRRegistroU:
                Registrar(v);
                Toast.makeText(this, "Se agrego correctamente", Toast.LENGTH_SHORT).show();
                    break;
        }
    }


    public String codigoAutogenerado(){
        Random rand = new Random();
        int n = (100+ rand.nextInt(99));
        String TokenUsuario = "CO"+(n);
            return TokenUsuario;
    }
}
