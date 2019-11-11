package com.gess.example.statusBar;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.gess.example.R;
import com.gess.example.pic.ImageViewActivity;
import com.gess.example.pic.PictureActivity;
import com.gess.note.BaseActivity;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class StatusActivity extends BaseActivity {

    private RadioButton radioButton;
    private int etc = 0;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        radioButton = findViewById(R.id.rb_test);
        Drawable drawable = getResources().getDrawable(R.drawable.draw_select);
        drawable.setBounds(0, 0, SizeUtils.dp2px(24), SizeUtils.dp2px(24));
        radioButton.setCompoundDrawables(null, drawable, null, null);
    }

    public void button(View v) {
        switch (v.getId()) {
            case R.id.btn_sb_color:
                startActivity(new Intent(this, ColorActivity.class));
                break;
            case R.id.btn_sb_list:
                startActivity(new Intent(this, MatchActionBarActivity.class));
                break;
            case R.id.btn_sb_match:
//                double[] d = {/*0,0.1,0.11,*/1, 12, 123, 1234, 12345, 123456, 1234567, 12345678, 123456789, 1234567890};
//                isInput(d);
                startActivity(new Intent(this, SamplesListActivity.class));
//                if (etc == 0) {
//                    m();
//                } else {
//                    j();
//                }
                break;
            case R.id.btn_pic:
                startActivity(new Intent(this, PictureActivity.class));
                break;
            case R.id.btn_image:
                startActivity(new Intent(this, ImageViewActivity.class));
                break;
        }
    }

    private void isInput(double... d) {
        NumberFormat formatter = new DecimalFormat("####.#");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < d.length; i++) {
            sb.append(formatter.format(d[i]) + " = " + StrictMath.log10(d[i]));
            sb.append("\n");
            sb.append(formatValue(d[i]));
            sb.append("\n");
            System.out.println(formatter.format(d[i]) + " = " + StrictMath.log10(d[i]));
            System.out.println(formatValue(d[i]));
        }
        ((TextView) findViewById(R.id.tv_f)).setText(sb);
    }

    public static String formatValue(double value) {
        if (value == 0) {
            return "0";
        }
        int power;
        String[] suffix = {"", "万", "亿"};
        String formattedNumber = "";

        NumberFormat formatter = new DecimalFormat("####.#");
        power = (int) StrictMath.log10(value);
        value = value / (Math.pow(10, (power / 4) * 4));
        formattedNumber = formatter.format(value);
        formattedNumber = formattedNumber + suffix[power / 4];
        return formattedNumber.length() > 4 ? formattedNumber.replaceAll("\\.[0-9]+", "") : formattedNumber;
    }

    private void m() {
        try {
            etc = 1;
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource("/storage/emulated/0/看天下/1.m4a");
            mediaPlayer.prepare();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    LogUtils.d("dasdsadasdasdasdasdasdasdadsasdasdasdassda");
                    return false;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void j(){
        etc = 0;
        try {

        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
        mediaPlayer.reset();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
