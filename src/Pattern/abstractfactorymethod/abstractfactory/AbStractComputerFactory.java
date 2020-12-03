package Pattern.abstractfactorymethod.abstractfactory;

import Pattern.abstractfactorymethod.Keyboard;
import Pattern.abstractfactorymethod.Mouse;

public interface AbStractComputerFactory {
    public Keyboard createKeyboard();
    public Mouse createMouse();
}
