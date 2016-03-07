package com.jarvis.bricksproject.ui.adapter;

import android.content.Context;

import com.jarvis.bricksproject.domain.BrickModel;
import com.jarvis.bricksproject.ui.adapter.base.BaseAdapter;
import com.jarvis.bricksproject.ui.view.BigBrickItemView;
import com.jarvis.bricksproject.ui.view.BricksItemView;
import com.jarvis.bricksproject.ui.view.SmallBrickItemView;

import java.util.List;

public class BricksAdapter extends BaseAdapter<BrickModel, BricksItemView> {

    public BricksAdapter(List<BrickModel> listValues) {
        super(listValues);
    }

    @Override
    public BricksItemView onCreateItemView(Context context, int position) {
        if (position == 1 || position == 2) {
            return new BigBrickItemView(context);
        } else {
            return new SmallBrickItemView(context);
        }
    }

}


