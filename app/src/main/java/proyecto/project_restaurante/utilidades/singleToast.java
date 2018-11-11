package proyecto.project_restaurante.utilidades;

import android.content.Context;
import android.widget.Toast;

public class singleToast {


    private static Toast mToast;

    public static void show(Context context, String text) {
        if (mToast != null)
            mToast.cancel();
            mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            mToast.show();
            }
}
