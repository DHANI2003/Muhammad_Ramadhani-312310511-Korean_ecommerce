package com.Dhani.korean;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailPesanan extends AppCompatActivity {

    private TextView itemName, orderNumber, notes, orderListLabel1, totalPrice;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pesanan);

        // Initialize views
        itemName = findViewById(R.id.itemName);
        orderNumber = findViewById(R.id.orderNumber);  // Menambahkan untuk Nomor Pesanan
        notes = findViewById(R.id.notes);  // Menambahkan untuk Catatan
        orderListLabel1 = findViewById(R.id.orderListLabel1);
        totalPrice = findViewById(R.id.totalPrice);  // Menambahkan untuk Total Harga
        backButton = findViewById(R.id.backButton);

        // Get the data passed from the previous activity (Intent)
        Intent intent = getIntent();
        String name = intent.getStringExtra("itemName");
        String orderNum = intent.getStringExtra("orderNumber");
        String note = intent.getStringExtra("notes");
        String price = intent.getStringExtra("itemPrice");

        // Set the data to the views
        itemName.setText(name);
        orderNumber.setText(orderNum);  // Menampilkan Nomor Pesanan
        notes.setText(note);  // Menampilkan Catatan

        // Display total price (assuming we are just displaying the item price as total)
        totalPrice.setText("Total: " + price);  // Menampilkan Total Harga

        // Set back button functionality
        backButton.setOnClickListener(v -> finish());
    }
}
