package com.example.mycreditcard008;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NubankActivity extends AppCompatActivity {


    private EditText edtItemNubank, edtDataNubank, edtValorNubank;

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nubank);

        edtItemNubank = (EditText) findViewById(R.id.edtItemNubank);
        edtDataNubank = (EditText) findViewById(R.id.edtDataNubank);
        edtValorNubank = (EditText) findViewById(R.id.edtValorNubank);



    }

    public void clique_addNubank(View view){


        add_nubank();



    }

    public void add_nubank(){

        String item = edtItemNubank.getText().toString();
        String data = edtDataNubank.getText().toString();

        String valorV = edtValorNubank.getText().toString();
        double valor = Double.parseDouble(valorV);

        Cartoes nubank_card =  new Cartoes();

        DatabaseReference cartoes = referencia.child("NUBANK");

        nubank_card.setItem(item);
        nubank_card.setData(data);
        nubank_card.setValor(valor);
        cartoes.push().setValue(nubank_card);

        finish();

   }

}