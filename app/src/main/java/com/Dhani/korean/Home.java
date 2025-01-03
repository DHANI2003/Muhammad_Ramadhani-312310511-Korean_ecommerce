package com.Dhani.korean;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Home extends AppCompatActivity {

    private TextView title, jenisMakanan, harga;
    private EditText searchBar;
    private Button btnSemua, btnMakanan, btnMinuman;
    private ImageView homeIcon, favoriteIcon, menuIcon, accountIcon;
    private CardView mainCard1, mainCard2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize views
        title = findViewById(R.id.title);
        searchBar = findViewById(R.id.search);

        btnSemua = findViewById(R.id.btnSemua);
        btnMakanan = findViewById(R.id.btnMakanan);
        btnMinuman = findViewById(R.id.btnMinuman);

        homeIcon = findViewById(R.id.homeIcon);
        favoriteIcon = findViewById(R.id.favoriteIcon);
        menuIcon = findViewById(R.id.menuIcon);
        accountIcon = findViewById(R.id.accountIcon);

        mainCard1 = findViewById(R.id.mainCard1);
        mainCard2 = findViewById(R.id.mainCard2);

        // Set button click listeners for navigation
        btnSemua.setOnClickListener(v -> openActivity(Minuman.class)); // Navigate to Minuman
        btnMakanan.setOnClickListener(v -> openActivity(Makanan.class)); // Navigate to Makanan
        btnMinuman.setOnClickListener(v -> openActivity(Minuman.class)); // Navigate to Minuman

        // Set bottom navigation click listeners
        homeIcon.setOnClickListener(v -> openActivity(Home.class)); // Stay on Home, or navigate if needed
        favoriteIcon.setOnClickListener(v -> openActivity(MenuFavorit.class)); // Navigate to MenuFavorit
        menuIcon.setOnClickListener(v -> openActivity(Home.class)); // Navigate back to Home
        accountIcon.setOnClickListener(v -> openActivity(Profil.class)); // Navigate to Profil

        // Set search bar action
        searchBar.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE || (event != null && event.getAction() == KeyEvent.ACTION_DOWN)) {
                String query = searchBar.getText().toString().trim();
                if (!query.isEmpty()) {
                    showToast("Mencari: " + query);
                } else {
                    showToast("Kolom pencarian kosong");
                }
                return true;
            }
            return false;
        });

        // Example main card interactions
        mainCard1.setOnClickListener(v -> openDetailPage("Makanan 1", "Makanan", "20000")); // Pass food item data
        mainCard2.setOnClickListener(v -> openDetailPage("Minuman 1", "Minuman", "15000")); // Pass drink item data
    }

    // Function to open the detail page with item data
    private void openDetailPage(String itemName, String itemType, String itemPrice) {
        Intent intent = new Intent(Home.this, DetailPesanan.class);
        intent.putExtra("itemName", itemName); // Pass food/drink name
        intent.putExtra("itemType", itemType); // Pass food/drink type
        intent.putExtra("itemPrice", itemPrice); // Pass food/drink price
        startActivity(intent);
    }

    // Utility function to show a toast message
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // Helper method to open an activity
    private void openActivity(Class<?> activityClass) {
        Intent intent = new Intent(Home.this, activityClass);
        startActivity(intent);
    }
}
