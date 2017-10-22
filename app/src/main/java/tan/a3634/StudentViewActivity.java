package tan.a3634;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by Karen Feng on 22/10/2017.
 */

public class StudentViewActivity extends AppCompatActivity {
    private EditText mZidAttend;
    private EditText mCodeFind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentview);
        mZidAttend = (EditText) findViewById(R.id.zIDAttend);
        mCodeFind = (EditText) findViewById(R.id.codeFind);
        try {//insert values
            mZidAttend.getText();
            mCodeFind.getText();
        }
        catch(Exception e) {
            System.out.print("failed");
        }
    }
}
