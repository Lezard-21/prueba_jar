package uv.mx;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import spark.Request;
import spark.Response;
import spark.Route;

public class AnimalApi {
    static Gson gson = new Gson();
    static List<Animal> listaClientes = new ArrayList<>();

    public static Route mostrar = (Request req, Response res) -> {
        res.type("application/json");
        if (!listaClientes.isEmpty()) {
            return gson.toJson(listaClientes);
        } else {
            res.status(404);
            return null;
        }
        // return gson.toJson(AnimalDAO.getAllAnimales());
    };
    
    public static Route buscarPorId = (Request req, Response res) -> {
        String id = req.queryParams("id");
        res.type("application/json");
        Animal c = null;
        boolean band = false;
        for (Animal dueño : listaClientes) {
            if (id != null && dueño.getId().equals(id)) {
                c = dueño;
                band = true;
            }
        }
        if (band) {
            return gson.toJson(c);
        }else{
            res.status(404);
            return null;
        }
        // return gson.toJson(AnimalDAO.GetAnimalFromId(id));
    };

    public static Route agregar = (Request req, Response res) -> {
        Animal user = gson.fromJson(req.body(), Animal.class);
        String id = UUID.randomUUID().toString();
        user.setId(id);
        listaClientes.add(user);
        // AnimalDAO.createAnimal(user);
        res.type("application/json");
        res.status(200);
        return gson.toJson(id);
    };

    public static Route eliminar = (Request req, Response res) -> {
        String id = req.params(":id");
        Animal c = null;
        boolean band = false;
        for (Animal cliente : listaClientes) {
            if (id != null && cliente.getId().equals(id)) {
                c = cliente;
                band = true;
            }
        }
        if (band) {
            listaClientes.remove(c);
            return gson.toJson(c);
        }else{
            res.status(404);
            return null;
        }
    };

    public static Route modificar = (Request req, Response res) -> {
        Animal user = gson.fromJson(req.body(), Animal.class);    
        res.type("application/json");
        Animal c = null;
        boolean band = false; 
        for (Animal cliente : listaClientes) {
            if (user.getId() != null && cliente.getId().equals(user.getId())) {
                c = cliente;
                band = true;
            }
        }  
        if (band) {
            // res.status(200);
            listaClientes.remove(c);
            listaClientes.add(user);
            return gson.toJson(user);
        }else{
            res.status(404);
            return null;
        }
    };
}
