/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sunrisedentalclinic;

/**
 *
 * @author Dinuli Disara
 */

import javax.swing.SwingUtilities;
import view.LoginForm;
 
public class SunriseDentalClinic { 

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new LoginForm().setVisible(true);
        });
    }
}
