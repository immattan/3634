package tan.a3634;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TutorialListViewActivity extends AppCompatActivity {
    DatabaseReference cDatabase;
    private ListView listViewTut;
    List<Tutorial> tutorialList;

    public static final String TUTORIAL_ID = "tutorialID";
    public static final String TUTORIAL_CLASSES = "tutorialClasses";

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
