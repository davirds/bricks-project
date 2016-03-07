package com.jarvis.bricksproject.ui.adapter.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jarvis.bricksproject.ui.view.base.BaseCustomView;

import java.util.Collections;
import java.util.List;

public abstract class BaseAdapter<T, V extends BaseCustomView>
        extends RecyclerView.Adapter<BaseAdapter.BaseViewHolder<T, V>> implements ItemTouchHelperAdapter {

    private int position;

    private List<T> listValues;

    public BaseAdapter(List<T> listValues) {
        this.listValues = listValues;
    }

    public T getItem(int position) {
        return listValues.get(position);
    }

    @Override
    public BaseViewHolder<T, V> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseViewHolder<>(onCreateItemView(parent.getContext(), position));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<T, V> holder, int position) {
        this.position++;
        holder.bind(getItem(position));
    }

    @NonNull
    public abstract V onCreateItemView(Context context, int position);

    @Override
    public int getItemCount() {
        return listValues.size();
    }

    @Override
    public void onItemDismiss(int position) {
        listValues.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(listValues, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(listValues, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    public static class BaseViewHolder<T, V extends BaseCustomView>
            extends RecyclerView.ViewHolder {
        private V itemView;

        public BaseViewHolder(V itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        public void bind(T item) {
            this.itemView.bind(item);
        }
    }
}
