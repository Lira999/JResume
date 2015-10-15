package com.softserveinc.ita.jresume.common.adapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Xml adapter for date format.
 * 
 * @author Andriy Zykhor
 */
public class JAXBDateAdapter extends XmlAdapter<String, Date> {
    
    /** Object that represent date format. */
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    @Override
    public final Date unmarshal(final String date) throws ParseException {
        return dateFormat.parse(date);
    }
    
    @Override
    public final String marshal(final Date date) {
        return dateFormat.format(date);
    }
}
