package ru.dmitry.bocharov.observers;

import ru.dmitry.bocharov.observable.IObservable;
import java.io.IOException;
import java.nio.file.*;
import java.util.Date;

public class SaveLogOnFile extends Observer {
    private  String _direction;
    private String _pathToTheFile;


     public SaveLogOnFile(IObservable logger){
         super(logger);

         _direction= Observer.DIRECTION;
         _pathToTheFile=_direction+"\\file.txt";

            CheckPathAndFile();
            Headline();
     }

     private void CheckPathAndFile(){
         Path path= Paths.get(_direction);
         if (!Files.exists(path)){
             try{
                 Files.createDirectory(path);
             }
            catch (Exception e){
                System.out.println(Observer._PROBLEM_MESSAGE+e.getMessage());
            }
         }
            if(!Files.exists(Paths.get(_pathToTheFile))){
                try{
                    Files.createFile(Paths.get(_pathToTheFile));
                }
                catch (Exception e){
                    System.out.println(Observer._PROBLEM_MESSAGE+e.getMessage());
                }

            }
     }

     private void Headline(){
         try {
             Files.write(Paths.get(_pathToTheFile), ("Now : "+new Date().toString()+System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
         }
         catch (IOException e) {
             System.out.println(Observer._PROBLEM_MESSAGE+e.getMessage());
         }
     }

    @Override
    public void update(String message) {
        try {
            Files.write(Paths.get(_pathToTheFile), super.EditingMessage(message).getBytes(), StandardOpenOption.APPEND);
        }
        catch (IOException e) {
            System.out.println(Observer._PROBLEM_MESSAGE+e.getMessage());
        }
    }
}
