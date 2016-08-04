package com.example.esc.assignment1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by ESC on 8/2/2016.
 */
public class PostAdapter extends ArrayAdapter<Post> {
    public List<Post> objects;
    private Context context;
    public PostAdapter(Context context, int resource, List<Post> objects) {
        super(context, resource, objects);
        this.objects = objects;
        this.context = context;
    }
    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Post getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        PostHolder holder = null;
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.post,parent,false);
            holder = new PostHolder(view);
            view.setTag(holder);
        }
        else{
            holder = (PostHolder)view.getTag();
        }

        Post post =  objects.get(position);
        holder.comments1.setText(post.getComments());
        holder.likes1.setText(post.getLikes());
        holder.shares1.setText(post.getShares());
        holder.userName.setText(post.getName());
        holder.post1.setText(post.getContent());
        Picasso.with(context).load(post.getProfile())
                .resize(100,100).centerCrop()
                .into(holder.profile1);
        Picasso.with(context).load(post.getPostImage())
                .resize(300,300).centerCrop()
                .into(holder.postImage);


        return view;
    }
}
