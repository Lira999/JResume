package com.softserveinc.ita.jresume.business.xslt;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Service;

import com.softserveinc.ita.jresume.business.utils.FileUtils;

/**
 * Class to operate with XSLT files.
 * 
 * @author Golovii Sergii
 */
@Service
public final class XsltTransformer {
    
    /**
     * Instance of {@link javax.xml.transform.TransformerFactory}.
     */
    private TransformerFactory transformerFactory =
            TransformerFactory.newInstance();
    
    /**
     * Perform data transformation in according to schema.
     * 
     * @param input
     *            source data to be transform
     * @param schema
     *            xsl transformation schema
     * @param output
     *            target output stream to write converted data
     * @throws XstlTransformerException
     *             in case of wrong input parameters or during transformation
     *             process.
     */
    public void transform(final InputStream input,
            final File schema, final OutputStream output)
            throws XstlTransformerException {
        if (input == null || schema == null || output == null) {
            throw new XstlTransformerException(
                    "Some of paramaters might not have been initialized");
        }
        if (!FileUtils.getExtension(schema).equalsIgnoreCase("xsl")) {
            throw new XstlTransformerException(
                    "Wrong schema format. Schema file should have xsl "
                            + "extension");
        }
        try {
            StreamSource inputStreamSource = new StreamSource(input);
            StreamSource schemaStreamSource = new StreamSource(schema);
            Transformer transformer =
                    transformerFactory.newTransformer(schemaStreamSource);
            StreamResult resultStream = new StreamResult();
            resultStream.setOutputStream(output);
            transformer.transform(inputStreamSource, resultStream);
        } catch (TransformerConfigurationException e) {
            throw new XstlTransformerException(
                    "Exception in transformer configuration", e);
        } catch (TransformerException e) {
            throw new XstlTransformerException("Transformation exception", e);
        }
        
    }
    
}
