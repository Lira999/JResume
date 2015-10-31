package com.softserveinc.ita.jresume.business.converter;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.stereotype.Service;

import com.softserveinc.ita.jresume.common.entity.UserInformation;

/**
 * Converter that convert data of user information to XML representation.
 * 
 * @author Andriy
 */
@Service
public class XMLConverter {
    
    /**
     * This method converts object UserInformation to XML representation.
     * 
     * @param userInformation
     *            the object to convert
     * @return InputStream of XML representation
     * @throws JAXBException
     *             in the case of an error in the conversion
     */
    public final InputStream convert(final UserInformation userInformation)
            throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(userInformation
                .getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        jaxbMarshaller.marshal(userInformation, stringWriter);
        return new ByteArrayInputStream(stringWriter.toString().getBytes());
    }
}
