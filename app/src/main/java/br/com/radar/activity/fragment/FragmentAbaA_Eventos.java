package br.com.radar.activity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.radar.adpter.FeedItemAdpter;
import br.com.radar.dao.FeedItemDAO;
import br.com.radar.intefaces.EndlessRecyclerOnScrollListener;
import br.com.radar.model.FeedItem;
import br.com.radar.model.Post;
import br.com.radar.radar.R;

import static android.support.v7.widget.RecyclerView.*;

public class FragmentAbaA_Eventos extends Fragment {

    private int contadorPaginas;

    private View myView;
    private RecyclerView recyclerView;
    private FeedItemAdpter mAdapter;
    private List<FeedItem> feedItemList = new ArrayList<>();

    private TextView participar;
    private TextView participarCounter;
    private TextView adicionar;
    private TextView messagem;
    private TextView messagemCounter;
    private TextView favorito;
    private TextView favoritoCounter;

    public FragmentAbaA_Eventos() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView  =  inflater.inflate(R.layout.f1_aba_eventos, container, false);
        contadorPaginas = 0;
        setupRecyclerView();
        setupIcones();
        return myView;
    }

    private void setupIcones(){

        participar = (TextView) myView.findViewById(R.id.participar);
        participarCounter = (TextView) myView.findViewById(R.id.participar_counter);
        adicionar = (TextView) myView.findViewById(R.id.adicionar);
        messagem = (TextView) myView.findViewById(R.id.messagem);
        messagemCounter = (TextView) myView.findViewById(R.id.messagem_counter);
        favorito = (TextView) myView.findViewById(R.id.favorito);
        favoritoCounter = (TextView) myView.findViewById(R.id.favorito_counter);
    }


    private void setupRecyclerView(){

        recyclerView = (RecyclerView) myView.findViewById(R.id.recycler_view);
        mAdapter = new FeedItemAdpter(feedItemList);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        feedItemList.addAll(new FeedItemDAO().getItemList());
        mAdapter.notifyDataSetChanged();


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        recyclerView.setOnScrollListener(new EndlessRecyclerOnScrollListener(mLayoutManager) {
            @Override
            public void onLoadMore(int current_page) {
               Toast.makeText(getActivity(), "Espere um momento", Toast.LENGTH_SHORT).show();
                feedItemList.addAll(new FeedItemDAO().getItemList());
               mAdapter.notifyDataSetChanged();
            }
        });

        recyclerView.setAdapter(mAdapter);
        feedItemList.addAll(new FeedItemDAO().getItemList());
        mAdapter.notifyDataSetChanged();
    }

    public interface ClickListener {
        void onClick(View view, int position);
        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements OnItemTouchListener {

        private GestureDetector gestureDetector;
        private FragmentAbaA_Eventos.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final FragmentAbaA_Eventos.ClickListener clickListener) {
            this.clickListener = clickListener;

            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}