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
public abstract class BasicBox {
    int depth;
    int length;
    int height;
    int cardGrade;
    boolean sealableTop;
    int quantity;
    
    public BasicBox() {
        
    }
    
    public double calculateCosts() {
        return 0.0;
    }
}