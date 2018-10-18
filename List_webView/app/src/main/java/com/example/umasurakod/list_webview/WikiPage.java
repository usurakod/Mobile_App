package com.example.umasurakod.list_webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WikiPage extends AppCompatActivity {

    WebView webView ;
    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki_page);

        webView = (WebView)findViewById(R.id.wv);

        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("Flower");
        if(bundle != null){
            switch (data){
                case "Rose":
                    url = "https://en.wikipedia.org/wiki/Rose";
                    break;
                case "Lotus":
                    url = "https://en.wikipedia.org/wiki/Nelumbo_nucifera";
                    break;
                case "Lily":
                    url = "https://en.wikipedia.org/wiki/Lily";
                    break;
                case "Marigold":
                    url = "https://en.wikipedia.org/wiki/Calendula_officinalis";
                    break;
                case "Jasmine":
                    url = "https://en.wikipedia.org/wiki/Jasmine";
                    break;
            }
        }

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient());
    }
}
