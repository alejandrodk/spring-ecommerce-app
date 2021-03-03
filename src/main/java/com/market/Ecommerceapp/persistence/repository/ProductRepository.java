package com.market.Ecommerceapp.persistence.repository;

import com.market.Ecommerceapp.domain.dal.ProductDAL;
import com.market.Ecommerceapp.domain.repository.ProductRepositoryInterface;
import com.market.Ecommerceapp.persistence.crud.ProductCrudRepository;
import com.market.Ecommerceapp.persistence.entity.Product;
import com.market.Ecommerceapp.persistence.mapper.ProductDalMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements ProductRepositoryInterface {
    private final ProductCrudRepository productCrudRepository;
    private final ProductDalMapper mapper;

    public ProductRepository(ProductCrudRepository productCrudRepository, ProductDalMapper mapper) {
        this.productCrudRepository = productCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductDAL> getAll() {
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return mapper.toProductsDal(products);
    }

    @Override
    public Optional<List<ProductDAL>> getByCategory(int categoryId) {
        List<Product> products = productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProductsDal(products));
    }

    @Override
    public Optional<List<ProductDAL>> getScaseProducts(int stockQuantity) {
        Optional<List<Product>> products = productCrudRepository.findByStockLessThanAndStatus(stockQuantity, true);
        return products.map(mapper::toProductsDal);
    }

    @Override
    public Optional<ProductDAL> getProduct(int productId) {
        Optional<Product> product = productCrudRepository.findById(productId);
        return product.map(mapper::toProductDal);
    }

    @Override
    public ProductDAL create(ProductDAL product) {
        Product newProduct = mapper.toProduct(product);
        return mapper.toProductDal(productCrudRepository.save(newProduct));
    }

    @Override
    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }
}
