package com.softserveinc.ita.jresume.business.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Service to handle file uploading.
 * 
 * @author Golovii Sergii
 */
@Service
public class FileUploadService {
    
    /**
     * Logger instance.
     */
    private static final Logger LOGGER =
            Logger.getLogger(FileUploadService.class);
            
    /**
     * Path to folder to save files.
     */
    @Value("${fileUpload.path}")
    private String uploadPath;
    
    /**
     * Save data as file on server side.
     * 
     * @param inputData
     *            byte array to be saved to file
     * @param name
     *            target name of file
     * @param extension
     *            target extension of file
     * @return {@code true} if operation success or false in case of errors.
     */
    public final boolean saveFile(final byte[] inputData,
            final String name,
            final String extension) {
        boolean result = false;
        String fileName = name + "." + extension;
        String path = Paths.get(uploadPath, fileName).toString();
        LOGGER.info("Strarting write file " + fileName);
        File outputFile = new File(path);
        try {
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }
            FileOutputStream fileOutputStream =
                    new FileOutputStream(outputFile);
            fileOutputStream.write(inputData);
            fileOutputStream.close();
            result = true;
        } catch (IOException e) {
            LOGGER.error("Exception during writting file " + fileName);
        }
        return result;
    }
    
}
