package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class FonctionsUtiles {
	
	public static boolean download_base64image_from_url(String src, String pathOutputImagePNG) {
        try {
        	String base64Image = src.split(",")[1]; // supprimer le préfixe : data:image/png;base64,
    		byte[] imageBytes = Base64.getDecoder().decode(base64Image);
			FileUtils.writeByteArrayToFile(new File(pathOutputImagePNG), imageBytes);
			System.out.println("Image downloaded successfully : "+pathOutputImagePNG);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
        return true;
	}
		
	public static String extractTextFromImage(String imagePath) {
		//download and install (windows) : https://sourceforge.net/projects/tesseract-ocr-alt/files/tesseract-ocr-setup-3.02.02.exe/download
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("src/test/resources/Tesseract-OCR/tessdata/");
        tesseract.setLanguage("eng");
        try {
            String text = tesseract.doOCR(new File(imagePath));
            text = text.replaceAll("[^a-zA-Z]", "");
            if (text != null) {
	            System.out.println("Extracted text: " + text);
	        } else {
	            System.out.println("Failed to extract text.");
	        }
            return text;
        } catch (TesseractException e) {
            e.printStackTrace();
            return null;
        }
    }

}
