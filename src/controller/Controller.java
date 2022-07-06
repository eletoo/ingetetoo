package controller;

import model.User;
import view.View;
import view.menu.MenuEntry;

import java.util.Arrays;
import java.util.List;

public class Controller {

    private View view;
    private User currentUser = null;

    public Controller(View view){
        this.view = view;
    }

    private List<Action<Boolean>> publicActions = Arrays.asList(
            new Action<>(Prompt.ACTION_LOGIN, this::login),
            new Action<>(Prompt.ACTION_REGISTER, this::register),
            new Action<>(Prompt.ACTION_EXIT, this::exit)
    );

    public boolean mainloop(){
        if(currentUser == null)
            return this.view.chooseAction(publicActions, Prompt.WELCOME_PROMPT).runAction();
        else
            return false;
    }

    public Boolean login(){
        return true;
    }

    public Boolean register(){
        return true;
    }

    public Boolean exit(){
        //save
        return false;
    }

}
