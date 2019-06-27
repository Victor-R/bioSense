/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosense;

import biosensews.ws.Usuario;

/**
 *
 * @author Matheus Gaseta
 */
public class UserInfo {
    
    private static Usuario user;

    public static Usuario getUser() {
        return user;
    }

    public static void setUser(Usuario user) {
        UserInfo.user = user;
    }

    
}
