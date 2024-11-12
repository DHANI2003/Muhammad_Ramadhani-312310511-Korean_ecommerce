package com.Dhani.korean;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Login extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;

    // Akun yang akan digunakan untuk login
    private final String correctUsername = "dhani";
    private final String correctPassword = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        // Inisialisasi komponen dari XML
        etUsername = findViewById(R.id.username); // Sesuai dengan ID di XML
        etPassword = findViewById(R.id.password); // Sesuai dengan ID di XML
        btnLogin = findViewById(R.id.btnlogin);   // Sesuai dengan ID di XML

        // Logika saat tombol Login diklik
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                // Validasi username dan password
                if (username.equals(correctUsername) && password.equals(correctPassword)) {
                    Toast.makeText(Activity_Login.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    // Lanjutkan ke MainActivity
                    Intent intent = new Intent(Activity_Login.this, Home.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Activity_Login   .this, "Username atau Password salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}