/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosense.util;

import biosensews.ws.Planta;
import biosensews.ws.Usuario;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author Lucas Leandro
 */
public class ObjectListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {
        if (value instanceof Usuario) {
            value = ((Usuario) value).getNome();
        } else if (value instanceof Planta) {
            Planta planta = (Planta) value;
            value = planta.getTipoPlanta().getNome() + " - " + DataUtils.GregorianCalendarToString(planta.getDataPlantio());
        }
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        return this;
    }
}
