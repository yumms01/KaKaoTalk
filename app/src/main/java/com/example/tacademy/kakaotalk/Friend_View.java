package com.example.tacademy.kakaotalk;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tacademy on 2016-02-06.
 */
public class Friend_View extends FrameLayout {

    public Friend_View(Context context) {
        super(context);
        init();
    }

    ImageView iconView;
    TextView nameView;
    Friend friend;

    public interface OnImageClickListener {
        public void onImageClick(Friend_View view, Friend friend);
    }
    OnImageClickListener mImageClickListener;
    public void setOnImageClickListener(OnImageClickListener listener) {
        mImageClickListener = listener;
    }

    private void init() {
        inflate(getContext(), R.layout.view_friend, this);
        iconView = (ImageView)findViewById(R.id.image_icon);
        nameView = (TextView)findViewById(R.id.text_name);

        iconView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImageClickListener != null) {
                    mImageClickListener.onImageClick(Friend_View.this, friend);
                }
            }
        });
    }

    public void setChatting(Friend f) {
        friend = f;
        if (f.getIcon() != null) {
            iconView.setImageDrawable(f.getIcon());
        } else {
            iconView.setImageResource(R.mipmap.ic_launcher);
        }
        nameView.setText(f.getName());
    }

}
