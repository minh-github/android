package com.example.listviewcustom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<MonHoc> data;

    public MyAdapter(Context context, ArrayList<MonHoc> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.customitem,viewGroup,false);

        ImageView imgItem = view.findViewById(R.id.anhMonHoc);
        TextView monHocItem = view.findViewById(R.id.monHocItem);
        TextView tinChiItem = view.findViewById(R.id.tinChiItem);

        imgItem.setImageResource(data.get(i).getIdAnh());
        monHocItem.setText(data.get(i).getTenMonHoc());
        tinChiItem.setText(data.get(i).getTheLoai());

        return view;
    }
}
