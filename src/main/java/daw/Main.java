/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author aiman
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<App> apps = crearApps();
        //Crea 50 aplicaciones usando el constructor por defecto, guárdalas 
        //en una lista y muéstralas por pantalla. 
        mostrarApps(apps);
        //Guarda los datos de todas las App de la lista, en un fichero de texto 
        //llamado aplicacionestxt.csv, dentro del directorio “./appscsv”.
        crearDirectorio("./appscsv");
        crearCSV(apps);
        //Crea un directorio, "./appscsv2", donde se guarden en archivos individuales 
        //CSV, los datos de cada una de las aplicaciones. 
        //En este directorio deben generarse 50 ficheros con el nombre que tenga la aplicación en su atributo.
        crearDirectorio("./appscsv2");
        crearCSVindividual(apps);
        //Guarda los datos de todas las App de la lista, en un fichero XML llamado 
        //aplicacionesxml.xml, dentro del directorio “./appsxml”. Ayúdate del ejemplo
        //del repositorio de clase. Incluye las dependencias necesarias en el pom.xml
        crearDirectorio("./appsxml");
        try{
            crearXML(apps, "aplicacionesxml.xml");
        }catch(JAXBException jaxbe){
            System.out.println("Error");
        }
        //Crea una carpeta “./copias” y realiza una copia de los ficheros anteriores dentro de ella.
        crearDirectorio("./copias");
        //En una carpeta “./aplicaciones” crea un archivo de texto por cada 
        //aplicación que haya en la lista. El archivo se llamará igual que la app 
        //y contendrá los datos de la aplicación, separando los campos por el carácter (;).
        crearDirectorio("./aplicaciones");
        crearTXTindividual(apps);
        //Guarda los datos de todas las App de la lista, en un fichero JSON llamado 
        //aplicacionesxml.json, dentro del directorio “./appsjson”. Ayúdate del ejemplo del repositorio de clase. Incluye las dependencias necesarias en el pom.xml.
        crearDirectorio("./appsjson");
        
    }
    public static ArrayList<App> crearApps(){
        ArrayList<App> apps = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            apps.add(new App());
        }
        return apps;
    }
    public static void mostrarApps(ArrayList<App> apps){
        for (App app : apps) {
            System.out.println(app);
        }
        System.out.println("--------------");
    }
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
    public static void crearXML(ArrayList<App> apps, String nomFichero) throws JAXBException{
        CatalogoApps catApps = new CatalogoApps();
        ArrayList<App> app = new ArrayList(apps);
        catApps.setApps(app);
        catApps.setNombre("Mis Apps");
        JAXBContext contexto = JAXBContext.newInstance(CatalogoApps.class);
        Marshaller serializador = contexto.createMarshaller();
        serializador.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        serializador.marshal(catApps, System.out);
        serializador.marshal(catApps, new File("./appsxml/" + nomFichero));
        System.out.println("Fichero " + nomFichero + ".xml creado correctamente.");
    }
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
