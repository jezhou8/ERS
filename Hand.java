import java.util.ArrayList;
/**
 * Hand.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Hand
{
    private ArrayList<Card> hand;
    private boolean outcome=false;
    public Hand()
    {
        hand=new ArrayList<Card>();
    }
    
    public void addCardToHand(Card c)
    {
        hand.add(0,c);
    }
    
    public boolean checkWin(Shoe s)
    {
        if (hand.size()==s.getinitialShoeSize())
            return true;
        return false;
    }
    
    public ArrayList<Card> getHand(){
        return hand;
    }
    
    public String toString()
    {
        String a="";
        for(Card c: hand)
        {
            a+="\n"+c;
        }
        return a;
    }
}
