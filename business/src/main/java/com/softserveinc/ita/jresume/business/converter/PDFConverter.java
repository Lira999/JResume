/**
 * 
 */
package com.softserveinc.ita.jresume.business.converter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * Converter that convert html data to PDF.
 * 
 * @author Andriy Zykhor
 */
@Service
public class PDFConverter {
    
    /**
     * This method converts html to pdf.
     * 
     * @param bytes
     *            the bytes of html code to convert
     * @return bytes that corresponds pdf
     * @throws DocumentException
     *             in case of wrong document
     * @throws IOException
     *             in case of stream exception
     */
    public final byte[] convert(final byte[] bytes) throws DocumentException,
            IOException {
        ByteArrayInputStream input = new ByteArrayInputStream(bytes);
        Document document = new Document();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        
        PdfWriter writer = PdfWriter.getInstance(document, output);
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, input);
        document.close();
        return output.toByteArray();
    }
}
