package br.com.jvcm.storepreference.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import br.com.jvcm.storepreference.R;
import br.com.jvcm.storepreference.fragment.FormSingupFragment;
import br.com.jvcm.storepreference.manager.SharedPreferenceManager;
import br.com.jvcm.storepreference.manager.StorageAPI;

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

        //edtValue.setText(mStorage.restoreName());
        btnFormSingup.setOnClickListener(this::onClick);
        btnConsultar.setOnClickListener(this::onClickList);
    }

    private void onClick(View view) {
        Intent intent = new Intent(this, ClientManagerActivity.class);
        startActivity(intent);


        //String value = edtValue.getText().toString();
        //mStorage.salveName(value);
    }

    private void onClickList(View view){
        Intent intent = new Intent(this, ClientManagerActivity.class);
        startActivity(intent);
    }
}
