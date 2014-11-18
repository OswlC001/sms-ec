/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBeans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author SiperProg
 */
public class MetodoPost {

    public MetodoPost() {
    }

    public boolean ejecutar(String host, String puerto, String numero, String mensaje) {
        URL url;

        try {
            String a = "http://" + host + ":" + puerto + "/?phone=" + numero + "&msg=" + mensaje;
            url = new URL(a);
            URLConnection conn = url.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                System.out.println(inputLine);
            }

            br.close();
            System.out.println("SMS Enviado Correctamente");
            return true;

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
