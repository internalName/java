package ru.dmitry.bocharov.observable;

import ru.dmitry.bocharov.Direction;
import ru.dmitry.bocharov.observers.IObserver;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Logger implements IObservable {

    private List<IObserver> _observers;
    private String _message;
    private Date _dateTime;
    private int _counter=0;

    public Logger(){
        _observers=new LinkedList<>();
        System.out.println("Save information file on:\n"+ Direction.GetDirection());
    }


    public void Log(String message, Date dateTime){
        _message=EditingMessage(message,dateTime);
        _dateTime=dateTime;
        NotifyObserver();
    }

    private String EditingMessage(String message,Date dateTime){
        return ++_counter+". DateTime: "+dateTime+" message: "+message+System.lineSeparator();
    }

    public void AddObserver(IObserver observer) {
        _observers.add(observer);
    }

    public void RemoveObserver(IObserver observer) {
        _observers.remove(observer);
    }

    public void NotifyObserver() {
        for (IObserver observer:_observers){
            observer.update(_message,_dateTime);
        }
    }
}
