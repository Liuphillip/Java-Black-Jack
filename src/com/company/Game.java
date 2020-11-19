package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Game {
    private int playerHandValue;
    private int dealerHandValue;
    private int playerHandCount;
    private int dealerHandCount;
    private String[] playerHand;
    private String[] dealerHand;
    private boolean inGame;
    private double bank;
    private Deck deck;
    private double betAmount;

    public Game(int playerHandValue, int dealerHandValue, int handCount, int dealerHandCount) {
        this.playerHandValue = playerHandValue;
        this.dealerHandValue = dealerHandValue;
        this.playerHandCount = handCount;
        this.dealerHandCount = dealerHandCount;
    }
    public Game(){
        setDealerHandCount(2);
        setDealerHandValue(0);
        setPlayerHandCount(2);
        setPlayerHandValue(0);
        setInGame(true);
        setBank(100);
        playerHand = new String[11];
        dealerHand = new String[11];
        deck = new Deck();
        setBetAmount(0);
    }

    public void setBetAmount(double betAmount) {
        this.betAmount = betAmount;
    }

    public void setPlayerHandValue(int playerHandValue) {
        this.playerHandValue = playerHandValue;
    }

    public void setDealerHandValue(int dealerHandValue) {
        this.dealerHandValue = dealerHandValue;
    }

    public void setPlayerHandCount(int handCount) {
        this.playerHandCount = handCount;
    }

    public void setDealerHandCount(int dealerHandCount) {
        this.dealerHandCount = dealerHandCount;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public void setBank(double bank) {
        this.bank = bank;
    }

    public void placeBet(){

        boolean hasNextDouble;
        //double bankAmount = bank;
        //int betAmount;
        Scanner scanner = new Scanner(System.in);
        boolean betIsLessThanZero = true;
        while(betIsLessThanZero){
            System.out.println("Enter bet amount: ");
            hasNextDouble = scanner.hasNextDouble();
            if (hasNextDouble){
                betAmount = scanner.nextDouble();
                bank -= betAmount;

                if(bank < 0){
                    System.out.println("Not Enough Money");
                    bank+=betAmount;
                    continue;
                }
                betIsLessThanZero=false;
            }else{
                System.out.println("Invalid bet amount");
                scanner.nextLine();
            }
        }
    }

    private void dealCards(){
        String first = deck.getRandomCard();
        int firstCardValue = deck.getCardValue(first);
        String second = deck.getRandomCard();
        int secondCardValue = deck.getCardValue(second);

        String dealerFirst = deck.getRandomCard();
        int dealerFirstCardValue = deck.getCardValue(dealerFirst);
        String dealerSecond = deck.getRandomCard();
        int dealerSecondCardValue = deck.getCardValue(dealerSecond);

        playerHand[0] = first;
        playerHand[1] = second;
        playerHandValue += firstCardValue;
        playerHandValue += secondCardValue;

        dealerHand[0] = dealerFirst;
        dealerHand[1] = dealerSecond;
        dealerHandValue += dealerFirstCardValue;
        dealerHandValue += dealerSecondCardValue;


    }



    public void Play(){
        boolean dealersTurn = false;
        String hitOrStay;
        Scanner scanner = new Scanner(System.in);


        while(isInGame()){
            System.out.println("-------------");
            System.out.println("Balance: "+ bank);
            placeBet();
            dealCards();
            //REMEMBER TO RESET HAND VALUES AT END
            //System.out.println("Player hand:" + playerHandValue);
            System.out.println("PLayer Hand:");
            System.out.println(playerHand[0]+playerHand[1]);
            //System.out.println("Dealer hand: " + dealerHandValue);
            System.out.println("Dealer Hand");
            System.out.println(dealerHand[0]+" *");

            while(!dealersTurn){

                while(true){
                    System.out.println("Hit or stay?");
                    //scanner.nextLine();
                    hitOrStay = scanner.next();
                    hitOrStay.toLowerCase(Locale.ROOT);

                    if((hitOrStay.equals("hit")) || (hitOrStay.equals("stay"))){
                        break;
                    }else
                        System.out.println("Invalid entry");
                }

                if(hitOrStay.equals("hit")){
                    //System.out.println("you made it to hit");
                    playerHand[playerHandCount] = deck.getRandomCard();
                    playerHandValue+=deck.getCardValue(playerHand[playerHandCount]);
                    for(int i = 0; i<= playerHandCount; i++){
                        System.out.print(playerHand[i]+" ");
                    }
                    System.out.println(" ");
                    System.out.println("player hand value:"+ playerHandValue);
                    if(playerHandValue>21){
                        System.out.println("BUST");
                        break;
                    }
                    playerHandCount+=1;
                }
                if(hitOrStay.equals("stay")){
                    System.out.println("Dealers turn.");
                    dealersTurn = true;
                    break;
                }

            }
            if(playerHandValue==21){
                System.out.println("You Win!");
                bank += betAmount*1.5;
                continue;
            }

            while(dealersTurn){
                //System.out.println("Dealer hand value" + dealerHandValue);
                System.out.print(dealerHand[0]+" "+dealerHand[1]+ " ");

                for(int i = 2; i<11 ; i++){
                    if(dealerHandValue>16){
                        dealersTurn = false;
                        break;
                    }
                    dealerHand[i] = deck.getRandomCard();
                    System.out.print(dealerHand[i]+" ");
                    dealerHandValue+=deck.getCardValue(dealerHand[i]);
                    if(dealerHandValue<=16){
                        continue;
                    }
                    if(dealerHandValue>16){
                        dealersTurn = false;
                        break;
                    }
                }
                //System.out.println("dealerhand value: "+ dealerHandValue);

                //dealersTurn = false;
                //dealerHandCount +=1;
            }
            //EVALUATE
            System.out.println(" ");
            if(dealerHandValue>21 && playerHandValue < 21){
                System.out.println("You Win!");
                bank += betAmount *1.5;
            }
            if(dealerHandValue<playerHandValue){
                System.out.println("You Win!");
                bank += betAmount *1.5;
            }
            if(dealerHandValue==playerHandValue){
                System.out.println("Tie");
                bank += betAmount;
            }
            if((playerHandValue<dealerHandValue) && (dealerHandValue<21)){
                System.out.println("You Loose");
                //placebet() already takes away bet amount
            }

            setPlayerHandValue(0);
            setDealerHandValue(0);
            setPlayerHandCount(2);
        }
    }



}
