package br.com.radar.helper;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.radar.model.Post;
import br.com.radar.radar.R;

public class PostHelper {

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


    public PostHelper(final View view) {

        profilePic = (ImageView) view.findViewById(R.id.profilePic);
        name = (TextView) view.findViewById(R.id.name);
        timestamp = (TextView) view.findViewById(R.id.timestamp);
        txtStatusMsg = (TextView) view.findViewById(R.id.txtStatusMsg);
        txtUrl = (TextView) view.findViewById(R.id.txtUrl);
        feedImage1 = (ImageView) view.findViewById(R.id.feedImage1);
        participar  = (TextView) view.findViewById(R.id.participar);
        adicionar = (TextView) view.findViewById(R.id.adicionar);
        messagem = (TextView) view.findViewById(R.id.messagem);
        favorito = (TextView) view.findViewById(R.id.favorito);
        participarCounter = (TextView) view.findViewById(R.id.participar_counter);
        messagemCounter = (TextView) view.findViewById(R.id.messagem_counter);
        favoritoCounter = (TextView) view.findViewById(R.id.favorito_counter);

    }

    public Post getPostByView(){
        return null;
    }

}
