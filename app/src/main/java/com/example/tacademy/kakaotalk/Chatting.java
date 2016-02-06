package com.example.tacademy.kakaotalk;

import android.graphics.drawable.Drawable;

/**
 * Created by Tacademy on 2016-02-01.
 */
public class Chatting {
    private Drawable icon;
    private String name;
    private String chatting;

    public Chatting(Drawable icon, String name, String chatting) {
        this.icon = icon;
        this.name = name;
        this.chatting = chatting;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setChatting(String chatting) {
        this.chatting = chatting;
    }

    public String getChatting() {
        return chatting;
    }

}
