package Pattern.abstractfactorymethod.factory;

import Pattern.abstractfactorymethod.CompanyType;
import Pattern.abstractfactorymethod.Keyboard;
import Pattern.abstractfactorymethod.LGKeyboard;
import Pattern.abstractfactorymethod.SamsungKeyboard;

public class KeyboardFactory {
    public Keyboard createKeyboard(CompanyType type){
        Keyboard keyboard;
        switch (type){
            case LG:
                keyboard = new LGKeyboard();
                break;
            case SAMSUNG:
                keyboard = new SamsungKeyboard();
                break;
            default:
                keyboard = null;
        }

        return keyboard;
    }
}
