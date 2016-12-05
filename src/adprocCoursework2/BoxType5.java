package adprocCoursework2;
/**
 *
 * @author Dylan Tomkins, Keir James, Andrew Tootell
 */
public class BoxType5 extends BasicBox {
    public BoxType5(int depth, int length, int height, int cardGrade,boolean sealableTop, int quantity) {
        super(depth,length,height,cardGrade,sealableTop,quantity);
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
        double area = (super.depth * super.length + super.depth * super.height + super.length * super.height) * 2;
        area = area / 1000000;
        cost = area * cardGradeCost;
        cost = cost * (1 + 0.16 + 0.14 + 0.10 + sealableTopPercentage);
        return cost * super.quantity;
    }
}
