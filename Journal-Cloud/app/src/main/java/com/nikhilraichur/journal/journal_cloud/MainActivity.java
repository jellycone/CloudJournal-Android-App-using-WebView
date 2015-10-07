package com.nikhilraichur.journal.journal_cloud;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


public class MainActivity extends ActionBarActivity {

    private WebView myWebview;


    @Override
    public void onBackPressed() {
        if (myWebview.canGoBack()) {
            myWebview.goBack();
        } else
            super.onBackPressed();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myWebview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = myWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);


        myWebview.setInitialScale(0);
        myWebview.getSettings().setBuiltInZoomControls(false);
        myWebview.getSettings().setSupportZoom(false);
        myWebview.getSettings().setLoadWithOverviewMode(false);
        myWebview.getSettings().setUseWideViewPort(false);
        myWebview.getSettings().setLoadWithOverviewMode(false);
        myWebview.getSettings().setUseWideViewPort(false);
        myWebview.setWebViewClient(new WebViewClient());
        myWebview.setWebViewClient(new MyAppwebViewClient());
        myWebview.loadUrl("http://journal.nikhilraichur.com/login/index.php");
        myWebview.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }


        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_create) {
            myWebview.loadUrl("http://journal.nikhilraichur.com/login/index.php?create");
            return true;
        }

        if (id == R.id.action_edit) {
            myWebview.loadUrl("http://journal.nikhilraichur.com/login/index.php?ednote");
            return true;
        }

        if (id == R.id.action_delete) {
            myWebview.loadUrl("http://journal.nikhilraichur.com/login/index.php?delnote");
            return true;
        }

        if (id == R.id.action_upload) {
            myWebview.loadUrl("http://journal.nikhilraichur.com/login/index.php?upload");
            return true;
        }

        if (id == R.id.action_deldoc) {
            myWebview.loadUrl("http://journal.nikhilraichur.com/login/index.php#ManageDoc");
            return true;
        }

        if (id == R.id.action_alert) {
            myWebview.loadUrl("http://journal.nikhilraichur.com/login/index.php?remcheck");
            return true;
        }

        if (id == R.id.action_login) {
            myWebview.loadUrl("http://journal.nikhilraichur.com/index.php#login");
            return true;
        }

        if (id == R.id.action_logout) {
            myWebview.loadUrl("http://journal.nikhilraichur.com/login/out.php");
            return true;
        }

        if (id == R.id.action_exit) {
            System.exit(0);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
