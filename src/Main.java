import controller.Controller;
import view.View;

public class Main {
    public static void main(String[] args) {
        var view = new View();
        var controller = new Controller(view);

        while(controller.mainloop());
    }
}
