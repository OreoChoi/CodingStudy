package Pattern.abstractfactorymethod.abstractfactory;

import Pattern.abstractfactorymethod.LGKeyboard;
import Pattern.abstractfactorymethod.LGMouse;

public class LGComputerFactory implements AbStractComputerFactory {

    @Override
    public LGKeyboard createKeyboard(){
        return new LGKeyboard();
    }

    @Override
    public LGMouse createMouse(){
        return new LGMouse();
    }
}
