package com.mobauacm.naveli.ayudacomdeor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    Calendar calendario = new GregorianCalendar();

    @Bind(R.id.name)
    EditText name;
    @Bind(R.id.lastName)
    EditText lastName;
    @Bind(R.id.desayuno)
    EditText desayuno;
    @Bind(R.id.button)
    Button button;
    @Bind(R.id.comida)
    EditText comida;
    @Bind(R.id.button2)
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

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

    @OnClick({R.id.button, R.id.button2})
    public void onClick(View view) {
        final int hora, minutos, segundos;
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        String tiempo = "";
        switch (view.getId()) {
            case R.id.button:
                tiempo = String.valueOf(hora) +":"+ String.valueOf(minutos)+":"+ String.valueOf(segundos);
                enviarDatos(name.getText().toString(), lastName.getText().toString(), desayuno.getText().toString(), tiempo);

                break;
            case R.id.button2:
                tiempo = String.valueOf(hora) +":"+ String.valueOf(minutos)+":"+ String.valueOf(segundos);
                enviarDatos(name.getText().toString(), lastName.getText().toString(), comida.getText().toString(), tiempo);
                break;
        }
    }

    public String enviarDatos(String dato1, String dato2, String dato3, String dato4){
        URL url;
        String linea;
        int resp = 0;
        StringBuilder resul = new StringBuilder();
        try {
            url = new URL("http;//webservice.php?"+"name="+dato1+"last="+dato2+"descrip="+dato3+"tiempo="+dato4);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            resp = connection.getResponseCode();

            resul  = new StringBuilder();

            if(resp == HttpURLConnection.HTTP_OK){
                InputStream in = new BufferedInputStream(connection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while ((linea = reader.readLine())!=null){
                    resul.append(linea);
                }
            }
        }catch (Exception e){

        }
        return resul.toString();

    }
}


