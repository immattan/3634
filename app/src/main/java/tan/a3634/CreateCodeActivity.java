package tan.a3634;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateCodeActivity extends AppCompatActivity {
    DatabaseReference codeDatabase;
    private Button genCode;
    private Button nextSession;
    private TextView showCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_code);
        genCode = (Button) findViewById(R.id.genCode);
        nextSession = (Button) findViewById(R.id.goCreateSesssion);
        showCode = (TextView) findViewById(R.id.codeView);
        codeDatabase = FirebaseDatabase.getInstance().getReference("Codes");

        genCode.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                addCode();
            }
        });
        nextSession.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent intentCreate = new Intent (CreateCodeActivity.this, CreateSessionActivity.class);
                startActivity(intentCreate);
            }
        });
    }

    private void addCode() {
        String name = showCode.getText().toString();
        String id = codeDatabase.push().getKey();

        Code code = new Code(id, name);
        codeDatabase.child(id).setValue(code);
    }
}


//    generateCode gen = new generateCode();
//String roomCode = gen.nextString().toUpperCase();
// The random string that becomes our push code is generated when attempting to create a Session
//    Bundle mBundle = new Bundle();
//                mBundle.putString("randomString", roomCode); // Bundle the room code and transfer it to be displayed
//                        createSessionIntent.putExtras(mBundle);
//                        startActivity(createSessionIntent);
//                        addTutorial();
//                        Toast.makeText(CreateSessionActivity.this, roomCode, Toast.LENGTH_LONG).show();