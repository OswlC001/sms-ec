/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBeans;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Oswaldo Cruz
 */
@ManagedBean
@RequestScoped
public class LlamadasBacking {

    private String numero;
    final String HOST = "192.168.1.108";
    final int PUERTO = 8080;
    Socket sc;

    /**
     * Creates a new instance of LlamadasBacking
     */
    public LlamadasBacking() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void marcar(String num) {
        numero += num;
    }

    public void limpiar() {
        numero = null;
    }

    public void llamar() {
        try {
            sc = new Socket(HOST, PUERTO);
            sc.close();

        } catch (IOException ex) {
            Logger.getLogger(LlamadasBacking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void colgar() {

    }

}
