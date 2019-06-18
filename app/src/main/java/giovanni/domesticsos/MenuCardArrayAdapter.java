package giovanni.domesticsos;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MenuCardArrayAdapter  extends ArrayAdapter<InfoCard> {
    Context context;

    public MenuCardArrayAdapter(Context context, int resourceId, List<InfoCard> items) {
        super(context, resourceId, items);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        InfoCard item = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.menu_item, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.title);
        title.setText(item.getTitle());
        title.setBackgroundColor(Color.parseColor(item.getBgColor()));

        return convertView;
    }
}
