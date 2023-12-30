package uv.mx;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.google.gson.Gson;

import spark.Request;
import spark.Response;
import spark.Route;

public class DueñoApi {
    static Gson gson = new Gson();
    static List<Dueño> listaDueños = new ArrayList<>();
    public static Route mostrar = (Request req, Response res) -> {
        res.type("application/json");
        if (!listaDueños.isEmpty()) {
            return gson.toJson(listaDueños);
        }else{
            res.status(404);
            return null;
        }
        // return gson.toJson(DueñoDAO.getAllDueños());
    };
    
    public static Route buscarPorId = (Request req, Response res) -> {
        String id = req.queryParams("id");
        res.type("application/json");
        Dueño c = null;
        boolean band = false;
        for (Dueño dueño : listaDueños) {
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
        // return gson.toJson(listaDueños);
        // return gson.toJson(DueñoDAO.GetDueñoFromId(id));
    };

    public static Route agregar = (Request req, Response res) -> {
        Dueño user = gson.fromJson(req.body(), Dueño.class);
        String id = UUID.randomUUID().toString();
        user.setId(id);
        // DueñoDAO.createUsuario(user);
        listaDueños.add(user);
        res.type("application/json");
        res.status(200);
        return gson.toJson(id);
    };

    public static Route eliminar = (Request req, Response res) -> {
        // String id = req.queryParams("id");
        String id = req.params(":id");
        Dueño c = null;
        boolean band = false;
        for (Dueño dueño : listaDueños) {
            if (id != null && dueño.getId().equals(id)) {
                c = dueño;
                band = true;
            }
        }
        if (band) {
            listaDueños.remove(c);
            return gson.toJson(c);
        }else{
            res.status(404);
            return null;
        }
    };

    public static Route modificar = (Request req, Response res) -> {
        res.type("application/json");
        Dueño user = gson.fromJson(req.body(), Dueño.class); 
        Dueño c = null;
        boolean band = false; 
        for (Dueño dueño : listaDueños) {
            if (user.getId() != null && dueño.getId().equals(user.getId())) {
                c = dueño;
                band = true;
            }
        }  
        if (band) {
            // res.status(200);
            listaDueños.remove(c);
            listaDueños.add(user);
            return gson.toJson(user);
        }else{
            res.status(404);
            return null;
        }
        // return gson.toJson( DueñoDAO.modifyUsuario(user));
    };

    public static Route auth = (Request req, Response res) -> {
        Dueño user = gson.fromJson(req.body(), Dueño.class);  
        System.out.println(user);
        Dueño c = null;
        boolean band = false;
        for (Dueño dueño : listaDueños) {
            if (dueño.getId() != null && dueño.getId().equals(dueño.getId())) {
                c = dueño;
                band = true;
            }
        }
        if (band) {
            return true;
        }else{
            res.status(404);
            return false;
        }
    };
}
