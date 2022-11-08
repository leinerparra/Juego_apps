package com.example.trivia;

import java.util.ArrayList;
import java.util.List;

public class BancoPreguntas {

    //Futbol

    private static List<ListaPreguntas> futbolPreguntas()
    {

        final List<ListaPreguntas> questionLists = new ArrayList<>();

        //Preguntas

        final ListaPreguntas pregunta1 = new ListaPreguntas("¿Qué selección ganó la primera Copa del Mundo (1930)?", "Colombia","Japon","Uruguay","Chile","Uruguay","");
        final ListaPreguntas pregunta2 = new ListaPreguntas("¿Qué selección tiene más títulos en la Copa del Mundo?", "Argentina","Brasil","Alemania","España","Brasil","");
        final ListaPreguntas pregunta3 = new ListaPreguntas("¿Qué selección llegó a tres finales de la Copa del Mundo pero nunca ganó el título?", "Holanda","Mexico","Argentina","Francia","Holanda","");
        final ListaPreguntas pregunta4 = new ListaPreguntas("¿En qué Copa del Mundo Diego Maradona firmó la famosa 'Mano de Dios'?", "Africa","Brasil","Mexico","Alemania","Mexico","");
        final ListaPreguntas pregunta5 = new ListaPreguntas("¿Qué jugador fue expulsado por morder a otro en el Mundial de 2014?", "Messi","Cr7","Suarez","Falcao","Suarez","");

        //Preguntas añadir

        questionLists.add(pregunta1);
        questionLists.add(pregunta2);
        questionLists.add(pregunta3);
        questionLists.add(pregunta4);
        questionLists.add(pregunta5);

        return questionLists;
    }

    //Basket

    private static List<ListaPreguntas> basketPreguntas()
    {

        final List<ListaPreguntas> questionLists = new ArrayList<>();

        //Preguntas

        final ListaPreguntas pregunta1 = new ListaPreguntas("¿De cuántos jugadores pueden ser los equipos?", "5","6","4","7","5","");
        final ListaPreguntas pregunta2 = new ListaPreguntas("¿A qué altura está colocado el aro para las canastas en Metros?", "2","3","3.5","2.5","3","");
        final ListaPreguntas pregunta3 = new ListaPreguntas("¿Cuántas señales sonoras hay?", "1","0","3","2","2","");
        final ListaPreguntas pregunta4 = new ListaPreguntas("¿En cuántos periodos se divide el partido?", "2","3","4","5","4","");
        final ListaPreguntas pregunta5 = new ListaPreguntas("¿Con qué parte del cuerpo se agarra la pelota?", "Esternon","Cara","pies","Mano","Mano","");

        //Preguntas añadir

        questionLists.add(pregunta1);
        questionLists.add(pregunta2);
        questionLists.add(pregunta3);
        questionLists.add(pregunta4);
        questionLists.add(pregunta5);

        return questionLists;
    }

    //Ciclismo

    private static List<ListaPreguntas> ciclcismoPreguntas()
    {

        final List<ListaPreguntas> questionLists = new ArrayList<>();

        //Preguntas

        final ListaPreguntas pregunta1 = new ListaPreguntas("¿Desde cuándo se disputa el Tour de Francia?", "1903","1899","1910","1902","1903","");
        final ListaPreguntas pregunta2 = new ListaPreguntas("¿En qué fecha se corre el Tour? de Francia", "Julio","Agosto","Junio","Mayo","Junio","");
        final ListaPreguntas pregunta3 = new ListaPreguntas("¿Cuantos equipos Compiten?", "10","18","20","22","22","");
        final ListaPreguntas pregunta4 = new ListaPreguntas("¿Cuáles son el maximo de etapas que se disputan?", "18","21","22","19","21","");
        final ListaPreguntas pregunta5 = new ListaPreguntas("¿Que significa la camisa rosada", "Lider","Manager","Ultimo","Peaton","Lider","");

        //Preguntas añadir

        questionLists.add(pregunta1);
        questionLists.add(pregunta2);
        questionLists.add(pregunta3);
        questionLists.add(pregunta4);
        questionLists.add(pregunta5);

        return questionLists;
    }


}

