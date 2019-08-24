package br.com.jvcm.storepreference.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import br.com.jvcm.storepreference.R;
import br.com.jvcm.storepreference.core.StorageAPI;
import br.com.jvcm.storepreference.query.ClientManagerActivity;
import br.com.jvcm.storepreference.singup.SignupActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnFormSingup;
    private Button btnConsultar;

    private StorageAPI mStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFormSingup = findViewById(R.id.btn_form_singup);
        btnConsultar = findViewById(R.id.btn_consultar);
        btnFormSingup.setOnClickListener(this::onClick);
        btnConsultar.setOnClickListener(this::onClickList);
    }

    private void onClick(View view) {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    private void onClickList(View view) {
        Intent intent = new Intent(this, ClientManagerActivity.class);
        startActivity(intent);
    }
}
