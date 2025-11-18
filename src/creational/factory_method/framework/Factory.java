package creational.factory_method.framework;

/**
 * Template method 패턴이 사용, 추상 메서드 createProduct로 제품을 만들고,
 * 만 든 제품을 추상 메서드 registerProduct로 등록합니다. 제품 만들기와 등록하기를 하위 클래스에서 구현합니다.
 */
public abstract class Factory {
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);
}
