package br.com.radar.adpter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
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
import br.com.radar.util.Typefaces;

public class FeedItemAdpter extends RecyclerView.Adapter<FeedItemAdpter.MyViewHolder> {

    private List<FeedItem> feedItemListList;
    private Context context;

    private int VERMELHO;
    private int CINZA;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView participar;
        public TextView participarCounter;
        public TextView adicionar;
        public TextView messagem;
        public TextView messagemCounter;
        public TextView favorito;
        public TextView favoritoCounter;

        public ImageView profilePic;
        public TextView name;
        public TextView timestamp;
        public TextView txtStatusMsg;
        public TextView txtUrl;
        public ImageView feedImage1;

        public MyViewHolder(final View view) {
            super(view);

            //campos
            profilePic = (ImageView) view.findViewById(R.id.profilePic);
            name = (TextView) view.findViewById(R.id.name);
            timestamp = (TextView) view.findViewById(R.id.timestamp);
            txtStatusMsg = (TextView) view.findViewById(R.id.txtStatusMsg);
            txtUrl = (TextView) view.findViewById(R.id.txtUrl);
            feedImage1 = (ImageView) view.findViewById(R.id.feedImage1);



            //icones
            participar  = (TextView) view.findViewById(R.id.participar);
            participar.setTypeface(Typefaces.get(context, "icon.ttf"));

            adicionar = (TextView) view.findViewById(R.id.adicionar);
            adicionar.setTypeface(Typefaces.get(context, "icon.ttf"));

            messagem = (TextView) view.findViewById(R.id.messagem);
            messagem.setTypeface(Typefaces.get(context, "icon.ttf"));

            favorito = (TextView) view.findViewById(R.id.favorito);
            favorito.setTypeface(Typefaces.get(context, "icon.ttf"));

            favorito.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(favorito.getCurrentTextColor()== VERMELHO){
                        favorito.setTextColor(CINZA);
                    }else{
                        favorito.setTextColor(VERMELHO);
                    }
                }
            });

            participarCounter = (TextView) view.findViewById(R.id.participar_counter);
            messagemCounter = (TextView) view.findViewById(R.id.messagem_counter);
            favoritoCounter = (TextView) view.findViewById(R.id.favorito_counter);

        }
    }

    public FeedItemAdpter(List<FeedItem> feedItemListList) {
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
