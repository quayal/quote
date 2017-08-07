package pl.loysys.app.data.client;

public class ClientTO {
    String name;
    Long id;

    public ClientTO() {
    }

    public ClientTO(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
