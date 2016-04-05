package ca.gbc.mobile.yafanzhang.matchit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**************************************************
 * Yafan Zhang
 * 100816652
 * created: 10/3/2014
 * lastEdit: 10/10/2014
 **************************************************/
public class MainActivity extends Activity implements View.OnClickListener{

    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button game_button=(Button)findViewById(R.id.start_game);
        Button score_button=(Button)findViewById(R.id.score_board);
        Button about_button=(Button)findViewById(R.id.about_button);

        game_button.setOnClickListener(this);
        score_button.setOnClickListener(this);
        about_button.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){

            case R.id.start_game:
                Intent game=new Intent(this, GameActivity.class);
                startActivity(game);
                break;
            case R.id.score_board:
                Intent score=new Intent(this, ScoreActivity.class);
                startActivity(score);
                break;
            case R.id.about_button:
                Intent about=new Intent(this, AboutActivity.class);
                startActivity(about);
                break;
        }
    }
}
