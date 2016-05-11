package com.softpo.jsonparsedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.softpo.jsonparsedemo.bean.Bean;
import com.softpo.jsonparsedemo.http.HttpUtils;
import com.softpo.jsonparsedemo.parse.JsonUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnParse(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "http://v4.qdqss.cn/api/posts.ashx?action=list&page=1&category=674&db=%E9%9D%92%E5%B2%9B";
                String data = HttpUtils.getData(url);

                Bean bean = JsonUtils.parseJson(data);

                if (bean != null) {
                    Log.d("flag", "-------->size: " + bean.getDatas().size());
                }

//                fastJson解析

                Bean fast = JSON.parseObject(data.toString(), Bean.class);

                if (fast != null) {
                    Log.d("flag", "-------->fast size: " + fast.getData().size());
                }

                //Gson解析
                Gson gson = new Gson();

                Bean gsonParse = gson.fromJson(data.toString(), Bean.class);

                if (gsonParse != null) {
                    Log.d("flag", "-------->gson size: " + gsonParse.getData().size());
                }
            }
        }).start();

    }
}
