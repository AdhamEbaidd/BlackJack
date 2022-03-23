package blackjack;

import org.w3c.dom.ls.LSOutput;

public class Player {
    private String Name="";
    private int Score=0;
    private Card cardarr[] = new Card[11];

    public void setCardarr(Card[] cardarr) {
        this.cardarr = cardarr;
    }


    private boolean blckJck;
    private boolean lost;
    private int numberOfCards=0;

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public void setNumberOfCards(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }

    public String getName() {
        return Name;
    }

    public int getScore() {
        return Score;
    }

    public Card[] getCardarr() {
        return cardarr;
    }

    public boolean isBlckJck() {
        return blckJck;
    }

    public boolean isLost() {
        return lost;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setScore(int score) {
        Score = score;
    }

    public void setCardarr(int i , Card x) {
        this.cardarr[i]=new Card(x.getSuit(), x.getRank(), x.getValue());

    }

    public void setBlckJck(boolean blckJck) {
        this.blckJck = blckJck;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }


}
