package ru.dmitry.bocharov.observers;

import ru.dmitry.bocharov.observable.IObservable;

import java.util.Date;


public class Observer implements IObserver {
    private LogOutput _logOutput;
    private SaveLogOnFile _saveLogOnFile;
    private IObservable _observable;
    private TypeOfAction _typeOfAction;

    public Observer(IObservable logger, TypeOfAction typeOfAction){
        _observable=logger;
        _typeOfAction=typeOfAction;

        if(typeOfAction.equals(TypeOfAction.Save)) {
            _saveLogOnFile=new SaveLogOnFile(logger);
            _observable.AddObserver(this);
        }
        else if(typeOfAction.equals(TypeOfAction.Output)){
            _logOutput=new LogOutput(logger);
            _observable.AddObserver(this);
        }

    }

    @Override
    public void update(String message, Date dateTime) {
        if(_typeOfAction.equals(TypeOfAction.Output)) _logOutput.update(message,dateTime);
        else if(_typeOfAction.equals(TypeOfAction.Save)) _saveLogOnFile.update(message,dateTime);
    }
}
