package com.team8.seatonvalley;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by tomsturgeon on 31/03/2018.
 * Last Edited by Steven Kirby on 08/04/2018.
 *
 * NewsFragment loads seatonvalley news page from its website
 */

public class NewsFragment extends Fragment {

    public WebView mWebView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v=inflater.inflate(R.layout.fragment_news, container, false);

        //get xml corresponding webview from fragment_news in above view ^
        mWebView = v.findViewById(R.id.webView);
        //skips to the correct section using #content-section-1 on loading.
        mWebView.loadUrl("http://seatonvalleycommunitycouncil.gov.uk/news/#content-section-1");

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageFinished(WebView view, String url) {

                //hides loading circle
                v.findViewById(R.id.indeterminateBar).setVisibility(View.GONE);
                //show webview
                v.findViewById(R.id.webView).setVisibility(View.VISIBLE);

            }


        });

        //allows webview to react how is expected when the user clicks the back button on android
        mWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == android.view.KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
                    mWebView.goBack();
                    return true;
                }
                    return false;
            }
        });

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("News");
    }

}
