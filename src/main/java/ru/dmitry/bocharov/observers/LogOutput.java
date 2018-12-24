package ru.dmitry.bocharov.observers;

import ru.dmitry.bocharov.observable.IObservable;

import java.util.Date;


class LogOutput implements IObserver {

    private IObservable _logger;


    public LogOutput(IObservable logger){
        _logger=logger;
    }

    public void update(String message, Date dateTime) {

        System.out.println(message);
    }
}
