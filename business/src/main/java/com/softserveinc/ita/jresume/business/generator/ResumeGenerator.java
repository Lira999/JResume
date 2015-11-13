package com.softserveinc.ita.jresume.business.generator;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBException;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;
import com.softserveinc.ita.jresume.business.converter.DOCConverter;
import com.softserveinc.ita.jresume.business.converter.PDFConverter;
import com.softserveinc.ita.jresume.business.converter.XMLConverter;
import com.softserveinc.ita.jresume.business.xslt.XsltTransformer;
import com.softserveinc.ita.jresume.business.xslt.XstlTransformerException;
import com.softserveinc.ita.jresume.common.dto.TemplateDTO;
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
    
    /** Converter that converts from html code to PDF representation. */
    @Autowired
    private PDFConverter pdfConverter;
    
    /** Converter that converts from html to document representation. */
    @Autowired
    private DOCConverter docConverter;
    
    /** Path to folder to save files. */
    @Value("${fileUpload.path}")
    private String uploadPath;
    
    /**
     * This method retrieves generated resume to OutputStream.
     * 
     * @param userInformation
     *            the information about user for resume
     * @param templateDTO
     *            the template to use
     * @return array of bytes with writed html data
     * @throws ResumeGeneratorException
     *             in case of wrong input parameters or during generation
     *             process
     */
    public final byte[] generate(final UserInformation userInformation,
            final TemplateDTO templateDTO) throws ResumeGeneratorException {
        if (userInformation == null || templateDTO == null) {
            throw new ResumeGeneratorException(
                    "Some of paramaters might not have been initialized");
        }
        
        File schema = new File(uploadPath + "/" + templateDTO.getName()
                + ".xsl");
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
        return output.toByteArray();
    }
    
    /**
     * This method retrieves generated resume in pdf format to array of bytes.
     * 
     * @param userInformation
     *            the information about user for resume
     * @param templateDTO
     *            the template to use
     * @return array of bytes with writed pdf data
     * @throws ResumeGeneratorException
     *             in case of wrong input parameters or during generation
     *             process
     */
    public final byte[] generatePdf(final UserInformation userInformation,
            final TemplateDTO templateDTO) throws ResumeGeneratorException {
        byte[] bytes = generate(userInformation, templateDTO);
        try {
            return pdfConverter.convert(bytes);
        } catch (IOException e) {
            throw new ResumeGeneratorException("PDF conversion IOException", e);
        } catch (DocumentException e) {
            throw new ResumeGeneratorException(
                    "PDF conversion DocumentException", e);
        }
    }
    
    /**
     * This method retrieves generated resume in doc format to array of bytes.
     * 
     * @param userInformation
     *            the information about user for resume
     * @param templateDTO
     *            the template to use
     * @return array of bytes with writed doc data
     * @throws ResumeGeneratorException
     *             in case of wrong input parameters or during generation
     *             process
     */
    public final byte[] generateDoc(final UserInformation userInformation,
            final TemplateDTO templateDTO) throws ResumeGeneratorException {
        byte[] bytes = generate(userInformation, templateDTO);
        try {
            return docConverter.convert(bytes);
        } catch (Docx4JException e) {
            throw new ResumeGeneratorException("DOC conversion exception", e);
        }
    }
}
