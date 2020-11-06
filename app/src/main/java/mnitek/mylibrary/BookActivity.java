package mnitek.mylibrary;

import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY = "bookId";
    private ImageView imgBookActivity;
    private Button btnAddToCurrRead, btnAddToWishList, btnAddToAlreadyRead, btnAddToFav;
    private TextView aBNametxt, aBAuthortxt, aBPagestxt, aBDescriptiontxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

        Intent intent = getIntent();
        if(null != intent) {
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);
            if (bookId != -1) {
                Book incomingBook = Utils.getInstance().getBookById(bookId);
                if(null != incomingBook) setData(incomingBook);
            }
        }
    }

    private void initViews() {
        imgBookActivity = findViewById(R.id.imgBookActivity);
        btnAddToCurrRead = findViewById(R.id.btnAddToCurrRead);
        btnAddToWishList = findViewById(R.id.btnAddToWishList);
        btnAddToAlreadyRead = findViewById(R.id.btnAddToAlreadyRead);
        btnAddToFav = findViewById(R.id.btnAddToFav);
        aBNametxt = findViewById(R.id.aBNametxt);
        aBAuthortxt = findViewById(R.id.aBPagestxt);
        aBPagestxt = findViewById(R.id.aBPagestxt);
        aBDescriptiontxt = findViewById(R.id.aBDescriptiontxt);
    }

    private void setData(Book book) {
        aBNametxt.setText(book.getName());
        aBAuthortxt.setText(book.getAuthor());
        aBPagestxt.setText(String.valueOf(book.getPages()));
        aBDescriptiontxt.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap().load(book.getImgUrl())
                .into(imgBookActivity);
    }
}