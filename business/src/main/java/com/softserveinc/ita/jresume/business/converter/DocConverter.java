package com.softserveinc.ita.jresume.business.converter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.docx4j.convert.in.xhtml.XHTMLImporterImpl;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.springframework.stereotype.Service;

/**
 * Converter that convert html data to .doc format.
 * 
 * @author Andriy Zykhor
 */
@Service
public class DocConverter implements Converter {
    
    @Override
    public final byte[] convert(final byte[] bytes) throws ConverterException {
        try (ByteArrayOutputStream output = new ByteArrayOutputStream();) {
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
                    .createPackage();
            XHTMLImporterImpl xHTMLImporter = new XHTMLImporterImpl(
                    wordMLPackage);
            xHTMLImporter.setHyperlinkStyle("Hyperlink");
            wordMLPackage.getMainDocumentPart().getContent().addAll(
                    xHTMLImporter.convert(new ByteArrayInputStream(bytes),
                            null));
            wordMLPackage.save(output);
            return output.toByteArray();
        } catch (InvalidFormatException e) {
            throw new ConverterException("Invalid format exception", e);
        } catch (Docx4JException e) {
            throw new ConverterException("Exception during conversion process",
                    e);
        } catch (IOException e) {
            throw new ConverterException(e);
        }
    }
}
