/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;

/**
 *
 * @author aiman
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<App> apps = App.crearApps();
        App app1 = new App();
        CatalogoApps catApps = new CatalogoApps();
        catApps.setApps(apps);
        //Crea 50 aplicaciones usando el constructor por defecto, guárdalas 
        //en una lista y muéstralas por pantalla. 
        App.mostrarApps(apps);
        //Guarda los datos de todas las App de la lista, en un fichero de texto 
        //llamado aplicacionestxt.csv, dentro del directorio “./appscsv”.
        Directorios.crearDirectorio("./appscsv");
        Csv.crearCSV(apps);
        //Crea un directorio, "./appscsv2", donde se guarden en archivos individuales 
        //CSV, los datos de cada una de las aplicaciones. 
        //En este directorio deben generarse 50 ficheros con el nombre que tenga la aplicación en su atributo.
        Directorios.crearDirectorio("./appscsv2");
        Csv.crearCSVindividual(apps);
        //Guarda los datos de todas las App de la lista, en un fichero XML llamado 
        //aplicacionesxml.xml, dentro del directorio “./appsxml”. Ayúdate del ejemplo
        //del repositorio de clase. Incluye las dependencias necesarias en el pom.xml
        Directorios.crearDirectorio("./appsxml");
        try {
            Xml.crearXML(apps, "aplicacionesxml.xml");
        } catch (JAXBException jaxbe) {
            System.out.println("Error");
        }
        //Guarda los datos de todas las App de la lista, en un fichero JSON llamado 
        //aplicacionesxml.json, dentro del directorio “./appsjson”. Ayúdate del 
        //ejemplo del repositorio de clase. Incluye las dependencias necesarias en el pom.xml.
        Directorios.crearDirectorio("./appsjson");
        try {
            Json.crearJson(app1, "aplicacionesjson.json");
        } catch (IOException ex) {
            System.out.println("Error");
        }
        //Crea una carpeta “./copias” y realiza una copia de los ficheros anteriores dentro de ella.
        Directorios.crearDirectorio("./copias");
        Copias.copiarFicheros("./appscsv/aplicacionestxt.csv", "./copias/ficheroCopia.csv");
        Copias.copiarFicheros("./appsxml/aplicacionesxml.xml", "./copias/ficheroCopiasxml.csv");
        Copias.copiarFicheros("./appscsv2", ",/copias/ficheroCopiasJSON");
        //En una carpeta “./aplicaciones” crea un archivo de texto por cada 
        //aplicación que haya en la lista. El archivo se llamará igual que la app 
        //y contendrá los datos de la aplicación, separando los campos por el carácter (;).
        Directorios.crearDirectorio("./aplicaciones");
        Txt.crearTXTindividual(apps);
        //Guarda los datos de todas las App de la lista, en un fichero JSON llamado 
        //aplicacionesxml.json, dentro del directorio “./appsjson”. Ayúdate del ejemplo del repositorio de clase. Incluye las dependencias necesarias en el pom.xml.
        Directorios.crearDirectorio("./appsjson");

    }
}
