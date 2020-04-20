package id.go.bintankab.bapelitbang.simonev.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {
    private SharedPreferences prefs;

    public Session(Context ctx) {
        this.prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public void setUser (String user) {
        prefs.edit().putString("user",user).commit();
    }

    public void setAPIToken (String token) {
        prefs.edit().putString("user",token).commit();
    }

    public void setTokenType (String token_type) {
        prefs.edit().putString("token_type",token_type).commit();
    }

    public void setExpireIn (String expire) {
        prefs.edit().putString("expires_in",expire).commit();
    }

    public String getUser () {
        String user = prefs.getString("user","");
        return user;
    }

    public String getAPIToken () {
        String token = prefs.getString("api_token","");
        return token;
    }

    public String getTokenType () {
        String token_type = prefs.getString("token_type","");
        return token_type;
    }

    public String getExpireIn () {
        String expires_in = prefs.getString("expires_in","");
        return expires_in;
    }
}
