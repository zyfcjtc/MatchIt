package ca.gbc.mobile.yafanzhang.matchit;

import java.util.ArrayList;

/**************************************************
 * Yafan Zhang
 * 100816652
 * created: 10/6/2014
 * lastEdit: 10/10/2014
 **************************************************/
public class Deck {
    ArrayList<Pair> deck = new ArrayList<Pair>();
    Pair a=new Pair(R.drawable.card1,R.drawable.carda);
    Pair b=new Pair(R.drawable.card2,R.drawable.cardb);
    Pair c=new Pair(R.drawable.card3,R.drawable.cardc);
    Pair d=new Pair(R.drawable.card4,R.drawable.cardd);
    Pair e=new Pair(R.drawable.card5,R.drawable.carde);
    Pair f=new Pair(R.drawable.card6,R.drawable.cardf);
    Pair g=new Pair(R.drawable.card7,R.drawable.cardg);
    Pair h=new Pair(R.drawable.card8,R.drawable.cardh);
    Pair i=new Pair(R.drawable.card9,R.drawable.cardi);
    Pair j=new Pair(R.drawable.card10,R.drawable.cardj);
    Pair k=new Pair(R.drawable.card11,R.drawable.cardk);
    Pair l=new Pair(R.drawable.card12,R.drawable.cardl);
    Pair m=new Pair(R.drawable.card13,R.drawable.cardm);
    Pair n=new Pair(R.drawable.card14,R.drawable.cardn);
    Pair o=new Pair(R.drawable.card15,R.drawable.cardo);
    Pair p=new Pair(R.drawable.card16,R.drawable.cardp);
    Pair q=new Pair(R.drawable.card17,R.drawable.cardq);
    Pair r=new Pair(R.drawable.card18,R.drawable.cardr);
    Pair s=new Pair(R.drawable.card19,R.drawable.cards);
    Pair t=new Pair(R.drawable.card20,R.drawable.cardt);
    Pair u=new Pair(R.drawable.card21,R.drawable.cardu);

    public Deck(){
        deck.add(a);
        deck.add(b);
        deck.add(c);
        deck.add(d);
        deck.add(e);
        deck.add(f);
        deck.add(g);
        deck.add(h);
        deck.add(i);
        deck.add(j);
        deck.add(k);
        deck.add(l);
        deck.add(m);
        deck.add(n);
        deck.add(o);
        deck.add(p);
        deck.add(q);
        deck.add(r);
        deck.add(s);
        deck.add(t);
        deck.add(u);

    }
    public ArrayList<Pair> getDeck() {
        return deck;
    }

}
