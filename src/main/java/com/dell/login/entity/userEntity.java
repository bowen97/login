package com.dell.login.entity;
import java.io.Serializable;


public class userEntity implements Serializable{
    private String userName;
    private String userPassword;
    private int id;
    private String author;
    private String content;
    private String title;
    private int traffic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTraffic() {
        return traffic;
    }

    public void setTraffic(int traffic) {
        this.traffic = traffic;
    }

    public userEntity() {
        super();
    }
    public userEntity(String userName,String userPassword){
        super();
        this.userName = userName;
        this.userPassword = userPassword;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


    @Override
    public String toString(){
        return "author: "+this.author+", title: "+this.title+";\n";
    }

}
