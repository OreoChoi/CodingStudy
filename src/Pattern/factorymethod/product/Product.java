package Pattern.factorymethod.product;

import Pattern.factorymethod.resource.StringFormat;

/**
 * 상품 - 생성될 클래스의 공통적인 특징
 */
public abstract class Product {
    private ProductType type;
    private String productName;

    /**
     * 공통적인 생성자입니다.
     * */
    Product(ProductType type, String productName) {
        this.type = type;
        this.productName = productName;
        System.out.println(StringFormat.makeProduct(type, productName));
    }

    /**
     * 기능을 사용합니다.
     */
    public void use() {
        System.out.println(StringFormat.useProduct(type, productName));
    }

    /**
     * 기능을 표시합니다.
     */
    public abstract void printFunc();
}
