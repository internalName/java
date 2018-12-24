package ru.dmitry.bocharov.observers;

import ru.dmitry.bocharov.observable.IObservable;


class LogOutput {

    private IObservable _logger;


    public LogOutput(IObservable logger){
        _logger=logger;
    }

    public void Print(String message) {

        System.out.println(message);
    }
}
