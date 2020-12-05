package Pattern.abstractfactorymethod.abstractfactory;

import Pattern.abstractfactorymethod.SamsungKeyboard;
import Pattern.abstractfactorymethod.SamsungMouse;

public class SamsungComputerFactory  implements AbStractComputerFactory {

    @Override
    public SamsungKeyboard createKeyboard(){
        return new SamsungKeyboard();
    }

    @Override
    public SamsungMouse createMouse(){
        return new SamsungMouse();
    }
}
