package proyecto.project_restaurante;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import proyecto.project_restaurante.utilidades.constantes;

public class PanelUsuario extends AppCompatActivity {

    ImageView imgPUSuario;
    TextView lblPNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_usuario);


        imgPUSuario = findViewById(R.id.imgPUSuario);
        lblPNombre = findViewById(R.id.lblPNombre);

        llamadaElementos();


    }

    private void llamadaElementos() {
        Bundle datos = this.getIntent().getExtras();
        boolean putSexo = datos.getBoolean(constantes.CAMPO_SEXO);
        if(putSexo == true ){
            imgPUSuario.setImageResource(R.drawable.iconohombre);
        }
        else{
            imgPUSuario.setImageResource(R.drawable.iconomujer);
        }
            String hola = datos.getString(constantes.CAMPO_NOMBRE);

        Toast.makeText(this, hola, Toast.LENGTH_SHORT).show();
        lblPNombre.setText(hola);
    }


}
