package proyecto.project_restaurante;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Random;

import proyecto.project_restaurante.conexion.ConexionSQLite;
import proyecto.project_restaurante.entidades.Usuario;
import proyecto.project_restaurante.utilidades.constantes;
import proyecto.project_restaurante.utilidades.singleToast;

public class registroActivity extends AppCompatActivity implements  View.OnClickListener , Response.Listener<String>, Response.ErrorListener{

        Spinner spnRSexo;
        EditText txtRNombre,txtRApellido,txtRCorreo,txtRClave,txtRDni,txtREdad;
        Button btnRRegistroU;
        //Variables globales
        String nombre,apellido,correo ,clave,sexo;
        boolean dato ;
        Integer dni,edad;

        RequestQueue request;
    StringRequest StringRequest;
    Usuario objUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        llamadaElementos();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.combo_sexo,android.R.layout.simple_spinner_item);
        spnRSexo.setAdapter(adapter);
        btnRRegistroU.setOnClickListener(this);

        request = Volley.newRequestQueue(this);
    }

    public void cargarWebService(){

        String URL = "http://192.168.1.41:8080/Rest_Servicio_presente/rest/servicios2/query3?"
                +"correo="+objUsuario.getCorreo()
                +"&pass="+ objUsuario.getClave()
                +"&nombre="+objUsuario.getNombres()
                +"&apellido="+objUsuario.getApellidos()
                +"&dni="+objUsuario.getDni()
                +"&edad="+objUsuario.getEdad()
                +"&sexo="+objUsuario.getSexo();

        URL = URL.replace(" ", "%20");
        StringRequest = new StringRequest(Request.Method.GET,URL,this,this);
        request.add(StringRequest);

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
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRRegistroU:
                if(
                        txtRNombre.getText().toString().trim().isEmpty() ||
                        txtRApellido.getText().toString().trim().isEmpty() ||
                        txtRCorreo.getText().toString().trim().isEmpty() ||
                        txtRClave.getText().toString().trim().isEmpty() ||
                        txtRDni.getText().toString().trim().isEmpty() ||
                        txtREdad.getText().toString().trim().isEmpty() ){
                    singleToast.show(this,"Por favor complete todos los campos");
                }
                else{
                    if(spnRSexo.getSelectedItem().toString().equals("[Seleccione]"))
                    {
                        singleToast.show(this,"Por favor seleccione su género");
                    }
                    else if(!txtRCorreo.getText().toString().matches(constantes.VALIDACION_CORREO.toString())){

                        singleToast.show(this,"Por favor coloque un correo valido");

                    }
                    else
                        {
                        nombre = txtRNombre.getText().toString();
                        apellido = txtRApellido.getText().toString();
                        correo = txtRCorreo.getText().toString();
                        clave = txtRClave.getText().toString();
                        dni = Integer.parseInt(txtRDni.getText().toString());
                        edad = Integer.parseInt(txtREdad.getText().toString());
                        sexo = spnRSexo.getSelectedItem().toString();
                        dato = obtenerSexo(sexo);
                        Toast.makeText(this, "Se ha registrado correctamente", Toast.LENGTH_SHORT).show();
                        Registrar();

                        Intent  intentMain = new Intent(this,MainActivity.class);
                        startActivity(intentMain);
                        break;
                    }
                }
        }
    }
    public String codigoAutogenerado(){
        Random rand = new Random();
        int n = (100+ rand.nextInt(99));
        String TokenUsuario = "CO"+(n);
            return TokenUsuario;
    }
public boolean obtenerSexo(String sexo){
    Boolean dato;
    if(sexo.equals("Masculino")) {
        dato = true;
        }
    else if (sexo.equals("Femenino"))
        {
            dato = false;
     }
     else {
        dato =true;
    }
    return dato;
}
    public void Registrar() {
        ConexionSQLite objCon = new ConexionSQLite(this);
        SQLiteDatabase BaseDeDatos = objCon.getWritableDatabase();

        objUsuario  = new Usuario(null,nombre,apellido,correo,clave,dni,edad,dato,codigoAutogenerado());
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
        cargarWebService();

        long idResultante = BaseDeDatos.insert(constantes.TABLA_USUARIO, constantes.CAMPO_ID_USUARIO, registro);
        Toast.makeText(this,"ID REGISTRO:" + idResultante,Toast.LENGTH_SHORT).show();
       //// Toast.makeText(this,"(1 AVISO) SU TOKEN DE SEGURIDAD ES: " + objUsuario.getTokenUsuario(),Toast.LENGTH_LONG).show();
       /// Toast.makeText(this,"(2 AVISO) SU TOKEN DE SEGURIDAD ES: " + objUsuario.getTokenUsuario(),Toast.LENGTH_LONG).show();
       // Toast.makeText(this,"(3 AVISO) SU TOKEN DE SEGURIDAD ES: " + objUsuario.getTokenUsuario(),Toast.LENGTH_LONG).show();

        objCon.close();
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this,"No se ha podido registrar ",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onResponse(String response) {
        Toast.makeText(this,"Se ha registrado correctamente en el WebService",Toast.LENGTH_SHORT).show();

    }
}