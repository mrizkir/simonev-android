package id.go.bintankab.bapelitbang.simonev.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import id.go.bintankab.bapelitbang.simonev.R;
import id.go.bintankab.bapelitbang.simonev.repository.WSDashboardRepo;

public class DashboardFrontActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_front);

        WSDashboardRepo dashboardRepo = new WSDashboardRepo(this.getApplicationContext());
    }
}
