package com.gess.example.fragment;


import com.gess.example.R;

import java.util.Stack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * Media栈
 *
 * @author zl
 * @date 2017/8/14
 */

public class FragmentContainerStack  {
    private static Stack<Fragment> stack;
    private static FragmentContainerStack instance;
    private AppCompatActivity activity;

    public static Stack<Fragment> getStack() {
        return stack;
    }

    private FragmentContainerStack() {
    }

    public static FragmentContainerStack getInstance() {
        if (instance == null) {
            synchronized (FragmentContainerStack.class) {
                if (instance == null) {
                    instance = new FragmentContainerStack();
                    instance.stack = new Stack<>();
                }
            }
        }
        return instance;
    }

    /**
     * 添加fragment
     *
     * @param fragment
     */
    public void addFragment(AppCompatActivity activity, Fragment fragment) {
        if (this.activity != activity){
            this.activity = activity;
        }
        if (this.activity == null){
            this.activity = activity;
        }
        FragmentManager manager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (stack.size() > 0) {
            stack.lastElement().onPause();
            transaction.hide(stack.lastElement());
        }
        transaction.add(R.id.fl_container, fragment);
        transaction.commit();
        stack.push(fragment);
        stack.lastElement().onResume();
    }

    /**
     * 替换fragment
     *
     * @param fragment
     */
    public void replaceFragment(AppCompatActivity activity, Fragment fragment, boolean isback) {
        FragmentManager manager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.show(fragment);
        transaction.commit();
        if (!isback) {
            stack.lastElement().onPause();
            stack.push(fragment);
        }
        stack.lastElement().onResume();
    }

    public boolean removeFragment(AppCompatActivity activity) {
        if (stack.isEmpty()) {
            return true;
        }
        Fragment fragment = stack.lastElement();
        fragment.onDestroyView();
        hideFragment(fragment);
        stack.remove(fragment);
        fragment = null;
        if (stack.isEmpty()) {
            return true;
        } else {
            Fragment fragment1 = stack.lastElement();
            replaceFragment(activity, fragment1, true);
            return false;
        }
    }


    /**
     * 隐藏
     */
    private void hideFragment(Fragment fragment){
        FragmentManager manager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }

    public Fragment getCurrentFragment(){
        if (!stack.empty()){
            return stack.peek();
        }else {
            return null;
        }

    }
}
