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

public class BlackJack {
    private static String database, password;
    
    public static void setDatabase(String db){
        database = db;
    }
    
    public static void setPassword(String pass){
        password = pass;
    }
    
    public static String getDatabaseName(){
        System.out.println(database);
        return database;
    }
    
    public static String getPassword(){
        return password;
    }

    public static int[] getInUseCards() {
        return inUseCards;
    }

    public static void setInUseCards(int[] inUseCards) {
        BlackJack.inUseCards = inUseCards;
    }

    public static int[] getDealersCards() {
        return dealersCards;
    }

    public static void setDealersCards(int[] dealersCards) {
        BlackJack.dealersCards = dealersCards;
    }

    public static int[] getUserOneCards() {
        return userOneCards;
    }

    public static void setUserOneCards(int[] userOneCards) {
        BlackJack.userOneCards = userOneCards;
    }

    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public static void setNumberOfPlayers(int numberOfPlayers) {
        BlackJack.numberOfPlayers = numberOfPlayers;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        BlackJack.name = name;
    }

    public static int getMoney() {
        return money;
    }

    public static void setMoney(int money) {
        BlackJack.money = money;
    }

    public static int getRoundsWon() {
        return roundsWon;
    }

    public static void setRoundsWon(int roundsWon) {
        BlackJack.roundsWon = roundsWon;
    }

    public static int getHandsPlayed() {
        return handsPlayed;
    }

    public static void setHandsPlayed(int handsPlayed) {
        BlackJack.handsPlayed = handsPlayed;
    }
    

    public static int getGameId() {
        return gameId;
    }

    public static void setGameId(int gameId) {
        BlackJack.gameId = gameId;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        BlackJack.id = id;
    }
    
    public static int getStake() {
        return stake;
    }

    public static void setStake(int stake) {
        BlackJack.stake = stake;
    }
        
    
    
    private static int [] inUseCards = new int [52];
    private static int [] dealersCards = new int [10];
    private static int [] userOneCards = new int [10];
    private static int numberOfPlayers , money , roundsWon , handsPlayed , stake ,gameId , id , alterOutcome ,insurance ;//one player for now

    public static int getAlterOutcome() {
        return alterOutcome;
    }

    public static void setAterOutcome(int alterOutcome) {
        BlackJack.alterOutcome = alterOutcome;
    }
    private static String name;
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        //int [] inUseCards = {1,2,3,4 } ;
        
        Cards cards = new Cards ();
        SqlAddUpdate sql = new SqlAddUpdate();
        Display display = new Display();
        Scanner read = new Scanner(System.in);
        int emptyArray [] = new int [10];
        int inuseEmpty [] =new int [52];
        //String cardName = cards.identifyCardName(14);
        //System.out.println("Card="+cardName);
//        for(int i=1;i<53;i++){
//            System.out.println(cards.identifyCardName(i)+"-"+cards.getCardScore(i));
//        }
        while(true){
            System.out.print("USERNAME : ");
            String uname = read.next();
            //System.out.println("");
            System.out.print("PASSWORD : ");
            String pass = read.next();
            if(sql.login(uname,pass)){
                break;   
            }else{
                System.out.println("Please try again");
            }
        }
        boolean blackjack;
        sql.getInformation();
        display.playerInfo();
        System.out.println("");
        
        dealer.askForStake();
        while(true){
            //THE DEALER GIVE  CARDS
            blackjack=false;
            setAterOutcome(0);
            setDealersCards(emptyArray);
            setUserOneCards(emptyArray);
            setInUseCards(inuseEmpty);
            
            System.out.println("");
            dealer.dealCards();
                    
            display.userCards();
            display.dealersCard(true);
            if(dealer.checkForBlackJack(1)){
                if(dealer.checkForBlackJack(2)){
                    //draw
                }else{
                    blackjack=true;
                }
            }
            if(!blackjack){
                dealer.askForHitStandDoubleSurrender();
                if(cards.getUserScore() < 22){
                    dealer.dealersMove();
                    dealer.checkWhoWon();
                }else{
                    System.out.println("Busted");
                }
            }else{
                sql.updateBlackjackrounds();
                money=money+stake+stake;
                sql.updateMoney(money);
                BlackJack.setMoney(money);
                sql.updateRoundsWon();
                System.out.println("BLACKJACK!!");
            }
 
            
            System.out.println("press 1 Continue");
            if(read.nextInt() == 1){
                continue;
            }
            break;
        }   
    }
}
