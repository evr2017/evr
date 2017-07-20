package evr.com.evr.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import evr.com.evr.R;

/**
 * Created by karenmatias on 30/04/2017.
 */

public class AboutUsFragment  extends Fragment {

    public AboutUsFragment() {
    }

    public static Fragment newInstance() {
        return new AboutUsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*TextView textView = (TextView) rootView.findViewById(R.id.textView1);
        textView.setText(getClass().getSimpleName());
        WebView myWebView = (WebView) rootView.findViewById(R.id.webView1);
        myWebView.loadUrl("http://192.168.43.111:8887");
        WebSettings webSettings=myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);*/
        return inflater.inflate(R.layout.fragment_about, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


}


