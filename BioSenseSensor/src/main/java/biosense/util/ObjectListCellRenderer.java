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

    /**
     * Lida com os casos em que o model de um JComboBox é um objeto,
     * sobrescrevendo nesses casos o texto visualizado nos itens do combobox
     *
     * @param list
     * @param value
     * @param index
     * @param isSelected
     * @param cellHasFocus
     * @return O componente com seu value formatado caso seja seja um objeto
     */
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
