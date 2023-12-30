package uv.mx;

import static spark.Spark.before;
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.path;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.put;

import com.google.gson.Gson;
/**
 * A simple api for web
 *
 */
public class App 
{
    static Gson gson = new Gson();
    public static void main( String[] args )
    {
        port(getAssignedPort());

        // get("/clientes", ClienteApi.mostrar);
        // get("/clientes/byId", ClienteApi.buscarPorId);
        // post("/clientes", ClienteApi.agregar);
        // delete("/clientes/:id", ClienteApi.eliminar);
        // patch("/clientes", ClienteApi.modificar); 
        path("/api", () -> {
            path("/clientes", () -> {
                post("/auth",      ClienteApi.auth);
                get("/get",        ClienteApi.mostrar);
                get("/getbyId",    ClienteApi.buscarPorId);
                post("/add",       ClienteApi.agregar);
                put("/change",     ClienteApi.modificar);
                delete("/remove/:id",  ClienteApi.eliminar);
            });
            path("/owners", () -> {
                get("/get",        DueñoApi.mostrar);
                get("/getbyId",    DueñoApi.buscarPorId);
                post("/add",       DueñoApi.agregar);
                put("/change",     DueñoApi.modificar);
                delete("/remove/:id",  DueñoApi.eliminar);
            });
            path("/animales", () -> {
                get("/get",        AnimalApi.mostrar);
                post("/add",       AnimalApi.agregar);
                get("/getbyId",    AnimalApi.buscarPorId);
                put("/change",     AnimalApi.modificar);
                delete("/remove/:id",  AnimalApi.eliminar);
            });
        });

    }
    static int getAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("MYSQLPORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("MYSQLPORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}

