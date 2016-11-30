/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adprocCoursework2;
/**
 *
 * @author Dylan
 */
public class BoxType5 extends BasicBox {
    public BoxType5(int depth, int length, int height) {
        super.depth = depth;
        super.length = length;
        super.height = height;
    }
     public double calculateCosts() {
        double cost;
        double cardGradeCost = 0.0;
        double sealableTopPercentage = 0.0;
        if (super.sealableTop) {sealableTopPercentage = 0.08;}
        switch (super.cardGrade) {
            case 3 :
                cardGradeCost = 0.72;
            case 4 :
                cardGradeCost = 0.9;
            case 5 :
                cardGradeCost = 1.4;
        }
        double area = super.depth * super.length * 2 + super.depth * super.height * 2 + super.length * super.height * 2;
        area = area / 1000000;
        cost = area * cardGradeCost;
        cost = cost * (1 + 0.16 + 0.14 + 0.10 + sealableTopPercentage);
        return cost * super.quantity;
    }
}
