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

public class TutorialList extends ArrayAdapter<Tutorial> {
        private Activity context;
        private List<Tutorial> tutorialList;

    public TutorialList(Activity context, List<Tutorial> tutorialList){
        super(context, R.layout.session_view, tutorialList);
                this.context = context;
                this.tutorialList = tutorialList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.session_view, null, true);

        TextView classView = (TextView) listViewItem.findViewById(R.id.classView);
        TextView codeView = (TextView) listViewItem.findViewById(R.id.codeView);

        Tutorial tutorial = tutorialList.get(position);

        classView.setText(tutorial.getClasses());
        codeView.setText(tutorial.getRoomCode());

        return listViewItem;
    }
}
