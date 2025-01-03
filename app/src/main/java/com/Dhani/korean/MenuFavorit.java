package com.Dhani.korean;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuFavorit extends AppCompatActivity {

    private LinearLayout favoriteContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_favorit);

        // Initialize favoriteContainer
        favoriteContainer = findViewById(R.id.favoriteContainer);

        // Check if data is passed from Home activity
        if (getIntent() != null) {
            String itemName = getIntent().getStringExtra("favoriteItemName");
            String itemPrice = getIntent().getStringExtra("favoriteItemPrice");
            int itemImage = getIntent().getIntExtra("favoriteItemImage", R.drawable.ic_launcher_foreground);

            // Add the received favorite item to the list
            if (itemName != null && itemPrice != null) {
                addFavoriteItem(itemName, itemPrice, itemImage);
            }
        }
    }

    /**
     * Method to add a favorite item dynamically to the favoriteContainer
     *
     * @param itemName Name of the item
     * @param itemPrice Price of the item
     * @param itemImage Resource ID of the item's image
     */
    private void addFavoriteItem(String itemName, String itemPrice, int itemImage) {
        // Inflate a new item layout
        View favoriteItem = LayoutInflater.from(this).inflate(R.layout.favorit_item, favoriteContainer, false);

        // Find and set item name, price, and image
        TextView itemNameView = favoriteItem.findViewById(R.id.favoriteItemName);
        TextView itemPriceView = favoriteItem.findViewById(R.id.favoriteItemPrice);
        ImageView itemImageView = favoriteItem.findViewById(R.id.favoriteItemImage);

        itemNameView.setText(itemName);
        itemPriceView.setText(itemPrice);
        itemImageView.setImageResource(itemImage);

        // Add the item to the container
        favoriteContainer.addView(favoriteItem);


    }
}
