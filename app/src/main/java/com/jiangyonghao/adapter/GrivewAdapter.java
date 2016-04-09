package com.jiangyonghao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiangyonghao.recycleview.recycleview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangyonghao on 2016/1/15.
 */
public class GrivewAdapter extends RecyclerView.Adapter<GrivewAdapter.viewholder> {
    private Context context;
    private List<String> list;
    private LayoutInflater inflater;
    private List<Integer> data;
    public GrivewAdapter(Context context, List<String> list) {
        super();
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
        data = new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            data.add((int)(100+Math.random()*300));
        }
    }

    @Override
    public int getItemCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public void onBindViewHolder(GrivewAdapter.viewholder holder, int postion) {
        // TODO Auto-generated method stub

        ViewGroup.LayoutParams layout = holder.itemView.getLayoutParams();
        layout.height=data.get(postion);
        holder.itemView.setLayoutParams(layout);

        holder.text.setText(list.get(postion));
    }

    @Override
    public GrivewAdapter.viewholder onCreateViewHolder(ViewGroup arg0, int arg1) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.recycle_item, arg0, false);
        viewholder viewholder = new viewholder(view);

        return viewholder;
    }
    class viewholder extends RecyclerView.ViewHolder {
        TextView text;

        public viewholder(View itemView) {
            super(itemView);
            // TODO Auto-generated constructor stub
            text = (TextView) itemView.findViewById(R.id.recycle_text);
        }
}
}
