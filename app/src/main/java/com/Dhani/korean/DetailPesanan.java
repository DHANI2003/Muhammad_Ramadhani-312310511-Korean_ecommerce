package com.Dhani.korean;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class DetailPesanan extends AppCompatActivity {

    private TextView itemName, orderNumber, notes, orderListLabel1, totalPrice;
    private ImageView backButton;
    private Spinner paymentMethodSpinner;
    private Button confirmPaymentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pesanan);

        // Inisialisasi tampilan
        itemName = findViewById(R.id.itemName);
        orderNumber = findViewById(R.id.orderNumber);
        notes = findViewById(R.id.notes);
        orderListLabel1 = findViewById(R.id.orderListLabel1);
        totalPrice = findViewById(R.id.totalPrice);
        backButton = findViewById(R.id.backButton);
        paymentMethodSpinner = findViewById(R.id.paymentMethodSpinner);  // Spinner untuk memilih metode pembayaran
        confirmPaymentBtn = findViewById(R.id.confirmPaymentBtn);  // Tombol konfirmasi pembayaran

        // Mendapatkan data dari activity sebelumnya (Intent)
        Intent intent = getIntent();
        String name = intent.getStringExtra("itemName");
        String orderNum = intent.getStringExtra("orderNumber");
        String note = intent.getStringExtra("notes");
        String price = intent.getStringExtra("itemPrice");

        // Menampilkan data pesanan pada tampilan
        itemName.setText(name);
        orderNumber.setText(orderNum);
        notes.setText(note);

        // Menampilkan total harga (asumsi kita hanya menampilkan harga item sebagai total)
        totalPrice.setText("Total: " + price);

        // Menangani tombol kembali untuk keluar dari activity ini
        backButton.setOnClickListener(v -> finish());

        // Setup Spinner dengan metode pembayaran
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.payment_methods, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paymentMethodSpinner.setAdapter(adapter);

        // Menangani pemilihan metode pembayaran
        paymentMethodSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedMethod = parentView.getItemAtPosition(position).toString();
                // Anda dapat menangani pemilihan ini jika diperlukan
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Menangani jika tidak ada metode pembayaran yang dipilih
            }
        });

        // Menangani tombol konfirmasi pembayaran
        confirmPaymentBtn.setOnClickListener(v -> {
            String selectedMethod = paymentMethodSpinner.getSelectedItem().toString();
            // Memproses konfirmasi pembayaran
            confirmPayment(selectedMethod);
        });
    }

    private void confirmPayment(String paymentMethod) {
        // Mengirim data ke PesananDiterimaActivity
        Intent intent = new Intent(DetailPesanan.this, PesananDiterima.class);
        intent.putExtra("itemName", itemName.getText().toString()); // Mengirim nama item
        intent.putExtra("itemQuantity", "1"); // Contoh jumlah item
        intent.putExtra("itemPrice", totalPrice.getText().toString()); // Mengirim harga item
        startActivity(intent);

        // Menampilkan pesan Toast yang mengonfirmasi metode pembayaran
        Toast.makeText(this, "Pembayaran dikonfirmasi dengan metode: " + paymentMethod, Toast.LENGTH_LONG).show();

        // Anda dapat menambahkan logika lebih lanjut, seperti menuju ke gateway pembayaran atau memproses pembayaran di backend
    }
}
