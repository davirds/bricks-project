package com.jarvis.bricksproject.ui.view;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.jarvis.bricksproject.domain.BrickModel;
import com.jarvis.bricksproject.ui.view.base.BaseCustomView;

public abstract class BricksItemView extends BaseCustomView<BrickModel> {
    protected View root;
    protected TextView name;
    protected TextView description;
    protected CardView cardView;

    public BricksItemView(Context context) {
        super(context);
    }

    @Override
    public void bind(BrickModel item) {
        name.setText(item.getName());
        description.setText(item.getDescription());
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            cardView.setBackground(getContext().getDrawable(item.getBackGround()));
        }

        cardView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
