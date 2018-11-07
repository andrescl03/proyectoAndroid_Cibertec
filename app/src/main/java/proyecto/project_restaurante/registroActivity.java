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

        Spinner spnRSexo;
        EditText txtRNombre,txtRApellido,txtRCorreo,txtRClave,txtRDni,txtREdad;
        Button btnRRegistroU;
        int codigo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        llamadaElementos();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.combo_sexo,android.R.layout.simple_spinner_item);
        spnRSexo.setAdapter(adapter);

        btnRRegistroU.setOnClickListener(this);
    }



    public void llamadaElementos(){


        txtRNombre  = findViewById(R.id.txtRNombre);
        txtRApellido = findViewById(R.id.txtRApellido);
        txtRCorreo = findViewById(R.id.txtRCorreo);
        txtRClave = findViewById(R.id.txtRClave);
        txtRDni = findViewById(R.id.txtRDni);
        txtREdad = findViewById(R.id.txtREdad);
        spnRSexo = findViewById(R.id.spnRSexo);
        btnRRegistroU = findViewById(R.id.btnRRegistroU);

    }

    public void Registrar(View view) {
        ConexionSQLite objCon = new ConexionSQLite(this, "BDRestaurante", null, 2);

        SQLiteDatabase BaseDeDatos = objCon.getWritableDatabase();

          String nombre = txtRNombre.getText().toString();
          String apellido = txtRApellido.getText().toString();
          String correo = txtRCorreo.getText().toString();
          String clave = txtRClave.getText().toString();
          int dni = Integer.parseInt(txtRDni.getText().toString());
          int edad = Integer.parseInt(txtREdad.getText().toString());
            String sexo = spnRSexo.getSelectedItem().toString();

            boolean dato;
            if(sexo.equals("Masculino")) {
             dato = true;
                    }
            else if (sexo.equals("Femenino"))
                {
                 dato = false;
                } else {

                 dato =true;

        }

            Usuario objUsuario = new Usuario();
        objUsuario.setIdUsuario(CodigoKey());
        objUsuario.setNombres(nombre);
        objUsuario.setApellidos(apellido);
        objUsuario.setCorreo(correo);
         objUsuario.setClave(clave);
         objUsuario.setDni(dni);
        objUsuario.setEdad(edad);
        objUsuario.setSexo(dato);
        objUsuario.setTokenUsuario(codigoAutogenerado());

        Toast.makeText(this, "sexo:" + dato, Toast.LENGTH_SHORT).show();
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
        public int CodigoKey(){
            codigo++;
            return codigo;
            }

}

