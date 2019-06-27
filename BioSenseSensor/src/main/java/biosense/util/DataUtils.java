/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosense.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Lucas Leandro
 */
public class DataUtils {

    public static String GregorianCalendarToString(XMLGregorianCalendar date) {
        Calendar calendar = date.toGregorianCalendar();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setTimeZone(calendar.getTimeZone());
        String dateString = formatter.format(calendar.getTime());
        return dateString;
    }

    public static XMLGregorianCalendar GetTodayDate() {
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        } catch (DatatypeConfigurationException ex) {
            return null;
        }
    }
}
