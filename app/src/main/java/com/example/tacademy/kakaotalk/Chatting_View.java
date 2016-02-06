package com.example.tacademy.kakaotalk;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tacademy on 2016-02-01.
 */
public class Chatting_View extends FrameLayout {

    public Chatting_View(Context context) {
        super(context);
        init();
    }

    ImageView iconView;
    TextView nameView, chattingView;
    Chatting chatting;

    public interface OnImageClickListener {
        public void onImageClick(Chatting_View view, Chatting chatting);
    }
    OnImageClickListener mImageClickListener;
    public void setOnImageClickListener(OnImageClickListener listener) {
        mImageClickListener = listener;
    }

    private void init() {
        inflate(getContext(), R.layout.view_chatting, this);
        iconView = (ImageView)findViewById(R.id.image_icon);
        nameView = (TextView)findViewById(R.id.text_name);
        chattingView = (TextView)findViewById(R.id.text_chatting);

        iconView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImageClickListener != null) {
                    mImageClickListener.onImageClick(Chatting_View.this, chatting);
                }
            }
        });
    }

    public void setChatting(Chatting c) {
        chatting = c;
        if (c.getIcon() != null) {
            iconView.setImageDrawable(c.getIcon());
        } else {
            iconView.setImageResource(R.mipmap.ic_launcher);
        }
        nameView.setText(c.getName());
        chattingView.setText(c.getChatting());
    }

}
