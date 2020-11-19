package com.company;

import java.util.Random;

public class Deck {
    private String[] cards = {"A\u2664","A\u2661","A\u2662","A\u2667","2\u2661","2\u2662","2\u2667","2\u2664","3\u2661","3\u2662","3\u2667",
            "3\u2664","4\u2661","4\u2662","4\u2667","4\u2664","5\u2661","5\u2662","5\u2667","5\u2664","6\u2661","6\u2662","6\u2667","6\u2664","7\u2661","7\u2662","7\u2667",
            "7\u2664","8\u2661","8\u2662","8\u2667","8\u2667","9\u2667","9\u2664","9\u2661","9\u2661","10\u2664","10\u2661","10\u2662","10\u2667",
            "J\u2664","J\u2661","J\u2662","J\u2667","Q\u2664","Q\u2661","Q\u2662","Q\u2667","K\u2664","K\u2661","K\u2662","K\u2667"};
    private String[] cardValue = {"A","A","A","A","2","2","2","2","3","3","3","3","4","4","4","4","5","5","5","5","6","6","6","6","7","7","7","7","8","8","8","8","9","9","9","9",
            "10","10","10","10",
            "10","10","10","10",
            "10","10","10","10",
            "10","10","10","10",};
    private int upperbound;


    public Deck(){
        setUpperBound();
    }

    public void setUpperBound(){
        this.upperbound = 52;
    }

    public void getCards() {
        for(int i =0; i< upperbound; i++){
            System.out.println(cards[i]);
        }
    }

    public int getCardValue(String card){
        char firstIndex = card.charAt(0);
        switch (firstIndex){
            case 'A':
                return 11;
            case '2':
                return 2;

            case '3':
                return 3;

            case '4':
                return 4;

            case '5':
                return 5;

            case '6':
                return 6;

            case '7':
                return 7;

            case '8':
                return 8;

            case '9':
                return 9;

            case '1'://10
                return 10;

            case 'J':
                return 10;

            case 'Q':
                return 10;

            case 'K':
                return 10;


        }
        return -1;
    }

    public String getRandomCard(){
        int cardIndex;
        Random rand = new Random();
        String card;
        while(true) {
            cardIndex = rand.nextInt(upperbound);

            if (cards[cardIndex] == "0") {
                continue;
            } else {
                card = cards[cardIndex];
                cards[cardIndex] = "0";
                break;
            }
        }
        return card;
    }

    public void resetDeck(){
        this.cards[0]= "A\u2664";
        this.cards[1]= "A\u2661";
        this.cards[2]= "A\u2662";
        this.cards[3]=         "A\u2667";
        this.cards[4]=         "2\u2661";
        this.cards[5]=         "2\u2662";
        this.cards[6]=         "2\u2667";
        this.cards[7]=         "2\u2664";
        this.cards[8]=         "3\u2661";
        this.cards[9]=         "3\u2662";
        this.cards[10]=         "3\u2667";
        this.cards[11]=         "3\u2664";
        this.cards[12]=         "4\u2661";
        this.cards[13]=         "4\u2662";
        this.cards[14]=         "4\u2667";
        this.cards[15]=         "4\u2664";
        this.cards[16]=         "5\u2661";
        this.cards[17]=         "5\u2662";
        this.cards[18]=         "5\u2667";
        this.cards[19]=         "5\u2664";
        this.cards[20]=         "6\u2661";
        this.cards[21]=         "6\u2662";
        this.cards[22]=         "6\u2667";
        this.cards[23]=         "6\u2664";
        this.cards[24]=         "7\u2661";
        this.cards[25]=         "7\u2662";
        this.cards[26]=         "7\u2667";
        this.cards[27]=         "7\u2664";
        this.cards[28]=         "8\u2661";
        this.cards[29]=         "8\u2662";
        this.cards[30]=         "8\u2667";
        this.cards[31]=         "8\u2667";
        this.cards[32]=         "9\u2667";
        this.cards[33]=         "9\u2664";
        this.cards[34]=         "9\u2661";
        this.cards[35]=         "9\u2661";
        this.cards[36]=         "10\u2664";
        this.cards[37]=         "10\u2661";
        this.cards[38]=         "10\u2662";
        this.cards[39]=         "10\u2667";
        this.cards[40]=         "J\u2664";
        this.cards[41]=         "J\u2661";
        this.cards[42]=         "J\u2662";
        this.cards[43]=         "J\u2667";
        this.cards[44]=         "Q\u2664";
        this.cards[45]=         "Q\u2661";
        this.cards[46]=         "Q\u2662";
        this.cards[47]=         "Q\u2667";
        this.cards[48]=         "K\u2664";
        this.cards[49]=         "K\u2661";
        this.cards[50]=         "K\u2662";
        this.cards[51]=         "K\u2667";
        upperbound = 52;
    }
}

