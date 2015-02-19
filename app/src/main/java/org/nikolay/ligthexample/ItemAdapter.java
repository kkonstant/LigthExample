package org.nikolay.ligthexample;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class ItemAdapter extends ArrayAdapter<Item> {

    public ItemAdapter(Context context, List<Item> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = View.inflate(getContext(), R.layout.list_item, null);
        }
        TextView titleText = (TextView) convertView.findViewById(R.id.text_title);
        Item item = getItem(position);

        titleText.setText(item.getTitle());
        return convertView;
    }
}
