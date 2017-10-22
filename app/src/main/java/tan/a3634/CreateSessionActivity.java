package tan.a3634;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

import tan.a3634.R;


public class CreateSessionActivity extends AppCompatActivity {

    generateCode gen = new generateCode();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createsession);
        //xs

        Button mCreateButton = (Button) findViewById(R.id.createButton);
        EditText mClassName = (EditText) findViewById(R.id.className);
        mCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createSessionIntent = new Intent(CreateSessionActivity.this, SessionActivity.class);
                Bundle mBundle = new Bundle();
                mBundle.putString("randomString", gen.nextString().toUpperCase());
                createSessionIntent.putExtras(mBundle);
                startActivity(createSessionIntent);
                Toast.makeText(CreateSessionActivity.this,"success", Toast.LENGTH_SHORT).show();
            }
        });
    }
}