package com.gess.example.douyin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.gess.example.R;
import com.gess.note.BaseActivity;

public class DouyinActivity extends BaseActivity {

    private Intent action;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_douyin);
    }

    public void douyin(View view){
        switch (view.getId()){
            case R.id.btn_dy_video:
                action = new Intent(Intent.ACTION_VIEW, Uri.parse("snssdk1128://aweme/detail/6682662824545684743?refer=web&gd_label=click_wap_download_banner&appParam=&needlaunchlog=1"));
                action.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(action);
                break;
            case R.id.btn_dy_profile:
                action = new Intent(Intent.ACTION_VIEW, Uri.parse("snssdk1128://user/profile/100388621525?refer=web&gd_label=click_wap_download_follow&type=need_follow&needlaunchlog=1"));
//                action = new Intent(Intent.ACTION_VIEW, Uri.parse("snssdk1128://user/profile/100388621528?refer=web&gd_label=click_wap_download_follow&type=need_follow&needlaunchlog=1"));
                action.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(action);
                break;
        }
    }
}
