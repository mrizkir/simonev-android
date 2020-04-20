package id.go.bintankab.bapelitbang.simonev.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import id.go.bintankab.bapelitbang.simonev.R;
import id.go.bintankab.bapelitbang.simonev.repository.WSCallback;
import id.go.bintankab.bapelitbang.simonev.repository.WSSingletonRepo;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG="LoginActivity";

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    private WSSingletonRepo repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText)findViewById(R.id.etUserame);
        etPassword = (EditText)findViewById(R.id.etPassword);

        repo = new WSSingletonRepo(this.getApplicationContext());
    }

    public void btnLoginClicked (View view) {
        JSONObject parameters = new JSONObject();
        try {
            parameters.put("username",etUsername.getText().toString());
            parameters.put("password",etPassword.getText().toString());
            repo.requestMethodPost("/auth/login", parameters, null, new WSCallback() {
                @Override
                public void OnSuccessResponse(JSONObject result) {
                    startActivity(new Intent(LoginActivity.this,DashboardAdminActivity.class));
                }
                @Override
                public void OnErrorResponse(JSONObject error) throws JSONException {
                    Toast.makeText(LoginActivity.this,error.getString("message"),Toast.LENGTH_LONG).show();
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
