package ru.dmitry.bocharov.observers;

import ru.dmitry.bocharov.Direction;
import ru.dmitry.bocharov.observable.IObservable;
import ru.dmitry.bocharov.observable.Logger;


import java.io.IOException;
import java.nio.file.*;

import java.util.Date;

class SaveLogOnFile implements IObserver {
    private IObservable _logger;
    private  String _direction;
    private String _pathToTheFile;


     public SaveLogOnFile(IObservable logger){
         _logger=logger;
         _direction= Direction.GetDirection();
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
                System.out.println(e);
            }
         }
            if(!Files.exists(Paths.get(_pathToTheFile))){
                try{
                    Files.createFile(Paths.get(_pathToTheFile));
                }
                catch (Exception e){
                    System.out.println(e);
                }

            }
     }

     private void Headline(){
         try {
             Files.write(Paths.get(_pathToTheFile), ("Now : "+new Date().toString()+System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
         }
         catch (IOException e) {
             System.out.println(e);
         }
     }

     public void update(String message, Date dateTime)  {

         try {
             Files.write(Paths.get(_pathToTheFile), message.getBytes(), StandardOpenOption.APPEND);
         }
         catch (IOException e) {
             System.out.println(e);
         }
         }
     }
