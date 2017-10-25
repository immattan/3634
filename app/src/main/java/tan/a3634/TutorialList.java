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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.session_view, null, true);

        TextView classView = (TextView) listViewItem.findViewById(R.id.classView);

        Tutorial tutorial = tutorialList.get(position);

        classView.setText(tutorial.getClasses());


        return listViewItem;
    }
}
