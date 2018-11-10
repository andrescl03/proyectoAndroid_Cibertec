package proyecto.project_restaurante.utilidades;

import android.content.Context;
import android.widget.Toast;

public class singleToast {


    private static Toast mToast;

    public static void show(Context context, String text, int duration) {
        if (mToast != null)
            mToast.cancel();
            mToast = Toast.makeText(context, text, duration);
            mToast.show();
            }
}
