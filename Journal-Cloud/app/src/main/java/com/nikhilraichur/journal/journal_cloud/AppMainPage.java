package com.nikhilraichur.journal.journal_cloud;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by NikhilRaichur on 17-03-2015.
 */
public class AppMainPage extends Activity {

    //private Button button;
    private WebView webView;
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get webview
        webView = (WebView) findViewById(R.id.webView);

        startWebView("http://journal.nikhilraichur.com/login/index.php");

    }

    private void startWebView(String url) {

        //Create new webview Client to show progress dialog
        //When opening a url or click on link

        webView.setWebViewClient(new WebViewClient() {
            ProgressDialog progressDialog;

            //If you will not use this method url links are open in new browser not in webview
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            //Show loader on url load
            public void onLoadResource (WebView view, String url) {
                if (progressDialog == null) {
                    // in standard case YourActivity.this
                    progressDialog = new ProgressDialog(AppMainPage.this);
                    progressDialog.setMessage("Loading data.. Please Wait");
                    progressDialog.show();
                }
            }
            public void onPageFinished(WebView view, String url) {
                try{
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                        progressDialog = null;
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
            }

        });

        // Javascript inabled on webview
        webView.getSettings().setJavaScriptEnabled(true);





        //Load url in webview
        webView.loadUrl(url);


    }

    // Open previous opened link from history on webview when back button pressed

    @Override
    // Detect when the back button is pressed
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            // Let the system handle the back button
            super.onBackPressed();
        }
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
        if (id == R.id.action_create) {
            webView.loadUrl("http://journal.nikhilraichur.com/login/index.php?create");
            return true;
        }

        if (id == R.id.action_edit) {
            webView.loadUrl("http://journal.nikhilraichur.com/login/index.php?ednote");
            return true;
        }

        if (id == R.id.action_delete) {
            webView.loadUrl("http://journal.nikhilraichur.com/login/index.php?delnote");
            return true;
        }

        if (id == R.id.action_upload) {
            webView.loadUrl("http://journal.nikhilraichur.com/login/index.php?upload");
            return true;
        }

        if (id == R.id.action_deldoc) {
            webView.loadUrl("http://journal.nikhilraichur.com/login/index.php#ManageDoc");
            return true;
        }

        if (id == R.id.action_alert) {
            webView.loadUrl("http://journal.nikhilraichur.com/login/index.php?remcheck");
            return true;
        }

        if (id == R.id.action_login) {
            webView.loadUrl("http://journal.nikhilraichur.com/index.php#login");
            return true;
        }

        if (id == R.id.action_logout) {
            webView.loadUrl("http://journal.nikhilraichur.com/login/out.php");
            return true;
        }



        if (id == R.id.action_exit) {
            System.exit(0);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
