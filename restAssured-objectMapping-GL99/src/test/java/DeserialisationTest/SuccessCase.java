package DeserialisationTest;

public class SuccessCase {
    @Override
    public String toString() {
        return "DeserialisationTest.SuccessCase{" +
                "id='" + id + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    private String id;
    private String token;

    public SuccessCase() {
    }
    public SuccessCase( String id, String token) {
        this.id = id;
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
