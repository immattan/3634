package tan.a3634;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EnterCodeActivity extends AppCompatActivity {
    private EditText writeCode;
    private Button enterCode;
    DatabaseReference codeDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_code);
        writeCode = (EditText) findViewById(R.id.writeCode);
        enterCode = (Button) findViewById(R.id.enterCode);
        codeDatabase = FirebaseDatabase.getInstance().getReference("Codes");

        enterCode.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                codeDatabase.child("Codes").equalTo(writeCode.getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChildren()) {
                            Intent intentAttend = new Intent (EnterCodeActivity.this, TutorialListViewActivity.class);
                            startActivity(intentAttend);
                        } else {
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Wrong Code try again!", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

        });

    }
}
