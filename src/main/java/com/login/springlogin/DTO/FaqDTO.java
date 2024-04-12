package com.login.springlogin.DTO;



public class FaqDTO {
    private int id;
    private String pregunta;
    private String respuesta;
    private String path_file;
    public FaqDTO() {
    }
    public FaqDTO(String pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }
    public FaqDTO(String pregunta, String respuesta, String path_file) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.path_file = path_file;
    }
    public FaqDTO(int id,String pregunta, String respuesta, String path_file) {
        this.id = id;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.path_file = path_file;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPregunta() {
        return pregunta;
    }
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    public String getRespuesta() {
        return respuesta;
    }
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    public String getPath_file() {
        return path_file;
    }
    public void setPath_file(String path_file) {
        this.path_file = path_file;
    }
    
}
