package com.example.calculo.alcool.gasolina.contract;

import com.google.android.material.textfield.TextInputEditText;

public interface CalculatorContract {

    interface View {
        void setResult(String result);
    }
    interface Presenter {
        void setView(View view);
        void calculate(TextInputEditText txtInputAlcool, TextInputEditText txtInputGasolina);
        boolean validaCampos(String precoAlcool, String precoGasolina);
    }
}
