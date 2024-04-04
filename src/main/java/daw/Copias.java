/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author aiman
 */
public class Copias {
    public static void copiarFicheros(String rutaOrigen, String rutaDestino) {
        Path origen = Paths.get(rutaOrigen);
        Path destino = Paths.get(rutaDestino);
        try {
            Files.copy(origen, destino);
        } catch (IOException e) {
            System.out.println("Problema copiando el archivo.");
        }
    }
    public static void copiarFicherosIndividual(String rutaOrigen,String rutaDestino){
        for (int i = 0; i < 50; i++) {
            Path origen = Paths.get(rutaOrigen);
            Path destino = Paths.get(rutaDestino+i+".txt");
            try {
                Files.copy(origen, destino);
            } catch (IOException e) {
                System.out.println("Problema copiando el archivo.");
            }
        }
    }
}
