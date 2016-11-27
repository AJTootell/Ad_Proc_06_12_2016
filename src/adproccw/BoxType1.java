/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adproccw;

/**
 *
 * @author Dylan
 */
public class BoxType1 extends BasicBox {
    public BoxType1(int depth, int length, int height) {
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
            case 1 :
                cardGradeCost = 0.5;
            case 2 :
                cardGradeCost = 0.6;
            case 3 :
                cardGradeCost = 0.72;
        }
        double area = super.depth * super.length * 2 + super.depth * super.height * 2 + super.length * super.height * 2;
        area = area / 1000000;
        cost = area * cardGradeCost;
        return cost * (1.0 + sealableTopPercentage);
    }
}
