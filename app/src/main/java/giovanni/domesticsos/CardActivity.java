package giovanni.domesticsos;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);

        Intent intent = getIntent();

        String title = intent.getStringExtra("title");
        String info = intent.getStringExtra("text");
        String bgColor = intent.getStringExtra("color");

        TextView t = (TextView) findViewById(R.id.title);
        TextView iT = (TextView) findViewById(R.id.infoText);
        ImageView backgroundImg = (ImageView) findViewById(R.id.image);

        t.setText(title);
        backgroundImg.setBackgroundColor(Color.parseColor(bgColor));
        iT.setText(info);
    }
}
