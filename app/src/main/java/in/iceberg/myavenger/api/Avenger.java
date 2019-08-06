package in.iceberg.myavenger.api;

import com.google.gson.annotations.SerializedName;

public class Avenger {

    @SerializedName("name")
    private String name;
    @SerializedName("realname")
    private String realname;
    @SerializedName("team")
    private String team;
    @SerializedName("firstappearance")
    private String firstappearance;
    @SerializedName("createdby")
    private String createdby;
    @SerializedName("publisher")
    private String publisher;
    @SerializedName("imageurl")
    private String imageurl;
    @SerializedName("bio")
    private String bio;

    public Avenger(String name, String realname, String team, String firstappearance,
                   String createdby, String publisher, String imageurl, String bio) {
        this.name = name;
        this.realname = realname;
        this.team = team;
        this.firstappearance = firstappearance;
        this.createdby = createdby;
        this.publisher = publisher;
        this.imageurl = imageurl;
        this.bio = bio;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setFirstappearance(String firstappearance) {
        this.firstappearance = firstappearance;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public String getRealname() {
        return realname;
    }

    public String getTeam() {
        return team;
    }

    public String getFirstappearance() {
        return firstappearance;
    }

    public String getCreatedby() {
        return createdby;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getBio() {
        return bio;
    }
}
