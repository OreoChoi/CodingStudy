package Pattern.abstractfactorymethod.abstractfactory;

import Pattern.abstractfactorymethod.Computer;
import Pattern.abstractfactorymethod.CompanyType;

/**
 * AbstractFactory클래스
 *  이전 ComputerFactory 클래스와 다르게
 *  Keyboard, Mouse, Moniter 등과 같은 factory를 전부 생성 하지 않고
 *  AbstractComputerFactory를 만들어 한 클래스에서
 *  관리 하도록 변경 되있는 것을 확인 할 수 있습니다.
 * */
public class FactoryOfComputerFactory {
    public Computer createComputer(CompanyType type){
        AbStractComputerFactory factory;
        switch (type){
            case SAMSUNG:
                factory = new SamsungComputerFactory();
                break;
            case LG:
                factory = new LGComputerFactory();
                break;
            default: factory = null;
        }

        return new Computer(factory.createKeyboard(),factory.createMouse());
    }
}
