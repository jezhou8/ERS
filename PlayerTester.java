import java.util.ArrayList;
/**
 * PlayerTester.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class PlayerTester
{

    public static void main (String [] args){ //burncard
       Deck d=new Deck();
       Hand h=new Hand();
       Rules r=new Rules();
       Card c=new Card(1);
       ArrayList<Player> p=new ArrayList<Player>(3);
       Table t =new Table(p);
       Player p1=new Player(true, "1");
       Player p2=new Player(false, "2");
       Player p3=new Player(false, "3");
       p.add(p1);
       p.add(p2);
       p.add(p3);
       d.shuffleDeck();
       p1.setPlayerKey("w");
       System.out.println("set and get method for playerKey output: "+p1.getPlayerKey());
       System.out.println("getName() output: "+p1.getName());
       for (int i=0; i<52; i++){
           c=d.getDeck().get(i);
           h.addCardToHand(c);
           p1.playCard(t);
           System.out.println("Number of Plays: "+p1.getPlays());
        }
        p1.setPlays(3);
        System.out.println("New number of plays: "+p1.getPlays());
        System.out.println("before slap method: "+h.getHand());
       if (p1.getPlays()==1){
           p1.slapCard(t,r);
           System.out.println("after slap method: "+h.getHand());
        }
    }
}
