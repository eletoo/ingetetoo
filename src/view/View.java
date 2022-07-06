package view;

import controller.Action;
import controller.Prompt;
import controller.Selectable;
import view.menu.MenuEntry;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {

    private PromptMap prompts = new PromptMap();

    public <T> Selectable<T> chooseAction(List<Action<T>> list, Prompt prompt){
        return this.choose(
                list.stream()
                        .map(e -> new MenuEntry<>(this.prompts.get(e.getTitle()), () -> e.getAction()))
                        .collect(Collectors.toList()), prompt);
    }

    private <T> T choose(List<MenuEntry<T>> chooseList, Prompt prompt){
        System.out.println(this.prompts.get(prompt));
        for (int i = 0; i < chooseList.size(); i++) {
            System.out.println(i + ") " + chooseList.get(i).getTitle());
        }

        do{
            var i = getInt("Selezionare un'opzione");
            if(i < 0 || i >= chooseList.size())
                continue;
            return chooseList.get(i).getAction().runAction();
        } while (true);
    }

    private int getInt(String prompt){
        while (true) {
            try {
                System.out.print(prompt);
                return new Scanner(System.in).nextInt();
            } catch (NumberFormatException | InputMismatchException e) {
                System.err.println("Formato non valido");
            }
        }
    }
}
