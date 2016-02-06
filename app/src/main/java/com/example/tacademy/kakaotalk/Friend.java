package com.example.tacademy.kakaotalk;

import android.graphics.drawable.Drawable;

/**
 * Created by Tacademy on 2016-02-06.
 */
public class Friend {
    private Drawable icon;
    private String name;

    public Friend(Drawable icon, String name) {
        this.icon = icon;
        this.name = name;
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

}
