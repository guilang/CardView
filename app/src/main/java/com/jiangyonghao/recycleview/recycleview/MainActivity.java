package com.jiangyonghao.recycleview.recycleview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jiangyonghao.adapter.Baseadapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycleview;
    private List<String> list;
    private Baseadapter adapter;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intdata();
        inview();

        recycleview.setAdapter(adapter);
        //设置布局管理
        LinearLayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recycleview.setLayoutManager(layout);
        //设置分割线
//		recycleview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }

    private void inview() {
        // TODO Auto-generated method stub
        recycleview = (RecyclerView) findViewById(R.id.recycleview_list);
        recycleview.setItemAnimator(new DefaultItemAnimator());
        btn = (Button) findViewById(R.id.btn);
        final String [] txt = {"listview","gridview","横着gridview","瀑布流","删除","增加"};
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v7.app.AlertDialog.Builder bulider = new android.support.v7.app.AlertDialog.Builder(MainActivity.this);
                bulider.setSingleChoiceItems(txt, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                recycleview.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                                break;
                            case 1:
                                recycleview.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
                                break;
                            case 2:
                                recycleview.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.HORIZONTAL));
                                break;
                            case 3:
                                Intent intent = new Intent(MainActivity.this, PubuliuActivity.class);
                                startActivity(intent);
                                break;
                            case 4:
                                adapter.deletedata(2);
                                break;
                            case 5:
                                adapter.adddata(2);
                                break;
                        }
                    }
                }).create().show();

            }
        });
        adapter.setOnItemClickLister(new Baseadapter.OnItemClickLister() {
            @Override
            public void OnItemClick(View view, int pos) {

                Toast.makeText(MainActivity.this,pos+"click",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnItemLong(View view, int pos) {
                Toast.makeText(MainActivity.this,pos+"long",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void intdata() {
        // TODO Auto-generated method stub
        list = new ArrayList<String>();
        for (int i = 0; i <100; i++) {
            list.add("" + i);
        }
        adapter = new Baseadapter(this, list);
    }


}
