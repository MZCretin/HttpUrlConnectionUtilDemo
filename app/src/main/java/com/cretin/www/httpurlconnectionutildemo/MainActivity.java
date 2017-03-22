package com.cretin.www.httpurlconnectionutildemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.cretin.www.httpurlconnectionutil.HttpUtils;
import com.cretin.www.httpurlconnectionutil.callback.HttpCallbackStringListener;

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
//        try {
//            HttpUtil.sendGetModelRequest(this, "http://caipu.yjghost.com/index.php/query/read?menu=" + URLEncoder.encode("土豆", "UTF-8") + "&rn=15&start=1", new HttpCallbackModelListener() {
//                @Override
//                public void onFinish(Object response) {
//                    Log.e("", "");
//                }
//
//                @Override
//                public void onError(Exception e) {
//
//                }
//            }, ResponseModel.class);
//        } catch ( UnsupportedEncodingException e ) {
//            e.printStackTrace();
//        }

        try {
            HttpUtils.doGet(this, "http://caipu.yjghost.com/index.php/query/read?menu=" + URLEncoder.encode("土豆", "UTF-8") + "&rn=15&start=1", new HttpCallbackStringListener() {

                @Override
                public void onFinish(String response) {

                }

                @Override
                public void onError(Exception e) {

                }
            });
        } catch ( UnsupportedEncodingException e ) {
            e.printStackTrace();
        }

//        try {
//            HttpUtil.doGet(this, "http://caipu.yjghost.com/index.php/query/read?menu=" + URLEncoder.encode("土豆", "UTF-8") + "&rn=15&start=1", new HttpCallbackModelListener<ResponseModel>() {
//                @Override
//                public void onFinish(ResponseModel response) {
//
//                }
//
//                @Override
//                public void onError(Exception e) {
//
//                }
//            }, ResponseModel.class);
//        } catch ( UnsupportedEncodingException e ) {
//            e.printStackTrace();
//        }
//        try {
//            HttpUtil.doGet(this, "http://caipu.yjghost.com/index.php/query/read?menu=" + URLEncoder.encode("土豆", "UTF-8") + "&rn=15&start=1", new HttpCallbackBytesListener() {
//                @Override
//                public void onFinish(byte[] response) {
//
//                }
//
//                @Override
//                public void onError(Exception e) {
//
//                }
//            });
//        } catch ( UnsupportedEncodingException e ) {
//            e.printStackTrace();
//        }
        Map<String, Object> map = new HashMap<>();
        map.put("productFirstType", "1");
        map.put("loanRange", "1");
        map.put("type", "hot");
        map.put("page", "1");
        map.put("timeRange", "1");
        HttpUtils.doPost(this, "http://101.201.31.212:8016/product/listProduct", new HttpCallbackStringListener() {
            @Override
            public void onFinish(String response) {
                tvContent.setText(response);
            }

            @Override
            public void onError(Exception e) {
                tvContent.setText(e.toString());
            }
        }, map);
    }
}
