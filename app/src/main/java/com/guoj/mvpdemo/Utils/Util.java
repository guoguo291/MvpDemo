package com.guoj.mvpdemo.Utils;

import android.content.Context;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Util {
    public static void toast(Context context, CharSequence text){
        Toast.makeText(context.getApplicationContext(),text,Toast.LENGTH_SHORT).show();
    }
}
