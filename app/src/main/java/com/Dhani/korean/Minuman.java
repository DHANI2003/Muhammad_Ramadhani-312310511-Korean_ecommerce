package com.Dhani.korean;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Minuman extends AppCompatActivity {

    private TextView jenismakanan, harga;
    private ImageView mainImage;
    private Button btnSemua, btnMakanan, btnMinuman;
    private ImageView homeIcon, favoriteIcon, menuIcon, accountIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minuman);  // Ganti dengan layout yang sesuai

        // Inisialisasi tampilan
        jenismakanan = findViewById(R.id.jenismakanan);
        harga = findViewById(R.id.harga);
        mainImage = findViewById(R.id.mainImage);
        btnSemua = findViewById(R.id.btnSemua);
        btnMakanan = findViewById(R.id.btnMakanan);
        btnMinuman = findViewById(R.id.btnMinuman);
        homeIcon = findViewById(R.id.homeIcon);
        favoriteIcon = findViewById(R.id.favoriteIcon);
        menuIcon = findViewById(R.id.menuIcon);
        accountIcon = findViewById(R.id.accountIcon);

        // Menampilkan item minuman
        showDrinkItems();

        // Menangani ikon bottom navigation
        homeIcon.setOnClickListener(v -> navigateToHome());
        favoriteIcon.setOnClickListener(v -> navigateToFavorites());
        menuIcon.setOnClickListener(v -> navigateToMenu());
        accountIcon.setOnClickListener(v -> navigateToAccount());

        // Menangani tombol kategori
        btnSemua.setOnClickListener(v -> navigateToAll());
        btnMakanan.setOnClickListener(v -> navigateToFood());
        btnMinuman.setOnClickListener(v -> navigateToDrinks());
    }

    // Fungsi untuk menampilkan item minuman
    private void showDrinkItems() {
        jenismakanan.setText("Es teh jeruk");  // Nama item minuman
        harga.setText("Rp. 50.000");  // Harga item minuman
        mainImage.setImageResource(R.drawable.minuman);  // Gambar minuman
    }

    // Navigasi ke HomeActivity
    private void navigateToHome() {
        Intent intent = new Intent(Minuman.this, Home.class);
        startActivity(intent);
    }

    // Navigasi ke FavoriteActivity
    private void navigateToFavorites() {
        Intent intent = new Intent(Minuman.this, MenuFavorit.class);
        startActivity(intent);
    }

    // Navigasi ke MenuActivity
    private void navigateToMenu() {
        Intent intent = new Intent(Minuman.this, Home.class);
        startActivity(intent);
    }

    // Navigasi ke AccountActivity
    private void navigateToAccount() {
        Intent intent = new Intent(Minuman.this, Profil.class);
        startActivity(intent);
    }

    // Navigasi ke halaman Semua (All)
    private void navigateToAll() {
        Intent intent = new Intent(Minuman.this, Home.class);  // Ganti dengan activity yang sesuai
        startActivity(intent);
    }

    // Navigasi ke halaman Makanan (Food)
    private void navigateToFood() {
        Intent intent = new Intent(Minuman.this, Makanan.class);  // Ganti dengan activity yang sesuai
        startActivity(intent);
    }

    // Navigasi ke halaman Minuman (Drinks)
    private void navigateToDrinks() {
        Intent intent = new Intent(Minuman.this, Minuman.class);  // Tetap di MinumanActivity
        startActivity(intent);
    }
}
