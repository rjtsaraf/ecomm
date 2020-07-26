package com.ecommerce.shoppinghub.services;

import com.ecommerce.shoppinghub.DTO.ListProductDTO;
import com.ecommerce.shoppinghub.DTO.ProductDTO;
import com.ecommerce.shoppinghub.domain.Product;
import com.ecommerce.shoppinghub.domain.User;
import com.ecommerce.shoppinghub.exceptions.BadRequestException;
import com.ecommerce.shoppinghub.exceptions.NotFoundException;
import com.ecommerce.shoppinghub.mapper.ProductMapper;
import com.ecommerce.shoppinghub.repositories.ProductRepository;
import com.ecommerce.shoppinghub.security.AuthTokenFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        logger.info("fetching product with adminId : {} ", productDTO.getAdmin_id());
        Product product = productRepository.save(productMapper.convertProductDTOToProduct(productDTO));
        return productMapper.convertProductToProductDTO(product);

    }

    @Override
    public ListProductDTO getAllProducts() {
        return new ListProductDTO(productRepository.findAll()
                .stream()
                .map(productMapper::convertProductToProductDTO)
                .collect(Collectors.toList()));
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent())
            throw new NotFoundException("product not found");
        Product product = productOptional.get();

        return productMapper.convertProductToProductDTO(product);


    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        Optional<Product> productOptional = productRepository.findByIdAndIsDeleted(productDTO.getId(), false);

        if (!productOptional.isPresent())
            throw new NotFoundException("product not found");

        Product product = productOptional.get();
        if (productDTO.getProduct_code() != null)
            product.setProduct_code(productDTO.getProduct_code());
        if (productDTO.getProduct_name() != null)
            product.setProduct_name(productDTO.getProduct_name());
        product.setAdmin_id(productDTO.getAdmin_id());
        productRepository.save(product);
        return productMapper.convertProductToProductDTO(product);
    }

    @Override
    public ProductDTO deleteProduct(Long id) {
        Optional<Product> productOptional = productRepository.findByIdAndIsDeleted(id, false);
        if (!productOptional.isPresent())
            throw new NotFoundException("No active product found");
        Product product = productOptional.get();
        product.setDeleted(true);
        Product updatedProduct = productRepository.save(product);
        return productMapper.convertProductToProductDTO(updatedProduct);

    }
}
