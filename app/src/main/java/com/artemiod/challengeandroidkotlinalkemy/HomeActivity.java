package com.artemiod.challengeandroidkotlinalkemy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.artemiod.challengeandroidkotlinalkemy.ui.view.DetailsFragment;
import com.artemiod.challengeandroidkotlinalkemy.ui.view.MainActivity;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    private Button btnLogout;
    private Button btnMostrar;
    private Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnMostrar = findViewById(R.id.home_Mostrar);
        btnBuscar = findViewById(R.id.home_buscar);
        btnLogout = findViewById(R.id.home_Exit);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viem) {
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
            }
        });
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viem) {
                startActivity(new Intent(HomeActivity.this, DetailsFragment.class));
            }
        });
    }
}