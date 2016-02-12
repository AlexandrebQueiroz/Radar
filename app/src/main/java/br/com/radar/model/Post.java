package br.com.radar.model;

public class Post {

    private int id;
    private String status;
    private String image;
    private String timeStamp;
    private String url;

    private Usuario usuario;

    public Post(int id, String status, String image, String timeStamp, String url, Usuario usuario) {
        this.id = id;
        this.status = status;
        this.image = image;
        this.timeStamp = timeStamp;
        this.url = url;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
