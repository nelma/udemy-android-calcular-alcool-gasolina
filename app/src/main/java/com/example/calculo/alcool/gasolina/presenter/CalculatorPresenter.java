package com.example.calculo.alcool.gasolina.presenter;

import com.example.calculo.alcool.gasolina.contract.CalculatorContract;
import com.google.android.material.textfield.TextInputEditText;

public class CalculatorPresenter implements CalculatorContract.Presenter {

    private CalculatorContract.View view;

    @Override
    public void setView(CalculatorContract.View view) {
        this.view = view;
    }

    @Override
    public void calculate(TextInputEditText txtInputAlcool, TextInputEditText txtInputGasolina) {

        String precoAlcool = txtInputAlcool.getText().toString();
        String precoGasolina = txtInputGasolina.getText().toString();

        if(validaCampos(precoAlcool, precoGasolina)) {

            //convertendo os valores para nros
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            String resultado = (valorAlcool / valorGasolina) >= 0.7 ? "Melhor utilizar gasolina" : "Melhor utilizar alcool";
            view.setResult(resultado);
        } else {
            view.setResult("Preencha os campos primeiros.");
        }
    }

    @Override
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
