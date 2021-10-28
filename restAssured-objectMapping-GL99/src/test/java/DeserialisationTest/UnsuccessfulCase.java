package DeserialisationTest;

public class UnsuccessfulCase {

    private  String error;

    @Override
    public String toString() {
        return "DeserialisationTest.UnsuccessfulCase{" +
                "error='" + error + '\'' +
                '}';
    }

    public UnsuccessfulCase() {
    }

    public UnsuccessfulCase(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
