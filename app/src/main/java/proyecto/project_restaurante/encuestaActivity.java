package proyecto.project_restaurante;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import proyecto.project_restaurante.entidades.encuesta;

import proyecto.project_restaurante.conexion.ConexionSQLite;
import proyecto.project_restaurante.utilidades.constantes;
import proyecto.project_restaurante.utilidades.singleToast;

public class encuestaActivity extends AppCompatActivity implements View.OnClickListener {

    TextView lblEPregunta;
    RadioButton rbtnE1, rbtnE2, rbtnE3, rbtnE4, rbtnE5;
    Button btnESiguiente;
    RadioGroup rbgEncuesta;
    int indicePregunta = 0;
    int arrayValPreguntas[] = new int[10];


    String putNombre, putApellido, putCorreo, putClave,putToken;
    int putDni, putEdad;
    boolean putSexo;

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
        recibirdatos();
        primeraPregunta();
        btnESiguiente.setOnClickListener(this);
        }

    public void primeraPregunta() {
        lblEPregunta.setText(constantes.CAMPO_PREGUNTA1);
    }

    public int segundaPregunta() {
        int index = rbgEncuesta.indexOfChild(findViewById(rbgEncuesta.getCheckedRadioButtonId())) + 1;
        lblEPregunta.setText(constantes.CAMPO_PREGUNTA2);
        return index;
    }

    public int terceraPregunta() {
        int index = rbgEncuesta.indexOfChild(findViewById(rbgEncuesta.getCheckedRadioButtonId())) + 1;
        lblEPregunta.setText(constantes.CAMPO_PREGUNTA3);
        return index;
    }

    public int cuartaPregunta() {
        int index = rbgEncuesta.indexOfChild(findViewById(rbgEncuesta.getCheckedRadioButtonId())) + 1;
        lblEPregunta.setText(constantes.CAMPO_PREGUNTA4);
        return index;
    }

    public int quintaPregunta() {
        int index = rbgEncuesta.indexOfChild(findViewById(rbgEncuesta.getCheckedRadioButtonId())) + 1;
        lblEPregunta.setText(constantes.CAMPO_PREGUNTA5);
        return index;
    }

    public int sextaPregunta() {
        int index = rbgEncuesta.indexOfChild(findViewById(rbgEncuesta.getCheckedRadioButtonId())) + 1;
        lblEPregunta.setText(constantes.CAMPO_PREGUNTA6);
        return index;
    }

    public int septimaPregunta() {
        int index = rbgEncuesta.indexOfChild(findViewById(rbgEncuesta.getCheckedRadioButtonId())) + 1;
        lblEPregunta.setText(constantes.CAMPO_PREGUNTA7);
        return index;
    }

    public int octavaPregunta() {
        int index = rbgEncuesta.indexOfChild(findViewById(rbgEncuesta.getCheckedRadioButtonId())) + 1;
        lblEPregunta.setText(constantes.CAMPO_PREGUNTA8);
        return index;
    }

    public int novenaPregunta() {
        int index = rbgEncuesta.indexOfChild(findViewById(rbgEncuesta.getCheckedRadioButtonId())) + 1;
        lblEPregunta.setText(constantes.CAMPO_PREGUNTA9);
        return index;
    }

    public int decimaPregunta() {
        int index = rbgEncuesta.indexOfChild(findViewById(rbgEncuesta.getCheckedRadioButtonId())) + 1;
        lblEPregunta.setText(constantes.CAMPO_PREGUNTA10);
        return index;
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();


        //-------------------------------------//
        if (indicePregunta == 0) {
            switch (viewId) {
                case R.id.btnESiguiente:
                    if (comprobarrbtn() == true) {
                        arrayValPreguntas[0] = segundaPregunta();
                        indicePregunta++;
                        limpiarRbtnEncuesta();
                        break;
                    }
            }
        } else if (indicePregunta == 1) {
            switch (viewId) {
                case R.id.btnESiguiente:
                    if (comprobarrbtn() == true) {
                        arrayValPreguntas[1] = terceraPregunta();
                        indicePregunta++;
                        limpiarRbtnEncuesta();
                        break;
                    }
            }
        } else if (indicePregunta == 2) {
            switch (viewId) {
                case R.id.btnESiguiente:
                    if (comprobarrbtn() == true) {
                        arrayValPreguntas[2] = cuartaPregunta();
                        indicePregunta++;
                        limpiarRbtnEncuesta();
                        break;
                    }
            }
        } else if (indicePregunta == 3) {
            switch (viewId) {
                case R.id.btnESiguiente:
                    if (comprobarrbtn() == true) {
                        arrayValPreguntas[3] = quintaPregunta();
                        indicePregunta++;
                        limpiarRbtnEncuesta();
                        break;
                    }
            }
        } else if (indicePregunta == 4) {
            switch (viewId) {
                case R.id.btnESiguiente:
                    if (comprobarrbtn() == true) {
                        arrayValPreguntas[4] = sextaPregunta();
                        indicePregunta++;
                        limpiarRbtnEncuesta();
                        break;
                    }
            }
        } else if (indicePregunta == 5) {
            switch (viewId) {
                case R.id.btnESiguiente:
                    if (comprobarrbtn() == true) {
                        arrayValPreguntas[5] = septimaPregunta();
                        indicePregunta++;
                        limpiarRbtnEncuesta();
                        break;
                    }
            }
        } else if (indicePregunta == 6) {
            switch (viewId) {
                case R.id.btnESiguiente:
                    if (comprobarrbtn() == true) {
                        arrayValPreguntas[6] = octavaPregunta();
                        indicePregunta++;
                        limpiarRbtnEncuesta();
                        break;
                    }
            }
        } else if (indicePregunta == 7) {
            switch (viewId) {

                case R.id.btnESiguiente:
                    if (comprobarrbtn() == true) {
                        arrayValPreguntas[7] = novenaPregunta();
                        indicePregunta++;
                        limpiarRbtnEncuesta();
                        break;

                    }
            }
        } else if (indicePregunta == 8) {
            switch (viewId) {
                case R.id.btnESiguiente:
                    if (comprobarrbtn() == true) {
                        arrayValPreguntas[8] = decimaPregunta();
                        indicePregunta++;
                        btnESiguiente.setText("Finalizar Encuesta");
                        limpiarRbtnEncuesta();
                        break;
                    }
            }
        } else if (indicePregunta == 9) {
            switch (viewId) {
                case R.id.btnESiguiente:
                    if (comprobarrbtn() == true) {
                        arrayValPreguntas[9] = rbgEncuesta.indexOfChild(findViewById(rbgEncuesta.getCheckedRadioButtonId())) + 1;
                        Toast.makeText(this, "ID: " + arrayValPreguntas[9], Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
                        dialogo.setTitle("Alerta");
                        dialogo.setMessage("¿Desea finalizar la encuesta?");
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
                        limpiarRbtnEncuesta();
                        break;
                    }

            }
        }
    }
    public void limpiarRbtnEncuesta() {
        rbgEncuesta.clearCheck();

    }
    public boolean comprobarrbtn() {

        if (rbtnE1.isChecked() == false && rbtnE2.isChecked() == false &&
                rbtnE3.isChecked() == false && rbtnE4.isChecked() == false && rbtnE5.isChecked() == false) {
            singleToast.show(this, "por favor seleccione una opción");
            return false;
        } else
            return true;
    }

    public void guardarEncuesta(){
        ConexionSQLite objCon = new ConexionSQLite(this);
        SQLiteDatabase BaseDeDatos =  objCon.getWritableDatabase();

        encuesta objEncuesta = new encuesta(null,
                arrayValPreguntas[0],
                arrayValPreguntas[1],
                arrayValPreguntas[2],
                arrayValPreguntas[3],
                arrayValPreguntas[4],
                arrayValPreguntas[5],
                arrayValPreguntas[6],
                arrayValPreguntas[7],
                arrayValPreguntas[8],
                arrayValPreguntas[9]);

        ContentValues registro1 = new ContentValues();

        registro1.put(constantes.CAMPO_ID_ENCUESTA,objEncuesta.getIdEncuesta());
        registro1.put(constantes.CAMPO_ENCUESTA1,objEncuesta.getePregunta1());
        registro1.put(constantes.CAMPO_ENCUESTA2,objEncuesta.getePregunta2());
        registro1.put(constantes.CAMPO_ENCUESTA3,objEncuesta.getePregunta3());
        registro1.put(constantes.CAMPO_ENCUESTA4,objEncuesta.getePregunta4());
        registro1.put(constantes.CAMPO_ENCUESTA5,objEncuesta.getePregunta5());
        registro1.put(constantes.CAMPO_ENCUESTA6,objEncuesta.getePregunta6());
        registro1.put(constantes.CAMPO_ENCUESTA7,objEncuesta.getePregunta7());
        registro1.put(constantes.CAMPO_ENCUESTA8,objEncuesta.getePregunta8());
        registro1.put(constantes.CAMPO_ENCUESTA9,objEncuesta.getePregunta9());
        registro1.put(constantes.CAMPO_ENCUESTA10,objEncuesta.getePregunta10());


       long  idResultante = BaseDeDatos.insert(constantes.TABLA_ENCUESTA, constantes.CAMPO_ID_ENCUESTA, registro1);
        Toast.makeText(this,"ID REGISTRO ENCUESTA:" + idResultante,Toast.LENGTH_SHORT).show();

        objCon.close();


    }

    public void aceptar(){
        guardarEncuesta();
        Intent intentPrincipal = new Intent(this,PanelUsuario.class);
        intentPrincipal.putExtra(constantes.CAMPO_SEXO,putSexo);
        intentPrincipal.putExtra(constantes.CAMPO_NOMBRE,putNombre);
        intentPrincipal.putExtra(constantes.CAMPO_APELLIDO,putApellido);

        startActivity(intentPrincipal);
        Toast.makeText(this, "Encuesta finalizada", Toast.LENGTH_SHORT).show();
        finish();
    }
    public void cancelar() {
    }

    public void recibirdatos(){
        Bundle datos = this.getIntent().getExtras();
         putSexo = datos.getBoolean(constantes.CAMPO_SEXO);
         putNombre = datos.getString(constantes.CAMPO_NOMBRE);
         putApellido = datos.getString(constantes.CAMPO_APELLIDO);

    }
}