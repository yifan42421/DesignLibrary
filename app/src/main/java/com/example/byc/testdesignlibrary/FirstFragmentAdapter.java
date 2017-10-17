package com.example.byc.testdesignlibrary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by byc on 2017/10/16.
 */

public class FirstFragmentAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<String> listData;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item,parent,false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder)holder).tv.setText(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public void setListData(List<String> datas,Context context){
        this.listData = datas;
        this.context = context;
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView)itemView.findViewById(R.id.item_tv);
        }
    }
}
