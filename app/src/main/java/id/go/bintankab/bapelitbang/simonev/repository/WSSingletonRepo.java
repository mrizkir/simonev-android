package id.go.bintankab.bapelitbang.simonev.repository;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;
import id.go.bintankab.bapelitbang.simonev.R;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * class untuk singleton app running di seluruh aplikasi
 */
public class WSSingletonRepo {

    private static final String TAG="WSSingletonRepo";

    private static WSSingletonRepo instance;

    private RequestQueue requestQueue;

    private ImageLoader imageLoader;

    private static Context ctx;

    private String apiURL;

    public WSSingletonRepo(Context context) {
        ctx = context;
        apiURL = ctx.getString(R.string.api_url);

        requestQueue = getRequestQueue();

        imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> cache = new LruCache<String,Bitmap>(20);
            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url, bitmap);
            }
        });

    }
    public static synchronized  WSSingletonRepo getInstance(Context context){
        if (instance == null){
            instance = new WSSingletonRepo(context);
        }
        return instance;
    }
    public RequestQueue getRequestQueue() {
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }
    public <T> void addToRequestQueue (Request<T> req) {
        getRequestQueue().add(req);
    }
    public ImageLoader getImageLoader () {
        return imageLoader;
    }


    public void requestMethodPost(String path, JSONObject parameters, final String token, final WSCallback callback) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, apiURL + path, parameters, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                callback.OnSuccessResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                JSONObject jsonError = new JSONObject();
                try {
                    switch(error.networkResponse.statusCode)
                    {
                        case 401:
                            jsonError.put("code",401);
                            jsonError.put("message","Token sudah expire atau username atau password salah");
                        break;
                    }
                    callback.OnErrorResponse(jsonError);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (token == null)
                {
                    return super.getHeaders();
                }
                else
                {
                    HashMap<String,String> headers = new HashMap<>();
                    headers.put("Authorization","Bearer "+token);

                    return headers;
                }
            }
        };
        this.addToRequestQueue(request);
    }
}
