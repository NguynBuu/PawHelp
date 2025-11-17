package com.example.pawhelp;

public class TeamMember {
    private String name;
    private String position;
    private String description;
    private String status;
    private int avatarResId;

    public TeamMember(String name, String position, String description, String status, int avatarResId) {
        this.name = name;
        this.position = position;
        this.description = description;
        this.status = status;
        this.avatarResId = avatarResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAvatarResId() {
        return avatarResId;
    }

    public void setAvatarResId(int avatarResId) {
        this.avatarResId = avatarResId;
    }
}
