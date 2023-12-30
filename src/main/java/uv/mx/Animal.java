package uv.mx;
public class Animal {
    private String id;
    private String especie;
    private String nombre;
    private String motivo;
    private String id_Dueño;

    public Animal(String id, String especie, String nombre,String motivo, String id_Dueño) {
        this.id = id;
        this.especie = especie;
        this.nombre = nombre;
        this.motivo = motivo;
        this.id_Dueño = id_Dueño;
    }  
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getId_Dueño() {
        return id_Dueño;
    }
    public void setId_Dueño(String id_Dueño) {
        this.id_Dueño = id_Dueño;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
}
