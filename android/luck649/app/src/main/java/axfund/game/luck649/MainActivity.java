package axfund.game.luck649;

import androidx.appcompat.app.AppCompatActivity;

import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private static String DebugTag = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView myWebView = (WebView) findViewById(R.id.webGameView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        // Below code is to fix the blank page of webview, our https is private signed ssl, so it will fail to verify.
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                // Log.i(DebugTag, String.format("Got http ssl error when load url, e: %s", error.toString()));
                handler.proceed();
            }
        });

        String gameUrl = getString(R.string.game_url);

        // Log.i(DebugTag, String.format("Start to load url %s in webview.", gameUrl));
        myWebView.loadUrl(gameUrl);
        // Log.d(DebugTag, String.format("Load finish"));
    }
}
