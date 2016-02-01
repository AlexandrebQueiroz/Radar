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

import br.com.radar.model.FeedItem;
import br.com.radar.radar.R;

/**
 * Created by Alexandre on 31/01/2016.
 */
public class FeedItemAdpter extends RecyclerView.Adapter<FeedItemAdpter.MyViewHolder> {

    private List<FeedItem> feedItemListList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView profilePic;
        public TextView name;
        public TextView timestamp;
        public TextView txtStatusMsg;
        public TextView txtUrl;
        public ImageView feedImage1;

        public MyViewHolder(final View view) {
            super(view);
            profilePic = (ImageView) view.findViewById(R.id.profilePic);
            name = (TextView) view.findViewById(R.id.name);
            timestamp = (TextView) view.findViewById(R.id.timestamp);
            txtStatusMsg = (TextView) view.findViewById(R.id.txtStatusMsg);
            txtUrl = (TextView) view.findViewById(R.id.txtUrl);
            feedImage1 = (ImageView) view.findViewById(R.id.feedImage1);
        }
    }

    public FeedItemAdpter(List<FeedItem> feedItemListList) {
        this.feedItemListList = feedItemListList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final Context context = parent.getContext();
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
