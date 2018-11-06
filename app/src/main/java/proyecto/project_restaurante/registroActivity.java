package proyecto.project_restaurante;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class registroActivity extends AppCompatActivity {

        Spinner spnSexo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        spnSexo = findViewById(R.id.spnSexo);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.combo_sexo,android.R.layout.simple_spinner_item);
        spnSexo.setAdapter(adapter);


    }




}
