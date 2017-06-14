package com.example.enchanter_swapna.onlyweb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = (WebView) findViewById(R.id.webview);



        //myWebView.loadUrl("file:///android_asset/message1.html");

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //myWebView=(WebView)findViewById(R.id.webview);
        myWebView.setWebViewClient(new MyBrowser());


        myWebView.loadUrl("http://24x7shoppers.com/swapna525/appdatabase/aumbuzam/index.html");
        myWebView.setWebViewClient(new WebViewClient(){

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                myWebView.loadUrl("file:///android_asset/message1.html");
                //Toast.makeText(getBaseContext(),"Press again to exit", Toast.LENGTH_SHORT).show();
            }
        });

       // if(CheckNetwork.isInternetAvailable(MainActivity.this)) //returns true if internet available
       // {
       //     myWebView.loadUrl("http:flatfull.com");
            //do something. loadwebview.
       // }
       // else
       // {
       //     Toast.makeText(MainActivity.this,"No Internet Connection",Toast.LENGTH_SHORT).show();
       // }



    }
//    public void isOnline() {
//        ConnectivityManager connMgr = (ConnectivityManager)
 //               getSystemService(Context.CONNECTIVITY_SERVICE);
 //       NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
 //       if (networkInfo != null && networkInfo.isConnected()) {
 //           Toast.makeText(getApplicationContext(),"Internet is available",Toast.LENGTH_SHORT).show();

 //       } else {
 //           String data="file:///android_asset/message1.html";
 //           myWebView.loadData(data, "text/html", "UTF-16");
 //           Toast.makeText(getApplicationContext(),data,Toast.LENGTH_SHORT).show();
 //       }
 //   }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (myWebView.canGoBack()) {
                        myWebView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }


}
    class MyBrowser extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);
            return true;

        }

    }

 //class CheckNetwork {
  //  private static final String TAG = CheckNetwork.class.getSimpleName();
    //public static boolean isInternetAvailable(Context context)
    //{
      //  NetworkInfo info = (NetworkInfo) ((ConnectivityManager)
       //         context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        //if (info == null)
        //{
         //   Log.d(TAG,"no internet connection");
         //   return false;
       // }
       // else
        //{
          //  if(info.isConnected())
           // {
            //    Log.d(TAG," internet connection available...");
          //      return true;
          //  }
          //  else
          //  {
          //      Log.d(TAG," internet connection");
          //      return true;
          //  }
       // }
   // }
//}