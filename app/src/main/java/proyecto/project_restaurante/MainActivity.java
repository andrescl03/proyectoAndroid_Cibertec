package proyecto.project_restaurante;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    //Creando los componentes
    Button btnRegistrarse;
    Button btnIniciarSesion;
    EditText txtCorreo;
    EditText txtClave;

    Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llamadaComponentes();

        btnRegistrarse.setOnClickListener(this);
        btnIniciarSesion.setOnClickListener(this);


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
                         Toast.makeText(this,"Campo Vacio",Toast.LENGTH_SHORT).show();
                }
                    else{

                        if(txtCorreo.getText().toString().matches(pattern.toString())) {
                            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(this,"Coloque un correo valido",Toast.LENGTH_SHORT).show();
                        }
                        }
                    break;

        }
    }




    public void llamadaComponentes(){

        txtCorreo = findViewById(R.id.txtCorreo);
        txtClave = findViewById(R.id.txtClave);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
    }



}

