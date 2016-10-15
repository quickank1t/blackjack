/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;

/**
 *
 * @author Ankit
 */
class dealer {

    static void dealCards() {
       
        Cards card = new Cards();
        SqlAddUpdate sql = new SqlAddUpdate();
        int [] inUsedCard =new int [52];
        int [] userOneCards = new int [10];
        int [] dealersCards = new int [10];
        
        int cardno,noOfPlayer,stack,roundsPlayed,money,id;
        stack=BlackJack.getStake();
        money = BlackJack.getMoney();
        money=money-stack;
        roundsPlayed=BlackJack.getHandsPlayed();
        //System.out.println(roundsPlayed);
        //id=BlackJack.getId();
        
        cardno=card.getRandomCard();
        userOneCards[0]=cardno;
        inUsedCard[0]=cardno;
        
        cardno=card.getRandomCard();   
        dealersCards[0]=cardno;
        inUsedCard[1]=cardno;
        
        cardno=card.getRandomCard();
        userOneCards[1]=cardno;
        inUsedCard[2]=cardno;
        
        cardno=card.getRandomCard();   
        dealersCards[1]=cardno;
        inUsedCard[3]=cardno;

        
        BlackJack.setInUseCards(inUsedCard);
        BlackJack.setUserOneCards(userOneCards);
        BlackJack.setDealersCards(dealersCards);
        BlackJack.setMoney(money);
        roundsPlayed++;
        BlackJack.setHandsPlayed(roundsPlayed);
        //System.out.println(roundsPlayed);
        sql.updateMoney(money);
        sql.updateRoundsPlayed(roundsPlayed);
        
        sql.addRound();
        
    }

    static void askForStake() {
        
        Scanner read = new Scanner (System.in);
        int stake,money;
        money = BlackJack.getMoney();
        while(true){
            System.out.println("Please Enter your Stake Amount");
            stake=read.nextInt();
            
            if(money > stake){
                BlackJack.setStake(stake);
                break;
            }else{
                System.out.println("You Dount have Enough money. Please add stack less than "+money+".");
            }
        }
    }

    static void askForHitStandDoubleSurrender() {
        
        Cards card = new Cards();
        Scanner read = new Scanner (System.in);
        Display display =new Display();
        boolean runGame=true;
        while(runGame){
            System.out.println("Press 1 to hit , 2 to stand , 3 to double and 4 to surrender");
            int result = read.nextInt();
            System.out.println("");
        
            switch(result){
            
                case 1:
                    hit();
                    display.userCards();
                    display.dealersCard(true);
                    System.out.println("");
                    break;
                
                case 2:
                    //stand();
                    runGame=false;
                    display.userCards();
                    display.dealersCard(false);
                    break;
                
                case 3:
                    hit();//increse outcome money
                    display.userCards();
                    BlackJack.setAterOutcome(1);
                    display.dealersCard(false);
                    runGame=false;
                    break;
                
                case 4:
                    runGame=false;
                    break;
                    
                default:System.out.println("TRY AGAIN");
            }
            
            int score =card.getUserScore();
            //System.out.println(score);
            if(score > 22){
                runGame=false;
                //System.out.println("BUSTED");
            }
            //System.out.println(card.getUserScore());
        }
        
    }

    private static void hit() {
        Cards card = new Cards();
        int [] inUseCards= BlackJack.getInUseCards();
        int [] userOneCards =BlackJack.getUserOneCards();
        int counterOfInusedcards=0,counterOfuserscard=0;
        
        for(int totalCards : inUseCards){
            if(totalCards != 0){
                counterOfInusedcards++;
            }else{
                break;
            }
        }
        
        for(int usercards : userOneCards){
            if(usercards != 0){
                counterOfuserscard++;
            }else{
                break;
            }
        }
        
        int newCard;
        newCard=card.getRandomCard();
        
        inUseCards[counterOfInusedcards]=newCard;
        userOneCards[counterOfuserscard]=newCard;
        
        BlackJack.setInUseCards(inUseCards);
        BlackJack.setUserOneCards(userOneCards);
        
    }

    static void dealersMove() {
        Cards card = new Cards();
        Display display =new Display();
        int [] inUseCards= BlackJack.getInUseCards();
        int [] dealersCard = BlackJack.getDealersCards();
        
        int counterOfInusedcards=0,counterOfdealerscard=0;
        
         for(int totalCards : inUseCards){
            if(totalCards != 0){
                counterOfInusedcards++;
            }else{
                break;
            }
        }
        
        for(int usercards : dealersCard){
            if(usercards != 0){
                counterOfdealerscard++;
            }else{
                break;
            }
        }
        
        int newCard,userscore,dealersscore;
        boolean skip=false;
        userscore=card.getUserScore();
        dealersscore=card.getDealersScore();
        
        if(dealersscore > userscore){
            skip=true;
        }
        while(!skip){
            
            newCard=card.getRandomCard();
            inUseCards[counterOfInusedcards++]=newCard;
            dealersCard[counterOfdealerscard++]= newCard;
            BlackJack.setDealersCards(dealersCard);
            BlackJack.setInUseCards(inUseCards);
            
            if(card.getDealersScore() > card.getUserScore()){
                display.dealersCard(false);
                break;
            }
        }
        
        
    }

    static void checkWhoWon() {
       Cards card = new Cards();
       SqlAddUpdate sql =new SqlAddUpdate();
       int userscore,dealersScore,stake,money,alterIncome;
       stake=BlackJack.getStake();
       money=BlackJack.getMoney();
       userscore=card.getUserScore();
       alterIncome=BlackJack.getAlterOutcome();//0 if no 1 if double 2 if half 
       dealersScore=card.getDealersScore();
       
       if(alterIncome == 0){
           money=money+stake+stake;
       }else if(alterIncome == 1){
           money=money+stake+stake+stake; 
           stake=stake+stake;
       }else if(alterIncome == 2){
           money=money+stake+(stake/2);
           stake=stake/2;
       }
       
       if(dealersScore < 22){
           if(dealersScore > userscore){
                System.out.println("Sorry you lost");   
           }else{
               if(userscore < 22){
                   //sSystem.out.println("Sorry you lost");
                   System.out.println("");
               }else{
                   System.out.println("DCongratz you won"+stake+". Your balance is now "+money+".");
                    sql.updateBlackjackrounds();
                    sql.updateMoney(money);
                    BlackJack.setMoney(money);
                    sql.updateRoundsWon();
               }
               
           }
           
       }else{
           System.out.println("Dealer busted you won"+stake+". Your balance is now "+money+".");
               sql.updateBlackjackrounds();
               sql.updateMoney(money);
               BlackJack.setMoney(money);
               sql.updateRoundsWon();
       }
       
    }

    static boolean checkForBlackJack(int i) {//1 for user 2 for dealer
        Cards card = new Cards();
        int  score=0;
        if(i == 1){
            score = card.getUserScore();
        }else{
            score = card.getDealersScore();
        }
        
        
        if(score == 21){
            return true;
        }
         return false;
            
    }
    
}
