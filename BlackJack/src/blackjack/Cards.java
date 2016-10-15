/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Random;

/**
 *
 * @author Ankit
 */
class Cards {

    int getRandomCard( ) {
        int [] inUseCards= BlackJack.getInUseCards();
       Random random = new Random();
       int number=0 ;
       boolean changeCard;
       while(true){
           changeCard=false;
           number = random.nextInt(52)+ 1;
       
           for(int ex : inUseCards){
               if(number == ex){
                   changeCard=true;
               }
            }
           if(changeCard == true){
               continue;
           }
           break;
       }
      return number;
    }

    String identifyCardName(int num) {
        String name="";
        int cardSuit , cardNumber;
        
        cardSuit = num / 13;
        //System.out.println(cardSuit);
        
        cardNumber = num % 13 ;
        //System.out.println(cardNumber);
        if( cardNumber == 0){
            cardSuit--;
        }
        
        switch (cardSuit) {
            case 0:
                name="Club of";
                //System.out.println("Clubs ");
                break;
            case 1:
                name="Diamond of";
                //System.out.println("Diamonds");
                break;
            case 2:
                name="Heart of";
                //System.out.println("Hearts");
                break;
            case 3:
                name="Spade of";
                //System.out.println("Spades");
                break;
            default:
                break;
        }
        
        if(cardNumber < 11 && cardNumber != 0){
            name+=" "+cardNumber;
            //System.out.println(cardNumber);
        }else if (cardNumber == 11){
            name+=" Jack";
            //System.out.println("Jack");
        }else if (cardNumber == 12){
            name+=" Queen";
            //System.out.println("Queen");
        }else if (cardNumber == 0){
            name+=" King";
            //System.out.println("King");
        }
        return name;
    }

    int getCardScore(int num) {
        int score=0,cardNumber;
        cardNumber = num % 13 ;
        if(num != 0){
            if(cardNumber == 0){
                score=10;
            }else if(cardNumber == 1){
                score=11;
            }else if(cardNumber < 11){
                score=cardNumber;
            }else{
                score=10;
            }
        }
        
        //System.out.println(score);
        return score;
    }

    boolean checkForScore() {
        int [] userOneCards =BlackJack.getUserOneCards();
        int score=0;
        for(int usercards : userOneCards ){
            System.out.println(usercards);
            if(usercards != 0){
                score = usercards + score ;
            }else{
                break;
            }
        }
        
        System.out.println(score);
        return score > 22;
    }
       
    int getUserScore(){//ace as 11
        int [] userOneCards =BlackJack.getUserOneCards();
        int score=0;
        for(int usercards : userOneCards ){
            score += getCardScore(usercards);
        }
        return score;
    }
    
    int getUserScoreAceas1(){//ace as 1
        int [] userOneCards =BlackJack.getUserOneCards();
        int score=0,card;
        for(int usercards : userOneCards ){
            card=getCardScore(usercards);
            if(card == 11){
                score +=  1;
            }else{
                score += card;
            }
        }
        return score;
    }
    
    int getDealersScore(){
        int [] dealersCard = BlackJack.getDealersCards();
        int score=0;
        for(int usercards : dealersCard ){
            score += getCardScore(usercards);
        }
        return score;
    }
}
