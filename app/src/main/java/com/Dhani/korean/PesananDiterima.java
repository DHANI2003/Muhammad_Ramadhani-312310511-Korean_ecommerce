package com.Dhani.korean;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PesananDiterima extends AppCompatActivity {

    private TextView itemNameText, itemQuantityText, itemPriceText;
    private Button lihatPesananBtn, pesanLainnyaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan_diterima);

        // Inisialisasi tampilan
        itemNameText = findViewById(R.id.itemNameText);
        itemQuantityText = findViewById(R.id.itemQuantityText);
        itemPriceText = findViewById(R.id.itemPriceText);
        lihatPesananBtn = findViewById(R.id.btn_lihat_pesanan);
        pesanLainnyaBtn = findViewById(R.id.btn_pesan_lainnya);

        // Menerima data dari activity sebelumnya
        String itemName = getIntent().getStringExtra("itemName");
        String itemQuantity = getIntent().getStringExtra("itemQuantity");
        String itemPrice = getIntent().getStringExtra("itemPrice");

        // Menampilkan data yang diterima
        itemNameText.setText("Nama Item: " + itemName);
        itemQuantityText.setText("Jumlah: " + itemQuantity);
        itemPriceText.setText("Harga: " + itemPrice);

        // Tombol Lihat Pesanan
        lihatPesananBtn.setOnClickListener(v -> {
            // Tindakan untuk melihat pesanan lebih lanjut
        });

        // Tombol Pesan Lainnya
        pesanLainnyaBtn.setOnClickListener(v -> {
            finish();  // Kembali ke activity sebelumnya
        });
    }
}
