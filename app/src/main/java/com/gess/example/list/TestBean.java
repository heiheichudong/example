package com.gess.example.list;

import android.os.Parcel;
import android.os.Parcelable;

public class TestBean implements Parcelable {
    private String id;
    private String name;
    private String content;

    public TestBean(String id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    protected TestBean(Parcel in) {
        id = in.readString();
        name = in.readString();
        content = in.readString();
    }

    public static final Creator<TestBean> CREATOR = new Creator<TestBean>() {
        @Override
        public TestBean createFromParcel(Parcel in) {
            return new TestBean(in);
        }

        @Override
        public TestBean[] newArray(int size) {
            return new TestBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(content);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
