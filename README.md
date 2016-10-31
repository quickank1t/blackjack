# BLACKJACK
Console based java application wiith databse connectivity (mysql)

# ABOUT GAME
It is just a random balckjack game which i tried to make because i love playing blackjack. Database connective is also there. It keep a track on differnt users, money they have, game wons by individual user, and a record of each and every game played by differnt users along with stake and the result, just to keep the track on house profit or lose situation.

# TECHNOLOGY
-core java<br>
-Mysql with jdbc connectivity

# THERE ARE 5 DIFFERENT CLASSES
<strong>1.BlackJack.java :</strong> it is the main class.It has all the private gobal variables and theirs setters and getters. Along the the actual game flow logic.

<strong>2.Cards.java :</strong> It contains functions such as genrate a random card (as the name suggest it will genrate  random card or basically a number between 1 to 52 which is not there previusly), identify card name (it will identify the name of the card which is genrated randomly ),  get card socre (it will get the score of the card ) check for score (calculate the user score of all his cards ace is valued as 1) , get dealer score (alculate the dealer score ) and also get user socre concidering ace as value 1 (same as check for score);

<strong>3.display.java :</strong> basically used to display to the userinterface in console. It has functions such as player info(it displayes the player info such as name and money), login(ask for credintials such as username password), usercards(at any given point displays all the user cars) and dealercards(at any given point displays the dealrs cards if we pass boolen true then it will hide a card as hole card orelse display if false)

<strong>4.SqlAddUpdate.java :</strong>it has a constructor which will connect to the databse . and all the functions in this class is used to either retrive, update or add into the databse.

<strong>5.dealer.java </strong>It maybe the heart of the program. it has function which the dealers performs in real world. such asdeal cads,ask for stake ,ask for hit or stand , check for blackjack , hit a card to the user etc.

# RESULT
Achived the desire result in 3 days.

# LIVE
I have made similar program in javascript. If you know how to play balckjack you can give this a try. <A HREF="https://quickank1t.github.io/blackjack/" target="_blank">Demo in github</A>
