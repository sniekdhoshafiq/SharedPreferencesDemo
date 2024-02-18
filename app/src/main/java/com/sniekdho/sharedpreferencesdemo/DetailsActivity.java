package com.sniekdho.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView nameTV, emailTV, phoneTV;
    private Button clearBTN;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        nameTV = findViewById(R.id.nameTV);
        emailTV = findViewById(R.id.emailTV);
        phoneTV = findViewById(R.id.phoneTV);

        clearBTN = findViewById(R.id.clearBTN);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String name = sharedPreferences.getString("NAME", null);
        String email = sharedPreferences.getString("EMAIL", "");
        String phone = sharedPreferences.getString("PHONE", "");

        nameTV.setText(name);
        emailTV.setText(email);
        phoneTV.setText(phone);

        clearBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.commit();

                nameTV.setText("");
                emailTV.setText("");
                phoneTV.setText("");

                startActivity(new Intent(DetailsActivity.this, MainActivity.class));
            }
        });
    }
}