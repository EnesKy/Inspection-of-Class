package com.fsmvu.inspectionofclass.http;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.*;

/**
 * Server class stand for an request to predefined URL. The Server
 * will respond it in http protocol way. 
 * 
 * @author Bilal Ekrem Harmansa
 */
public class Server {
    /** the port that server listens to */
    //public static final int PORT = 5006;

    private HttpServer server;

    private static Server singleton;
    /**
     * Singleton object, only one server object should be up at a time.
     */
    public static Server getInstance() {
        if (singleton == null) { 
            singleton = new Server();
        }
        return singleton;
    }

    /**
     * Creates a new ServerSocket to listen from given port.. If there is a 
     * HttpServer at current time, stops it before creating new one.
     * 
     * @param port number that HttpServer listens
     * 
     * @return server itselfs, using Builder pattern.
     */
    public Server build(int port) throws IOException {
        if(server != null) stop();

        server = HttpServer.create(new InetSocketAddress(port), 0);
        server.setExecutor(null);
        return this;
    }

    /**
     * Javadoc quote:
     * `One or more HttpHandler objects must be associated with a server in 
     * order to process requests. Each such HttpHandler is registered with a 
     * root URI path which represents the location of the application or 
     * service on this server. The mapping of a handler to a HttpServer is 
     * encapsulated by a HttpContext object. HttpContexts are created by calling
     * createContext(String,HttpHandler). 
     */
    public Server map(String path, HttpHandler handler) {
        server.createContext(path, handler);
        return this;
    }

    /**
     * Start command to server
     */
    public void start() {
        server.start();
    }

    /** 
     * Stops server 
     */
    public void stop() {
        server.stop(1);
    }
    
}