package ru.dmitry.bocharov.observable;

import ru.dmitry.bocharov.observers.Observer;

public interface IObservable {
        void AddObserver(Observer observer);
        void RemoveObserver(Observer observer);
        void NotifyObserver();
}
