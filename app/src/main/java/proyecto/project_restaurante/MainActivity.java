package proyecto.project_restaurante;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.prefs.Preferences;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    //Creando los componentes
    Button btnRegistrarse;
    Button btnIniciarSesion;
    EditText txtCorreo;
    EditText txtClave;
    CheckBox chkGuardarSesion;

    Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llamadaComponentes();

        btnRegistrarse.setOnClickListener(this);
        btnIniciarSesion.setOnClickListener(this);
    }

    protected void onResume(){
        super.onResume();
        String datoTemporalCorreo;
        String datoTemporalClave;
        boolean datoTemporalCheckBox;
        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);

        datoTemporalCorreo = datos.getString("usuario","");
        datoTemporalClave = datos.getString("clave","");
        datoTemporalCheckBox = datos.getBoolean("checkBox",false);
        txtCorreo.setText(datoTemporalCorreo);
        txtClave.setText(datoTemporalClave);
        chkGuardarSesion.setChecked(datoTemporalCheckBox);

    }
    public void llamadaComponentes(){

        txtCorreo = findViewById(R.id.txtCorreo);
        txtClave = findViewById(R.id.txtClave);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        chkGuardarSesion = findViewById(R.id.chkGuardarSesion);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnRegistrarse:
                    Intent intentRegistro = new Intent(this,registroActivity.class);

                        startActivity(intentRegistro);
                    break;
            case R.id.btnIniciarSesion:
                    if(txtCorreo.getText().toString().trim().isEmpty() || txtClave.getText().toString().trim().isEmpty()){
                         Toast.makeText(this,"Campos Vacios",Toast.LENGTH_SHORT).show();
                }
                    else{
                        if(txtCorreo.getText().toString().matches(pattern.toString())) {
                            Toast.makeText(this, "Login Exitoso", Toast.LENGTH_SHORT).show();
                            SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
                            SharedPreferences.Editor editor = datos.edit();
                                    //AQUI LLAMAR AL SIGUIENTE ACITIVITY
                            
                                if(chkGuardarSesion.isChecked()){
                                    editor.putString("usuario", txtCorreo.getText().toString());
                                    editor.putString("clave", txtClave.getText().toString());
                                    editor.putBoolean("checkBox", chkGuardarSesion.isChecked());
                                    editor.apply();

                                }
                                else{
                                    datos.edit().remove("usuario").commit();
                                    datos.edit().remove("clave").commit();
                                    datos.edit().remove("checkBox").commit();
                                }
                        }
                        else{
                            Toast.makeText(this,"Coloque un correo valido",Toast.LENGTH_SHORT).show();
                            }
                        }
                    break;

        }
    }








}

