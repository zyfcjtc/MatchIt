package ca.gbc.mobile.yafanzhang.matchit;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**************************************************
 * Yafan Zhang
 * 100816652
 * created: 10/20/2014
 * lastEdit: 10/23/2014
 **************************************************/
public class ScoreActivity extends ListActivity{


    MySQLHelper dbHandler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        List<Player> player_list=new ArrayList<Player>();

        Bundle extras=getIntent().getExtras();

        dbHandler = new MySQLHelper(this);
        dbHandler.getWritableDatabase();

        try {
            String name = extras.getString("Name");
            long time = extras.getLong("Time");
            Player player = new Player(name, time);
            dbHandler.createPlayer(name, time);
        }catch (Exception e){
            e.printStackTrace();
        }


          player_list=dbHandler.getAllPlayers();

       /* ArrayAdapter<Player>
                adapter = new ArrayAdapter<Player>(
                this,
                android.R.layout.simple_list_item_1,
                player_list);*/
       PlayerAdapter adapter=new PlayerAdapter(this, player_list.toArray(new Player[]{}));
        setListAdapter(adapter);
    }

}


