package com.jarvis.bricksproject.ui.view.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public abstract class BaseCustomView<T> extends FrameLayout {
    public BaseCustomView(Context context) {
        this(context, null);
    }

    public BaseCustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        prepareLayout(context);
    }

    public abstract void prepareLayout(Context context);

    public abstract void bind(T item);
}
