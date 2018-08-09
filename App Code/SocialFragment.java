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
 * Created by Steven Kirby on 18/04/2018.
 * Last Edited by Steven Kirby on 22/04/2018.
 *
 * SocialFragment has a WebView with 2 buttons to direct that WebView to the users choice of social media.
 */

public class SocialFragment extends Fragment {

    WebView mWebView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_social, container, false);

        //facebook and twitter buttons on clicked load the url into the webview.
        v.findViewById(R.id.fbButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                loadPage("https://www.facebook.com/seatonvalleycommunitycouncil/");
            }
        });
        v.findViewById(R.id.tButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                loadPage("http://twitter.com/seatonvalleycc");
            }
        });

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Social Media");
    }

    /**
     * @param url Takes the web address which is to be navigated to.
     */
    private void loadPage(String url){

        //Finds the webview from the XML layout to load the webpage on
        mWebView = getView().findViewById(R.id.twitterWebView);
        //Makes it visible to user
        getView().findViewById(R.id.indeterminateBar).setVisibility(View.VISIBLE);
        mWebView.loadUrl(url);
        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageFinished(WebView view, String url) {

                //hide all previous buttons and information from the user.
                getView().findViewById(R.id.indeterminateBar).setVisibility(View.GONE);
                getView().findViewById(R.id.fbButton).setVisibility(View.GONE);
                getView().findViewById(R.id.tButton).setVisibility(View.GONE);
                getView().findViewById(R.id.textView).setVisibility(View.GONE);
                getView().findViewById(R.id.textView2).setVisibility(View.GONE);
                getView().findViewById(R.id.textView3).setVisibility(View.GONE);
                getView().findViewById(R.id.textView4).setVisibility(View.GONE);
                getView().findViewById(R.id.textView5).setVisibility(View.GONE);
                getView().findViewById(R.id.textView6).setVisibility(View.GONE);

                //show webView
                getView().findViewById(R.id.twitterWebView).setVisibility(View.VISIBLE);
            }
        });

        //if user clicks the android back button, it will react as would be expected and go back a page in the webView.
        mWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == android.view.KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
                    mWebView.goBack();
                    return true;
                }
                    return false; }
        });
    }
}
