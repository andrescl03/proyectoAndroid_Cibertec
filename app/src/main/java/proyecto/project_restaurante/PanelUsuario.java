package proyecto.project_restaurante;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import proyecto.project_restaurante.utilidades.constantes;

public class PanelUsuario extends AppCompatActivity  implements View.OnClickListener{


    PieChart apcGrafica;
    ImageView imgPUSuario;
    TextView lblPNombre;
    Button btnRealizarEncuesta;
    ProgressBar pgbEncuesta;
    TextView lblSatisfaccion;

    String putNombre, putApellido, putCorreo, putClave,putToken;
    int putDni, putEdad ,putNumeroEncuesta, putUsuarioE;
    boolean putSexo,panel;
    int putArregloEncuesta[] = new int[10];
    ArrayList<PieEntry> yvalues = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_usuario);

        obtenerGrafica();



        btnRealizarEncuesta = findViewById(R.id.btnRealizarEncuesta);
        imgPUSuario = findViewById(R.id.imgPUSuario);
        lblPNombre = findViewById(R.id.lblPNombre);
        pgbEncuesta = findViewById(R.id.pgbEncuesta);
        llamadaElementos();
        lblSatisfaccion = findViewById(R.id.lblSatisfaccion);
        btnRealizarEncuesta.setOnClickListener(this);


        lblSatisfaccion.setText("Grado de satisfacción: " + putNumeroEncuesta);


    }

    public void obtenerGrafica(){
        apcGrafica = findViewById(R.id.apcGrafica);
        apcGrafica.setUsePercentValues(true);
        apcGrafica.getDescription().setEnabled(false);
        apcGrafica.setExtraOffsets(5,10,5,5);
        apcGrafica.setDragDecelerationFrictionCoef(0.95f);
        apcGrafica.setDrawHoleEnabled(true);
        apcGrafica.setHoleColor(Color.WHITE);
        apcGrafica.setTransparentCircleRadius(61f);

        PieDataSet dataSet = new PieDataSet(yvalues,"Performance");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        PieData data = new PieData((dataSet));
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.YELLOW);
        apcGrafica.setData(data);
    }

    private void llamadaElementos() {
        Bundle datos = this.getIntent().getExtras();
         putSexo = datos.getBoolean(constantes.CAMPO_SEXO);
         putNombre = datos.getString(constantes.CAMPO_NOMBRE);
        putUsuarioE = datos.getInt(constantes.CAMPO_ID_USUARIO);
        if(putSexo == true ){
            imgPUSuario.setImageResource(R.drawable.iconohombre);
        }
        else{
            imgPUSuario.setImageResource(R.drawable.iconomujer);
        }


        if(datos.getInt("ValorEncuesta") != 0 || datos.getIntArray("ArregloEncuesta")[0]!=0){
            putNumeroEncuesta =  datos.getInt("ValorEncuesta") * 2;
            putArregloEncuesta =  datos.getIntArray("ArregloEncuesta");
            pgbEncuesta.setProgress(putNumeroEncuesta);
        Toast.makeText(this,"arreglo: " + putArregloEncuesta.length,Toast.LENGTH_SHORT).show();


            int valorSumaPrimero= 0;
            int valorSumaSegundo= 0;
            int valorSumaTercero= 0;
            int valorSumaCuarto= 0;
            int valorSumadoQuinto = 0;

            for(int i = 1 ; i<=putArregloEncuesta.length-1 ; i++){
                if(putArregloEncuesta[i]==1){
                    valorSumaPrimero+=10;
                }
                else if(putArregloEncuesta[i]==2){
                    valorSumaSegundo+=10;
                }
                else if(putArregloEncuesta[i]==3){
                    valorSumaTercero+=10;
                }
                else if(putArregloEncuesta[i]==4){
                    valorSumaCuarto+=10;
                }
                else if(putArregloEncuesta[i]==5){
                    valorSumadoQuinto+=10;
                }

            }
            if(valorSumaPrimero!=0){
                yvalues.add(new PieEntry(valorSumaPrimero,"Muy bien"));

            }
                if(valorSumaSegundo!=0){
                    yvalues.add(new PieEntry(valorSumaSegundo,"Muy bien"));

                }
            if(valorSumaTercero!=0){
                yvalues.add(new PieEntry(valorSumaTercero,"Bien"));

            }

                if(valorSumaCuarto!=0) {
                yvalues.add(new PieEntry(valorSumaCuarto,"Mal"));

            }

            if(valorSumadoQuinto!=0){
                yvalues.add(new PieEntry(valorSumadoQuinto,"Muy Mal"));

            }


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
                        intentEncuesta.putExtra(constantes.CAMPO_ID_USUARIO, putUsuarioE);
                        startActivity(intentEncuesta);
                        break;
                }
                }
}


