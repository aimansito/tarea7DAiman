/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author aiman
 */
public class Directorios {
    public static void crearDirectorio(String nomDir){
        Path directory = Paths.get(nomDir);
        try {
            Files.createDirectory(directory);
            System.out.println("Se ha creado la ruta con éxito");
        } catch (FileAlreadyExistsException faee) {
            System.out.println("No se puede crear " + nomDir + " porque ya existe");
        } catch (AccessDeniedException ade) {
            System.out.println("No tiene permisos para crear " + nomDir);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio " + nomDir);
            System.out.println("Seguramente la ruta está mal escrita o no existe");
        }
    }
}
