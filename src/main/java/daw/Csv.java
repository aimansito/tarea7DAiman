/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author aiman
 */
public class Csv {
    public static void crearCSV(ArrayList<App> apps){
        File fichero = new File("./appscsv/aplicacionestxt.csv");   
        try(FileWriter fw = new FileWriter(fichero);){
            for(App app : apps){
                fw.write(app.toCSV()+"\n");
            }
        }catch(IOException e){
            System.out.println("error");
        }
    }
    public static void crearCSVindividual(ArrayList<App> apps){
        for (int i = 0; i < apps.size(); i++) {
            File fichero = new File("./appscsv2/"+apps.get(i).getNombre()+".csv");
            try(FileWriter fw = new FileWriter(fichero);){
                fw.write(apps.get(i).toCSV()+"\n");
            }catch(IOException e){
                System.out.println("error");
            }
        }
    }
}
