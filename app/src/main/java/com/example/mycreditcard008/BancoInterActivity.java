package com.example.mycreditcard008;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BancoInterActivity extends AppCompatActivity {

    private EditText edtItemBanco, edtDataBancoInter, edtValorBancoInter;
    private ImageView imgBancoInter, imgAddBancoInter;

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banco_inter);

        edtItemBanco = (EditText) findViewById(R.id.edtItemBancoInter);
        edtDataBancoInter = (EditText) findViewById(R.id.edtDataBancoInter);
        edtValorBancoInter = (EditText) findViewById(R.id.edtValorBancoInter);
        imgBancoInter = (ImageView)findViewById(R.id.imgBancoInterB);
        imgAddBancoInter = (ImageView)findViewById(R.id.imgAddBancoInter);
    }

    public void clique_add_banco_inter(View view){

        addBancoInter();

    }

    public void addBancoInter() {

        String item = edtItemBanco.getText().toString();
        String data = edtDataBancoInter.getText().toString();
        String valorV = edtValorBancoInter.getText().toString();
        double valor = Double.parseDouble(valorV);

        DatabaseReference cartoes = referencia.child("INTER");

        Cartoes inter = new Cartoes();
        inter.setItem(item);
        inter.setData(data);
        inter.setValor(valor);
        cartoes.push().setValue(inter);

        finish();


    }
}