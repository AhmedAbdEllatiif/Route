package com.example.ahmedd.route.API.Survey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Survey {

    @SerializedName("opinion")
    @Expose
    private String opinion;
    @SerializedName("answers")
    @Expose
    private List<Answer> answers = null;

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

}
