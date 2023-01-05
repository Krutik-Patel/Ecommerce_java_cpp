package demo.krutik;

import ecomm.Seller;
import ecomm.Globals.Category;

import java.util.*;
import demo.KPlatform;
import ecomm.Globals;
import ecomm.Platform;
import ecomm.Product;

public class SellerXYZ extends Seller {
    ArrayList<Product> mobileList;
    ArrayList<Product> bookList;

    public SellerXYZ(String id) {
        super(id);
        mobileList = new ArrayList<>();
        bookList = new ArrayList<>();
    }

    public void addPlatform(Platform thePlatform) {
        thePlatform.addSeller(this);
    }

    public ArrayList<Product> findProducts(Globals.Category whichOne) {
        if (whichOne == Category.Mobile)
            return mobileList;
        else
            return bookList;
    }

    public boolean buyProduct(String productID, int quantity) {
        System.out.println("buyProduct called");
        return true;
    }
}
