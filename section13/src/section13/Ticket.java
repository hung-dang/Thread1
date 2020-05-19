/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package section13;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Ticket implements Runnable {

    public int soVe;

    public void setSoVe() {
        this.soVe = 1;
    }

    public synchronized void muaVe() throws InterruptedException {
        if (soVe > 0) {
            Thread.sleep(100);
            soVe = soVe - 1;
            //if(soVe>=0{
            //Thread.sleep(100);
            ///soVe =soVe-1;
            //  }
            System.out.println(soVe);
        } else {
            System.out.println("het ve");
        }
    }

    @Override
    public void run() {
        try {
            muaVe();
        } catch (InterruptedException ex) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        t1.start();
        t2.start();
    }
}
