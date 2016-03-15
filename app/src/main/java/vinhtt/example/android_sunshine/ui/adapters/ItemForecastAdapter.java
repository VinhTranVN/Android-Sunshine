package vinhtt.example.android_sunshine.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import vinhtt.example.android_sunshine.R;
import vinhtt.example.android_sunshine.model.Forecast;

/**
 * Created by vit@tapptic.com on 3/15/16.
 */
public class ItemForecastAdapter extends ArrayAdapter<Forecast> {

    private List<Forecast> mItemList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public ItemForecastAdapter(Context context, List<Forecast> items) {
        super(context, 0, items);
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        mItemList = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.item_forecast, null);
            holder.title = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        }

        holder = (ViewHolder) convertView.getTag();
        Forecast item = mItemList.get(position);
        holder.title.setText(item.toString());

        return convertView;
    }


    static class ViewHolder {
        TextView title;
    }
}

