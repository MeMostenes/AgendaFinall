package com.memostenes.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma);
        Bundle p = getIntent().getExtras();
        String nombre = p.getString("Nombre");
        TextView tvNombre2 = (TextView) findViewById(R.id.tvNombre2);
        tvNombre2.setText(nombre);
        
        nombre = p.getString("Dia")+"/"+p.getString("Mes")+"/"+p.getString("Year");
        TextView tvDFecha = (TextView) findViewById(R.id.tvDFecha);
        tvDFecha.setText(nombre);
        nombre = p.getString("Telefono");
        TextView tvDTel = (TextView) findViewById(R.id.tvDTel);
        tvDTel.setText(nombre);
        nombre = p.getString("Correo");
        TextView tvDMail = (TextView) findViewById(R.id.tvDMail);
        tvDMail.setText(nombre);
        nombre = p.getString("Descripcion");
        TextView tvDDescr = (TextView) findViewById(R.id.tvDDescr);
        tvDDescr.setText(nombre);

        Button btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Confirma.this, MainActivity.class);
                Bundle p = getIntent().getExtras();
                String x = p.getString("Nombre");
                String xx = p.getString("Telefono");
                String xxx = p.getString("Correo");
                String xxxx = p.getString("Descripcion");
                String d = p.getString("Dia");
                String m = p.getString("Mes");
                String y = p.getString("Year");

                intent.putExtra("Nombree", x);
                intent.putExtra("Telefonoo", xx);
                intent.putExtra("Correoo", xxx);
                intent.putExtra("Descripcionn", xxxx);
                //intent.putExtra("Fechaa", fe);
                intent.putExtra("Dia", d);
                intent.putExtra("Mes", m);
                intent.putExtra("Year", y);

                startActivity(intent);
                finish();
            }
        });

    }
}
