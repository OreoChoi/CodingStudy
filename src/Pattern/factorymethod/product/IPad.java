package Pattern.factorymethod.product;

/**
 * 생성 할 대상
 * 아이패드(상품)
 */
public class IPad extends Product {
    private ProductType type;

    public IPad(ProductType type) {
        super(type, IPad.class.getSimpleName());
        this.type = type;
    }

    @Override
    public void printFunc() {
        System.out.println("나의 기능은 사과를 접시에 담는 것이야");
    }
}
