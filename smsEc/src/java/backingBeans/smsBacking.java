/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBeans;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author Oswaldo Cruz
 */
@ManagedBean
@RequestScoped
public class smsBacking {

    private final String host = "192.168.137.27";
    private final String puerto = "18080";
    private String numero;
    private String mensaje;

    public smsBacking() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void limpiar() {
        numero = null;
    }

    public void cancelar() {
        mensaje = null;
    }

    public void enviar() throws MalformedURLException, UnsupportedEncodingException, IOException {
        //Se debe instalar en el celular el app Simple SMS Server y tenerlo ejecutando permanentemente
        new MetodoPost().ejecutar(host, puerto, numero, adecuarMensaje(mensaje));
    }

    private String adecuarMensaje(String mensaje) {
        return mensaje.replace(" ", "%20");
    }

}
