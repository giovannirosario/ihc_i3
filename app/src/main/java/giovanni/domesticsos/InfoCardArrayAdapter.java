package giovanni.domesticsos;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class InfoCardArrayAdapter extends ArrayAdapter<InfoCard> {
    Context context;

    public InfoCardArrayAdapter(Context context, int resourceId, List<InfoCard> items) {
        super(context, resourceId, items);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        InfoCard item = getItem(position);


        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView infoText = (TextView) convertView.findViewById(R.id.infoText);
        //ImageView photoUrl = (ImageView) convertView.findViewById(R.id.image);

        title.setText(item.getTitle());
        infoText.setText(item.getInfoText());
        //photoUrl.setImageResource();

        return convertView;
    }
}
