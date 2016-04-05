package ca.gbc.mobile.yafanzhang.matchit;

import java.util.Comparator;

/**
 * Created by yafanzhang on 14-10-20.
 */
public class Player {
    String name;
    long time;
    long id;
    Player(){

    }
    Player(String name, long time){
        this.name=name;
        this.time=time;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name){this.name=name;}
    public String getName(){
        return name;
    }
    public void setTime(long time){this.time=time;}
    public long getTime(){return time;}
    public String getTimeString(){
        return Long.toString(time);
    }

}
class CustomComparator implements Comparator<Player> {
    @Override
    public int compare(Player lhs, Player rhs) {
        if(lhs.getTime()<rhs.getTime()){
            return -1;
        }else if(lhs.getTime()==rhs.getTime()){
            return 0;
        }else{
            return 1;
        }
    }
}
