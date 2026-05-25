package com.zybooks.myassettracker.UI;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.zybooks.myassettracker.Entities.Product;
import com.zybooks.myassettracker.R;
import com.zybooks.myassettracker.Database.Repository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button startBtn = findViewById(R.id.startBtn);
        Repository repository = new Repository(getApplication());


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                Product product = new Product(0,"Dell InspirePC", "100.99",100,"NJ");
                repository.insert(product);
                Product product1 = new Product(0, "Dell Inspiron 15", "799.99", 25, "NJ");
                repository.insert(product1);
                Product product2 = new Product(0, "HP Pavilion Desktop", "649.50", 0, "PA");
                repository.insert(product2);
                Product product3 = new Product(0, "Lenovo ThinkPad X1", "1299.00", 12, "PA");
                repository.insert(product3);
                Product product4 = new Product(0, "Apple MacBook Air M3", "1499.99", 10, "NY");
                repository.insert(product4);
                Product product5 = new Product(0, "ASUS ROG Gaming PC", "1899.95", 7, "NJ");
                repository.insert(product5);
                Product product6 = new Product(0, "Acer Aspire 5", "549.99", 30, "NY");
                repository.insert(product6);
                Product product7 = new Product(0, "MSI Stealth Laptop", "1599.49", 9, "NY");
                repository.insert(product7);
                Product product8 = new Product(0, "Samsung Odyssey Monitor", "349.99", 0, "NY");
                repository.insert(product8);
                Product product9 = new Product(0, "Corsair Gaming Keyboard", "129.95", 40, "PA");
                repository.insert(product9);
                Product product10 = new Product(0, "Logitech MX Master Mouse", "99.99", 50, "NY");
                repository.insert(product10);
                startActivity(intent);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}