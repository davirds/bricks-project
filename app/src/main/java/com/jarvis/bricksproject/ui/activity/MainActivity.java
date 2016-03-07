package com.jarvis.bricksproject.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.jarvis.bricksproject.R;
import com.jarvis.bricksproject.domain.BrickModel;
import com.jarvis.bricksproject.ui.activity.base.BaseToolbarActivity;
import com.jarvis.bricksproject.ui.adapter.BricksAdapter;
import com.jarvis.bricksproject.ui.adapter.base.SimpleItemTouchHelperCallback;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseToolbarActivity {

    @Bind(R.id.container_bricks)
    RecyclerView recyclerView;
    List<BrickModel> listBricks;

    @Override
    public int contentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar.setSubtitle("Test Bricks");
        prepareList();
        StaggeredGridLayoutManager layoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        BricksAdapter adapter = new BricksAdapter(listBricks);
        recyclerView.setAdapter(adapter);
        ItemTouchHelper.Callback callback =
                new SimpleItemTouchHelperCallback(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);
    }

    public void prepareList() {
        listBricks = new LinkedList<>();
        listBricks.add(new BrickModel("Brick 1", "Small", R.drawable.brick_background_blue));
        listBricks.add(new BrickModel("Brick 2", "Big", R.drawable.brick_background_red));
        listBricks.add(new BrickModel("Brick 3", "Big", R.drawable.brick_background_yellow));
        listBricks.add(new BrickModel("Brick 4", "Small", R.drawable.brick_background_blue));
        listBricks.add(new BrickModel("Brick 5", "Small", R.drawable.brick_background_blue));
        listBricks.add(new BrickModel("Brick 6", "Small", R.drawable.brick_background_yellow));
    }
}
