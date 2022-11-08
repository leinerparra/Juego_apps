package com.example.trivia;

public class ListaPreguntas {

    private String pregunta,opcion1,opcion2,opcion3,opcion4,respuesta;
    private String seleccionUsuario;

    public ListaPreguntas(String pregunta, String opcion1, String opcion2, String opcion3, String opcion4, String respuesta, String seleccionUsuario) {
        this.pregunta = pregunta;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcion4 = opcion4;
        this.respuesta = respuesta;
        this.seleccionUsuario = seleccionUsuario;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public String getOpcion4() {
        return opcion4;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public String getSeleccionUsuario() {
        return seleccionUsuario;
    }


}
