package com.example.calculo.alcool.gasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText txtInputAlcool, txtInputGasolina;
    Button btnCalcular;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInputAlcool = findViewById(R.id.txt_input_alcool);
        txtInputGasolina = findViewById(R.id.txt_input_gasolina);
        btnCalcular = findViewById(R.id.btn_calcular);
        txtResultado = findViewById(R.id.txt_resultado);
    }

    public void calcularPreco(View view) {
        String precoAlcool = txtInputAlcool.getText().toString();
        String precoGasolina = txtInputGasolina.getText().toString();

        if(validaCampos(precoAlcool, precoGasolina)) {

            //convertendo os valores para nros
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            String resultado = (valorAlcool / valorGasolina) >= 0.7 ? "Melhor utilizar gasolina" : "Melhor utilizar alcool";
            txtResultado.setText(resultado);
        } else {
            txtResultado.setText("Preencha os campos primeiros.");
        }
    }

    public boolean validaCampos(String precoAlcool, String precoGasolina) {

        Boolean camposValidados = true;

        if(precoAlcool == null || precoAlcool.equals("")) {
            camposValidados = false;
        } else if(precoGasolina == null || precoGasolina.equals("")) {
            camposValidados = false;
        }

        return camposValidados;
    }
}
