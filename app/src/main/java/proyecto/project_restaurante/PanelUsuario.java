package proyecto.project_restaurante;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import proyecto.project_restaurante.utilidades.constantes;

public class PanelUsuario extends AppCompatActivity  implements View.OnClickListener{


    ImageView imgPUSuario;
    TextView lblPNombre;
    Button btnRealizarEncuesta;


    String putNombre, putApellido, putCorreo, putClave,putToken;
    int putDni, putEdad;
    boolean putSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_panel_usuario);

        btnRealizarEncuesta = findViewById(R.id.btnRealizarEncuesta);
        imgPUSuario = findViewById(R.id.imgPUSuario);
        lblPNombre = findViewById(R.id.lblPNombre);

        llamadaElementos();

        btnRealizarEncuesta.setOnClickListener(this);

    }

    private void llamadaElementos() {
        Bundle datos = this.getIntent().getExtras();
         putSexo = datos.getBoolean(constantes.CAMPO_SEXO);
         putNombre = datos.getString(constantes.CAMPO_NOMBRE);
        if(putSexo == true ){
            imgPUSuario.setImageResource(R.drawable.iconohombre);
        }
        else{
            imgPUSuario.setImageResource(R.drawable.iconomujer);
        }


        lblPNombre.setText(putNombre);
    }


    @Override public void onBackPressed() {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Alerta");
        dialogo.setMessage("¿Desea cerrar sesión?");
        dialogo.setCancelable(false);
        dialogo.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo, int id) {
                aceptar();
            } });
            dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo, int id) {
                    cancelar();
                }
        });
            dialogo.show();
    }

    public void aceptar(){
            Intent intentPrincipal = new Intent(this,MainActivity.class);
            startActivity(intentPrincipal);
        Toast.makeText(this, "Sesión cerrada", Toast.LENGTH_SHORT).show();
        finish();
    }
    public void cancelar() {
    }

    @Override
    public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnRealizarEncuesta:
                        Intent intentEncuesta = new Intent(this,encuestaActivity.class);

                        intentEncuesta.putExtra(constantes.CAMPO_SEXO,putSexo);
                        intentEncuesta.putExtra(constantes.CAMPO_NOMBRE,putNombre);
                        intentEncuesta.putExtra(constantes.CAMPO_APELLIDO,putApellido);
                        startActivity(intentEncuesta);
                        break;
                }
                }
}


