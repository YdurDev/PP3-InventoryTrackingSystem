package com.zybooks.myassettracker.UI;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.zybooks.myassettracker.Database.Repository;
import com.zybooks.myassettracker.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        Repository repository = new Repository(getApplication());

        //----------------------Cards---------------------------
        //-------Total
        int totalValue = repository.getProductCount();
        TextView totalValueText = findViewById(R.id.totalValue);
        totalValueText.setText(String.valueOf(totalValue));

        //-------No Stock
        int noValue = repository.getNoStockCount();
        TextView noValueText = findViewById(R.id.noValue);
        noValueText.setText(String.valueOf(noValue));

        //-------Low Stock
        int lowValue = repository.getmUnitStockCount();
        TextView lowValueText = findViewById(R.id.lowValue);
        lowValueText.setText(String.valueOf(lowValue));

        //-------Unit Stock
        int unitValue = repository.getmUnitStockCount();
        TextView unitValueText = findViewById(R.id.unitValue);
        unitValueText.setText(String.valueOf(unitValue));




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}