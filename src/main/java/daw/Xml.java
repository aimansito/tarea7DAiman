/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author aiman
 */
public class Xml {
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
}
