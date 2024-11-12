package com.Dhani.korean;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button signUpButton;
    private Button signInButton;
    private TextView textLogin;
    private TextView textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi Views
        signUpButton = findViewById(R.id.button);
        signInButton = findViewById(R.id.textLogin2);
        textLogin = findViewById(R.id.textLogin);
        textMessage = findViewById(R.id.textView);

        // Listener untuk tombol Sign Up
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuka Activity_Regis_App saat tombol Sign Up ditekan
                Intent intent = new Intent(MainActivity.this, regis_app.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Sign Up Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Listener untuk tombol Sign In
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuka Activity_Login saat tombol Sign In ditekan
                Intent intent = new Intent(MainActivity.this, Activity_Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
