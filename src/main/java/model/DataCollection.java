package model;

import com.pvl.newparser.NewParser;

public class DataCollection {

    public static final String[] args = new String[3];


    public static void sendDataToCounter() {

        System.out.println("args [0]= " + args [0]);
        System.out.println("args [1]= " + args [1]);
        System.out.println("args [2]= " + args [2]);

        NewParser.executeParser(args);
    }


}