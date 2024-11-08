package org.example;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class ServicesCats {

    public static void showCats() throws IOException {
        // 1. traer lo datos de la api
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/images/search").get().build();
        Response response = client.newCall(request).execute();

        String elJson = response.body().string();

        //Cortar corchetes del Json
        elJson = elJson.substring(1,elJson.length());
        elJson = elJson.substring(0,elJson.length()-1);

        //Convertir imagen en objeto Gatos
        Gson gson = new Gson();
        Gatos gatos = gson.fromJson(elJson, Gatos.class);

        //Redimensionar imagen
        Image image = null;
        try {
            URL url = new URL(gatos.getUrl());
            image = ImageIO.read(url);

            ImageIcon fondoGato = new ImageIcon(image);

            if (fondoGato.getIconWidth() > 800) {
                Image fondo = fondoGato.getImage();
                Image modificada = fondo.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
                fondoGato = new ImageIcon(modificada);
            }

            String menu = "Opciones: \n" +
                    " 1. Ver otra imagen \n"
                    + " 2. Favorito \n" +
                    " 3. Volver";
            String[] botones = {"Ver otra imagen ", "Favorito", "Volver"};
            String idGatos = gatos.getId();
            String option = (String) JOptionPane.showInputDialog(null,menu,idGatos,JOptionPane.INFORMATION_MESSAGE,fondoGato,botones,botones[0]);

            int selection = -1;
            for(int i=0; i<botones.length;i++){
                if(option.equals(botones[i])){
                    selection = i;
                }
            }

            switch (selection){
                case 0:
                    showCats();
                    break;
                case 1:
                    favoritoGato(gatos);
                    break;
                default:
                    break;
            }

        }catch(IOException e) {
            System.out.println(e);
        }



    }

    public static void favoritoGato(Gatos gato){

    }
}
