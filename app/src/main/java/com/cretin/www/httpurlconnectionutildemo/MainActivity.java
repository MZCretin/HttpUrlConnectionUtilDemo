package com.cretin.www.httpurlconnectionutildemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.cretin.www.httpurlconnectionutil.HttpUtils;
import com.cretin.www.httpurlconnectionutil.callback.HttpCallbackBytesListener;
import com.cretin.www.httpurlconnectionutil.callback.HttpCallbackModelListener;
import com.cretin.www.httpurlconnectionutil.callback.HttpCallbackStringListener;
import com.cretin.www.httpurlconnectionutildemo.model.ResponseModel;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvContent = ( TextView ) findViewById(R.id.tv_content);

        //测试GET请求

        //返回字符串
        try {
            HttpUtils.doGet(this, "http://caipu.yjghost.com/index.php/query/read?menu=" + URLEncoder.encode("土豆", "UTF-8") + "&rn=15&start=1", new HttpCallbackStringListener() {

                @Override
                public void onFinish(String response) {
                    tvContent.setText(response);
                }

                @Override
                public void onError(Exception e) {
                    tvContent.setText(e.toString());
                }
            });
        } catch ( UnsupportedEncodingException e ) {
            e.printStackTrace();
        }

        //返回byte数组
        try {
            HttpUtils.doGet(this, "http://caipu.yjghost.com/index.php/query/read?menu=" + URLEncoder.encode("土豆", "UTF-8") + "&rn=15&start=1", new HttpCallbackBytesListener() {
                @Override
                public void onFinish(byte[] response) {
                    Log.e("HHHHHHH", "GET 方法：" + new String(response));
                }

                @Override
                public void onError(Exception e) {
                    Log.e("HHHHHHH", "doGet onError：" + e.toString());
                }
            });
        } catch ( UnsupportedEncodingException e ) {
            e.printStackTrace();
        }

        //返回对象
        try {
            HttpUtils.doGet(this, "http://caipu.yjghost.com/index.php/query/read?menu=" +
                            URLEncoder.encode("土豆", "UTF-8") + "&rn=15&start=1",
                    new HttpCallbackModelListener<ResponseModel>() {
                        @Override
                        public void onFinish(ResponseModel response) {
                            Log.e("HHHHHHH", "GET 方法：" + response.getResult().getTotalNum());
                        }

                        @Override
                        public void onError(Exception e) {
                            Log.e("HHHHHHH", "doGet onError：" + e.toString());
                        }
                    }, ResponseModel.class);
        } catch ( UnsupportedEncodingException e ) {
            e.printStackTrace();
        }

        //测试POST请求

        //参数列表
        Map<String, Object> map = new HashMap<>();
        map.put("productFirstType", "1");
        map.put("loanRange", "1");
        map.put("type", "hot");
        map.put("page", "1");
        map.put("timeRange", "1");

        //返回String
        HttpUtils.doPost(this, "http://101.201.31.212:8016/product/listProduct", new HttpCallbackStringListener() {
            @Override
            public void onFinish(String response) {
                Log.e("HHHHHHH", "POST 方法：" + response);
            }

            @Override
            public void onError(Exception e) {
                Log.e("HHHHHHH", "doPost onError：" + e.toString());
            }
        }, map);
        //返回byte数组
        HttpUtils.doPost(this, "http://101.201.31.212:8016/product/listProduct", new HttpCallbackBytesListener() {
            @Override
            public void onFinish(byte[] response) {
                Log.e("HHHHHHH", "POST 方法：" + new String(response));
            }

            @Override
            public void onError(Exception e) {
                Log.e("HHHHHHH", "doPost onError：" + e.toString());
            }
        }, map);
        //返回对象
        HttpUtils.doPost(this, "http://101.201.31.212:8016/product/listProduct", new HttpCallbackModelListener<ResponseModel>() {
            @Override
            public void onFinish(ResponseModel response) {
                Log.e("HHHHHHH", "POST 方法：" + response.getResult().getTotalNum());
            }

            @Override
            public void onError(Exception e) {
                Log.e("HHHHHHH", "doPost onError：" + e.toString());
            }
        }, map, ResponseModel.class);
    }
}
