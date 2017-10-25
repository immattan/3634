package tan.a3634;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class TutorialListViewActivity extends AppCompatActivity {


    public static final String TUTORIAL_ID = "tutorialID";
    public static final String TUTORIAL_CLASSES = "tutorialClasses";
//<<<<<<< Updated upstream:app/src/main/java/tan/a3634/TutorialListViewActivity.java

//=======
    private DatabaseReference cDatabase;
    private ListView listViewTut;
//<<<<<<< HEAD
    //List<Tutorial> studentTutorial;


//=======
//<<<<<<< HEAD
    List<Tutorial> studentTutorial;

//=======
//>>>>>>> 2bc592af7ddb43ab7b9bf81be85f7a0383ccda81
    private TextView tutorialName;
    List<Tutorial> tutorialList;
    // This activity is a listView that displays all the current sessions in the database.
    // Students can select a session and attempt to join it
//<<<<<<< HEAD

//=======
////>>>>>>> aa09dc8715c9686a089574090876a2545bfe478a
//>>>>>>> 2bc592af7ddb43ab7b9bf81be85f7a0383ccda81
//>>>>>>> Stashed changes:app/src/main/java/tan/a3634/SessionActivity.java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorialsessions);
        cDatabase = FirebaseDatabase.getInstance().getReference("Classes");
        listViewTut = (ListView) findViewById(R.id.listViewTutorial2);
        tutorialList = new ArrayList<>();

        listViewTut.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Tutorial tutorial = tutorialList.get(i);
                Intent intent = new Intent(getApplicationContext(),StudentViewActivity.class);

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
                tutorialList.clear();
                for(DataSnapshot tutorialSnapshot: dataSnapshot.getChildren()){
                    Tutorial tutorial = tutorialSnapshot.getValue(Tutorial.class);
                    tutorialList.add(tutorial);
                }
                TutorialList adapter = new TutorialList(TutorialListViewActivity.this, tutorialList);
                listViewTut.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
