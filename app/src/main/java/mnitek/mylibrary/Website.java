package mnitek.mylibrary;

import android.content.Intent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Website extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        Intent intent = getIntent();
        if(intent != null) {
            String url = intent.getStringExtra("url");
            webView = findViewById(R.id.webView);
            webView.loadUrl(url);
            webView.setWebViewClient(new WebViewClient());
        }
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) webView.goBack();
            else super.onBackPressed();
    }
}