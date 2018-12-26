package ru.dmitry.bocharov.observers;

import ru.dmitry.bocharov.observable.IObservable;
import java.io.File;
import java.util.Date;

public abstract class Observer implements IObserver {
    public static final String DIRECTION=new File("").getAbsolutePath()+"\\save file";
    protected static final String _PROBLEM_MESSAGE="Houston, we have a problems!\n";
    private int _counter=0;

     Observer(IObservable logger){
        logger.AddObserver(this);
    }

     String EditingMessage(String message){
        return ++_counter+". DateTime: "+new Date()+" message: "+message+System.lineSeparator();
    }

    @Override
    public abstract void update(String message);
    }

