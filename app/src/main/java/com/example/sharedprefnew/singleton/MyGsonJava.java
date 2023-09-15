package com.example.sharedprefnew.singleton;

import com.google.gson.Gson;

public class MyGsonJava {
    private static MyGsonJava myGsonJava = new MyGsonJava();
    private static Gson gson;

    private MyGsonJava() {
    }

    public static MyGsonJava getInstance() {
        if (gson == null) {
            gson = new Gson();
        }
        return myGsonJava;
    }

    public Gson getGson() {
        return gson;
    }
}
