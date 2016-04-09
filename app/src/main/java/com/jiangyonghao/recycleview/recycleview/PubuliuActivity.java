package com.jiangyonghao.recycleview.recycleview;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import com.jiangyonghao.adapter.Baseadapter;
import com.jiangyonghao.adapter.GrivewAdapter;

import java.util.ArrayList;
import java.util.List;

public class PubuliuActivity extends AppCompatActivity {
    private RecyclerView recycleview;
    private List<String> list;
    private GrivewAdapter adapter;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intdata();
        inview();

        recycleview.setAdapter(adapter);
        //设置布局管理
//        LinearLayoutManager layout = new LinearLayoutManager(this,
//                LinearLayoutManager.VERTICAL, false);

        recycleview.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        //设置分割线
//		recycleview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }

    private void inview() {
        // TODO Auto-generated method stub
        recycleview = (RecyclerView) findViewById(R.id.recycleview_list);
        btn = (Button) findViewById(R.id.btn);
        final String [] txt = {"listview","gridview","横着gridview","瀑布流","删除","增加"};
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v7.app.AlertDialog.Builder bulider = new android.support.v7.app.AlertDialog.Builder(PubuliuActivity.this);
                bulider.setSingleChoiceItems(txt,0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                            recycleview.setLayoutManager(new LinearLayoutManager(PubuliuActivity.this));
                                break;
                            case 1:
                                recycleview.setLayoutManager(new GridLayoutManager(PubuliuActivity.this,3));
                                break;
                            case 2:
                                recycleview.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL));
                                break;
                            case 3:
                                Intent intent = new Intent(PubuliuActivity.this,MainActivity.class);
                                startActivity(intent);
                                break;
                            case 4:

                                break;
                            case 5:
                                break;
                        }
                    }
                }).create().show();

            }
        });
    }

    private void intdata() {
        // TODO Auto-generated method stub
        list = new ArrayList<String>();
        for (int i = 0; i <100; i++) {
            list.add("" + i);
        }
        adapter = new GrivewAdapter(this, list);
    }


}
