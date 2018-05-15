import java.util.Scanner;
import java.util.ArrayList;

/**
 * Game.java  
 *
 * @author: Jessica Shen
 * 
 * Brief Program Description:
 * 
 *
 */
public class Game
{
    public static void main (String[] args)
    {
        UsingKeys app=new UsingKeys();
        //int width = Integer.parseInt(args[0]);
        //int height = Integer.parseInt(args[1]);
        int width=500;
        int height=500;

        app.debug(width,height);

        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to a new game of Egyptian Rat Screw!");
        System.out.println("Please enter the number of decks you would like to start out with: ");
        int numDecks=sc.nextInt();
        Shoe shoe1 = new Shoe(numDecks); 
        shoe1.shuffleShoe();
        System.out.print("Please enter the number of players you have: ");
        int numPlayers=sc.nextInt();
        ArrayList <Player> allPlayers=new ArrayList <Player> ();
        ArrayList <String> allKeys=new ArrayList <String> ();
        boolean game=true;

        while (numPlayers<2)
        {
            System.out.println("You need at least 2 players. Please a value greater than 2: ");
            numPlayers=sc.nextInt();
        }
        for (int i=1; i<=numPlayers; i++)
        {
            boolean check=false;
            System.out.print("Please enter the name of the player: ");
            Scanner scan=new Scanner(System.in);
            String name=scan.nextLine();
            Player p;
            if(i==1)
            {
                p=new Player(true, name);
            }
            else
            {
                p=new Player(false, name);
            }
            allPlayers.add(p);
            System.out.print("Please enter which key player "+p.getName()+ " will press to slap the deck (letters only): ");
            String key=scan.nextLine();
            //2 people ccan't select same char
            p.setPlayerKey(key);
        }
        Table t1=new Table(allPlayers);
        Rules r1=new Rules();

        int pos=0;
        while(shoe1.getNumCardsInShoe()>0)
        {
            allPlayers.get(pos).getHand().addCardToHand(shoe1.dealCard());
            pos++;            
            if(pos==allPlayers.size())
            {
                pos %= allPlayers.size();
            }
        }

        boolean end=true;
        boolean winner=false;

        while(!winner)
        {
            end=true;
            System.out.println("New Round");
            while(end)
            {
                if(allPlayers.get(0).getHand().getHand().size()==0)
                {
                    t1.endTurn(allPlayers.get(0));
                }

                System.out.println("It is "+allPlayers.get(0).getName()+"'s turn");
                Scanner scan2=new Scanner(System.in);
                String playing = scan2.nextLine();

                while(!playing.equals(allPlayers.get(0).getPlayerKey()))
                    playing = scan2.nextLine();
                allPlayers.get(0).playCard(t1); //current player plays card

                if(t1.isFace())
                {
                    for(Player p: allPlayers)
                    {
                        p.setCollect(false);
                    }
                    allPlayers.get(0).setCollect(true);
                }

                //sets next player's number of plays
                if(allPlayers.get(0).getPlays()>=1 || (allPlayers.get(0).getPlays()==0 && t1.getEndRound()))
                {
                    if(t1.isFace())
                    {                        
                        allPlayers.get(1).setPlays(t1.faceCard(allPlayers.get(0), allPlayers.get(1)));
                    }
                    else if(allPlayers.get(0).getPlays()==0)
                    {
                        end=false;                                               
                        for(int i=0; i<allPlayers.size(); i++)
                        {
                            if(allPlayers.get(i).getCollect())
                            {
                                allPlayers.get(i).collectCards(t1);
                            }
                        }
                        //allPlayers.get(allPlayers.size()-1).collectCards(t1);
                        //System.out.println(allPlayers.get(allPlayers.size()-1).getHand());
                    }                
                }
                else
                {                    
                    allPlayers.get(1).setPlays(t1.faceCard(allPlayers.get(0), allPlayers.get(1)));
                }

            }
            for(Player p: allPlayers)
            {
                //p.setPlays(0);
                System.out.println(p);
            }
            t1.setEndRound(false);

            if(allPlayers.size()==1)
            {
                winner=true;
                System.out.println("Player "+allPlayers.get(0).getName()+" is the winner!");
            }
        }

    }

}
