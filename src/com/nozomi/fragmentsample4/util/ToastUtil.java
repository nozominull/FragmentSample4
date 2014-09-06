package com.nozomi.fragmentsample4.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    private static Toast toast = null;

    /**
     * @param context
     * @param text
     */
    public static void makeToast(Context context, String text) {
        if (toast == null) {
            toast = Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
        }
        toast.show();
    }
}
