package controller;

public class Action<T> {

    private Prompt title;
    private Selectable<T> action;

    public Action(Prompt title, Selectable<T> action){
        this.title = title;
        this.action = action;
    }

    public Prompt getTitle(){
        return title;
    }

    public Selectable<T> getAction(){
        return action;
    }

}
