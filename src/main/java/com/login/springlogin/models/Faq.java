package com.login.springlogin.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "faq")
public class Faq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "pregunta")
    private String pregunta;
    @Column(name = "respuesta")
    private String respuesta;
    @Column(name = "archivo")
    private String path_file;
    public Faq() {
    }
    public Faq(String pregunta, String respuesta, String path_file) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.path_file = path_file;
    }
    public Faq(String pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }
    public Faq(int id, String pregunta, String respuesta, String path_file) {
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
