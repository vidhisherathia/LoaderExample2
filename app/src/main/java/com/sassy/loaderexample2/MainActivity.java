package com.sassy.loaderexample2;

import androidx.fragment.app.FragmentActivity;

import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements
        LoaderManager.LoaderCallbacks<ArrayList<Friend>> {

    private FriendListViewAdapter adapter;
    private ArrayList<Friend> friends;
    private ListView listView;
    private View loadingBar;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        loadingBar = findViewById(R.id.loading);
        initAdapter();
        getSupportLoaderManager().initLoader(0,null,this);

    }

    private void initAdapter() {
        friends = new ArrayList<Friend>();
        adapter = new FriendListViewAdapter(this, R.layout.item_list_friend,
                R.id.nameOfItem, friends);
        listView.setAdapter(adapter);
    }

    @Override
    public Loader<ArrayList<Friend>> onCreateLoader(int id, Bundle args) {
        CustomAsyncLoader asyncTaskLoader = new CustomAsyncLoader(this, friends);
        asyncTaskLoader.forceLoad();
        Log.i(TAG, "onCreateLoader");
        return asyncTaskLoader;
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Friend>> loader, ArrayList<Friend> data) {
        adapter.notifyDataSetChanged();

        loadingBar.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);
        Log.i(TAG, "onLoadFinish");
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Friend>> loader) {
        listView.setAdapter(null);
        Log.i(TAG, "onLoaderReset");
    }
}
