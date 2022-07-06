package view;

import controller.Prompt;

import java.util.HashMap;

public class PromptMap extends HashMap<Prompt, String> {

    public PromptMap(){
        this.put(Prompt.ACTION_LOGIN, "Accedi");
        this.put(Prompt.ACTION_REGISTER, "Regisrati");
        this.put(Prompt.ACTION_EXIT, "Esci");
        this.put(Prompt.WELCOME_PROMPT, "Benvenuto, scegli un'opzione");
    }

}
