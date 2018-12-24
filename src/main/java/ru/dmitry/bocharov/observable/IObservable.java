package ru.dmitry.bocharov.observable;

import ru.dmitry.bocharov.observers.IObserver;

public interface IObservable {
        void AddObserver(IObserver observer);
        void RemoveObserver(IObserver observer);
        void NotifyObserver();
}
