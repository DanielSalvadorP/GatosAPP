package org.example;
import javax.swing.JOptionPane;

public class Inicio {
    public static void main(String[] args){
        int menuOption = -1;
        String[] botones = { "1. Ver gatos", "2. Salir"};
        do {
            String option = (String) JOptionPane.showInputDialog(null, "Gatitos java", "Menu principal",
                    JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);

            //Validacion de opción de usuario
            for(int i=0; i<botones.length;i++){
                if(option.equals(botones[i])){
                    menuOption = i;
                }
            }

            switch (menuOption){
                case 0:
                    ServicesCats.showCats();
                    break;
                default:
                    break;
            }
        } while (menuOption != 1);

    }
}
