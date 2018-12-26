package ru.dmitry.bocharov.observers;

import ru.dmitry.bocharov.observable.IObservable;


public class LogOutput extends Observer {

    public LogOutput(IObservable logger){
        super(logger);
    }

    @Override
    public void update(String message) {
        System.out.println(super.EditingMessage(message));
    }
}
