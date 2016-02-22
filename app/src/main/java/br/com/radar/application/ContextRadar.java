package br.com.radar.application;


import android.app.Application;

import br.com.radar.model.Usuario;

public class ContextRadar extends Application {

    private Usuario usuario;

    @Override
    public void onCreate() {
        super.onCreate();

        if(usuario == null){
            usuario = new Usuario();
        }
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
