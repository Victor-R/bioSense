/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosense.util;

/**
 *
 * @author Lucas Leandro
 */
public class StringUtils {

    public static boolean IsNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
