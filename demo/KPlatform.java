package demo;

import ecomm.Platform;
import java.util.*;
import ecomm.Seller;

public class KPlatform extends Platform {
    private ArrayList<Seller> sellersList;

    public KPlatform() {
        sellersList = new ArrayList<>();
    }

    public boolean addSeller(Seller aSeller) {
        return sellersList.add(aSeller);
    }

    public void processRequests() {
        System.out.println("processing requests");
    }

}
