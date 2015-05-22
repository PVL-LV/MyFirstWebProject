package model;

public class CheckMinVal {

    public static void minValCheck() {
        //set minVal if user didn't set it
        if (DataCollection.args [1] == null) {
            DataCollection.args[1] = ("minValue=1");
        }
    }
}
