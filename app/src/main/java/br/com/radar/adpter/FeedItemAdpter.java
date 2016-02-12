package br.com.radar.adpter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.radar.helper.PostHelper;
import br.com.radar.model.FeedItem;
import br.com.radar.model.Post;
import br.com.radar.radar.R;
import br.com.radar.util.Typefaces;

public class FeedItemAdpter extends RecyclerView.Adapter<FeedItemAdpter.MyViewHolder> {

    private List<Post> feedItemListList;
    private Context context;

    private int VERMELHO;
    private int CINZA;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        PostHelper post;

        public MyViewHolder(final View view) {
            super(view);


        }
    }

    public FeedItemAdpter(List<Post> feedItemListList) {
        this.feedItemListList = feedItemListList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        context = parent.getContext();
        VERMELHO = context.getResources().getColor(R.color.vermelho);
        CINZA = context.getResources().getColor(R.color.black);

        final View itemView = LayoutInflater.from(context).inflate(R.layout.f1_aba_eventos_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FeedItem feedItem = feedItemListList.get(position);
        holder.name.setText(feedItem.getName());
        holder.timestamp.setText(feedItem.getTimeStamp());
        holder.txtStatusMsg.setText(feedItem.getStatus());
        SpannableString content = new SpannableString(feedItem.getUrl());
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        holder.txtUrl.setText(content);

        if(feedItem.getId()==1){
            holder.feedImage1.setImageResource(R.drawable.ic_ico_sfrega);
        }

        if(feedItem.getProfilePic()!=null){
             holder.profilePic.setImageBitmap(BitmapFactory.decodeFile(feedItem.getProfilePic()));
        }else{
            holder.profilePic.setImageResource(R.drawable.ic_foto_perfil);
        }
    }

    @Override
    public int getItemCount() {
        return feedItemListList.size();
    }

}
