package com.example.esc.assignment1;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Controller.PostController;

    /**
     * A placeholder fragment containing a simple view.
     */
    public class MainActivityFragment extends Fragment implements OnDataSendToActivity {
        private ArrayList<Post>posts;
        public PostAdapter adapter;

        public MainActivityFragment(){
            posts = new ArrayList<>();
            Post comp = new Post();
            comp.setComments("comments");
            comp.setContent("postText");
            comp.setLikes("likes");
            comp.setShares("shares");
            comp.setName("userName");
            comp.setPostImage("postImage");
            comp.setProfile("userPic");
            posts.add(comp);
            posts.add(comp);
            posts.add(comp);
        }

        public ArrayList<Post> getPosts() {
            return posts;
        }

        public void setPosts(ArrayList<Post> posts) {
            this.posts = posts;
        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v("zeh2t", posts.get(0).getName());
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ListView listView = (ListView)view.findViewById(R.id.postsList);
        adapter = new PostAdapter(getContext(), R.layout.post, posts);
        listView.setAdapter(adapter);
        PostController.getPost(adapter);
        return view;
    }
        @Override
        public void updateListView(ArrayList<Post>details){
            adapter.clear();
            for(Post post : details){
                adapter.add(post);
            }
        }
}
