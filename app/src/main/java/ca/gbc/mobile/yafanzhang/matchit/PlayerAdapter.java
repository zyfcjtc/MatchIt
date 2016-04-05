package ca.gbc.mobile.yafanzhang.matchit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by yafanzhang on 14-10-20.
 */
public class PlayerAdapter extends ArrayAdapter<Player> {

    private final Context context;
    private final Player[] players;

    public PlayerAdapter(Context context, Player[] players) {
        super(context,R.layout.rowlayout,players);
        this.context = context;
        this.players=players;
    }
    @Override
    public View getView(int position,
                        View convertView,
                        ViewGroup parent)
    {
        LayoutInflater inflater =
                (LayoutInflater)context.
                        getSystemService(
                                Context.
                                        LAYOUT_INFLATER_SERVICE);
        View rowView =
                inflater.inflate(R.layout.rowlayout, parent, false);


        TextView name =
                (TextView)rowView.findViewById(R.id.name);
        TextView time =
                (TextView)rowView.findViewById(R.id.time);

        name.setText(players[position].getName());
        time.setText(players[position].getTimeString());
        return rowView;
    }
}
