package com.team8.seatonvalley;

import android.graphics.drawable.Drawable;
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
 * Last Edited by Steven Kirby on 22/04/2018.
 *
 * MeetingsFragment loads the picture of a table of meetings in a webview
 */

public class MeetingsFragment extends Fragment {

    WebView mWebView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v=inflater.inflate(R.layout.fragment_meetings, container, false);

        //corresponding webview in XML from fragment_meetings
        mWebView = v.findViewById(R.id.webView);
        //image of meetings
        mWebView.loadUrl("http://seatonvalleycommunitycouncil.gov.uk.gridhosted.co.uk/wp-content/uploads/2018/04/Meetings-2018.jpg");

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageFinished(WebView view, String url) {

                //show webview which allows zooming.
                v.findViewById(R.id.imageView).setVisibility(View.GONE);
                v.findViewById(R.id.webView).setVisibility(View.VISIBLE);

            }


        });

        //just incase user manages to redirect themselves to another webpage, the back button will work
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
        getActivity().setTitle("Meetings");
    }
}
