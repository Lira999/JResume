package com.softserveinc.ita.jresume.business.xslt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Utility class to operate with XSLT files.
 * 
 * @author Golovii Sergii
 */
public final class XsltUtils {
    
    /**
     * Default private constructor for this utility class.
     */
    private XsltUtils() {
        
    }
    
    /**
     * Method to transform input file in according to xslt file.
     * 
     * @param input
     *            target file to transform.
     * @param xslt
     *            xslt file
     * @param output
     *            transformed file. If file not exists, program will create it
     * @throws NullPointerException
     *             in case of not initialized files
     * @throws FileNotFoundException
     *             in case of not founded files input or schema files
     * @throws IOException
     *             in case of error during creating output file
     * @throws TransformerException
     *             in case of transformation error
     */
    public static void transform(final File input, final File xslt,
            final File output)
            throws TransformerException,
            FileNotFoundException,
            IOException {
        verifyFile(input, xslt, output);
        TransformerFactory transformerFactory =
                TransformerFactory.newInstance();
        StreamSource ss = new StreamSource(xslt);
        Transformer transformer = transformerFactory.newTransformer(ss);
        StreamSource in = new StreamSource(input);
        StreamResult out = new StreamResult(output);
        transformer.transform(in, out);
    }
    
    /**
     * Method verifies files for transformation.
     * 
     * @param input
     *            ,
     * @param xslt
     *            and
     * @param output
     *            - files to verify
     * @throws NullPointerException
     *             in case of not initialized files
     * @throws FileNotFoundException
     *             in case of not founded files input or schema files
     * @throws IOException
     *             in case of wrong file extensions or during creating output
     *             file
     */
    private static void verifyFile(final File input, final File xslt,
            final File output)
            throws FileNotFoundException, IOException {
        if (input == null || xslt == null || output == null) {
            throw new NullPointerException(
                    "Some of files may not been initialized!");
        }
        if (!input.exists() || !xslt.exists()) {
            throw new FileNotFoundException("Can't find specified file!");
        }
        // checks input file extension (should be .xml) and xslt schema
        // extension (.xsl or .xslt)
        if (!getFileExtension(input).equalsIgnoreCase("xml")
                || !getFileExtension(xslt).equalsIgnoreCase("xslt")
                && !getFileExtension(xslt).equalsIgnoreCase("xsl")) {
            throw new FileNotFoundException(
                    "Input file should be xml document");
        }
        if (!output.exists()) {
            output.createNewFile();
        }
    }
    
    /**
     * Method to get file extension.
     * 
     * @param f
     *            target file to get extension
     * @return extension of file or <strong>null</strong> in case of not
     *         existing extension
     */
    private static String getFileExtension(final File f) {
        String fileName = f.getAbsolutePath();
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            return fileName.substring(i + 1);
        }
        return null;
    }
    
}
