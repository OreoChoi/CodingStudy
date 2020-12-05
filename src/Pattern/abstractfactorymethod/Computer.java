package Pattern.abstractfactorymethod;

public class Computer {
    Keyboard keyboard;
    Mouse mouse;

    public Computer(Keyboard keyboard, Mouse mouse){
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
}
