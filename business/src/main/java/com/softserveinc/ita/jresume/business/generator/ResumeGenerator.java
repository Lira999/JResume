package com.softserveinc.ita.jresume.business.generator;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.jresume.business.converter.XMLConverter;
import com.softserveinc.ita.jresume.business.xslt.XsltTransformer;
import com.softserveinc.ita.jresume.business.xslt.XstlTransformerException;
import com.softserveinc.ita.jresume.common.entity.Template;
import com.softserveinc.ita.jresume.common.entity.UserInformation;

/**
 * This class generates html code of user resume.
 * 
 * @author Andriy Zykhor
 */
@Service
public class ResumeGenerator {
    
    /** Object to operate with xsl files. */
    @Autowired
    private XsltTransformer xsltTransformer;
    
    /** Converter that converts from object to XML representation. */
    @Autowired
    private XMLConverter xmlConverter;
    
    /** Path to folder to save files. */
    @Value("${fileUpload.path}")
    private String uploadPath;
    
    /**
     * This method retrieves generated resume to OutputStream.
     * 
     * @param userInformation
     *            the information about user for resume
     * @param template
     *            the template to use
     * @return output stream with writed html data
     * @throws ResumeGeneratorException
     *             in case of wrong input parameters or during generation
     *             process
     */
    public final OutputStream generate(final UserInformation userInformation,
            final Template template) throws ResumeGeneratorException {
        if (userInformation == null || template == null) {
            throw new ResumeGeneratorException(
                    "Some of paramaters might not have been initialized");
        }
        
        File schema = new File(uploadPath + "\\" + template.getName() + ".xsl");
        if (!schema.exists() || schema.isDirectory()) {
            throw new ResumeGeneratorException("Schema is not found");
        }
        
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            InputStream inputXmlData = xmlConverter.convert(userInformation);
            xsltTransformer.transform(inputXmlData, schema, output);
        } catch (JAXBException e) {
            throw new ResumeGeneratorException("XML conversion exception", e);
        } catch (XstlTransformerException e) {
            throw new ResumeGeneratorException("Exception in xslt transformer",
                    e);
        }
        return output;
    }
}
