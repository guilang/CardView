package com.jiangyonghao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiangyonghao.recycleview.recycleview.R;

import java.util.List;

/**
 * Created by jiangyonghao on 2016/1/14.
 */
public class Baseadapter extends RecyclerView.Adapter<viewholder> {
    private Context context;
    private List<String> list;
    private LayoutInflater inflater;
    public interface  OnItemClickLister{
        void OnItemClick(View view,int pos);
        void OnItemLong(View view,int pos);
    }
    private OnItemClickLister clickLister;
    public void setOnItemClickLister(OnItemClickLister clickLister){
        this.clickLister = clickLister;
    }

    public Baseadapter(Context context, List<String> list) {
        super();
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public void onBindViewHolder(final viewholder holder, final int postion) {
        // TODO Auto-generated method stub
        holder.text.setText(list.get(postion));
        if (clickLister!=null){

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getLayoutPosition();
                        clickLister.OnItemClick(holder.itemView,pos);

            }
        });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    clickLister.OnItemLong(holder.itemView,pos);
                    return true;
                }
            });
        }
    }

    @Override
    public viewholder onCreateViewHolder(ViewGroup arg0, int arg1) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.recycle_item, arg0, false);
        viewholder viewholder = new viewholder(view);

        return viewholder;
    }
    public void adddata(int pos){
        list.add(pos,"插入一个");
        notifyItemInserted(pos);
    }
    public void deletedata(int pos){
        list.remove(pos);
        notifyItemRemoved(pos);
    }
}

class viewholder extends RecyclerView.ViewHolder {
    TextView text;

    public viewholder(View itemView) {
        super(itemView);
        // TODO Auto-generated constructor stub
        text = (TextView) itemView.findViewById(R.id.recycle_text);
    }


}
