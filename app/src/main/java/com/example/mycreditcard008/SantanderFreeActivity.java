package com.example.mycreditcard008;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SantanderFreeActivity extends AppCompatActivity {

    private EditText edtItemSantander, edtDataSantander, edtValorSantander;
    private ImageView imageSantanderView2, imageAddSantander;

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_santander_free);

        edtItemSantander = (EditText)findViewById(R.id.edtItemSantander);
        edtDataSantander = (EditText)findViewById(R.id.edtDataSantander);
        edtValorSantander = (EditText)findViewById(R.id.edtValorSantander);

        imageSantanderView2 = (ImageView)findViewById(R.id.imageSantanderView2);
        imageAddSantander = (ImageView)findViewById(R.id.imageAddSantander);
    }

    public void clique_add_santander(View view){
            add_santander();
    }

    public void add_santander(){

        String item = edtItemSantander.getText().toString();
        String data = edtDataSantander.getText().toString();
        String valorV = edtValorSantander.getText().toString();
        double valor = Double.parseDouble(valorV);

        DatabaseReference cartoes = referencia.child("SANTANDER");

        Cartoes santander = new Cartoes();
        santander.setItem(item);
        santander.setValor(valor);
        santander.setData(data);
        cartoes.push().setValue(santander);

        finish();


    }
}