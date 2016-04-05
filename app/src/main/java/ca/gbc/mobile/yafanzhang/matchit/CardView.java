package ca.gbc.mobile.yafanzhang.matchit;

import android.content.Context;
import android.content.res.TypedArray;
import android.media.Image;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ImageView;

import android.os.Handler;
import java.util.logging.LogRecord;

/**************************************************
 * Yafan Zhang
 * 100816652
 * created: 10/4/2014
 * lastEdit: 10/11/2014
 **************************************************/
public class CardView extends ImageView{

    private long Image = R.drawable.back;
    private long Front;
    private boolean flipped=false;
    final Handler handler=new Handler();
    public CardView(Context context){
        super(context);
    }
    public CardView(Context context,AttributeSet attrs){
        super(context, attrs);
        update();
    }
    private void update(){
        if (flipped) {
            setImageResource((int)Front);
        }
        else setImageResource((int)Image);
    }


    public void flip(){
        flipped=!flipped;
        update();

    }

    public long getFront() {
        return Front;
    }

    public void setFront(long Front) {
        this.Front = Front;
        update();
    }

    public long getImage() {
        return Image;
    }

    public void setImage(long Image) {
        this.Image = Image;
        update();
    }

    public boolean isFlipped() {
        return flipped;
    }

    public void setFlipped(boolean flipped) {
        this.flipped = flipped;
        update();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getActionMasked();
        if (action==MotionEvent.ACTION_DOWN){
            setFlipped(true);
            update();
        }

        return super.onTouchEvent(event);
    }


}
