
package models;

public class Doctor {
    private String id, name, spec;
    private int avail;

    public Doctor(String id, String name, String spec, int avail) {
        this.id = id;
        this.name = name;
        this.spec = spec;
        this.avail = avail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public int getAvail() {
        return avail;
    }

    public void setAvail(int avail) {
        this.avail = avail;
    }

    @Override
    public String toString() {
        return String.format("%-5s | %-18s | %-15s | %s ", id, name, spec, avail);
    }
}
