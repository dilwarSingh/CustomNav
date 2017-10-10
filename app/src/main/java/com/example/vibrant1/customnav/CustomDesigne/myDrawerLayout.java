package com.example.vibrant1.customnav.CustomDesigne;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;

/**
 * Created by Vibrant1 on 09-Oct-17.
 */

public class myDrawerLayout extends DrawerLayout {

    public myDrawerLayout(Context context) {
        super(context);
    }

    public myDrawerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public myDrawerLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(
                MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.EXACTLY);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(
                MeasureSpec.getSize(heightMeasureSpec), MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}