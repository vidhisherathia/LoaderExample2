package com.sassy.loaderexample2;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.ArrayList;

public class CustomAsyncLoader extends AsyncTaskLoader<ArrayList<Friend>> {

    private ArrayList<Friend> friends;
    private static final String TAG = "CustomAsyncLoader";  //shortcut logt

    public CustomAsyncLoader(MainActivity activity,ArrayList<Friend> friends) {
        super(activity);
        this.friends = friends;
        Log.e(TAG,"init AsyncTaskLoader");
    }

    @Nullable
    @Override
    public ArrayList<Friend> loadInBackground() {

        synchronized (this){
            try {
                wait(3000);
                setFriendsData(friends);
                Log.e(TAG,"load in background");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return friends;
    }

    public static void setFriendsData(ArrayList<Friend> list) {
        list.add(new Friend("Hoang An", false));
        list.add(new Friend("Nguyen Minh Ngan", false));
        list.add(new Friend("Phan Van Binh", true));
        list.add(new Friend("Pham Nhat Thanh", false));
        list.add(new Friend("Bui Cong Thanh", true));
        list.add(new Friend("Vu Huu Nhan", true));
    }

    @Override
    public void deliverResult(@Nullable ArrayList<Friend> data) {
        super.deliverResult(data);
        Log.e(TAG, "deliver Result");
    }
}
