package br.com.radar.activity.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import br.com.radar.radar.R;

/**
 * Created by Alexandre on 31/01/2016.
 */
public class DetalheItem extends AppCompatActivity {

    private ImageView fotoItemDetalhe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f1_aba_eventos_item_detalhe);

        if (savedInstanceState.getString("ENDERECO_IMAGEM") != null) {

            Toast.makeText(this,savedInstanceState.getString("ENDERECO_IMAGEM"), Toast.LENGTH_SHORT ).show();
            /*
            fotoItemDetalhe = (ImageView) findViewById(R.id.foto_detalhe);
            fotoItemDetalhe.setImageBitmap(BitmapFactory.decodeFile(savedInstanceState.getString("ENDERECO_IMAGEM")));
             */
        }
    }
}
