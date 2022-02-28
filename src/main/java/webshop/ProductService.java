package webshop;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saleProduct(long id, int amount) {
        Product productToSale = productRepository.findProductById(id);
        if (productToSale.getStock() < amount) {
            throw new IllegalArgumentException("Not enough products!");
        }
        else {
            productRepository.updateProductStock(id, amount);
        }
    }
}
