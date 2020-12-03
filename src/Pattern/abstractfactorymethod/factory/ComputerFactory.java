package Pattern.abstractfactorymethod.factory;


import Pattern.abstractfactorymethod.CompanyType;
import Pattern.abstractfactorymethod.Computer;

/**
 *  ComputerFactory 클래스
 *  - 본 클래스에서는
 *    Keyboard,Mouse 2가지 팩토리 클래스를 활용해
 *    Computer를 factory합니다.
 *
 *    만약 Keyboard, Mouse 뿐만 아닌 생성할 부품(객체)가
 *    많아 지면 그에 맞춰 xFactory, nFactory 등이 생성 되어
 *    다수의 Factory 메서드를 생성 해야 할 것 입니다.
 *
 *    그렇다면 생각외로 늘어버린 factory 메서드를
 *    한단계 Factory로 패키징 한 것이 AbstractFactory 입니다.
 *    다음 파일에서 보시죰
 * */
public class ComputerFactory {
    public Computer createComputer(CompanyType type) {
        KeyboardFactory keyboardFactory = new KeyboardFactory();
        MouseFactory mouseFactory = new MouseFactory();
        return new Computer(
                keyboardFactory.createKeyboard(type),
                mouseFactory.createMouse(type));
    }
}
