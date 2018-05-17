
/**
 * Represents a single playing card from a deck of cards.In particular
 * the card's methods have been defined to support the implmentation
 * of a blackjack game.
 * 
 * @author Jerry Zhou
 * @version March 2018
 */
public class Card
{
    private String suit;
    private int value;
    private String rank;
    
    /** 
     * Takes a number between 0 and 51 and converts it to a unique
     * card from a standard 52 card deck. Note, this is NOT random.
     * The same number will always generate the same card. Correct
     * use of this constructor for a Deck would be call it 52 times
     * passing it a unique number each time. 
     * @ precondition: 0 <= card < 52
     * @ param an integer between 0 and 51
     * @author David Gumminger
     * @version March 2018  
     */
    public Card (int card)
    {
        int temp1 = card % 4;
        if (temp1 == 0)
            suit = "H";
        else if (temp1 == 1)
            suit = "S";
        else if (temp1 == 2)
            suit = "D";
        else
            suit = "C";
        temp1 = (card / 4) % 13;
        if (temp1 == 0){
            rank = "A";
            value = 14;}
        else if (temp1 == 1){
            rank = "2";
            value = 2;}
        else if (temp1 == 2){
            rank = "3";
            value = 3;}
        else if (temp1 == 3){
            rank = "4";
            value = 4;}
        else if (temp1 == 4){
            rank = "5";
            value = 5;}
        else if (temp1 == 5){
            rank = "6";
            value = 6;}
        else if (temp1 == 6){
            rank = "7";
            value = 7;}
        else if (temp1 == 7){
            rank = "8";
            value = 8;}
        else if (temp1 == 8){
            rank = "9";
            value = 9;}
        else if (temp1 == 9){
            rank = "10";
            value = 10;}
        else if (temp1 == 10){
            rank = "J";
            value = 11;}
        else if (temp1 == 11){
            rank = "Q";
            value = 12;}
        else{
            rank = "K";
            value = 13;}
    }
    /**
     * Determines if the given card is an Ace
     * @return True if the card is an Ace. False otherwise
     * @author David Gumminger
     * @version March 2018  
     */
    public boolean isAce()
    {
        return rank.equals("Ace");
    }
    /**
     * Produces a string that contains the card's rank and suit
     * @return string with card's rank and suit (e.g. Ace of Hearts)
     * @author David Gumminger
     * @version March 2018  
     */
    public String toString()
    {
        return value+suit;  
    }
    /**
     * Get the cards value for a game of Blackjack
     * @return int between 1 and 11
     * @author David Gumminger
     * @version March 2018  
     */
    public int getCardValue()
    {
        return value;
    }
    
    public String getRank()
    {
        return rank;
    }    
    
}
