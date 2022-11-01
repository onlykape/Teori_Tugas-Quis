package com.example.tugasquismobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MhsViewModel MhsViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText nim = findViewById(R.id.Nim);
        EditText nama = findViewById(R.id.Nama);
        EditText jurusan = findViewById(R.id.Jurusan);
        TextView hasil = findViewById(R.id.hnam);
        TextView hasil2 = findViewById(R.id.hnim);
        TextView hasil3 = findViewById(R.id.hjur);
        Button insert = findViewById(R.id.btn);
        MhsViewModel = new ViewModelProvider(this).get(MhsViewModel.class);
        MhsViewModel.getName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                hasil.setText(s);
            }
        });

        MhsViewModel.getNim().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                hasil2.setText(s);
            }
        });

        MhsViewModel.getjurusan().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                hasil3.setText(s);
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MhsViewModel.getName().setValue(nama.getText().toString());
                MhsViewModel.getNim().setValue(nim.getText().toString());
                MhsViewModel.getjurusan().setValue(jurusan.getText().toString());
            }
        });
    }
}