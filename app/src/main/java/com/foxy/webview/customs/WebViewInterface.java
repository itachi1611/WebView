package com.foxy.webview.customs;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebViewInterface {

    Context mContext;

    public WebViewInterface(Context mContext) {
        this.mContext = mContext;
    }

    @JavascriptInterface
    public void showToast(String mess) {
        Toast.makeText(mContext, mess, Toast.LENGTH_SHORT).show();
    }

}
