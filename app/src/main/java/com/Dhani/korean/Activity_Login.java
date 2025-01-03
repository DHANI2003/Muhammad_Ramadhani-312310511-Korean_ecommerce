package com.Dhani.korean;

import android.content.SharedPreferences;
import android.content.Intent; // Import Intent
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_Login extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        // Inisialisasi komponen dari XML
        etUsername = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnlogin);

        // Logika saat tombol Login diklik
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                // Ambil data username dan password dari SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                String correctUsername = sharedPreferences.getString("username", null);
                String correctPassword = sharedPreferences.getString("password", null);

                // Validasi username dan password
                if (username.equals(correctUsername) && password.equals(correctPassword)) {
                    Toast.makeText(Activity_Login.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    // Lanjutkan ke Home activity
                    Intent intent = new Intent(Activity_Login.this, Home.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Activity_Login.this, "Username atau Password salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
