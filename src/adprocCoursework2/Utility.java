/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adprocCoursework2;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Dylan
 */
public class Utility {
    private static ArrayList<BasicBox> OrderBox = new ArrayList();
    //for every collection of boxes in the OrderBox array total the prices
    public static double getTotalPrice() {
        double totalCost = 0.0;
        for (BasicBox item : OrderBox) {
            //get the price of item and add it to the totalCost
            totalCost += item.calculateCosts();
        }
        return totalCost;
    }

    //
    public static void validateAndAdd(String depth, String length, String height,int cardGrade, int colour, boolean reinforcedBottom, boolean reinforcedCorners, boolean sealableTop, int quantity) {

        //THIS FUNCTION FOR TRYING TO ADD A BOX TO THE ARRAY, WILL GIVE ERROR MESSAGES
        int giveDepth = 0;
        int giveLength = 0;
        int giveHeight = 0;
        try {
            giveDepth = Integer.parseInt(depth);
        } catch (NumberFormatException e) {
            errorMessage("Invalid depth value!");
        }
        try {
            giveLength = Integer.parseInt(length);
        } catch (NumberFormatException e) {
            errorMessage("Invalid length value!");
        }
        try {
            giveHeight = Integer.parseInt(height);
        } catch (NumberFormatException e) {
            errorMessage("Invalid height value!");
        }
        // return true if box made, false if not
        if (addBoxToArray(giveDepth, giveLength, giveHeight, cardGrade, colour, reinforcedBottom, reinforcedCorners, sealableTop, quantity)){
            System.out.println(OrderBox.get(OrderBox.size() - 1).getClass());
        }
    }

    //create and add new boxes to the array
    public static boolean addBoxToArray(int depth, int length, int height,int cardGrade, int colour, boolean reinforcedBottom, boolean reinforcedCorners,boolean sealableTop, int quantity) {
        // box specified is within set dimensions
        if (quantity <= 0){
            errorMessage("Quantity must be positive");
            return false;
        }
        if ((depth >= 200 && length >= 200 && height >= 200)&&(depth <= 1000 && length <= 1000 && height <= 1000)) {
            // box specified matches boxType5 description
            if (reinforcedCorners == true && reinforcedBottom == true && colour == 2 && cardGrade > 2 && cardGrade < 6) {
                BoxType5 newbox = new BoxType5(depth, length, height, cardGrade, sealableTop, quantity);
                OrderBox.add(newbox);
                return true;
            } //if want reifocedCorners and not match boxType5 skip to err
            else if (reinforcedCorners == false) {

                if (reinforcedBottom == true && colour == 2 && cardGrade > 1 && cardGrade < 6) {
                    BoxType4 newbox = new BoxType4(depth, length, height, cardGrade, sealableTop, quantity);
                    OrderBox.add(newbox);
                    return true;
                } // if want reinforcedBottom and not match boxType4 or 5 skip to err
                else if (reinforcedBottom == false) {
                    //match against boxType3
                    if (colour == 2 && cardGrade > 1 && cardGrade < 6) {
                        BoxType3 newbox = new BoxType3(depth, length, height, cardGrade, sealableTop, quantity);
                        OrderBox.add(newbox);
                        return true;
                    } //match against boxType2
                    else if (colour == 1 && cardGrade > 1 && cardGrade < 5) {
                        BoxType2 newbox = new BoxType2(depth, length, height, cardGrade, sealableTop, quantity);
                        OrderBox.add(newbox);
                        return true;
                    } //match against boxType1
                    else if (colour == 0 && cardGrade > 0 && cardGrade < 4) {
                        BoxType1 newbox = new BoxType1(depth, length, height, cardGrade, sealableTop, quantity);
                        OrderBox.add(newbox);
                        return true;
                    }
                }
            }
        }
        //if box not allowed err
        errorMessage("Box not avalible");
        return false;
    }
    public static void errorMessage(String message) {
        JFrame frame = new JFrame("Error");
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
