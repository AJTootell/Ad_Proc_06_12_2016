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
public class BoxType1 extends BasicBox {
    public BoxType1(int depth, int length, int height, int cardGrade, boolean sealableTop, int quantity) {
        super(depth,length,height,cardGrade,sealableTop,quantity);
    }
    @Override
     public double calculateCosts() {
        double cost;
        double cardGradeCost;
        double sealableTopPercentage = 0.0;
        if (super.sealableTop) 
            sealableTopPercentage = 0.08;
        switch (super.cardGrade) {
            case 1:
                cardGradeCost = 0.5;
                break;
            case 2:
                cardGradeCost = 0.6;
                break;
            case 3:
                cardGradeCost = 0.72;
                break;
            //unreachable default
            default:
                cardGradeCost = 1;
                break;
        }
        double area = (super.depth * super.length + super.depth * super.height + super.length * super.height) * 2;
        area /= 1000000;
        cost = area * cardGradeCost;
        cost *= (1.0 + sealableTopPercentage);
        return cost * super.quantity;
    }
}
