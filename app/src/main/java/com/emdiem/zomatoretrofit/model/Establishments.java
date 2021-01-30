package com.emdiem.zomatoretrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Establishments {
    @SerializedName("establishments")
    @Expose
    private List<Establishment> establishments = null;

    public List<Establishment> getEstablishments(){
        return establishments;
    }

    public static class Establishment {
        @SerializedName("establishment")
        @Expose
        private Content content;

        public int getId() {
            return content.getId();
        }


        public String getName() {
            return content.getName();
        }

        public static class Content{
            @SerializedName("id")
            @Expose
            private int id;

            @SerializedName("name")
            @Expose
            private String name;

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }

        }
    }
}
