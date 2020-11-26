package Pattern.factorymethod.product;

/**
 * 생성 할 대상
 * 갤럭시 탭(상품)
 */
public class GalaxyTab extends Product {
    private ProductType type;

    public GalaxyTab(ProductType type) {
        super(type, GalaxyTab.class.getSimpleName());
        this.type = type;
    }

    @Override
    public void printFunc() {
        System.out.println("나의 기능은 우주를 tab으로 나눌 수 있어");
    }
}
