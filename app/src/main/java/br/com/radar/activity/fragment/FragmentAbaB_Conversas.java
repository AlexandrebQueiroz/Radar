package br.com.radar.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.radar.radar.R;

public class FragmentAbaB_Conversas extends Fragment {

    public FragmentAbaB_Conversas() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,     Bundle savedInstanceState) {
        return inflater.inflate(R.layout.f1_aba_eventos, container, false);
    }

}
