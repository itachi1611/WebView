package com.foxy.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.foxy.webview.customs.CustomeWebView;
import com.foxy.webview.customs.WebViewInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.webView)
    WebView webView;

    private Unbinder unbinder;

    public static final String URL = "https://developer.android.com/";
    private static final String DATA = "Relative link";
    private static final String MIME_TYPE = "text/html";
    private static final String ENCODING = "UTF-8";
    private static final String HISTORY_URL = "https://www.facebook.com/itachi1611";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initWebView();
    }

    private void initViews() {
        unbinder = ButterKnife.bind(this);
    }

    private void initWebView() {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

//        CustomeWebView customeWebView = new CustomeWebView(this);
//        webView.setWebViewClient(customeWebView);

//        webView.loadData(
//            "<html><body>Hello world !</body></html>",
//                "text/html",
//                "UTF-8"
//        );
//        webView.loadDataWithBaseURL(URL, DATA, MIME_TYPE, ENCODING, HISTORY_URL);

//        webView.addJavascriptInterface(new WebViewInterface(this), "NamtNT");

        webView.loadUrl(URL);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
