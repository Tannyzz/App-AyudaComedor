package com.mobauacm.naveli.ayudacomdeor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creacion la rutina para mostrar un dialogo antes de iniciar
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Escriba la Informacion a aceptar")
                .setTitle("Información")
                .setCancelable(false)
                .setNeutralButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
        //Termina la rutina de alerta
    }
}
