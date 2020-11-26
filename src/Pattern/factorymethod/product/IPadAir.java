package Pattern.factorymethod.product;

/**
 * 생성 할 대상
 * 아이패드(상품)
 */
public class IPadAir extends Product {
    private ProductType type;

    public IPadAir(ProductType type) {
        super(type, IPadAir.class.getSimpleName());
        this.type = type;
    }

    @Override
    public void printFunc() {
        System.out.println("나의 기능은 날아다니기야");
    }
}
