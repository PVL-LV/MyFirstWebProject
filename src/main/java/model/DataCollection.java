package model;

import com.pvl.newparser.NewParser;

public class DataCollection {

    public static final String[] args = new String[2];


    public static void sendDataToCounter() {

        System.out.println(args [0]);
        System.out.println(args [1]);

        NewParser.executeParser(args);
    }


}