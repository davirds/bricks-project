package com.jarvis.bricksproject.ui.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.jarvis.bricksproject.R;

import butterknife.Bind;

public abstract class BaseToolbarActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    public Toolbar toolbar;
    public ActionBar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
    }

    public boolean hasActionBar() {
        return actionBar != null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
