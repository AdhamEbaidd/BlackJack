package blackjack;
import java.util.Scanner;




public class BlackJack {



   public static Game game=new Game();
   public static Scanner scan = new Scanner(System.in);

    static Player players[]=  game.getPlayers();
   /* public static void hitOrStand(){

}*/

   /* public static void dealer() {

    }*/
public static int whoWon(){
        boolean push=false;
        int player1=7;
        game.updateMax();
        for (int i = 0 ; i < 3 ; i++) {
            if (players[i].getScore() == game.getHighscore()) {
                player1 = i;

                for (int j = 0; j < 3; j++) {

                    if (players[j].getScore() == game.getHighscore() && j != i) {
                        push = true;

                    }

                }

                break;

            }



        }
    if(push==true || player1==7){return 5;}
    else{return player1;}

}

    public static void main (String[] args){
        GUI gui = new GUI();
        game.create();
        game.generateDeck();
        game.setInfo();
        gui.runGUI( game.getDeck(), players[0].getCardarr(),players[1].getCardarr(), players[2].getCardarr(), players[3].getCardarr() );
        System.out.printf("the highscore is %d \n",game.getHighscore());
        //hitOrStand();



        for (int i = 0 ; i <3 ;i++)
        {int choice=0;
            //System.out.println("hello");
            //System.out.println(game.players[i].getName());
            Card cr[]= players[i].getCardarr();

            while (true) {
                //  System.out.printf("Your score is: %d \n",game.players[i].getScore());
                /*for (int k=0 ; k<game.players[i].numberOfCards;k++)
                {
                    System.out.println(cr[k].getValue());
                }*/


                //hit or stand
                if (players[i].getScore()>21) {
                    System.out.println("Bust!");
                    game.updateMax();
                    break;
                } else if (players[i].getScore()==21) {
                    System.out.println("Black jack!!!");
                    players[i].setBlckJck(true);
                    break;
                } else {
                    System.out.println("do you want to:");
                    System.out.println("1-hit");
                    System.out.println("2-stand");
                    choice=scan.nextInt();
                    Card test= game.drawCard();
                    if (choice==1){ players[i].setCardarr(players[i].getNumberOfCards(), test);players[i].setNumberOfCards(players[i].getNumberOfCards()+1);
                        game.updateScore(i); game.updateMax();
                        gui.updatePlayerHand(test, i);

                    }
                    else if (choice==2) { game.updateMax();break;}
                    else {break;}
                }
            }


        }




//dealer()



        game.updateMax();

        System.out.printf("the highscore is %d \n",game.getHighscore());

        if (players[3].getScore() > game.getHighscore() && players[3].getScore() <= 21) {
            System.out.println("Dealer wins");
            System.out.printf("dealer scored %d \n", players[3].getScore());

        } else if (players[3].getScore() > 21) {
            System.out.println("dealer is bust");
            System.out.printf("dealer scored %d \n", players[3].getScore());

            int dec = whoWon();
            if (dec == 5) {
                System.out.println("push!");
            } else {
                System.out.printf("%S won! \n", players[dec].getName());
            }

        }
        else {
            boolean loop = true;
            while(loop){
                Card test1= game.drawCard();
                players[3].setCardarr(players[3].getNumberOfCards(),test1 );
                players[3].setNumberOfCards(players[3].getNumberOfCards()+1);

                gui.updateDealerHand(test1, game.getDeck());
                game.updateScore(3);
                game.updateMax();

                if (players[3].getScore() > game.getHighscore() && players[3].getScore() <= 21) {
                    System.out.println("Dealer wins");
                    System.out.printf("dealer scored %d \n", players[3].getScore());
                    loop=false;
                    break;

                }

                else if (players[3].getScore() > 21) {
                    System.out.println("dealer is bust");
                    System.out.printf("dealer scored %d \n", players[3].getScore());

                    int dec = whoWon();
                    if (dec == 5) {
                        System.out.println("push!");
                    } else {
                        System.out.printf("%S won! \n", players[dec].getName());
                        System.out.printf("the wining score is %d ",game.getHighscore());
                    }
                    loop=false;
                }

            }


        }







    }
}
