/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author aiman
 */
public class App {
    private int codApp; 
    private String nombre;
    private String descripcion;
    private double tamaño; // en KB 
    private int numDescargas; 
    private static int contador;
    
    public App(int codApp, String nombre, String descripcion, double tamaño, int numDescargas) {
        this.codApp = codApp;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamaño = tamaño;
        this.numDescargas = numDescargas;
    }

    public App() {
       contador++;
       this.codApp = contador;
       this.nombre = "app"+contador+RandomStringUtils.randomAlphabetic(1);
       this.descripcion = descripcionApp();
       
    }
    public static String descripcionApp(){
        Random random = new Random();
        int num = random.nextInt(1,10);
        String[] descripciones = new String[10];
        
        descripciones[0] = "Apuestas de fútbol";
        descripciones[1] = "Aplicación de juegos";
        descripciones[2] = "Hoja de cálculo";
        descripciones[3] = "Documentos de texto";
        descripciones[4] = "Presentaciones";
        descripciones[5] = "Calendario";
        descripciones[6] = "Alarma";
        descripciones[7] = "Reloj";
        descripciones[8] = "SmartGit";
        descripciones[9] = "Google Classroom";
        
        return descripciones[num];
    } 

    public int getCodApp() {
        return codApp;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getTamaño() {
        return tamaño;
    }

    public int getNumDescargas() {
        return numDescargas;
    }

    public static int getContador() {
        return contador;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("App{");
        sb.append("codApp=").append(codApp);
        sb.append(", nombre=").append(nombre);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", tama\u00f1o=").append(tamaño);
        sb.append(", numDescargas=").append(numDescargas);
        sb.append('}');
        return sb.toString();
    }
    
}
