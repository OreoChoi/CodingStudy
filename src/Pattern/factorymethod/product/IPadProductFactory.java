package Pattern.factorymethod.product;

/**
 * 아이패드(상품)을 생성할 클래스
 * */
public class IPadProductFactory extends ProductFactory {

    @Override
    protected Product createProduct(ProductType type) {
        switch (type) {
            case NORMAL:
                return new IPad(type);
            case PRO:
                return new IPadAir(type);
            default:
                return new IPad(ProductType.NORMAL);
        }
    }
}
