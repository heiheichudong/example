package com.gess.appkotlin.example.tab;

import android.content.Context;
import android.util.AttributeSet;

import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TabUtilityLayoutJava extends TabLayout {

    public TabUtilityLayoutJava(Context context) {
        this(context,null);
    }

    public TabUtilityLayoutJava(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TabUtilityLayoutJava(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void tab(){
        try {
            Field field =this.getClass().getDeclaredField("slidingTabIndicator");
            field.setAccessible(true);
            Field field1 = field.getClass().getDeclaredField("defaultSelectionIndicator");
            field1.setAccessible(true);
            Method method = field.getClass().getMethod("setSize");
            method.invoke("","");
        } catch (/*NoSuchField*/Exception e) {
            e.printStackTrace();
        }
    }
}
