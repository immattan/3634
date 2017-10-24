package tan.a3634;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tan on 20/10/2017.
 */

public class SessionActivity extends AppCompatActivity {
    public static final String TUTORIAL_ID = "tutorialID";
    public static final String TUTORIAL_CLASSES = "tutorialClasses";
    private DatabaseReference cDatabase;
    private ListView listViewTut;
<<<<<<< HEAD
    List<Tutorial> studentTutorial;

=======
    private TextView tutorialName;
    List<Tutorial> tutorialList;
    // This activity is a listView that displays all the current sessions in the database.
    // Students can select a session and attempt to join it
>>>>>>> aa09dc8715c9686a089574090876a2545bfe478a
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sessionlistview);
        listViewTut = (ListView) findViewById(R.id.listViewTutorial);


        studentTutorial = new ArrayList<>();

        cDatabase = FirebaseDatabase.getInstance().getReference();

        listViewTut.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Tutorial tutorial = studentTutorial.get(i);
                Intent intent = new Intent(getApplicationContext(),StudentViewActivity.class);

                intent.putExtra(TUTORIAL_ID, tutorial.getClassID());
                intent.putExtra(TUTORIAL_CLASSES, tutorial.getClasses());

                startActivity(intent);

            }
        });
    }

    protected void onStart() {
        super.onStart();
        cDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot tutorialSnapshot: dataSnapshot.getChildren()){
                    Tutorial tutorial = tutorialSnapshot.getValue(Tutorial.class);
                    studentTutorial.add(tutorial);
                }
                StudentTutorialList adapter = new StudentTutorialList(SessionActivity.this, studentTutorial);
                listViewTut.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
