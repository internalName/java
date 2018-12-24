package ru.dmitry.bocharov.observers;
import java.util.*;

public interface IObserver {
    void update(String message,Date dateTime);
}
