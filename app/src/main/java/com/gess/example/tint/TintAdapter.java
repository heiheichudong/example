package com.gess.example.tint;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gess.example.R;
import com.luck.picture.lib.widget.SquareRelativeLayout;

import java.util.ArrayList;

public class TintAdapter extends RecyclerView.Adapter<TintAdapter.TintViewHolder> {

    private Context context;
    private ArrayList<String> strings;

    public TintAdapter(Context context, ArrayList<String> strings) {
        this.context = context;
        this.strings = strings;
    }

    @NonNull
    @Override
    public TintViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tint,null);
        return new TintViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TintViewHolder holder, int position) {
        holder.textView.setText(strings.get(position));
        Drawable drawable = context.getResources().getDrawable(R.drawable.tangram);
        drawable.setTint(Color.BLACK);
        switch (strings.get(position)){
            case "CLEAR":
                drawable.setTintMode(PorterDuff.Mode.CLEAR);
                break;
            case "SRC":
                drawable.setTintMode(PorterDuff.Mode.SRC);
                break;
            case "DST":
                drawable.setTintMode(PorterDuff.Mode.DST);
                break;
            case "SRC_OVER":
                drawable.setTintMode(PorterDuff.Mode.SRC_OVER);
                break;
            case "DST_OVER":
                drawable.setTintMode(PorterDuff.Mode.DST_OVER);
                break;
            case "SRC_IN":
                drawable.setTintMode(PorterDuff.Mode.SRC_IN);
                break;
            case "DST_IN":
                drawable.setTintMode(PorterDuff.Mode.DST_IN);
                break;
            case "SRC_OUT":
                drawable.setTintMode(PorterDuff.Mode.SRC_OUT);
                break;
            case "DST_OUT":
                drawable.setTintMode(PorterDuff.Mode.DST_OUT);
                break;
            case "SRC_ATOP":
                drawable.setTintMode(PorterDuff.Mode.SRC_ATOP);
                break;
            case "DST_ATOP":
                drawable.setTintMode(PorterDuff.Mode.DST_ATOP);
                break;
            case "XOR":
                drawable.setTintMode(PorterDuff.Mode.XOR);
                break;
            case "DARKEN":
                drawable.setTintMode(PorterDuff.Mode.DARKEN);
                break;
            case "LIGHTEN":
                drawable.setTintMode(PorterDuff.Mode.LIGHTEN);
                break;
            case "MULTIPLY":
                drawable.setTintMode(PorterDuff.Mode.MULTIPLY);
                break;
            case "SCREEN":
                drawable.setTintMode(PorterDuff.Mode.SCREEN);
                break;
            case "ADD":
                drawable.setTintMode(PorterDuff.Mode.ADD);
                break;
            case "OVERLAY":
                drawable.setTintMode(PorterDuff.Mode.OVERLAY);
                break;
        }
        holder.squareRelativeLayout.setBackground(drawable);
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    class TintViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        SquareRelativeLayout squareRelativeLayout;
        public TintViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_tint);
            squareRelativeLayout = itemView.findViewById(R.id.srl_tint);
        }
    }
}
