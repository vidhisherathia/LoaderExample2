package com.sassy.loaderexample2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class FriendListViewAdapter extends ArrayAdapter<Friend> {

    private Activity activity;

    public FriendListViewAdapter(Activity activity, int resource,
                                 int textviewResId, ArrayList<Friend> objects) {
        super(activity, resource, textviewResId, objects);
        this.activity = activity;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder = null;
        LayoutInflater layoutInflater = (LayoutInflater) activity
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.item_list_friend,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        Friend f = getItem(position);
        holder.friendName.setText(f.getName());
        if(f.isGender()){
            holder.friendName.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.male,
                    0,0,0);
        }
        else{
            holder.friendName.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.female,
                    0,0,0);
        }

        return convertView;
    }

    private class ViewHolder {
        private TextView friendName;

        public ViewHolder(View v) {
            friendName = (TextView) v.findViewById(R.id.nameOfItem);
        }
    }

}
