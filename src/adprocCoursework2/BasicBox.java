package adprocCoursework2;

/**
 *
 * @author Dylan Tomkins, Keir James, Andrew Tootell
 */
public abstract class BasicBox {

    int depth;
    int length;
    int height;
    int cardGrade;
    boolean sealableTop;
    int quantity;

    public BasicBox() {

    }

    public BasicBox(int depth, int length, int height, int cardGrade, boolean sealableTop, int quantity) {
        this.depth = depth;
        this.length = length;
        this.height = height;
        this.sealableTop = sealableTop;
        this.quantity = quantity;
        this.cardGrade = cardGrade;
    }

    public double calculateCosts() {
        return 0.0;
        //method will always get overridden
    }
}
