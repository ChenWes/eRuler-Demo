package com.bwhx.test_bwhx_and_sdk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bwhx.bwhx_and_sdk.MeasureActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView tv_itemname1,tv_itemname2,tv_itemname3,tv_itemname4;
    private EditText et_itemdata1,et_itemdata2,et_itemdata3,et_itemdata4;
    private TextView tv_pinlei;
    ArrayList<String> items = new ArrayList<>();
    private HashMap<String, String> items_map = new HashMap<>();
  //  private ArrayList<EditText> edits = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initdata();
    }
    private void initdata() {
        items.add("颈围");
        items.add("身高");
        items.add("肩宽");
        items.add("腰围");
//        edits.add(et_itemdata1);
//        edits.add(et_itemdata2);
//        edits.add(et_itemdata3);
//        edits.add(et_itemdata4);
        tv_itemname1.setText("颈围");
        tv_itemname2.setText("身高");
        tv_itemname3.setText("肩宽");
        tv_itemname4.setText("腰围");
    }

    private void initview() {
        tv_itemname1 = (TextView) findViewById(R.id.tv_itemname1);
        tv_itemname2 = (TextView) findViewById(R.id.tv_itemname2);
        tv_itemname3 = (TextView) findViewById(R.id.tv_itemname3);
        tv_itemname4 = (TextView) findViewById(R.id.tv_itemname4);
        et_itemdata1 = (EditText) findViewById(R.id.et_itemdata1);
        et_itemdata2 = (EditText) findViewById(R.id.et_itemdata2);
        et_itemdata3 = (EditText) findViewById(R.id.et_itemdata3);
        et_itemdata4 = (EditText) findViewById(R.id.et_itemdata4);
        tv_pinlei = (TextView) findViewById(R.id.tv_pinlei);
        tv_pinlei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, MeasureActivity.class);
                intent.putStringArrayListExtra("measureitem",items);
                startActivityForResult(intent,1);
            }
        });

    }

    @Override
    public  void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1){
            items_map = (HashMap<String, String>) data.getSerializableExtra("data");
            for(Map.Entry<String,String> entry : items_map.entrySet()){
                if (entry.getKey().equals(tv_itemname1.getText())){
                    et_itemdata1.setText(entry.getValue());
                }else  if (entry.getKey().equals(tv_itemname2.getText())){
                    et_itemdata2.setText(entry.getValue());
                }else  if (entry.getKey().equals(tv_itemname3.getText())){
                    et_itemdata3.setText(entry.getValue());
                }else  if (entry.getKey().equals(tv_itemname4.getText())){
                    et_itemdata4.setText(entry.getValue());
                }
            }
        }
    }
}
