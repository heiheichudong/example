package com.gess.example.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListViewModel extends ViewModel {
    private MutableLiveData<List<TestBean>> users;
    public LiveData<List<TestBean>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<>();
        }
        return users;
    }

    public void loadUsers(boolean isEmpty) {
        ArrayList<TestBean> list = new ArrayList();
        if (!isEmpty){
            for (int i = 0; i < 25; i++) {
                TestBean tb = new TestBean(i+"","第"+i+"项","第"+i+"项 内容");
                list.add(tb);
            }
        }
        users.setValue(list);
    }
}
