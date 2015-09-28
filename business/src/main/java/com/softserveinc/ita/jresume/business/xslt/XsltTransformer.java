package com.softserveinc.ita.jresume.business.xslt;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Class to operate with XSLT files.
 * 
 * @author Golovii Sergii
 */
public final class XsltTransformer {
    
    /**
     * Perform data transformation in according to schema.
     * 
     * @param input
     *            source data to be transform
     * @param schema
     *            xsl transformation schema
     * @param output
     *            target output stream to write converted data
     * @throws TransformerException
     *             in case of errors during transformation or if schema file is
     *             not initialized
     * @throws IOException
     *             in case of wrong input file format
     */
    public void transform(final InputStream input,
            final File schema, final OutputStream output)
            throws TransformerException, IOException {
        if (!getExtension(schema).equalsIgnoreCase("xsl")) {
            throw new IOException(
                    "Wrong schema format. Schema file should have xsl "
                            + "extension");
        }
        StreamSource inputStreamSource = new StreamSource(input);
        StreamSource schemaStreamSource = new StreamSource(schema);
        TransformerFactory transformerFactory =
                TransformerFactory.newInstance();
        Transformer transformer =
                transformerFactory.newTransformer(schemaStreamSource);
        StreamResult resultStream = new StreamResult();
        resultStream.setOutputStream(output);
        transformer.transform(inputStreamSource, resultStream);
    }
    
    /**
     * Method to get file extension.
     * 
     * @param file
     *            target file to get extension
     * @return extension of file or <strong>null</strong> in case of not
     *         existing extension.
     */
    private String getExtension(final File file) {
        String fileName = file.getAbsolutePath();
        int i = fileName.lastIndexOf('.');
        if (i != -1) {
            return fileName.substring(i + 1);
        }
        return null;
    }
    
}
