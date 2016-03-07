package com.jarvis.bricksproject.ui.adapter.base;

/**
 * Created by davirodrigues on 06/03/16.
 */
public interface ItemTouchHelperAdapter {

    void onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
