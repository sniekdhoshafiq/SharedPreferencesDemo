package com.sniekdho.sharedpreferencesdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;

public class MainActivity extends AppCompatActivity {

    private EditText nameET, emailET, phoneET;
    private Button saveBTN, detailsBTN;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameET = findViewById(R.id.nameET);
        emailET = findViewById(R.id.emailET);
        phoneET = findViewById(R.id.phoneET);

        saveBTN = findViewById(R.id.saveBTN);
        detailsBTN = findViewById(R.id.detailsBTN);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
        editor = sharedPreferences.edit();


        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nameET.length()!=0 && emailET.length()!=0 && phoneET.length()!=0)
                {
                    String name = nameET.getText().toString();
                    String email = emailET.getText().toString();
                    String phone = phoneET.getText().toString();

                    editor.putString("NAME", name);
                    editor.putString("EMAIL", email);
                    editor.putString("PHONE", phone);
                    editor.commit();

                    Toast.makeText(MainActivity.this, "Data Save Successfully", Toast.LENGTH_SHORT).show();

                    nameET.setText("");
                    emailET.setText("");
                    phoneET.setText("");
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Please enter all data", Toast.LENGTH_SHORT).show();
                }
            }
        });


        detailsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, DetailsActivity.class));

            }
        });
    }

}