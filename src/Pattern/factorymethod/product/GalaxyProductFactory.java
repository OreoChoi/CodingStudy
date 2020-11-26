package Pattern.factorymethod.product;

/**
 * 갤럭시탭(상품)을 생성할 클래스
 */
public class GalaxyProductFactory extends ProductFactory {
    @Override
    protected Product createProduct(ProductType type) {
        switch (type) {
            case NORMAL:
                return new GalaxyTab(type);
            case PRO:
                return new GalaxyTabNew(type);
            default:
                return new GalaxyTab(ProductType.NORMAL);
        }
    }
}
