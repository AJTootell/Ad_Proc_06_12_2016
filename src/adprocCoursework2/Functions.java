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
public class Functions {
    ArrayList<BasicBox> OrderBox = new ArrayList();
    //for every collection of boxes in the OrderBox array total the prices
    public double getTotalPrice() {
        double totalCost = 0.0;
        for (BasicBox item : OrderBox) {
            //get the price of item and add it to the totalCost
            totalCost = totalCost + item.calculateCosts();
        }
        return totalCost;
    }

    //
    public void validateAndAdd(String depth, String length, String height, int colour, boolean reinforcedBottom, boolean reinforcedCorners, int cardGrade) {

        //THIS FUNCTION FOR TRYING TO ADD A BOX TO THE ARRAY, WILL GIVE ERROR MESSAGES
        int givedepth = 0;
        int givelength = 0;
        int giveheight = 0;
        int givecardGrade = 0;
        try {
            givedepth = Integer.parseInt(depth);
        } catch (NumberFormatException e) {
            errorMessage("Incorrect Depth value!");
        }
        try {
            givelength = Integer.parseInt(length);
        } catch (NumberFormatException e) {
            errorMessage("Incorrect length value!");
        }
        try {
            giveheight = Integer.parseInt(height);
        } catch (NumberFormatException e) {
            errorMessage("Incorrect height value!");
        }
        addBoxToArray(givedepth, givelength, giveheight, colour, reinforcedBottom, reinforcedCorners, givecardGrade);
    }

    //create and add new boxes to the array
    public void addBoxToArray(int depth, int length, int height, int colour, boolean reinforcedBottom, boolean reinforcedCorners, int cardGrade) {
        // box specified is within set dimensions
        if ((depth > 199 && length > 199 && height > 199)&&(depth < 1001 && length < 1001 && height < 1001)) {
            // box specified matches boxType5 description
            if (reinforcedCorners == true && reinforcedBottom == true && colour == 2 && cardGrade > 2 && cardGrade < 6) {
                BoxType5 newbox = new BoxType5(depth, length, height);
                OrderBox.add(newbox);
                return;
            } //if want reifocedCorners and not match boxType5 skip to err
            else if (reinforcedCorners == false) {

                if (reinforcedBottom == true && colour == 2 && cardGrade > 1 && cardGrade < 6) {
                    BoxType4 newbox = new BoxType4(depth, length, height);
                    OrderBox.add(newbox);
                    return;
                } // if want reinforcedBottom and not match boxType4 or 5 skip to err
                else if (reinforcedBottom == false) {
                    //match against boxType3
                    if (colour == 2 && cardGrade > 1 && cardGrade < 6) {
                        BoxType3 newbox = new BoxType3(depth, length, height);
                        OrderBox.add(newbox);
                        return;
                    } //match against boxType2
                    else if (colour == 1 && cardGrade > 1 && cardGrade < 5) {
                        BoxType2 newbox = new BoxType2(depth, length, height);
                        OrderBox.add(newbox);
                        return;
                    } //match against boxType1
                    else if (colour == 0 && cardGrade > 0 && cardGrade < 4) {
                        BoxType1 newbox = new BoxType1(depth, length, height);
                        OrderBox.add(newbox);
                        return;
                    }
                }
            }
        }
        //if box not allowed err
        errorMessage("Box not avalible");
    }
    public void errorMessage(String message) {
        JFrame frame = new JFrame("Error");
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}