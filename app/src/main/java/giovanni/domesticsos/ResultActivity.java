package giovanni.domesticsos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

import pl.pawelkleczkowski.customgauge.CustomGauge;

public class ResultActivity extends AppCompatActivity {

        private CustomGauge gauge3;
        int i;
        private TextView score;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_result);
            // Get the Intent that started this activity and extract the string
            Intent intent = getIntent();
            String total_score = intent.getStringExtra(MainActivity.TOTAL_SCORE);
            Log.d("LIST", "Result activity");


            gauge3 = findViewById(R.id.gauge3);
            gauge3.setValue(Integer.parseInt(total_score));
            score = findViewById(R.id.scoreView);
            score.setText(total_score);
        }

        public void onInfoTextClicked(View view){
            Intent intent = new Intent(getApplicationContext(), MoreInfoActivity.class);
            startActivity(intent);
        }

        public void onCallTextClicked(View view){
            Log.d("LIST", "Call clicked");

            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "180"));
            startActivity(intent);
        }
}
