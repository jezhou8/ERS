
/**
 * Player.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Player
{
    private int nbrOfPlays;
    private Hand hand;
    private String name;
    private String playerKey;
    private boolean collect;

    public Player(boolean check, String n)
    {
        if(check)
            nbrOfPlays=1;
        else
            nbrOfPlays=0;
        hand=new Hand();
        name=n;
        playerKey="";
        collect=false;        
    }
    
    public boolean getCollect()
    {
        return collect;
    }

    public void setCollect(boolean b)
    {
        collect=b;
    }
    
    public String getPlayerKey()
    {
        return playerKey;
    }

    public void setPlayerKey(String s)
    {
        playerKey=s;
    }

    public Hand getHand()
    {
        return hand;
    }

    public String getName()
    {
        return name;
    }

    public void playCard(Table t){
        t.addCard(hand.getHand().remove(0));
        nbrOfPlays--;
    }

    public int getPlays(){
        return nbrOfPlays;
    }

    public void setPlays(int s)
    {
        nbrOfPlays=s;
    }

    public void slapCard(Table t, Rules r){ 
        if (r.checkSlap(t)){
            collectCards(t);
        }
        else{
            burnCard(t);
        }
    }

    public void collectCards (Table table){ //modify based on hand class     
        for (int i=table.getTableCards().size()-1; i>0; i--)
        {
            hand.getHand().add(table.getTableCards().get(i));   
        }
    }

    public void burnCard (Table table){ //modify based on hand class
        table.addCard(hand.getHand().remove(0));
    }

    public String toString()
    {
        return "Player name is: "+name+"\n nbr of plays is: "+nbrOfPlays;
    }

}

