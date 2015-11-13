package com.softserveinc.ita.jresume.business.converter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.docx4j.convert.in.xhtml.XHTMLImporterImpl;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.springframework.stereotype.Service;

/**
 * Converter that convert html data to .doc format.
 * 
 * @author Andriy Zykhor
 */
@Service
public class DOCConverter {
    /**
     * This method converts html to doc.
     * 
     * @param bytes
     *            the bytes of html code to convert
     * @return bytes that corresponds pdf
     * @throws DocumentException
     *             in case of wrong document
     * @throws Docx4JException
     *             in case of conversion exception
     */
    public final byte[] convert(final byte[] bytes) throws Docx4JException {
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
                .createPackage();
        XHTMLImporterImpl xHTMLImporter = new XHTMLImporterImpl(wordMLPackage);
        xHTMLImporter.setHyperlinkStyle("Hyperlink");
        wordMLPackage.getMainDocumentPart().getContent().addAll(xHTMLImporter
                .convert(new ByteArrayInputStream(bytes), null));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        wordMLPackage.save(output);
        return output.toByteArray();
    }
}
