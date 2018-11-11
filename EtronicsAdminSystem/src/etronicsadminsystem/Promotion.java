/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etronicsadminsystem;

import java.util.Date;

/**
 *
 * @author Brian
 */
class Promotion {
    private int productID;
    private int discountAmount;
    private Date endDate;

    public Promotion(int PID, int disAmount, Date EDate)
    {
        productID = PID;
        discountAmount = disAmount;
        endDate = EDate;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
