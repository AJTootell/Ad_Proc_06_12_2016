/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adproccw;

import java.util.ArrayList;

/**
 *
 * @author Dylan
 */
public class Adproccw {
    ArrayList<BasicBox> OrderBox = new ArrayList<BasicBox>();

    public static void main(String[] args) {

    }
    
    //for every collection of boxes in the OrderBox array total the prices
    public double getTotalPrice() {
        double totalCost = 0.0;
        for (BasicBox item:OrderBox ){
            //get the price of item and add it to the totalCost
              totalCost = totalCost + item.calculateCosts();
          }
        return totalCost;
    }
    
    //
    public void validateAndAdd(String depth, String length, String height, int colour, boolean reinforcedBottom, boolean reinforcedCorners, String cardGrade) {
        int giveDepth = 0;
        int giveLength = 0;
        int giveHeight = 0;
        int giveCardGrade = 0;
        
        addBoxToArray(giveDepth, giveLength, giveHeight, colour, reinforcedBottom, reinforcedCorners, giveCardGrade);
    }
    
    //
    public void addBoxToArray(int depth, int length, int height, int colour, boolean reinforcedBottom, boolean reinforcedCorners, int cardGrade) {
        boolean allowedBox = false;
        if (depth > 199 && length > 199 && height > 199) {
        if (reinforcedCorners == true && reinforcedBottom == true && colour == 2 && cardGrade > 2 && cardGrade < 6) {
            BoxType5 newbox = new BoxType5(depth,length,height);
            OrderBox.add(newbox);
            allowedBox = true;
        } else if (reinforcedCorners == false && reinforcedBottom == true && colour == 2 && cardGrade > 1 && cardGrade < 6) {
            BoxType4 newbox = new BoxType4(depth,length,height);
            OrderBox.add(newbox);
            allowedBox = true;
        } else if (reinforcedCorners == false && reinforcedBottom == false && colour == 2 && cardGrade > 1 && cardGrade < 6) {
            BoxType3 newbox = new BoxType3(depth,length,height);
            OrderBox.add(newbox);
            allowedBox = true;
        } else if (reinforcedCorners == false && reinforcedBottom == false && colour == 1 && cardGrade > 1 && cardGrade < 5) {
            BoxType2 newbox = new BoxType2(depth,length,height);
            OrderBox.add(newbox);
            allowedBox = true;
        } else if (reinforcedCorners == false && reinforcedBottom == false && colour == 0 && cardGrade > 0 && cardGrade < 4) {
            BoxType1 newbox = new BoxType1(depth,length,height);
            OrderBox.add(newbox);
            allowedBox = true;
        }}
        if (allowedBox == false) {
            //BOX TYPE  NOT ALLOWED
        }
    }
}
