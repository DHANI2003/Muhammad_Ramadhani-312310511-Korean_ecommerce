package com.Dhani.korean;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Makanan extends AppCompatActivity {

    private TextView jenismakanan, harga;
    private ImageView mainImage;
    private Button btnSemua, btnMakanan, btnMinuman;
    private ImageView homeIcon, favoriteIcon, menuIcon, accountIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan);  // Pastikan layout sesuai

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

        // Menampilkan item makanan
        showFoodItems();

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

    // Fungsi untuk menampilkan item makanan
    private void showFoodItems() {
        jenismakanan.setText("Menu Spesial");  // Nama item makanan
        harga.setText("Rp. 300.000");  // Harga item makanan
        mainImage.setImageResource(R.drawable.img4);  // Gambar makanan
    }

    // Navigasi ke HomeActivity
    private void navigateToHome() {
        Intent intent = new Intent(Makanan.this, Home.class);
        startActivity(intent);
    }

    // Navigasi ke FavoriteActivity
    private void navigateToFavorites() {
        Intent intent = new Intent(Makanan.this, MenuFavorit.class);
        startActivity(intent);
    }

    // Navigasi ke MenuActivity
    private void navigateToMenu() {
        Intent intent = new Intent(Makanan.this, Home.class);
        startActivity(intent);
    }

    // Navigasi ke AccountActivity
    private void navigateToAccount() {
        Intent intent = new Intent(Makanan.this, Profil.class);
        startActivity(intent);
    }

    // Navigasi ke halaman Semua (All)
    private void navigateToAll() {
        Intent intent = new Intent(Makanan.this, Home.class);  // Ganti dengan activity yang sesuai
        startActivity(intent);
    }

    // Navigasi ke halaman Makanan (Food)
    private void navigateToFood() {
        Intent intent = new Intent(Makanan.this, Makanan.class);  // Tetap di MakananActivity
        startActivity(intent);
    }

    // Navigasi ke halaman Minuman (Drinks)
    private void navigateToDrinks() {
        Intent intent = new Intent(Makanan.this, Minuman.class);  // Ganti dengan activity yang sesuai
        startActivity(intent);
    }
}
