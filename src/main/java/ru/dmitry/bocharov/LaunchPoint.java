package ru.dmitry.bocharov;

import ru.dmitry.bocharov.observable.Logger;
import ru.dmitry.bocharov.observers.Observer;
import ru.dmitry.bocharov.observers.LogOutput;
import ru.dmitry.bocharov.observers.SaveLogOnFile;

public class LaunchPoint {
    public static void main(String[] args) {
        System.out.println("Save information file on:\n"+ Observer.DIRECTION);

        Logger logger=new Logger();

        Observer observerFirst=  new SaveLogOnFile(logger);
        Observer observerSecond=  new LogOutput(logger);

        logger.Log("first");
        logger.Log("second");

        logger.RemoveObserver(observerFirst);

        logger.Log("third");

        logger.RemoveObserver(observerSecond);

        logger.Log("fourth");
    }
}
