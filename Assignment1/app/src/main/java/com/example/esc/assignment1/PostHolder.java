package com.example.esc.assignment1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ESC on 8/2/2016.
 */
public class PostHolder {
    public TextView userName ;
    public TextView post1 ;
    public TextView likes1 ;
    public TextView comments1 ;
    public TextView shares1 ;
    public ImageView profile1 ;
    public ImageView postImage ;

    public PostHolder(View view){
        userName = (TextView)view.findViewById(R.id.userName);
        post1 = (TextView)view.findViewById(R.id.post);
        likes1 = (TextView)view.findViewById(R.id.likes);
        comments1 = (TextView)view.findViewById(R.id.comments);
        shares1 = (TextView)view.findViewById(R.id.shares);
        profile1 = (ImageView) view.findViewById(R.id.userImage);
        postImage = (ImageView) view.findViewById(R.id.postImage);
    }
}
