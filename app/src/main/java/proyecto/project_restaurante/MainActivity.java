package proyecto.project_restaurante;

import android.content.Intent;
import android.content.SharedPreferences;
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

import java.util.regex.Pattern;

import proyecto.project_restaurante.utilidades.constantes;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    //Creando los componentes
    Button btnRegistrarse;
    Button btnIniciarSesion;
    ImageButton btnFacebook;
    EditText txtCorreo;
    EditText txtClave;
    CheckBox chkGuardarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llamadaComponentes();

        btnRegistrarse.setOnClickListener(this);
        btnIniciarSesion.setOnClickListener(this);
        btnFacebook.setOnClickListener(this);
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
                    Toast.makeText(this, "Por favor llene los campos", Toast.LENGTH_SHORT).show();
                } else {
                    if (txtCorreo.getText().toString().matches(constantes.VALIDACION_CORREO.toString())) {
                        Toast.makeText(this, "Login Exitoso", Toast.LENGTH_SHORT).show();
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
                    } else {
                        Toast.makeText(this, "Coloque un correo valido", Toast.LENGTH_SHORT).show();
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


}

