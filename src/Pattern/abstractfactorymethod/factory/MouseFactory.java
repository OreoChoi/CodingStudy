package Pattern.abstractfactorymethod.factory;

import Pattern.abstractfactorymethod.CompanyType;
import Pattern.abstractfactorymethod.LGMouse;
import Pattern.abstractfactorymethod.Mouse;
import Pattern.abstractfactorymethod.SamsungMouse;

public class MouseFactory {
    public Mouse createMouse(CompanyType type){
        Mouse mouse;
        switch (type){
            case SAMSUNG:
                mouse = new SamsungMouse();
                break;
            case LG:
                mouse = new LGMouse();
                break;
            default:
                mouse = null;
        }
        
        return mouse;
    }
}
