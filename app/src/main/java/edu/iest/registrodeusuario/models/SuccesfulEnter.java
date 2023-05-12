package edu.iest.registrodeusuario.models;

public class SuccesfulEnter {
     private int status;
     private String id;
     private String token;

     public void setStatus(int status) {
          this.status = status;
     }


     public int getStatus() {
          return status;
     }

     public String getId() {
          return id;
     }

     public String getToken() {
          return token;
     }

     public void setToken(String token) {
          this.token = token;
     }
}
