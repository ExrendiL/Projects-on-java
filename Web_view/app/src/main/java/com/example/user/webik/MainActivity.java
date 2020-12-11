package com.example.user.webik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv = (WebView)findViewById(R.id.webv);
        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        wv.loadUrl("https://www.istu.edu.ua/%D1%84%D1%96%D0%BD%D0%B0%D0%BD%D1%81%D0%B8_%D1%96_%D0%BA%D1%80%D0%B5%D0%B4%D0%B8%D1%82/");
        wv.setWebViewClient(new WebViewClient());
    }
    @Override
    public void onBackPressed ()
    {
        if (wv.canGoBack())
            wv.goBack();
        else
            super.onBackPressed();
    }
}
