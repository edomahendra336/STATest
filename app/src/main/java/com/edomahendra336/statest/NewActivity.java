package com.edomahendra336.statest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewActivity extends AppCompatActivity {

    EditText namaadd, inadd, usiaadd;
    Button saveadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        namaadd = findViewById(R.id.add_NAMA);
        inadd = findViewById(R.id.add_tglmasuk);
        usiaadd = findViewById(R.id.add_USIA);
        saveadd = findViewById(R.id.save_btn);
        saveadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper databaseHelper = new DatabaseHelper(NewActivity.this);
                databaseHelper.addNew(namaadd.getText().toString().trim(),
                        inadd.getText().toString().trim(),
                        Integer.parseInt(usiaadd.getText().toString().trim()));
            }
        });
    }
}