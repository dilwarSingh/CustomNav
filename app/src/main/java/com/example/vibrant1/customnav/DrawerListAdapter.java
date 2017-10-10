package com.example.vibrant1.customnav;

/**
 * Created by Vibrant1 on 09-Oct-17.
 */

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by ramees on 8/16/2016.
 */
public class DrawerListAdapter extends BaseAdapter {
    Activity activity;
    int[] imageId;
    private static LayoutInflater inflater = null;
    ArrayList<String> titles;
    private int lineAfter;
    int[] nos;

    public DrawerListAdapter(Activity activity, ArrayList<String> titles, int[] icons, int lineAfter, int[] nos) {
// TODO Auto-generated constructor stub
        this.titles = titles;
        this.activity = activity;
        this.imageId = icons;
        this.lineAfter = lineAfter;
        this.nos = nos;

        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
// TODO Auto-generated method stub
        return titles.size();
    }

    @Override
    public Object getItem(int position) {
// TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
// TODO Auto-generated method stub
        return position;
    }

    public class Holder {
        CardView notfView;
        TextView notfNo;
        TextView tv_title;
        ImageView im_icon;
        ImageView line;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
// TODO Auto-generated method stub
        Holder holder = new Holder();
        View view;
        view = inflater.inflate(R.layout.layout_drawer_item, null);

        holder.tv_title = (TextView) view.findViewById(R.id.tv_title);
        holder.notfNo = (TextView) view.findViewById(R.id.notificationNo);

        holder.im_icon = (ImageView) view.findViewById(R.id.im_icon);
        holder.line = (ImageView) view.findViewById(R.id.imageView5);

        holder.notfView = (CardView) view.findViewById(R.id.notificationView);

        holder.tv_title.setText(titles.get(position));
        Picasso.with(activity.getApplicationContext()).load(imageId[position]).into(holder.im_icon);

        if (position == lineAfter) {
            holder.line.setVisibility(View.VISIBLE);
        } else {
            holder.line.setVisibility(View.GONE);
        }

        if (nos[position] > 0) {
            holder.notfNo.setText(nos[position]+"");
        } else {
            holder.notfView.setVisibility(View.GONE);
        }


        return view;
    }

}