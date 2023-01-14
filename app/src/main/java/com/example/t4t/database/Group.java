package com.example.t4t.database;

public class Group {
    private String mTeamName;
    private String mType;
    public Group(String team, String type) {
        this.mTeamName = team;
        this.mType = type;
    }

    public String getTeamName() {
        return mTeamName;
    }

    public String getType() {
        return mType;
    }
}
