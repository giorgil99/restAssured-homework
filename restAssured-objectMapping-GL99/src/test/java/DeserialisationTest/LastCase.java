package DeserialisationTest;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LastCase {

   private String name ;
   private String job ;
   private String id ;
   private ZonedDateTime createdAt;

    @Override
    public String toString() {
        return "LastCase{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", id='" + id + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public LastCase() {
    }

    public LastCase(String name, String job, String id, String createdAt) {
        this.name = name;
        this.job = job;
        this.id = id;
        dateConverter(createdAt);
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
