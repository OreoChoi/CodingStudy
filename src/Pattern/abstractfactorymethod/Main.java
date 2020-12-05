package Pattern.abstractfactorymethod;

import Pattern.abstractfactorymethod.abstractfactory.FactoryOfComputerFactory;
import Pattern.abstractfactorymethod.factory.ComputerFactory;

/**
 * 추상화 팩토리 메서드 예제 시작점
 *
 * 아래 실행 구문을 보면 둘이 흡사하다고 생각할 수있다
 * 각각의 factory 클래스에 들어가 비교해 보자.
 * */
public class Main {
    public static void main(String[] args){
        //팩토리 메서드 시
        ComputerFactory factory = new ComputerFactory();
        Computer samCom = factory.createComputer(CompanyType.SAMSUNG);

        //추상화 팩토리 메서드 시
        FactoryOfComputerFactory abFactory = new FactoryOfComputerFactory();
        Computer lgCom = abFactory.createComputer(CompanyType.LG);
    }
}
