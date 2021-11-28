package com.toadsdewin.FootballLeague.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "match")
public class MatchModel
{
    @Id
    private String id;
    private UserModel userModel;        //User information
    private TeamModel local;            //This is the local team information
    private TeamModel visitor;          //This is the visitor team information
    private String data;
    private int localScores;
    private int visitorScores;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public TeamModel getLocal() {
        return local;
    }

    public void setLocal(TeamModel local) {
        this.local = local;
    }

    public TeamModel getVisitor() {
        return visitor;
    }

    public void setVisitor(TeamModel visitor) {
        this.visitor = visitor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getLocalScores() {
        return localScores;
    }

    public void setLocalScores(int localScores) {
        this.localScores = localScores;
    }

    public int getVisitorScores() {
        return visitorScores;
    }

    public void setVisitorScores(int visitorScores) {
        this.visitorScores = visitorScores;
    }
}
