package com.example.kaleb.greatfuel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    private EditText gasolinaField;
    private EditText alcoolField;
    private Button calcularButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gasolinaField = (EditText) findViewById(R.id.gasolina_field);
        alcoolField = (EditText) findViewById(R.id.alcool_field);
        calcularButton = (Button) findViewById(R.id.calcular_button);

        calcularButton.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {

            String msn = determinaResultado();
            Toast.makeText(this, msn, Toast.LENGTH_SHORT).show();
        }


    private String determinaResultado(){
        String resultado = "";

        String campoGasolina = gasolinaField.getText().toString();
        if ((campoGasolina == null || campoGasolina.isEmpty())) {
            resultado = "o preço da gasolina é obrigatorio";
            return resultado;
        }

        Double precoGasolina = Double.parseDouble(campoGasolina);

        String campoAlcool = alcoolField.getText().toString();
        if ((campoAlcool == null || campoAlcool.isEmpty())) {
            resultado = "o preço do alcool é obrigatorio";
            return resultado;
        }
        Double precoAlcool = Double.parseDouble(campoAlcool);

        Double divisao = precoAlcool / precoGasolina;

        if (divisao > 0.7d) {
            resultado = "É melhor abastecer com Gasolina.";
        } else {
            resultado = "É melhor abastercer com Alcool";
        }

        return resultado;
    }
}
