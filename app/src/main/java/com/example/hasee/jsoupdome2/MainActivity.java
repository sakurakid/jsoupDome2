package com.example.hasee.jsoupdome2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MainActivity extends AppCompatActivity {
    private TextView show;
    private String s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (TextView) findViewById(R.id.text);
        get();


}
   private void get(){
               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       try {
                           Log.d("233","llll");
                           Document document = Jsoup.connect("http://home.meishichina.com/show-top-type-recipe.html").get();
                           Elements element = document.select("div.top-bar");
                           Log.i("mytag",element.select("a").attr("title"));
                       }catch (Exception e){
                           Log.i("mytag",e.toString());
                       }
                   }
               }).start();
           }

   





}
