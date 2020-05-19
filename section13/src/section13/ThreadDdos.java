/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package section13;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ThreadDdos extends Thread {

    public ThreadDdos() {
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadDdos.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < 1000; i++) {
            System.out.println("DOSS " + i);
        }
    }

    public void Dos() throws IOException {
        URL url = new URL("http://qldt.utt.edu.vn/CMCSoft.IU.Web.info/login.aspx");
        URL url1 = new URL("https://www.24h.com.vn/");
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
        for (int i = 0; i < urlCon.getHeaderFields().size(); i++) {
            System.out.println(urlCon.getHeaderFieldKey(i) + "=" + urlCon.getHeaderField(i));
        }
    }

    public static void main(String[] args) {
        ThreadDdos threadDdos = new ThreadDdos();
        try {
            threadDdos.Dos();
        } catch (IOException ex) {
            Logger.getLogger(ThreadDdos.class.getName()).log(Level.SEVERE, null, ex);
        }
        threadDdos.start();
    }

}
