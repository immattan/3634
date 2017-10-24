package tan.a3634;

import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Karen Feng on 22/10/2017.
 */

public class StudentViewActivity extends AppCompatActivity {
    private EditText mStudentName;
    private EditText mCodeFind;
    private Spinner mspinnerZID;
    private Button mAttendButton;
    private TextView tutorialName;

    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentview);

        mStudentName = (EditText) findViewById(R.id.studentName);
        mCodeFind = (EditText) findViewById(R.id.codeFind);
        mspinnerZID = (Spinner) findViewById(R.id.spinnerZID);
        mAttendButton = (Button) findViewById(R.id.attendButton);
        tutorialName = (TextView) findViewById(R.id.textViewTutorialName);

        Intent intent = getIntent();
        String id = intent.getStringExtra(SessionActivity.TUTORIAL_ID);
        String name = intent.getStringExtra(SessionActivity.TUTORIAL_CLASSES);
        tutorialName.setText(name);

        mDatabase = FirebaseDatabase.getInstance().getReference("Students").child(id);


        mAttendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            addStudent();
            }
        });
    }

    private void addStudent(){
        String name = mStudentName.getText().toString().trim();
        String zid = mspinnerZID.getSelectedItem().toString();
        String code = mCodeFind.getText().toString().trim();
        if(!TextUtils.isEmpty(name)){
           String id = mDatabase.push().getKey();

            Student student = new Student(id, name, zid, code);
            mDatabase.child(id).setValue(student);

            Toast.makeText(this,"Attendance has been marked!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Please enter your name! ", Toast.LENGTH_LONG).show();
        }

    }
}
