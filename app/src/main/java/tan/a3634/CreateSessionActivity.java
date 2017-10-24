package tan.a3634;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class CreateSessionActivity extends AppCompatActivity {
    private DatabaseReference cDatabase;
    private Spinner cspinnerClass;
    private Button ccreateButton;

    public static final String TUTORIAL_ID = "tutorialID";
    public static final String TUTORIAL_CLASSES = "tutorialClasses";

    private ListView listViewTut;
    List<Tutorial> tutorialList;

    generateCode gen = new generateCode();
    String roomCode = gen.nextString().toUpperCase();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createsession);
        cDatabase = FirebaseDatabase.getInstance().getReference("Classes");
        ccreateButton = (Button) findViewById(R.id.createButton);
        cspinnerClass = (Spinner) findViewById(R.id.spinnerClass);
        listViewTut = (ListView) findViewById(R.id.listViewTutorial);
        tutorialList = new ArrayList<>();


        ccreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createSessionIntent = new Intent(CreateSessionActivity.this, SessionActivity.class);
                Bundle mBundle = new Bundle();
                mBundle.putString("randomString", roomCode);
                createSessionIntent.putExtras(mBundle);
                startActivity(createSessionIntent);
                addTutorial();
                Toast.makeText(CreateSessionActivity.this, roomCode, Toast.LENGTH_SHORT).show();
            }
        });

        listViewTut.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Tutorial tutorial = tutorialList.get(i);
                Intent intent = new Intent(getApplicationContext(),StudentListActivity.class);

                intent.putExtra(TUTORIAL_ID, tutorial.getClassID());
                intent.putExtra(TUTORIAL_CLASSES, tutorial.getClasses());

                startActivity(intent);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        cDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot tutorialSnapshot: dataSnapshot.getChildren()){
                    Tutorial tutorial = tutorialSnapshot.getValue(Tutorial.class);
                    tutorialList.add(tutorial);
                }
                TutorialList adapter = new TutorialList(CreateSessionActivity.this, tutorialList);
                listViewTut.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void addTutorial() {

        String classes = cspinnerClass.getSelectedItem().toString();
        String roomcode = roomCode.getClass().toString().trim();
        String id = cDatabase.push().getKey();

        Tutorial tutorial = new Tutorial(id, classes, roomcode);
        cDatabase.child(id).setValue(tutorial);
    }
}