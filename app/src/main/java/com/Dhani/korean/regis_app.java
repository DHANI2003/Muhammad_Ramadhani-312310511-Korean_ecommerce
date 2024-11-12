package com.Dhani.korean;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class regis_app extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText phoneEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis_app);

        // Inisialisasi elemen tampilan dari XML
        usernameEditText = findViewById(R.id.username);
        emailEditText = findViewById(R.id.email);
        phoneEditText = findViewById(R.id.phone);
        passwordEditText = findViewById(R.id.password2);
        confirmPasswordEditText = findViewById(R.id.password);
        signUpButton = findViewById(R.id.akunButton);

        // Set listener untuk tombol sign-up
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String phone = phoneEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();

                // Validasi input
                if (username.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(regis_app.this, "Semua kolom harus diisi", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(regis_app.this, "Password tidak cocok", Toast.LENGTH_SHORT).show();
                } else {
                    // Logika ketika data sudah valid
                    Toast.makeText(regis_app.this, "Pendaftaran Berhasil", Toast.LENGTH_SHORT).show();

                    // Contoh: arahkan ke halaman login setelah registrasi berhasil
                    Intent intent = new Intent(regis_app.this,Activity_Login.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
