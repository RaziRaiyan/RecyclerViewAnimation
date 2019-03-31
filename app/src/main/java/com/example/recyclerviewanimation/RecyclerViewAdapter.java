package com.example.recyclerviewanimation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.SimpleDateFormat;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Message> mMessageList;
    private boolean isDark;

    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public RecyclerViewAdapter(Context context, List<Message> messageList, boolean isDark) {
        mContext = context;
        mMessageList = messageList;
        this.isDark = isDark;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rv_row,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.iv_item.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_animation));
        myViewHolder.container.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_scale_animation));
        myViewHolder.tv_title.setText(mMessageList.get(position).getTitle());
        myViewHolder.tv_date.setText(formatter.format(mMessageList.get(position).getDate()));
        myViewHolder.tv_description.setText(mMessageList.get(position).getDescripton());
        Glide.with(mContext)
                .load(mMessageList.get(position).getPhotoUrl())
                .centerCrop()
                .apply(RequestOptions.circleCropTransform())
                .into(myViewHolder.iv_item);
    }


    @Override
    public int getItemCount() {
        return mMessageList==null?0:mMessageList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title;
        TextView tv_description;
        TextView tv_date;
        ImageView iv_item;
        RelativeLayout container;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_description = itemView.findViewById(R.id.tv_description);
            iv_item = itemView.findViewById(R.id.iv_item);
            container = itemView.findViewById(R.id.item_container);

            if(isDark){
                setDarkTheme();
            }
        }

        void setDarkTheme(){
            container.setBackgroundResource(R.drawable.card_bg_dark);
        }
    }
}
