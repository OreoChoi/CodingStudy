package Pattern.factorymethod.product;

/**
 * 생성 할 대상
 * 갤럭시 탭(상품)
 */
public class GalaxyTabNew extends Product {
    private ProductType type;

    public GalaxyTabNew(ProductType type) {
        super(type, GalaxyTabNew.class.getSimpleName());
        this.type = type;
    }

    @Override
    public void printFunc() {
        System.out.println("나의 기능은 새로운 우주를 만드는 것이야");
    }
}
