package Controller;

import com.example.esc.assignment1.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Mohamed AbdEl Mohaimen Mohamed on 7/28/2016.
 */
public class JsonParser implements DataParser {
    public JsonParser(){

    }

    @Override
    public ArrayList<Post> parseData(String data) throws JSONException {
        ArrayList<Post> posts = new ArrayList<>();
        JSONArray array = new JSONArray(data);
        for(int i=0;i<array.length();i++) {
            JSONObject Json = array.getJSONObject(0);
            Post comp = new Post();
            comp.setComments(Json.getString("comments"));
            comp.setContent(Json.getString("postText"));
            comp.setLikes(Json.getString("likes"));
            comp.setShares(Json.getString("shares"));
            comp.setName(Json.getString("userName"));
            comp.setPostImage(Json.getString("postImage"));
            comp.setProfile(Json.getString("userPic"));
            posts.add(comp);
        }

        return posts;
    }
}
