package com.example.mycreditcard008;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HiperCardActivity extends AppCompatActivity {

    private EditText edtItemHiper, edtDataHiper, edtValorHiper;
    private ImageView imgAddHiper, imgHiperView2;

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiper_card);

        edtItemHiper = (EditText)findViewById(R.id.edtItemHiper);
        edtDataHiper = (EditText)findViewById(R.id.edtDataHiper);
        edtValorHiper = (EditText)findViewById(R.id.edtValorHiper);
        imgAddHiper = (ImageView)findViewById(R.id.imgAddHiper);
        imgHiperView2 = (ImageView)findViewById(R.id.imgHiperView2);
    }

    public void clique_add_hiper(View view) {
        add_hiper();
    }

    public void add_hiper(){

        String item = edtItemHiper.getText().toString();
        String data = edtDataHiper.getText().toString();
        String valorV= edtValorHiper.getText().toString();
        double valor = Double.parseDouble(valorV);

        DatabaseReference cartoes = referencia.child("HIPERCARD");

        Cartoes hiper = new Cartoes();
        hiper.setItem(item);
        hiper.setData(data);
        hiper.setValor(valor);
        cartoes.push().setValue(hiper);

        finish();

    }
}