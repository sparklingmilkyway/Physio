package ch.ti.bfh.physio_app.service;

import org.apache.commons.codec.binary.Base64;

import javax.enterprise.context.ApplicationScoped;
import java.io.*;

@ApplicationScoped
// https://myjeeva.com/convert-image-to-string-and-string-to-image-in-java.html#download-source-code
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
