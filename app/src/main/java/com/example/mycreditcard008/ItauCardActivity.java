package com.example.mycreditcard008;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ItauCardActivity extends AppCompatActivity {

    private EditText edtItemItau, edtDataItau, edtValorItau;
    private ImageView imgAddItau, imageItauView3;


    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itau_card);

        edtItemItau = (EditText)findViewById(R.id.edtItemItau);
        edtDataItau = (EditText)findViewById(R.id.edtDataItau);
        edtValorItau = (EditText)findViewById(R.id.edtIValorItau);

        imgAddItau = (ImageView) findViewById(R.id.imgAddItau);
        imageItauView3 = (ImageView) findViewById(R.id.imageItauView3);


    }

    public void clique_add_itau(View view) {
            add_itau();
    }

    public void add_itau(){

        String item = edtItemItau.getText().toString();
        String data = edtDataItau.getText().toString();
        String valorV = edtValorItau.getText().toString();
        double valor = Double.parseDouble(valorV);

        DatabaseReference cartoes = referencia.child("ITAU");

        Cartoes itau = new Cartoes();
        itau.setItem(item);
        itau.setData(data);
        itau.setValor(valor);
        cartoes.push().setValue(itau);

        finish();


    }
}