package mnitek.mylibrary;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Button btnSeeAllBooks, btnCurrentlyReading, btnAlreadyRead, btnWishlist, btnFavorites, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnSeeAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(intent);
            }
        });
    }

    public void initViews() {
        btnSeeAllBooks = findViewById(R.id.btnSeeAllBooks);
        btnCurrentlyReading = findViewById(R.id.btnCurrentlyReading);
        btnAlreadyRead = findViewById(R.id.btnAlreadyRead);
        btnWishlist = findViewById(R.id.btnWishlist);
        btnFavorites = findViewById(R.id.btnFavorites);
        btnAbout = findViewById(R.id.btnAbout);
    }
}