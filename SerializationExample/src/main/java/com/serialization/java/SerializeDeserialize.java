package com.serialization.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializeDeserialize {

	public static void main(String[] args) throws ClassNotFoundException {

		int i;
        Item[] items = new Item[2];

 

        SerializeDeserialize c = new SerializeDeserialize();
        for (i = 0; i < items.length; i++) {
            items[i] = new Item(); // create array
        }



         // hard-coded values of id, desc, cost, qty
                 items[0].setItemID("ITEM101");
                 items[1].setItemID("ITEM102");


                 items[0].setDesc("iPad");
                 items[1].setDesc("iPhone");


                 items[0].setCost(888);
                 items[1].setCost(999);


                 items[0].setQuantity(1);
                 items[1].setQuantity(3);
         
             System.out.println("Item Details.....");
             for (Item d : items) {
                 System.out.print(d.getItemID());
                 System.out.print("\t" + d.getDesc());
                 System.out.print("\t" + d.getCost());
                 System.out.println("\t" + d.getQuantity());
             }
             List<Item> obj;
             obj = new ArrayList<Item>();

      

             for (i = 0; i < items.length; i++) {
                 obj.add(items[i]);
             }
          // Let's serialize an Object
                  try {
                      FileOutputStream fileOut = new FileOutputStream("myserial.ser");
                      ObjectOutputStream out = new ObjectOutputStream(fileOut);
                      out.writeObject(obj);
                      out.close();
                      fileOut.close();
                      System.out.println("\nSerialization Successful... Checkout your specified output file..\n");

           

                  } catch (FileNotFoundException e) {
                      e.printStackTrace();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
               // Let's deserialize an Object
                  try {
                      FileInputStream fileIn = new FileInputStream("myserial.ser");
                      ObjectInputStream in = new ObjectInputStream(fileIn);
                      System.out.println("Deserialized Data: \n" + in.readObject().toString());
                      in.close();
                      fileIn.close();
                  } catch (FileNotFoundException e) {
                      e.printStackTrace();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }	

        }
	}

