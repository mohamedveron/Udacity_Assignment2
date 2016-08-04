package Controller;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.esc.assignment1.MainActivityFragment;
import com.example.esc.assignment1.OnDataSendToActivity;
import com.example.esc.assignment1.Post;
import com.example.esc.assignment1.PostAdapter;
import com.example.esc.assignment1.R;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Mohamed AbdEl Mohaimen Mohamed on 7/28/2016.
 */
public class PostController {

    public  PostController(){

    }

    public  static void getPost(PostAdapter adapter){
           new OpenConnection(adapter).execute("https://dl.dropboxusercontent.com/s/7rvknz9e6tfprun/facebookFeed.json");
    }

    public static class OpenConnection extends AsyncTask<String,Void, ArrayList<Post>>{
        public PostAdapter adapter;
        public OpenConnection(PostAdapter adapter){
             this.adapter = adapter;
        }

        @Override
        protected ArrayList<Post> doInBackground(String... params) {
            URL url = null;
            HttpURLConnection connection = null;
            BufferedReader buffer = null;
            String result = null;
            try {
                url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                InputStream input = connection.getInputStream();
                buffer = new BufferedReader(new InputStreamReader(input));
                StringBuffer sbuffer = new StringBuffer();
                String  line;
                while ((line = buffer.readLine())!= null){
                    sbuffer.append(line);
                }
                result = sbuffer.toString();
                DataParser parser = new JsonParser();
                ArrayList<Post>details = parser.parseData(result);
                Log.v("here", details.get(0).getContent());
                return details;
            } catch (MalformedURLException e) {
                System.out.println("URL is wrong");
            } catch (IOException e) {
                System.out.println("Connection failed");
            } catch (Exception e) {
                System.out.println("PARSE JSON failed");
            }
            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<Post>details){
            OnDataSendToActivity fragment = new MainActivityFragment();
            //fragment.updateListView(details);
            adapter.clear();
            for(Post post : details){
                adapter.add(post);
            }

        }
    }
}
