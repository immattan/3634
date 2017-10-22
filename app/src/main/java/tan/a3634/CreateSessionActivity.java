package tan.a3634;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CreateSessionActivity extends AppCompatActivity {

    generateCode gen = new generateCode();
    String roomCode = gen.nextString().toUpperCase();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createsession);

        Button mCreateButton = (Button) findViewById(R.id.createButton);
        EditText mClassName = (EditText) findViewById(R.id.className);
        mCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createSessionIntent = new Intent(CreateSessionActivity.this, SessionActivity.class);
                Bundle mBundle = new Bundle();
                mBundle.putString("randomString", roomCode);
                createSessionIntent.putExtras(mBundle);
                try {//insert into db
                    //roomCode;
                }
                catch (Exception e) {

                }
                startActivity(createSessionIntent);
                Toast.makeText(CreateSessionActivity.this, roomCode, Toast.LENGTH_SHORT).show();
            }
        });
    }
}