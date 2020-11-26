package Pattern.factorymethod.product;

/**
 * 상품(객체)를 생성할 클래스
 * */
public abstract class ProductFactory {
    public final Product create(ProductType type) {
        Product p = createProduct(type);
        return p;
    }

    protected abstract Product createProduct(ProductType type);
}
