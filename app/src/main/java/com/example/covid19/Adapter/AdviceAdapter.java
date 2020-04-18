package com.example.covid19.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid19.Model.Advice;
import com.example.covid19.R;

import java.util.List;

public class AdviceAdapter extends RecyclerView.Adapter<AdviceAdapter.AdviceViewHolder> {

    Context context;
    List<Advice> adviceList;


    public AdviceAdapter(Context context, List<Advice> adviceList) {
        this.context = context;
        this.adviceList = adviceList;
    }


    @NonNull
    @Override
    public AdviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.advice, parent, false);
        return new AdviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdviceViewHolder holder, int position) {

        holder.img.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_transition_animation));
        holder.container.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_scale_animation));

        holder.title.setText(adviceList.get(position).getTitle());
        holder.content.setText(adviceList.get(position).getContent());
        holder.img.setImageResource(adviceList.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return adviceList.size();
    }

    public class AdviceViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView title, content;
        RelativeLayout container;

        public AdviceViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.tv_title);
            content = itemView.findViewById(R.id.tv_description);
            container = itemView.findViewById(R.id.container);

        }
    }
}
