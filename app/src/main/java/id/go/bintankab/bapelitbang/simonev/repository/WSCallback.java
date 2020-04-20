package id.go.bintankab.bapelitbang.simonev.repository;

import org.json.JSONException;
import org.json.JSONObject;

public interface WSCallback {
    void OnSuccessResponse(JSONObject result);
    void OnErrorResponse (JSONObject error) throws JSONException;
}
