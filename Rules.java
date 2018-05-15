import java.util.Scanner;

/**
 * Rules.java  
 *
 * @author: Joel Slaby
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Rules
{
    public final String SANDWICHLETTER="a";
    public final String PAIRLETTER="b";
    public final String JOKERLETTER="c";
    public final String TOPBOTTOMLETTER="d";
    public final String TENSLETTER="e";
    public final String MARRIAGELETTER="f";
    public final String FOURINAROWLETTER="g";
    boolean sandwhich, pair, joker, topBottom, tens, marriage, fourInaRow;

    public Rules()
    {
        System.out.println(possibleRules());
        Scanner scan=new Scanner(System.in);
        System.out.println("Please enter which rules you would like to use as a concatenated String:");
        String a = scan.nextLine();
        while(!a.contains("a") && !a.contains("b") && !a.contains("c") && !a.contains("d") && !a.contains("e") && !a.contains("f") && !a.contains("g"))
        {
            System.out.println("Please enter a valid String");
            a = scan.nextLine();
        }
        enableRules(a);
    }

    public String possibleRules()
    {
        return "\nThe possible rules are:\nSandwhich=a\nPair=b\n";
    }

    public void enableRules(String s)
    {
        if(s.contains(SANDWICHLETTER))
            sandwhich=true;
        else
            sandwhich=false;
        if(s.contains(PAIRLETTER))
            pair=true;
        else
            pair=false;   
        if(s.contains(JOKERLETTER))
            pair=true;
        else
            pair=false; 
        if(s.contains(TOPBOTTOMLETTER))
            pair=true;
        else
            pair=false; 
        if(s.contains(TENSLETTER))
            pair=true;
        else
            pair=false; 
        if(s.contains(MARRIAGELETTER))
            pair=true;
        else
            pair=false; 
        if(s.contains(FOURINAROWLETTER))
            pair=true;
        else
            pair=false; 
    }

    public String toString()
    {
        String a="\nThe current rules are:\n";
        if(sandwhich)
            a+="Sandwhich\n";
        if(pair)
            a+="Pair\n";
        return a;
    }

    public boolean checkSlap(Table t)
    {
        boolean slap=false;
        if(sandwhich)
        {
            if(t.getTableCards().get(t.getTableCards().size()-1).getRank().equals(t.getTableCards().get(t.getTableCards().size()-3).getRank()))
            {
                slap=true;
            }
        }
        if(pair)
        {
            if(t.getTableCards().get(t.getTableCards().size()-1).getRank().equals(t.getTableCards().get(t.getTableCards().size()-2).getRank()))
            {
                slap=true;
            }
        }
        return slap;
    }
}