package org.example;
import javax.swing.JOptionPane;
import java.io.IOException;

public class Inicio {
    public static void main(String[] args) throws IOException {
        int menuOption = -1;
        String[] boton = { "1. Ver gatos", "2. Salir"};
        do {
            String option = (String) JOptionPane.showInputDialog(null, "Gatitos java", "Menu principal",
                    JOptionPane.INFORMATION_MESSAGE, null, boton, boton[0]);

            //Validacion de opción de usuario
            for(int i=0; i<boton.length;i++){
                if(option.equals(boton[i])){
                    menuOption = i;
                }
            }

            switch (menuOption){
                case 0:
                    CatService.showCats();
                    break;
                case 1:
                    Cat gato = new Cat();
                    CatService.showFav(gato.getApyKey());
                default:
                    break;
            }
        } while (menuOption != 1);

    }
}
