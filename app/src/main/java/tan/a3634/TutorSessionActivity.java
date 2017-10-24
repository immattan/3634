package tan.a3634;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Karen Feng on 24/10/2017.
 */

public class TutorSessionActivity extends AppCompatActivity {
    private TextView mPushCodeDisplayed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentview);
        mPushCodeDisplayed = findViewById(R.id.pushCodeDisplayed);
        String getCode = getIntent().getExtras().getString("randomString");
        mPushCodeDisplayed.setText(getCode);
    }
}
