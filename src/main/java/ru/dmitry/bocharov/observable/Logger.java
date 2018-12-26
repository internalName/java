package ru.dmitry.bocharov.observable;

import ru.dmitry.bocharov.observers.Observer;

import java.util.LinkedList;
import java.util.List;

public class Logger implements IObservable {

    private List<Observer> _observers;
    private String _message;

    public Logger(){
        _observers=new LinkedList<>();
    }

    public void Log(String message){
        _message=message;
        NotifyObserver();
    }

    public void AddObserver(Observer observer) {
        _observers.add(observer);
    }

    public void RemoveObserver(Observer observer) {
        _observers.remove(observer);
    }

    public void NotifyObserver() {
        for (Observer observer:_observers){
            observer.update(_message);
        }
    }
}
