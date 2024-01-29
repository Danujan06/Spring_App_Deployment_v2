package com.group15.AutomatedHydroponicsSystem.mqtt;

public class DataVariables {
    // ON and OFF states
    public  static  final Boolean ON_STATE = true;
    public  static final Boolean OFF_STATE = false;


    //static variables to store the received data
    public  static double pHData ;
    public static double tdsData;
    public static boolean floatSensorData;
    public static double phpumpData;
    public static double phlowpumpData;
    public static double tdspumpData;
    public static double phhigherrorData;
    public static double phlowerrorData;
    public static double tdserrorData;
    public static double phsensorerrorData;
    public static double tdssensorerrorData;

    public static int  phPumpCount;
    public static int phLowPumpCount;
    public static int tdsPumpCount;

}
