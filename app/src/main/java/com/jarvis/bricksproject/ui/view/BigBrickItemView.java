package com.jarvis.bricksproject.ui.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.jarvis.bricksproject.R;

public class BigBrickItemView extends BricksItemView {

    public BigBrickItemView(Context context) {
        super(context);
    }

    @Override
    public void prepareLayout(Context context) {
        root = LayoutInflater.from(context).inflate(R.layout.item_big_brick, this, true);
        name = (TextView) root.findViewById(R.id.big_brick_name);
        description = (TextView) root.findViewById(R.id.big_brick_description);
        cardView = (CardView) root.findViewById(R.id.big_card_view);
    }
}
