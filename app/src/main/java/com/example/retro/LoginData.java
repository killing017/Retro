package com.example.retro;

//import javax.xml.transform.Result;

import java.util.List;

public class LoginData {
  private List<Result> result;

    public LoginData(List<Result> result) {
        this.result = result;
    }

    public List<Result> getResult() {
        return result;
    }
}
