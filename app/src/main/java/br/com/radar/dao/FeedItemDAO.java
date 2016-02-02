package br.com.radar.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.radar.model.FeedItem;

public class FeedItemDAO {

    public  List<FeedItem> getItemList(){

        List<FeedItem> itemList = new ArrayList<>();
        FeedItem item0 = new FeedItem(1, "e900" ,null, "Eu vou pra o sfrega, quem quiser saber mais clica aqui. ingresso em promoção.", null, "Agora mesmo", "playstore.com.br/radarsocial");
        FeedItem item1 = new FeedItem(2, "Alexandre" ,null, "O radar esta Online", null, "poucos instantes", "www.radar.com.br");
        FeedItem item2 = new FeedItem(3, "Alexandre" ,null, "tem um monte de coisa aqui, veem tambem!", null, "Um hora atras", "www.radar.com.br");
        FeedItem item3 = new FeedItem(4, "Alexandre" ,null, "O que estará acontecendo de bom hoje?", null, "Varias Horas atras", "www.radar.com.br");
        FeedItem item4 = new FeedItem(5, "Alexandre" ,null, "Vamos explorar essa cidade!", null, "Ontem", "www.radar.com.br");
        FeedItem item5 = new FeedItem(6, "Alexandre" ,null, "Diga aos seus amigos as melhores coisa pra fazer", null, "Semana passada", "www.radar.com.br");
        FeedItem item6 = new FeedItem(7, "Alexandre" ,null, "Venha postar uma foto!", null, "Semana passada", "www.radar.com.br");
        FeedItem item7 = new FeedItem(8, "Alexandre" ,null, "Vamos lá, aproveite", null, "Semana passada", "www.radar.com.br");
        FeedItem item8 = new FeedItem(9, "Alexandre" ,null, "Um aplicativo super bacana esta no ar", null, "05/01/2016", "www.radar.com.br");
        FeedItem item9 = new FeedItem(10, "Alexandre",null, "Aberta a temporada de Download!", null, "01/01/2016", "www.radar.com.br");

        itemList.add(item0);
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);
        itemList.add(item7);
        itemList.add(item8);
        itemList.add(item9);

        return itemList;
    }


}
