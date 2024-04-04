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
public class Txt {
    public static void crearTXTindividual(ArrayList<App> apps){
        for (int i = 0; i < apps.size(); i++) {
            File fichero = new File("./aplicaciones/"+apps.get(i).getNombre()+".txt");
            try(FileWriter fw = new FileWriter(fichero);){
                fw.write(apps.get(i).toTXT()+"\n");
            }catch(IOException e){
                System.out.println("error");
            }
        }
    }
}
