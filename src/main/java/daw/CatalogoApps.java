/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aiman
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CatalogoApps {
    @XmlElementWrapper(name = "catalogo") 
    // XmlElement establece el nombre de los elementos
    // Cada elemento de la lista llevará esta etiqueta en el fichero xml
    @XmlElement(name = "Apps")
    private ArrayList<App> apps;
    private String nombre;

    public CatalogoApps() {
    }
            
    public ArrayList<App> getApps() {
        return apps;
    }

    public void setApps(ArrayList<App> app) {
        this.apps = app;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
