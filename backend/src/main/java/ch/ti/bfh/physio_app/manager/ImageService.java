package ch.ti.bfh.physio_app.manager;

import org.apache.commons.codec.binary.Base64;

import javax.enterprise.context.ApplicationScoped;
import java.io.*;

@ApplicationScoped
public class ImageService {

    // local saving location for vanessa
    public static String path = "/Users/Vanessa/Desktop/ex_";

    // server saving location
    // public static String path = "/data/exImages/";


    // get image with given path
    public File getImageByPath(String path){
        File image = new File(path);
        return image;
    }

}
