package tan.a3634;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

import tan.a3634.R;

/**
 * Created by Tan on 20/10/2017.
 */

public class SessionActivity extends AppCompatActivity {
    private TextView mDisplayedCode;
    private String randomString;
    String[] attendingArray = {"z1688543", "z3925548", "z3029650", "z4039348", "z5053214"};
    generateCode gen = new generateCode();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attendingtable);
        randomString = getIntent().getExtras().getString("randomString");
        Log.d("TESTTEST", randomString);
        mDisplayedCode = (TextView) findViewById(R.id.displayedCode);
        int i = 0;
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_view, attendingArray);

        ListView attendingList = (ListView) findViewById(R.id.attendList);
        attendingList.setAdapter(adapter);

        mDisplayedCode.setText(gen.nextString().toUpperCase());
    }
}
