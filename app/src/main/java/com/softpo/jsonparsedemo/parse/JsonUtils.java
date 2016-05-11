package com.softpo.jsonparsedemo.parse;

import com.softpo.jsonparsedemo.bean.Bean;
import com.softpo.jsonparsedemo.bean.BeanOne;
import com.softpo.jsonparsedemo.bean.BeanTwo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by softpo on 2016/5/10.
 */
public class JsonUtils {

    public static Bean parseJson(String data){

        Bean ret = new Bean();

        try {
            JSONObject object = new JSONObject(data);

            String error = object.getString("error");

            ret.setError(error);

//            获取jsonArray
            JSONArray jsonArray = object.getJSONArray("data");

            List<Object> result = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject arrJson = jsonArray.getJSONObject(i);

                String post_cart = arrJson.getString("post_cart");

                if("0".equals(post_cart)||"6".equals(post_cart)){
                    BeanOne beanOne = new BeanOne();
                    /**
                     *  {
                     "ID": 682119,
                     "post_date": "2016-5-10 6:53:28",
                     "post_content": "采摘车",
                     "post_title": "住山里吃野味!山色峪摘樱桃",
                     "post_excerpt": "",
                     "item_small_pic": "http://zsqd.qdqss.cn/upload/2016/05/small_news_0.521536243856669.jpg",
                     "post_cart": "0",
                     "post_hd": "1",
                     "post_link": "http://v4.qdqss.cn//api/detail.aspx?id=682119"
                     }
                     */
                    beanOne.setID(arrJson.getInt("ID"));
                    beanOne.setPost_date(arrJson.getString("post_date"));
                    beanOne.setPost_content(arrJson.getString("post_content"));
                    beanOne.setPost_title(arrJson.getString("post_title"));
                    beanOne.setPost_excerpt(arrJson.optString("post_excerpt"));
                    beanOne.setItem_small_pic(arrJson.getString("item_small_pic"));
                    beanOne.setPost_cart(arrJson.getString("post_cart"));
                    beanOne.setPost_hd(arrJson.getString("post_hd"));
                    beanOne.setPost_link(arrJson.getString("post_link"));

                    result.add(beanOne);

                }else {
                    BeanTwo beanTwo = new BeanTwo();
                    /**
                     * {
                     "ID": 682403,
                     "post_date": "2016-5-10 15:44:45",
                     "post_content": "",
                     "post_title": "莫斯科阅兵式:长腿女兵很漂亮",
                     "post_excerpt": "682403",
                     "item_small_pic": "http://zsqd.qdqss.cn/upload/2016/05/0.78378844856461.jpg",
                     "post_cart": "1",
                     "post_hd": "",
                     "post_tuji": "682403",
                     "pics": "http://zsqd.qdqss.cn/upload/2016/05/small_news_0.826879693114608.jpg|http://zsqd.qdqss.cn/upload/2016/05/small_news_0.627485689067974.jpg|http://zsqd.qdqss.cn/upload/2016/05/small_news_0.0473932731186008.jpg",
                     "post_link": "http://v4.qdqss.cn//api/detail.aspx?id=682403"
                     }
                     */
                    beanTwo.setID(arrJson.getInt("ID"));
                    beanTwo.setPost_date(arrJson.getString("post_date"));
                    beanTwo.setPost_content(arrJson.optString("post_content"));
                    beanTwo.setPost_title(arrJson.getString("post_title"));
                    beanTwo.setPost_excerpt(arrJson.getString("post_excerpt"));
                    beanTwo.setItem_small_pic(arrJson.getString("item_small_pic"));
                    beanTwo.setPost_cart(arrJson.getString("post_cart"));
                    beanTwo.setPost_hd(arrJson.optString("post_hd"));
                    beanTwo.setPost_tuji(arrJson.getString("post_tuji"));
                    beanTwo.setPics(arrJson.optString("pics"));
                    beanTwo.setPost_link(arrJson.getString("post_link"));

                    result.add(beanTwo);
                }
            }

            ret.setDatas(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return ret;
    }

}
