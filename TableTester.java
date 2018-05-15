import java.util.ArrayList;
/**
 * TableTester.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class TableTester
{
    public static void main (String[] args){
    ArrayList<Player> list = new ArrayList<Player>();
    ArrayList <Card> tableCards = new ArrayList <Card>();
    Table t = new Table(list); 
    Card c1=new Card(0);
    Card c2=new Card(0);
    t.addCard(c1);
    t.addCard(c2); 
    t.isFace(c1);
    Player p1 = new Player(true, "one");
    Player p2 = new Player(false, "two");
    t.endTurn(p1);
    t.checkPlayer(p1);
    t.checkPlayer(p2);
    t.faceCard(c1, p1, p2);
    Card c3 = new Card(0);
    t.addCard(c3);
    t.getTableCards();
    t.faceCard(c1, p1 ,p2); 
}
}
