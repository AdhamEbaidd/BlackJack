package blackjack;
import java.util.Random;
import java.util.Scanner;
public class Game {
    private static Player players[] = new Player[4];



    private Card deck[] = new Card[52];
   private static int highscore=0;
   public void create(){
       players[0]= new Player();
       players[1]= new Player();
       players[2]= new Player();
       players[3]= new Player();
   }
   public void updateScore(int i){
       int scr=0;
       Card cr[]=players[i].getCardarr();
       for(int j = 0 ; j< players[i].getNumberOfCards();j++)
       {
           scr+=cr[j].getValue();

       }
       players[i].setScore(scr);
   }
   public void generateDeck(){
       //create();
     int counter=0;
       for (int i = 0 ; i<4 ;i++)
       {
          for (int j=0 ; j<13;j++){
              int val;
              if(j<=9){val=j+1;}
              else{val=10;}


              deck[counter]= new Card(i,j,val);
              counter++;
          }
       }
   }


    public void updateMax(){
        for (int i=0 ; i<3 ;i++){
            if (players[i].getScore()>21){players[i].setLost(true);}
            if (players[i].getScore()==21){players[i].setBlckJck(true);}
            if (players[i].getScore()>highscore && players[i].getScore()<=21){highscore=players[i].getScore();}
        }
    }
Random rand = new Random();
   Scanner scan= new Scanner(System.in);
   public Card drawCard(){
       int randomChoice;
       while (true){
           randomChoice=rand.nextInt(51);
           if (deck[randomChoice]!=null) {break;}
       }
Card generatedCard = deck[randomChoice];
deck[randomChoice]=null;
updateMax();
return generatedCard;
   }



    public void setInfo(){
create();
       for (int i = 0 ; i <4 ; i++)
       {


           if(i==3){players[3].setName("Dealer");}
           else{
          System.out.printf("Enter player %d name : ",i+1);
               String n = scan.next();
         players[i].setName(n);

           }

           players[i].setCardarr(0,drawCard());
           players[i].setCardarr(1,drawCard());
           players[i].setNumberOfCards(players[i].getNumberOfCards()+2);
           updateScore(i);



         //  int score=(c[0].getValue()+c[1].getValue());
          // players[i].setScore(score);
           //if (players[i].getScore()>21) {players[i].setLost(true);}


       }
        updateMax();
   }
    public Player[] getPlayers() {
        return players;
    }

    public Card[] getDeck() {
        return deck;
    }

    public static int getHighscore() {
        return highscore;
    }
}
