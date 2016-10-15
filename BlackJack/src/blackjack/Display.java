/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Ankit
 */
public class Display {

    void playerInfo() {
        
        System.out.println("Name="+BlackJack.getName());
        System.out.println("MoneyLeft="+BlackJack.getMoney());
        
    }

    void login() {
        System.out.println("USERNAME : ");
        System.out.println("PASSWORD : ");
    }

    void userCards() {
        Cards card =new Cards();
        String name=BlackJack.getName();
        System.out.print(name+"'s Cards || || ");
        
        int [] userOneCards =BlackJack.getUserOneCards();
 
        for(int cards : userOneCards ){
            if(cards != 0){
                System.out.print(" "+card.identifyCardName(cards)+" -");
            }
        }
        System.out.println("   Score="+card.getUserScore());
        System.out.println();
        //System.out.println(card.getUserScore());
      
                
    }

    void dealersCard(boolean hidden) {
        Cards card =new Cards();
        int [] dealersCard = BlackJack.getDealersCards();
        int runonce=0;
        System.out.print("Dealers's Cards || || ");
        if(hidden == true){
            runonce=1;
        }
        int score=0;
        for(int cards : dealersCard ){
            if(cards != 0 ){
                if(runonce == 0){
                    score += card.getCardScore(cards);
                    System.out.print(" "+card.identifyCardName(cards)+" -");
                }else if(runonce == 1){
                    score += card.getCardScore(cards);
                    System.out.print(" "+card.identifyCardName(cards)+" -");
                    runonce++;
                }else{
                    System.out.print(" HOLE CARD -");
                }
                
            }
        }
        System.out.println("  Score="+score);
        System.out.println();
        
    }
    
    
    
}
