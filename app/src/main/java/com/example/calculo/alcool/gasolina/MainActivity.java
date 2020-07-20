package com.example.calculo.alcool.gasolina;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculo.alcool.gasolina.contract.CalculatorContract;
import com.example.calculo.alcool.gasolina.presenter.CalculatorPresenter;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements CalculatorContract.View {

    TextInputEditText txtInputAlcool, txtInputGasolina;
    Button btnCalcular;
    TextView txtResultado;

    private CalculatorContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new CalculatorPresenter();
        presenter.setView(this);

        txtInputAlcool = findViewById(R.id.txt_input_alcool);
        txtInputGasolina = findViewById(R.id.txt_input_gasolina);
        btnCalcular = findViewById(R.id.btn_calcular);
        txtResultado = findViewById(R.id.txt_resultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.calculate(txtInputAlcool, txtInputGasolina);
            }
        });
    }

    @Override
    public void setResult(String result) {
        txtResultado.setText(result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_reset) {
            txtInputAlcool.setText("");
            txtInputGasolina.setText("");
            txtResultado.setText("");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
