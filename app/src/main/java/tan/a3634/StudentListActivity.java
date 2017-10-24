package tan.a3634;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class StudentListActivity extends AppCompatActivity {
    private Button activate;
    private Button deactivate;
    private TextView tutorialName;
    private ListView studentList;
    List<Student> students;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentlistview);
        tutorialName = (TextView) findViewById(R.id.textTutName2);
        activate = (Button) findViewById(R.id.activateAttend);
        deactivate = (Button) findViewById(R.id.deactivateAttend);
        students = new ArrayList<>();
        Intent intent = getIntent();
        String name = intent.getStringExtra(CreateSessionActivity.TUTORIAL_CLASSES);
        tutorialName.setText(name);
        mDatabase = FirebaseDatabase.getInstance().getReference("Students");

//        activate.setOnClickListener(new View.OnClickListener(){
//         @Override
//         public void onClick(View view) {
//
//         }
//           });
    }
    protected void onStart() {
        super.onStart();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                students.clear();
                for(DataSnapshot studentSnapshot: dataSnapshot.getChildren()){
                    Student student = studentSnapshot.getValue(Student.class);
                    students.add(student);
                }
                StudentList adapter = new StudentList(StudentListActivity.this, students);
                studentList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


}
