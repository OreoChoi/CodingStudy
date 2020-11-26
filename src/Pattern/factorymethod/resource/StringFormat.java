package Pattern.factorymethod.resource;

import Pattern.factorymethod.product.ProductType;

/**
 * 문자열을 관리하는 리소스 클래스입니다.
 * */
public class StringFormat {

    //상품 생성 문구를 생성하여 반환합니다.
    public static String makeProduct(ProductType type, String productName){
        return type + " Type의 " + productName+ "를 만듭니다.";
    }

    //상품 사용 문구를 생성하여 반환합니다.
    public static String useProduct(ProductType type, String productName){
        return type + " Type의 " + productName+ "를 사용합니다.";
    }
}
