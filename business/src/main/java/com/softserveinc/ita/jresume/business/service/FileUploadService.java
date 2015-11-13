package com.softserveinc.ita.jresume.business.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.jresume.business.enums.FileExtensions;

/**
 * Service to handle file uploading.
 * 
 * @author Golovii Sergii
 */
@Service
public class FileUploadService {
    
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
     * @throws IOException
     *             in case of errors during saving files
     */
    public final void saveFile(final byte[] inputData,
            final String name,
            final FileExtensions extension) throws IOException {
        String fileName = name + "." + extension.toString();
        String path = Paths.get(uploadPath, fileName).toString();
        File outputFile = new File(path);
        FileOutputStream fileOutputStream = null;
        try {
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }
            fileOutputStream =
                    new FileOutputStream(outputFile);
            fileOutputStream.write(inputData);
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }
    
}
