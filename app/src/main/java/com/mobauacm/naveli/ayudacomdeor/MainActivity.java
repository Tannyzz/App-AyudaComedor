package com.mobauacm.naveli.ayudacomdeor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;

public class MainActivity extends AppCompatActivity{

    @Bind(R.id.name) EditText name;
    @Bind(R.id.lastName) EditText lastName;
    @Bind(R.id.desayuno) EditText desatuno;
    @Bind(R.id.comida) EditText comida;

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
