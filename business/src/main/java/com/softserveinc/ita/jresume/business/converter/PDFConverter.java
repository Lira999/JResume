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
public class PDFConverter implements Converter {
    
    /**
     * This method converts html to pdf.
     * 
     * @param bytes
     *            the bytes of html code to convert
     * @return bytes that corresponds pdf
     * @throws ConverterException
     *             in case of conversion process
     */
    public final byte[] convert(final byte[] bytes) throws ConverterException {
        try (ByteArrayInputStream input = new ByteArrayInputStream(bytes);
                ByteArrayOutputStream output = new ByteArrayOutputStream();) {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, output);
            document.open();
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, input);
            document.close();
            return output.toByteArray();
        } catch (DocumentException e) {
            throw new ConverterException("Exception with document", e);
        } catch (IOException e) {
            throw new ConverterException(e);
        }
    }
}
