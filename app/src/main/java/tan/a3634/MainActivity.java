package tan.a3634;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import tan.a3634.R;

public class MainActivity extends AppCompatActivity {

    private Button mLogin;
    private Button mSignup;
    private EditText midLogin;
    private EditText mpasswordLogin;
    private Button mattendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        mLogin = (Button) findViewById(R.id.login);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent (MainActivity.this, CreateSessionActivity.class);
                startActivity(mainIntent);
            }
        });
        mSignup = (Button) findViewById(R.id.signup);
        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.register);
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