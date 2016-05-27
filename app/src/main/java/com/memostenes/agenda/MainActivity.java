package com.memostenes.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {
    private android.support.design.widget.TextInputEditText n;
    private android.support.design.widget.TextInputEditText t;
    private android.support.design.widget.TextInputEditText c;
    private android.support.design.widget.TextInputEditText d;
    private DatePicker dp;
    private String nombre;
    private boolean sema;
    private Bundle p;
    private int dia, mes, year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //carga los datos anteriores

        if(getIntent().getExtras()!=null) {
            p = getIntent().getExtras();
            sema=true;
        }


        Button btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        n = (android.support.design.widget.TextInputEditText)findViewById(R.id.itNombre);
        t = (android.support.design.widget.TextInputEditText)findViewById(R.id.tiTel);
        c = (android.support.design.widget.TextInputEditText)findViewById(R.id.correo);
        d = (android.support.design.widget.TextInputEditText)findViewById(R.id.descr);
        dp = (DatePicker) findViewById(R.id.dpFecha);
       if (sema==true) {
           nombre = p.getString("Nombree");
           n.setText(nombre);
           nombre = p.getString("Telefonoo");
           t.setText(nombre);
           nombre = p.getString("Correoo");
           c.setText(nombre);
           nombre = p.getString("Descripcionn");
           d.setText(nombre);
           String x=p.getString("Dia");
           dia= Integer.parseInt(x);
           x=p.getString("Mes");
           mes = Integer.parseInt(x);
           mes--;
           x=p.getString("Year");
           year = Integer.parseInt(x);
           //year=p.getInt("Year");
           //dp.updateDate(year, mes, dia);
           //dp.updateDate(1996,10,15);
           dp.updateDate(year,mes,dia);
        }

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Confirma.class);
                String x = n.getText().toString();
                String xx = t.getText().toString();
                String xxx = c.getText().toString();
                String xxxx = d.getText().toString();
                int d = dp.getDayOfMonth();
                int m = dp.getMonth()+1;
                int y = dp.getYear();

                //String fe = dp.getDayOfMonth()+"/"+n+"/"+dp.getYear();

                intent.putExtra("Nombre", x);
                intent.putExtra("Telefono", xx);
                intent.putExtra("Correo", xxx);
                intent.putExtra("Descripcion", xxxx);
                intent.putExtra("Dia", ""+d);
                intent.putExtra("Mes", ""+m);
                intent.putExtra("Year", ""+y);
                startActivity(intent);
                finish();
            }
        });
    }
}
