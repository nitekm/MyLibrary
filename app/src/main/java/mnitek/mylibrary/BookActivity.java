package mnitek.mylibrary;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

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

                handleAlreadyRead(incomingBook);
                handleCurrRead(incomingBook);
                handleAddToWishList(incomingBook);
                handleAddToFav(incomingBook);
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

    private void handleAlreadyRead(final Book book) {

        ArrayList<Book> alreadyReadBooks = Utils.getInstance().getReadBooks();

        boolean existInAlreadyRead = false;

        for (Book b:alreadyReadBooks)
        if(b.getId() == book.getId()) {
            existInAlreadyRead = true;
        }

        if(existInAlreadyRead) {
            btnAddToAlreadyRead.setEnabled(false);
        }
        else {
            btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToAlreadyRead(book)) {
                        Toast.makeText(BookActivity.this, "Book added to Already Read", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, AlreadyReadBook.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void handleCurrRead(final Book book) {

        ArrayList<Book> currReadBooks = Utils.getInstance().getCurrentBooks();

        boolean existInCurrRead = false;

        for (Book b:currReadBooks)
            if(b.getId() == book.getId()) {
                existInCurrRead = true;
            }

        if(existInCurrRead) {
            btnAddToCurrRead.setEnabled(false);
        }
        else {
            btnAddToCurrRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToCurrRead(book)) {
                        Toast.makeText(BookActivity.this, "Book added to Currently Read", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, CurrentlyReadBook.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
    private void handleAddToWishList(final Book book) {

        ArrayList<Book> wishList = Utils.getInstance().getWantBooks();

        boolean existInWishList = false;

        for (Book b:wishList)
            if(b.getId() == book.getId()) {
                existInWishList = true;
            }

        if(existInWishList) {
            btnAddToWishList.setEnabled(false);
        }
        else {
            btnAddToWishList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToWantRead(book)) {
                        Toast.makeText(BookActivity.this, "Book added to Wishlist", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, WishList.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
    private void handleAddToFav(final Book book) {

        ArrayList<Book> favBooks = Utils.getInstance().getFavBooks();

        boolean existInFavBooks = false;

        for (Book b:favBooks)
            if(b.getId() == book.getId()) {
                existInFavBooks = true;
            }

        if(existInFavBooks) {
            btnAddToFav.setEnabled(false);
        }
        else {
            btnAddToFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToFav(book)) {
                        Toast.makeText(BookActivity.this, "Book added to Favourites", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, FavBook.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
