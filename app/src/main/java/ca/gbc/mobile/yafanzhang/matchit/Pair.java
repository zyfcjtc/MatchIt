package ca.gbc.mobile.yafanzhang.matchit;

/**************************************************
 * Yafan Zhang
 * 100816652
 * created: 10/6/2014
 * lastEdit: 10/10/2014
 **************************************************/
public class Pair {
    long First;
    long Second;
    Pair(long first,long second){
        this.First=first;
        this.Second=second;
    }
    public void setFirst(long First){
        this.First=First;
    }
    public long getFirst()
    {
        return First;
    }
    public void setSecond(long Second){
        this.Second=Second;
    }
    public long getSecond()
    {
        return Second;
    }
}
