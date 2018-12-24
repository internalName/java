package ru.dmitry.bocharov;

import java.io.File;

public class Direction {
    private static final String _direction=new File("").getAbsolutePath()+"\\save file";

    public static String GetDirection(){
        return _direction;
    }
}
