package evr.com.evr.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import evr.com.evr.R;

/**
 * Created by sf.jerome.w.catalon on 23/05/2017.
 */

public class WebViewVRModeActivity extends FragmentActivity {

    @BindView(R.id.vr_mode_web_view)
    protected WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.web_view_vr_mode_activity_layout);

        ButterKnife.bind(this);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        String vrUrl = "http://localhost:8080/Reticulum-master1/examples/basic.html";
        String dummyUrl = "https://stackoverflow.com/questions/4509851/web-server-for-android";

        WebSettings webSettings = webView.getSettings();
        //webSettings.setLoadWithOverviewMode(true);
        //webSettings.setUseWideViewPort(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        //webSettings.setAppCacheEnabled(false);
        //webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);

        //webView.setVerticalScrollBarEnabled(false);
        //webView.setHorizontalScrollBarEnabled(false);
        //webView.clearCache(true);
        //webView.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }
        });

        webView.loadUrl(vrUrl);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
