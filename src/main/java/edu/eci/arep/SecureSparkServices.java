package edu.eci.arep;

import static spark.Spark.*;


public class SecureSparkServices {

    public static void main(String[] args) {
        port(getPort());

        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath, truststorePassword);
        secure("keystores/ecikeystore.p12", "123456", null, null);

        get("/hello", (req, res) -> "Hello services!");
    }

    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     * <p>
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

}
