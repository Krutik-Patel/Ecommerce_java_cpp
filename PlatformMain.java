import ecomm.Platform;
import ecomm.Seller;
import demo.KPlatform;
import java.util.*;
import demo.*;
import demo.krutik.*;

public class PlatformMain {
    public static void main(String args[]) {
        Platform pf = new KPlatform();

        Seller s1 = new SellerXYZ("XYZ");

        s1.addPlatform(pf);

        Scanner sc = new Scanner(System.in);

        boolean run = true;

        while (run) {
            String type = sc.next();
            if (type.equals("Check")) {
                pf.processRequests();
            } else if (type.equals("End")) {
                break;
            }
        }

    }
}