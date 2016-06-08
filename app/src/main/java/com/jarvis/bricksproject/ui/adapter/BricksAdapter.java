package com.jarvis.bricksproject.ui.adapter;

import android.content.Context;

import com.jarvis.bricksproject.domain.BrickModel;
import com.jarvis.bricksproject.ui.adapter.base.BaseAdapter;
import com.jarvis.bricksproject.ui.adapter.base.ItemTouchHelperAdapter;
import com.jarvis.bricksproject.ui.view.BigBrickItemView;
import com.jarvis.bricksproject.ui.view.BricksItemView;
import com.jarvis.bricksproject.ui.view.SmallBrickItemView;

import java.util.Collections;
import java.util.List;

public class BricksAdapter extends BaseAdapter<BrickModel, BricksItemView> implements ItemTouchHelperAdapter {

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


    @Override
    public void onItemDismiss(int position) {
        getListValues().remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(getListValues(), i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(getListValues(), i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

}


