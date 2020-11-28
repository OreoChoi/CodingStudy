package Pattern.factorymethod;

import Pattern.factorymethod.product.*;

/**
 * [main 메서드 실행 결과]
 *
 * NORMAL Type의 GalaxyTab를 만듭니다.
 * NORMAL Type의 GalaxyTab를 사용합니다.
 * 나의 기능은 우주를 tab으로 나눌 수 있어
 *
 * PRO Type의 GalaxyTabNew를 만듭니다.
 * PRO Type의 GalaxyTabNew를 사용합니다.
 * 나의 기능은 새로운 우주를 만드는 것이야
 *
 * NORMAL Type의 IPad를 만듭니다.
 * NORMAL Type의 IPad를 사용합니다.
 * 나의 기능은 사과를 접시에 담는 것이야
 *
 * PRO Type의 IPadAir를 만듭니다.
 * PRO Type의 IPadAir를 사용합니다.
 * 나의 기능은 날아다니기야
 * */
public class Main {
    public static void main(String[] args){
        ProductFactory gpf = new GalaxyProductFactory();
        Product galTab1 = gpf.create(ProductType.NORMAL);
        galTab1.use();
        galTab1.printFunc();
        Product galTab2 = gpf.create(ProductType.PRO);
        galTab2.use();
        galTab2.printFunc();

        System.out.println("");

        ProductFactory ipf = new IPadProductFactory();
        Product iPad1 = ipf.create(ProductType.NORMAL);
        iPad1.use();
        iPad1.printFunc();
        Product iPad2 = ipf.create(ProductType.PRO);
        iPad2.use();
        iPad2.printFunc();
    }
}