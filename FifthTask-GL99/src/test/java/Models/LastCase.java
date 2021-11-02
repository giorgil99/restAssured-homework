package Models;

import java.time.ZonedDateTime;

public class LastCase {

   private String name ;
   private String job ;
   private String id ;
   private ZonedDateTime createdAt;

    @Override
    public String toString() {
        return "DeserializationTest.LastCase{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", id='" + id + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public LastCase() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        dateConverter(createdAt);
    }


    private  void dateConverter(String date) {
        this.createdAt = ZonedDateTime.parse(date);

    }
}
