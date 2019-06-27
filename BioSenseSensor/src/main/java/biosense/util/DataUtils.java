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

    /**
     * Converte para String uma data e a formata como dd/MM/yyyy
     *
     * @param date Data a ser convertida para String
     * @return Data convertida e formatada
     */
    public static String GregorianCalendarToString(XMLGregorianCalendar date) {
        Calendar calendar = date.toGregorianCalendar();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setTimeZone(calendar.getTimeZone());
        String dateString = formatter.format(calendar.getTime());
        return dateString;
    }

    /**
     * Pega a data atual no formato XMLGregorianCalendar
     *
     * @return Data atual no formato desejado
     */
    public static XMLGregorianCalendar GetTodayDate() {
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        } catch (DatatypeConfigurationException ex) {
            return null;
        }
    }
}
