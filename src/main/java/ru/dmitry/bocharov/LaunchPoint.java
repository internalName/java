package ru.dmitry.bocharov;

import ru.dmitry.bocharov.observable.Logger;
import ru.dmitry.bocharov.observers.IObserver;
import ru.dmitry.bocharov.observers.Observer;
import ru.dmitry.bocharov.observers.TypeOfAction;

import java.util.Date;


public class LaunchPoint {
    public static void main(String[] args) {
        Logger logger=new Logger();
        IObserver observerFirst=  new Observer(logger, TypeOfAction.Output);
        IObserver observerSecond=  new Observer(logger,TypeOfAction.Save);


        logger.Log("first",new Date());
        logger.Log("second",new Date());
        logger.RemoveObserver( observerFirst);
        logger.Log("third",new Date());
        logger.RemoveObserver(observerSecond);
        logger.Log("fourth",new Date());
    }
}
