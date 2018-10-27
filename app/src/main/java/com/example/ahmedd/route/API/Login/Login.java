package com.example.ahmedd.route.API.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private ModeratorData data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ModeratorData getData() {
        return data;
    }

    public void setData(ModeratorData data) {
        this.data = data;
    }
}
