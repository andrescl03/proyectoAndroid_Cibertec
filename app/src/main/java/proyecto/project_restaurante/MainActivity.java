package proyecto.project_restaurante;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import proyecto.project_restaurante.conexion.ConexionSQLite;
import proyecto.project_restaurante.utilidades.constantes;
import proyecto.project_restaurante.utilidades.singleToast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener,  Response.Listener<String>, Response.ErrorListener {

    //Creando los componentes
    Button btnRegistrarse;
    Button btnIniciarSesion;
    ImageButton btnFacebook;
    EditText txtCorreo;
    EditText txtClave;
    CheckBox chkGuardarSesion;

    ConexionSQLite objCon;

     String putNombre, putApellido, putCorreo, putClave,putToken;
     int putDni, putEdad, putIdUsuario;
     boolean putSexo;
    int  ValoresEncuestas[] = new int[11];



    RequestQueue request;

    StringRequest StringRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llamadaComponentes();
        btnRegistrarse.setOnClickListener(this);
        btnIniciarSesion.setOnClickListener(this);
        btnFacebook.setOnClickListener(this);

        objCon = new ConexionSQLite(this);

        request = Volley.newRequestQueue(this);
    }




    protected void onResume() {
        super.onResume();
        String datoTemporalCorreo;
        String datoTemporalClave;
        boolean datoTemporalCheckBox;
        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
        datoTemporalCorreo = datos.getString("usuario", "");
        datoTemporalClave = datos.getString("clave", "");
        datoTemporalCheckBox = datos.getBoolean("checkBox", false);
        txtCorreo.setText(datoTemporalCorreo);
        txtClave.setText(datoTemporalClave);
        chkGuardarSesion.setChecked(datoTemporalCheckBox);
    }
    public void llamadaComponentes() {
        txtCorreo = findViewById(R.id.txtRCorreo);
        txtClave = findViewById(R.id.txtClave);
        btnRegistrarse = findViewById(R.id.btnRRegistrarse);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        btnFacebook = findViewById(R.id.btnFacebook);
        chkGuardarSesion = findViewById(R.id.chkGuardarSesion);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRRegistrarse:
                Intent intentRegistro = new Intent(this, registroActivity.class);
                startActivity(intentRegistro);
                break;
            case R.id.btnIniciarSesion:
                if (txtCorreo.getText().toString().trim().isEmpty() || txtClave.getText().toString().trim().isEmpty()) {

                    singleToast.show(this,"Por favor llene todos los campos");

                } else {
                    if (txtCorreo.getText().toString().matches(constantes.VALIDACION_CORREO.toString())) {
                        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
                        SharedPreferences.Editor editor = datos.edit();

                        //AQUI LLAMAR AL SIGUIENTE ACITIVITY
                        if (chkGuardarSesion.isChecked()) {
                            editor.putString("usuario", txtCorreo.getText().toString());
                            editor.putString("clave", txtClave.getText().toString());
                            editor.putBoolean("checkBox", chkGuardarSesion.isChecked());
                            editor.apply();
                        } else {
                            datos.edit().remove("usuario").commit();
                            datos.edit().remove("clave").commit();
                            datos.edit().remove("checkBox").commit();
                        }
                        if(consultar() == true){
                            cargarWebService();
                            Intent PanelIntent = new Intent(this,PanelUsuario.class);
                            PanelIntent.putExtra(constantes.CAMPO_SEXO,putSexo);
                            PanelIntent.putExtra(constantes.CAMPO_NOMBRE,putNombre);
                            PanelIntent.putExtra(constantes.CAMPO_APELLIDO,putApellido);
                            PanelIntent.putExtra(constantes.CAMPO_ID_USUARIO, putIdUsuario);
                            PanelIntent.putExtra("ArregloEncuesta",ValoresEncuestas);
                            startActivity(PanelIntent);
                        }
                        else {
                           // Toast.makeText(this,"Correo y/o contraseña incorrecta",Toast.LENGTH_SHORT).show();
                            singleToast.show(this,"Correo y/o contraseña incorrecta");
                        }

                    } else {
                        singleToast.show(this,"Coloque un correo valido");
                    }
                }
                break;
            case R.id.btnFacebook:
                browser(v);
                break;
        }
    }
    public void browser(View view) {
        Intent BrowserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Restaurant-Cyber-Technology-371038736773378"));
        startActivity(BrowserIntent);
    }
    @Override public void onBackPressed() {
        moveTaskToBack(true);
        }

public boolean consultar(){
    SQLiteDatabase db = objCon.getReadableDatabase();
        String[] parametros  = {txtCorreo.getText().toString(),txtClave.getText().toString()};
            try {
            String queryUsuario = constantes.CREATE_QUERY_LOGIN_USUARIO;
            Cursor cursor = db.rawQuery(queryUsuario,parametros);
            cursor.moveToFirst();
                putIdUsuario = cursor.getInt(0);
                putNombre = cursor.getString(1);
                putApellido = cursor.getString(2);
                putSexo =  cursor.getString(7).equals("1");

                try {
                    String[] parametrosEncuesta = {String.valueOf(putIdUsuario)};
                    String queryEncuesta = "SELECT * FROM encuesta where idUsuario_e =?";
                    Cursor cursor1 = db.rawQuery(queryEncuesta, parametrosEncuesta);
                    cursor1.moveToFirst();


                    //Recorriendo el cursor y guardando en un array
                    for (int i = 0; i<=ValoresEncuestas.length-1 ;i++){

                        ValoresEncuestas[i]= cursor1.getInt(i);
                    }

                    //Imprimiendo los datos del array
                    for (int i= 0 ; i<= ValoresEncuestas.length-1 ; i++){

                     Toast.makeText(this,"Valor " +i  + " = " + ValoresEncuestas[i] , Toast.LENGTH_SHORT).show();

                    }
                    cursor1.close();
                }
                catch (Exception e){
                    return true;
                }
               cursor.close();
                return true;
                }
        catch (Exception e){
                return false;
                }
}



    public void cargarWebService() {



            llamadaComponentes();
            String URL = "http://192.168.1.41:8080/Rest_Servicio/rest/servicios2/query1?"
                    + "correo=" + txtCorreo.getText().toString()
                    + "&pass=" + txtClave.getText().toString();

            URL = URL.replace(" ", "%20");
            StringRequest = new StringRequest(Request.Method.GET, URL, this, this);
            request.add(StringRequest);


    }
    @Override
    public void onErrorResponse(VolleyError error) {

        Toast.makeText(this,"El usuario no existe en el servidor ",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(String response) {

        Toast.makeText(this,"El usuario existe en el WebService",Toast.LENGTH_SHORT).show();

    }
}