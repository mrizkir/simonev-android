package id.go.bintankab.bapelitbang.simonev.repository;

import android.content.Context;
import android.media.audiofx.DynamicsProcessing;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;

import id.go.bintankab.bapelitbang.simonev.model.WSDashboadModel;

public class WSDashboardRepo {
    private static final String TAG="WSDashboardRepo";
    private WSDashboadModel dashboadModel;
    public WSDashboardRepo(Context context) {
        WSSingletonRepo repo = new WSSingletonRepo(context);

        HashMap<String,String> params = new HashMap<>();
        params.put("tahun","2020");
        JSONObject parameters = new JSONObject(params);

        repo.requestMethodPost("/dashboard/front", parameters, null, new WSCallback() {
            @Override
            public void OnSuccessResponse(JSONObject result) {
                Log.i(TAG,result.toString());
            }
        });
    }

};

