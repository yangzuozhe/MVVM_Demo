package com.example.mvvm_demo.Repository;

import java.io.Serializable;

public class User implements Serializable {
  private int code;
  private Data data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public User(int code) {
        this.code = code;
    }

    public void setData(Data data) {
        this.data = data;
    }

     class Data{
       private String artistsname;
       private String name;
       private String picurl;
       private String url;

        public String getArtistsname() {
            return artistsname;
        }

        public void setArtistsname(String artistsname) {
            this.artistsname = artistsname;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
