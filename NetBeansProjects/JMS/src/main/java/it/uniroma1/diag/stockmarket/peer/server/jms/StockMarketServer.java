/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1.diag.stockmarket.peer.server.jms;

/**
 *
 * @author biar
 */
public class StockMarketServer {

	public static void main(String args[]) throws Exception {

	NotificatoreAcquisto n = new NotificatoreAcquisto();
                n.start();	
            
            ProduttoreQuotazioni q = new ProduttoreQuotazioni();
		q.start();
                
                
	}
}