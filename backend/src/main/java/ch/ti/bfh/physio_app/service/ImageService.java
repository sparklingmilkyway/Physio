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

    public void saveImage(String imageAsBase64String, String uniqueName){
        String savingLocation = path + uniqueName +".jpg";
        convertBase64StringToFile(imageAsBase64String, savingLocation);
    }

    public String getImageString(String path){
        File image = getImageByPath(path);
        return convertFileToBase64String(image);
    }

    private String convertFileToBase64String(File file){

        String result = "";

        try {
            FileInputStream imageFile = new FileInputStream(file);
            byte data[] = new byte[(int)file.length()];
            imageFile.read(data);
            // encodes the byte array into base64 string
            result = Base64.encodeBase64URLSafeString(data);
            imageFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }

        return result;
    }


    private void convertBase64StringToFile(String baseString, String savingLocation){

        try {
            // decodes the base64 string into byte array
            byte[] imageByte = Base64.decodeBase64(baseString);
            FileOutputStream image = new FileOutputStream("/Users/Vanessa/Desktop/file.jpg");
            image.write(imageByte);
            image.close();
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }
    }


    // get image with given path
    public File getImageByPath(String path){
        File image = new File(path);
        return image;
    }

}
