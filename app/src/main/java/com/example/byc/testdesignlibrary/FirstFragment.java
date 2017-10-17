package com.example.byc.testdesignlibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by byc on 2017/10/15.
 */

public class FirstFragment extends Fragment {

    private String strTV;//简化的版本，viewpager里的fragment是一样的界面，为了区分，通过setArguments传入一个字符串并显示到TextView中
    private TextView tv;
    private RecyclerView rv;
    private View view;
    private List<String> listDatas;
    private final static String[] fragmentText = new String[]{
            "RecyclerView_LinearLayoutManager", "RecyclerView_GridLayoutManager", "RecyclerView_StaggeredGridLayoutManager"
    };
    private int m_index;//此程序是一个简单版，所以三个recyclerview都在这个里面显示，这个参数表示fragmentText代表的不同布局的RecyclerView

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.firstfragment_layout, container, false);
        initView();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        switch (m_index){
            case 0:
                rv.setLayoutManager(new LinearLayoutManager(getContext()));
                //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
                rv.setHasFixedSize(true);
                break;
            case 1:
                rv.setLayoutManager(new GridLayoutManager(getContext(),4));
                break;
            case 2:
                rv.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL));
                break;
            default:
                break;
        }

        FirstFragmentAdapter fragmentAdapter = new FirstFragmentAdapter();
        fragmentAdapter.setListData(listDatas, this.getContext());
        rv.setAdapter(fragmentAdapter);
    }

    private void initView() {
        tv = (TextView) view.findViewById(R.id.tv);
        Bundle bundle = getArguments();
        m_index = bundle.getInt("index");
        tv.setText(fragmentText[m_index]);
        rv = (RecyclerView) view.findViewById(R.id.rv);
    }

    private void initData() {
        listDatas = new ArrayList<>();
        for (int i = 'A'; i <= 'z'; i++) {
            listDatas.add("  " + (char) i);
        }
    }
}
