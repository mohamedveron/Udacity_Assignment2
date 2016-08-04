package Controller;

import com.example.esc.assignment1.Post;

import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by ESC on 8/4/2016.
 */
public interface DataParser {
    public ArrayList<Post> parseData(String data) throws Exception;
}
