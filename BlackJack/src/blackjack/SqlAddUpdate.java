/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 *
 * @author Ankit
 */
public class SqlAddUpdate {
    
    private Connection connection;
    private Statement statement;
    private ResultSet result;
    
    public SqlAddUpdate(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack", "root", "");
             statement = connection.createStatement();

        }catch(Exception e){
            System.out.println("Error:"+e);
        }
    }

    void getInformation() {
        
        String money="",name="",roundsWon="",roundsPlayed="";
        String getInformationQuery="select * from `useraccounts` where id='1';";
        try{
            result=statement.executeQuery(getInformationQuery);
            while(result.next()){
                money=result.getString("money");
                name=result.getString("name");
                roundsWon=result.getString("roundsWon");
                roundsPlayed=result.getString("handsPlayed");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        int moneyToInt = Integer.parseInt(money);
        int roundsWonToInt = Integer.parseInt(roundsWon);
        int handsPlayedToInt = Integer.parseInt(roundsPlayed);
        
        BlackJack.setMoney(moneyToInt);
        BlackJack.setRoundsWon(roundsWonToInt);
        BlackJack.setHandsPlayed(handsPlayedToInt);
        BlackJack.setName(name);
        
        
    }

    boolean login(String uname, String pass) {
       
       String loginQuery="select * from `useraccounts` where username ='"+uname+"' and password='"+pass+"' ;", id="";
       
        //System.out.println(loginQuery);
       try{
           result=statement.executeQuery(loginQuery);
            while(result.next()){
               id=result.getString("id");
            }
        }catch(Exception e){
                   e.printStackTrace();
        }
       
       
       if(id.isEmpty()){
           return false;
       }
       int idInInt = Integer.parseInt(id);
       BlackJack.setId(idInInt);
       return true;
    }

    void updateMoney(int money) {
        int id= BlackJack.getId();
        String updateMoneyString="update useraccounts set money='"+money+"' where id='"+id+"' ;";
        try{
           statement.executeUpdate(updateMoneyString);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    void updateRoundsPlayed(int roundsPlayed) {
        int id= BlackJack.getId();
        String updateRoundsPlayed="update useraccounts set handsPlayed='"+roundsPlayed+"' where id='"+id+"' ;";
        try{
           statement.executeUpdate(updateRoundsPlayed);
        }catch(Exception e){
            e.printStackTrace();
        }
       
    }

    void addRound() {
       int id,stake,auto_id;
       
       id=BlackJack.getId();
       stake=BlackJack.getStake();
       
       String insertRoundQuery="INSERT INTO `blackjackRounds` (`id`, `playedbyid`, `stake`, `won`) VALUES (NULL, '"+id+"', '"+stake+"', '0');";
       
       try{
           statement.execute(insertRoundQuery,RETURN_GENERATED_KEYS);
           //result=statement.getGeneratedKeys();
           
             result = statement.getGeneratedKeys();
                result.next();
                auto_id = result.getInt(1);
                BlackJack.setGameId(auto_id);

       }catch(Exception e){
           e.printStackTrace();
       }
               
    }

    void updateBlackjackrounds() {
            int alterIncome=BlackJack.getAlterOutcome();
            int stake=BlackJack.getStake();
            String getRoundsWon="UPDATE blackjackrounds SET won='1'";
        if(alterIncome == 0){
               
           }else if(alterIncome == 1){
               getRoundsWon+=" , stake='"+(stake+stake);
           }else if(alterIncome == 2){
               getRoundsWon+=" , stake='"+(stake/2);
           }
            getRoundsWon+=" where id='"+BlackJack.getGameId()+"';";
            
            //System.out.println(getRoundsWon);
            try{
                statement.executeUpdate(getRoundsWon);
            }catch(Exception e){
                e.printStackTrace();
            }
    }

    void updateRoundsWon() {
        int id=BlackJack.getId(),roundsWon=0;
        
        String getRoundsWon="SELECT roundsWon FROM `useraccounts` WHERE id='"+id+"'";
        try{
           result=statement.executeQuery(getRoundsWon);
            while(result.next()){
               roundsWon=Integer.parseInt(result.getString("roundsWon"));
            }
        }catch(Exception e){
                   e.printStackTrace();
        }
        roundsWon++;
        
        String updateroundswonQuery="UPDATE  useraccounts set roundsWon='"+roundsWon+"' where id='"+id+"';";
        try{
           statement.executeUpdate(updateroundswonQuery);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    
}
