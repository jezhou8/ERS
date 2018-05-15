import java.util.ArrayList;

/**
 * Table.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Table
{
    private ArrayList<Player> players;    
    private ArrayList <Card> tableCards;
    private boolean endRound;

    public Table(ArrayList<Player> p)
    {
        players = p;
        tableCards = new ArrayList<Card>();
        endRound=false;
    }

    public boolean isFace()
    {
        if (tableCards.get(0).getCardValue() > 10)
        {
            endRound=true;
            return true; 
        }
        return false; 
    }

    public boolean getEndRound()
    {
        return endRound;
    }
    
    public void setEndRound(boolean t)
    {
        endRound=t;
    }

    public void endTurn(Player p)
    {
        players.add(players.remove(0));
    }

    public boolean checkPlayer(Player p)
    {
        if (p.equals(players.get(0)))
        {
            return true; 
        }
        return false; 
    }

    public int faceCard(Player currentPlayer, Player nextPlayer)
    {
        endTurn(currentPlayer); 
        if (isFace())
        {
            return tableCards.get(0).getCardValue() - 10; 
        }
        return 1;  
    }

    public void clearTable()
    {
        tableCards = new ArrayList<Card>(0);
    }

    public ArrayList<Card> getTableCards()
    {
        return tableCards;
    }

    public void addCard(Card c)
    {
        tableCards.add(0,c);        
        System.out.println(c);
    }
}
