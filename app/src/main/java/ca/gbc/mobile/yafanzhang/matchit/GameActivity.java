package ca.gbc.mobile.yafanzhang.matchit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.*;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import java.util.*;
import java.util.ArrayList;
import android.content.ContentValues;


/**************************************************
 * Yafan Zhang
 * 100816652
 * created: 10/4/2014
 * lastEdit: 10/11/2014
 **************************************************/
public class GameActivity extends Activity implements View.OnClickListener{

    private Pair pair;
    private Deck deck;
    private CardView card1,card2,card3,card4,card5,card6,card7,card8,card9,card10,card11,card12;
    private ArrayList<CardView> card_list=new ArrayList<CardView>();
    private ArrayList<Pair> pair_list=new ArrayList<Pair>();
    private CardView check_card;
    private TextView timer;
    int counter=0;
    long start_time;
    long time;
    String name;
    MySQLHelper dbHandler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        dbHandler = new MySQLHelper(getApplicationContext());
        deck = new Deck();
        ArrayList<Pair> deck_list = deck.getDeck();
        ArrayList<Long> backpage_list = new ArrayList<Long>(12);

        for (int i = 1; i <= 6; i++) {
            Random r = new Random();
            int index = r.nextInt(deck_list.size());
            pair = deck_list.get(index);
            backpage_list.add(pair.getFirst());
            backpage_list.add(pair.getSecond());
            pair_list.add(pair);
            deck_list.remove(index);
        }
        Collections.shuffle(backpage_list);
        card1 = (CardView) findViewById(R.id.viewn);
        card2 = (CardView) findViewById(R.id.view);
        card3 = (CardView) findViewById(R.id.view2);
        card4 = (CardView) findViewById(R.id.view3);
        card5 = (CardView) findViewById(R.id.view4);
        card6 = (CardView) findViewById(R.id.view5);
        card7 = (CardView) findViewById(R.id.view6);
        card8 = (CardView) findViewById(R.id.view7);
        card9 = (CardView) findViewById(R.id.view9);
        card10 = (CardView) findViewById(R.id.view11);
        card11 = (CardView) findViewById(R.id.view13);
        card12 = (CardView) findViewById(R.id.view14);

        card1.setFront(backpage_list.get(0));
        card2.setFront(backpage_list.get(1));
        card3.setFront(backpage_list.get(2));
        card4.setFront(backpage_list.get(3));
        card5.setFront(backpage_list.get(4));
        card6.setFront(backpage_list.get(5));
        card7.setFront(backpage_list.get(6));
        card8.setFront(backpage_list.get(7));
        card9.setFront(backpage_list.get(8));
        card10.setFront(backpage_list.get(9));
        card11.setFront(backpage_list.get(10));
        card12.setFront(backpage_list.get(11));
        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
        card7.setOnClickListener(this);
        card8.setOnClickListener(this);
        card9.setOnClickListener(this);
        card10.setOnClickListener(this);
        card11.setOnClickListener(this);
        card12.setOnClickListener(this);
        card_list.add(card1);
        card_list.add(card2);
        card_list.add(card3);
        card_list.add(card4);
        card_list.add(card5);
        card_list.add(card6);
        card_list.add(card7);
        card_list.add(card8);
        card_list.add(card9);
        card_list.add(card10);
        card_list.add(card11);
        card_list.add(card12);





    }

    @Override
    public void onClick(View v) {
        time=(System.currentTimeMillis()-start_time)/1000;
       //check time
        if(start_time==0){
            start_time=System.currentTimeMillis();
        }

        //check cards
        if(check_card==null){
            check_card=(CardView)v;
        }
        else{
           while(true) {
               if (Pair_match(check_card, (CardView) v)) {
                   SearchCard_list(check_card.getFront()).setVisibility(View.INVISIBLE);
                   v.setVisibility(View.INVISIBLE);
                   counter+=1;
                   timer=(TextView)findViewById(R.id.timer);
                   String count= Integer.toString(counter);

                   timer.setText("TIME: "+Long.toString(time));
                   check_card = null;
                   break;

               } else {
                   start_time-=2000;
                   SearchCard_list(check_card.getFront()).setFlipped(false);
                   ((CardView) v).setFlipped(false);

                   check_card = null;
                   break;
               }
           }
           }
        //show alertbox if user finish the game
           if(counter==6){

               AlertDialog.Builder alert=new AlertDialog.Builder(this);

               alert.setTitle("Congratulations!");
               alert.setMessage("YOUR TIME: "+Long.toString(time)+"\n\nYOUR NAME: \n");
               // Set an EditText view to get user input
               final EditText input = new EditText(this);
               alert.setView(input);

               alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int whichButton) {

                           name = input.getText().toString();
                       if(name==null){
                           name="No Name";
                       }
                       Intent sc = new Intent(GameActivity.this, ScoreActivity.class);
                       Bundle extras=new Bundle();
                       extras.putString("Name",name);
                       extras.putLong("Time",time);
                       sc.putExtras(extras);
                       startActivity(sc);
                       GameActivity.this.finish();
                   }
               }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int whichButton) {
                       //Intent main = new Intent(GameActivity.this, MainActivity.class);
                       //startActivity(main);
                       GameActivity.this.finish();
                   }
               });

               final AlertDialog dialog=alert.create();

               dialog.show();
           }

       }

    public boolean Pair_match(CardView a,CardView b)
    {
        for(Pair s:pair_list){
            if((a.getFront()==s.getFirst()&&b.getFront()==s.getSecond())||
                    (a.getFront()==s.getSecond()&&b.getFront()==s.getFirst()))
            {
                return true;
            }
        }
        return false;
    }
// search a arraylist by checking the front page
    protected CardView SearchCard_list(long front){
        for(CardView s:card_list){
            if(s.getFront()==front)
            {
                return s;
            }
        }
        return null;
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


}
