package com.lab.chun.androidlab;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by chun on 2015-05-02.
 */
public class ClubWeb extends Fragment {
    private WebView web;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.club_web, container, false);
        web = (WebView) view.findViewById(R.id.webView);

        // configuration
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // show inside webview
        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        return view;
    }

    public void loadUrl(String url) {
        web.loadUrl(url);
    }
}
