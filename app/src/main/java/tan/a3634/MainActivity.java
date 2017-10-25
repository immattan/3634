package tan.a3634;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button mStudent;
    private Button mTutor;

    @Override //A splash page to direct the user
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        mStudent = (Button) findViewById(R.id.student);
        Intent intentOnButton =getIntent();
        String enable = intentOnButton.getStringExtra("Button");
        if(enable.equals("enabled")){
            mStudent.setEnabled(true);
        }
        else{
            mStudent.setEnabled(false);
        }

        //Start activities containing functions depending on user type
        mStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStudent = new Intent (MainActivity.this, EnterCodeActivity.class);
                startActivity(intentStudent);
            }
        });
        mTutor = (Button) findViewById(R.id.Teacher);
        mTutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTutor = new Intent (MainActivity.this, CreateCodeActivity.class);
                startActivity(intentTutor);
            }
        });
        //midLogin = (EditText) findViewById(R.id.idLogin);
        //String loginAttempt = midLogin.getText().toString();
        //     if (loginAttempt == /*db login student*/) {
        //       setContentView(R.layout.studentview);
        //  }
        //else if (loginAttempt == /* db login tutor*/) {
            /*setContentView(R.layout.createsession);
        }
        else {
            Toast.makeText(this, "Login Details Incorrect", Toast.LENGTH_SHORT).show();
        }
        mattendButton = (Button) findViewById(R.id.attendButton);
        mattendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.attendingtable);
            }
        });*/

    }
}

