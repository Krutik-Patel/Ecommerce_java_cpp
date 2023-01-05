package demo;

import ecomm.Globals;
import ecomm.Platform;
import ecomm.Product;

import java.util.*;
import ecomm.Seller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class KPlatform extends Platform {
    private ArrayList<Seller> sellersList;
    private HashMap<String, Boolean> handled;

    public KPlatform() {
        sellersList = new ArrayList<>();
        handled = new HashMap<>();
    }

    public boolean addSeller(Seller aSeller) {
        return sellersList.add(aSeller);
    }

    public void processRequests() {
        System.out.println("processing requests");

        // From here
        try {

            // file reading
            File file = new File(Globals.toPlatform);
            Scanner sc = new Scanner(file);

            // main while loop
            while (sc.hasNextLine()) {
                String inp = sc.nextLine();
                String[] words = inp.split("\\s");

                // handle requests
                if (!handled.containsKey(words[1])) {
                    handleIndividualRequest(words);
                }

                System.out.println("The request has been handled");
            }

            // end
            System.out.println("[This is the end of a check request]");
            sc.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    private void handleIndividualRequest(String[] request) {
        if (request[2].equals("Start")) {
            String output = request[0] + " " + request[1] + " ";
            for (Globals.Category category : Globals.Category.values()) {
                output += category.name() + " ";
            }

            // write to PlatformToPortal.txt
            writeOutput(output);

        } else if (request[2].equals("List")) {
            ArrayList<Product> prodList;
            for (int i = 0; i < sellersList.size(); i++) {
                if (request[3].equals("Mobile")) {
                    prodList = sellersList.get(i).findProducts(Globals.Category.Mobile);
                } else {
                    prodList = sellersList.get(i).findProducts(Globals.Category.Book);
                }
                System.out.println(prodList.size());
                for (Product prod : prodList) {
                    String output = request[0] + " " + request[1] + " ";
                    output += prod.getCategory() + " " + prod.getName() + " " + prod.getPrice() +
                            " "
                            + prod.getQuantity();
                    writeOutput(output);
                }
            }
            System.out.println("All products Listed");
        } else if (request[2].equals("Buy")) {
            
        }
    }

    private void writeOutput(String output) {
        try {
            System.out.println("Output is getting written");
            Writer writer;
            writer = new FileWriter(Globals.fromPlatform, true);
            writer.append(output + "\n");

            writer.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
