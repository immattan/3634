package tan.a3634;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jitae on 24/10/2017.
 */

public class StudentList extends ArrayAdapter<Student> {
    private Activity context;
    private List<Student> students;

    public StudentList(Activity context, List<Student> students){
        super(context, R.layout.studentlistview, students);
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.session_view, null, true);

        TextView name = (TextView) listViewItem.findViewById(R.id.studentName);
        TextView zid = (TextView) listViewItem.findViewById(R.id.studentZid);

        Student student = students.get(position);

        name.setText(student.getStudentName());
        zid.setText(student.getzID());

        return listViewItem;
    }
}
