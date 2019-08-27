package com.example.viveragrofinal.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class Produto implements Parcelable {
    private String avaliacao;
    private String img;
    private String nome;
    private String produtor;

    protected Produto(Parcel in) {
        avaliacao = in.readString();
        img = in.readString();
        nome = in.readString();
        produtor = in.readString();
    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };

    public Produto() {

    }

    public String getAvaliacao() {
        return avaliacao;
    }
    public String getImg() {
        return img;
    }

    public String getNome() {
        return nome;
    }

    public String getProdutor() {
        return produtor;
    }


    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }
    public void setImg(String img) {
        this.img = img;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(avaliacao);
        dest.writeString(img);
        dest.writeString(nome);
        dest.writeString(produtor);
    }
}
