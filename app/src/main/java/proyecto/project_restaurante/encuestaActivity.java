package proyecto.project_restaurante;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import proyecto.project_restaurante.utilidades.constantes;

public class encuestaActivity extends AppCompatActivity implements View.OnClickListener {

    TextView lblEPregunta;
    RadioButton rbtnE1, rbtnE2, rbtnE3, rbtnE4, rbtnE5;
    Button btnESiguiente;
    RadioGroup rbgEncuesta;
    int VPpregunta, VPpregunta2,VPpregunta3,VPpregunta4,VPpregunta5;
    int indicePregunta = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        lblEPregunta = findViewById(R.id.lblEPregunta);
        btnESiguiente = findViewById(R.id.btnESiguiente);

        rbtnE1 = findViewById(R.id.rbtnE1);
        rbtnE2 = findViewById(R.id.rbtnE2);
        rbtnE3 = findViewById(R.id.rbtnE3);
        rbtnE4 = findViewById(R.id.rbtnE4);
        rbtnE5 = findViewById(R.id.rbtnE5);
        rbgEncuesta = findViewById(R.id.rbgEncuesta);

        rbtnE1.setText(" Muy buena");
        rbtnE2.setText(" Buena");
        rbtnE3.setText(" Regular");
        rbtnE4.setText(" Mala");
        rbtnE5.setText(" Muy mala");

        primeraPregunta();
        btnESiguiente.setOnClickListener(this);
    }

    public void primeraPregunta() {
        lblEPregunta.setText(constantes.CAMPO_PREGUNTA1);
    }

    public int segundaPregunta() {
        int index = rbgEncuesta.indexOfChild(findViewById(rbgEncuesta.getCheckedRadioButtonId())) + 1;
        Toast.makeText(this, "ID: " + index, Toast.LENGTH_SHORT).show();
        lblEPregunta.setText(constantes.CAMPO_PREGUNTA2);
        return index;
    }

    public int terceraPregunta() {
        int index = rbgEncuesta.indexOfChild(findViewById(rbgEncuesta.getCheckedRadioButtonId())) + 1;
        Toast.makeText(this, "ID: " + index, Toast.LENGTH_SHORT).show();
        lblEPregunta.setText(constantes.CAMPO_PREGUNTA3);
        return index;
    }

    public int cuartaPregunta() {
        int index = rbgEncuesta.indexOfChild(findViewById(rbgEncuesta.getCheckedRadioButtonId())) + 1;
        Toast.makeText(this,"ID: "+index, Toast.LENGTH_SHORT).show();
        lblEPregunta.setText(constantes.CAMPO_PREGUNTA4);
        return index;
    }

    public int QuintaPregunta() {
        int index = rbgEncuesta.indexOfChild(findViewById(rbgEncuesta.getCheckedRadioButtonId())) + 1;
        Toast.makeText(this,"ID: "+index, Toast.LENGTH_SHORT).show();
        lblEPregunta.setText(constantes.CAMPO_PREGUNTA5);
        return index;
    }
    @Override
    public void onClick(View v) {
                int viewId = v.getId();
        if(indicePregunta == 1) {
                switch (viewId) {
                    case R.id.btnESiguiente:
                    VPpregunta = segundaPregunta();
                    indicePregunta++;
                    break;
                    }
            }
        else if(indicePregunta == 2){
            switch (viewId) {
                case R.id.btnESiguiente:
                    VPpregunta2 = terceraPregunta();
                    indicePregunta++;
                    break;
            }
        }
        else if(indicePregunta ==3 ){
            switch (viewId) {
                case R.id.btnESiguiente:
                    VPpregunta3 = cuartaPregunta();
                    indicePregunta++;
                    break;
            }
        }
        else if(indicePregunta == 4){
            switch (viewId){
                case R.id.btnESiguiente:
                    VPpregunta4 = QuintaPregunta();
            }
        }
                }

}