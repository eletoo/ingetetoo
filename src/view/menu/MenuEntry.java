package view.menu;

import controller.Selectable;

public class MenuEntry<T> {

    private String title;
    private Selectable<T> action;

    public MenuEntry(String title, Selectable<T> action){
        this.title = title;
        this.action = action;
    }

    public String getTitle(){
        return title;
    }

    public Selectable<T> getAction(){
        return action;
    }

}
