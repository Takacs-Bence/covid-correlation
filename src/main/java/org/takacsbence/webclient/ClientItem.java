package org.takacsbence.webclient;

public class ClientItem {

    private int version;
    private String name;
    private String basePath;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    @Override
    public String toString() {
        return  "ClientItem [version=" +
                version +
                ", name=" +
                name +
                ", basePath=" +
                basePath +
                "]";
    }
}
