package com.softserveinc.ita.jresume.business.generator;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.softserveinc.ita.jresume.business.xslt.XsltTransformer;
import com.softserveinc.ita.jresume.business.xslt.XstlTransformerException;
import com.softserveinc.ita.jresume.common.entity.Template;
import com.softserveinc.ita.jresume.common.entity.UserInformation;

/**
 * This class generates html code of user resume.
 * 
 * @author Andriy Zykhor
 */
public class ResumeGenerator {
    
    /**
     * This method retrieves generated resume to OutputStream.
     * 
     * @param userInformation
     *            the information about user for resume
     * @param template
     *            the template to use
     * @param output
     *            target output stream to write converted data
     * @throws ResumeGeneratorException
     *             in case of wrong input parameters or during generation
     *             process
     */
    public final void generateResume(final UserInformation userInformation,
            final Template template, final OutputStream output)
            throws ResumeGeneratorException {
        if (userInformation == null || template == null || output == null) {
            throw new ResumeGeneratorException(
                    "Some of paramaters might not have been initialized");
        }
        File schema = new File("src/main/resources/templates/" + template
                .getName() + ".xsl");
        if (!schema.exists() || schema.isDirectory()) {
            throw new ResumeGeneratorException("Schema is not found.");
        }
        
        try {
            InputStream inputXmlData = convertToXml(userInformation);
            XsltTransformer transformer = new XsltTransformer();
            transformer.transform(inputXmlData, schema, output);
        } catch (JAXBException e) {
            throw new ResumeGeneratorException("XML conversion exception", e);
        } catch (XstlTransformerException e) {
            throw new ResumeGeneratorException("Exception in xslt transformer",
                    e);
        }
    }
    
    /**
     * This method converts object UserInformation to XML representation.
     * 
     * @param userInformation
     *            the object to convert
     * @return InputStream of XML representation
     * @throws JAXBException
     *             in the case of an error in the conversion
     */
    private InputStream convertToXml(final UserInformation userInformation)
            throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(userInformation
                .getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        jaxbMarshaller.marshal(userInformation, stringWriter);
        return new BufferedInputStream(new ByteArrayInputStream(stringWriter
                .toString().getBytes()));
    }
}
