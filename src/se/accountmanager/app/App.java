package se.accountmanager.app;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import se.accountmanager.view.AccountView;

public class App {
	private static AccountView view = new AccountView();
	
	public static void main(String[] arg) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8001), 0);
        server.createContext("/", new MainHandler());
        server.createContext("/api", new ApiHandler());
        server.start();
        System.out.println("listening 8001");
    }

    static  class MainHandler implements HttpHandler{
        public void handle(HttpExchange exchange) throws IOException {
        	System.out.println("Received main request");
        	view.respondMain(exchange);
        }
    }
    
    static  class ApiHandler implements HttpHandler{
    	public void handle(HttpExchange exchange) throws IOException	{
    		System.out.println("Received api request"); 
    		view.respondApi(exchange);
    
    	}
    }
}
