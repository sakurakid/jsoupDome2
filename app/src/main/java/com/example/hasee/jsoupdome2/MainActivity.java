package com.example.hasee.jsoupdome2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private TextView show;
    private String s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (TextView) findViewById(R.id.text);
        //get();
        get2();

}
//在这里Documnet继承于   Element 继承于 Node类
// Jsoup.connect(String url)方法不能运行在主线程，否则会报NetworkOnMainThreadException
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
    private void get2(){
       new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   Document doc = Jsoup.connect("http://home.meishichina.com/show-top-type-recipe.html").get();
                   Elements titleAnd = doc.select("div.pic");
                   Log.i("mytag","title:"+titleAnd.get(1).select("a").attr("title")+"pic:"+titleAnd.get(1).select("a").select("img").attr("data-src"));

                   Elements url = doc.select("a");
                   Log.i("mytag","url"+url.get(1).attr("href"));

                   Elements burden = doc.select("p.subcontent");
                   Log.i("mytag","burden"+burden.get(1).text());

               } catch (IOException e) {
                   e.printStackTrace();
               }

           }
       }).start();
    }


/*
1.下载jar包并丢到libs(或者在gradle)
2.找到心仪的网页
3.用Jsoup.connect()获取网页的document
4.查看网页源码，对准你想要的地方，给他来一个Element.select(String selector)
5.用Node.attr(String key)或者Element.text()方法把数据抽出来


作者：四会歌神陈子豪
链接：https://www.jianshu.com/p/a620a2664f58
來源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
* */




}
