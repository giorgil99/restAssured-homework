package Models;

public class UnsuccessfulCase {

    private  String error;

    @Override
    public String toString() {
        return "DeserializationTest.UnsuccessfulCase{" +
                "error='" + error + '\'' +
                '}';
    }

    public UnsuccessfulCase() {
    }


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
