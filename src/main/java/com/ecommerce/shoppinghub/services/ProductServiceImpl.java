package com.ecommerce.shoppinghub.services;

import com.ecommerce.shoppinghub.DTO.ListProductDTO;
import com.ecommerce.shoppinghub.DTO.ProductDTO;
import com.ecommerce.shoppinghub.domain.Product;
import com.ecommerce.shoppinghub.exceptions.BadRequestException;
import com.ecommerce.shoppinghub.mapper.ProductMapper;
import com.ecommerce.shoppinghub.repositories.ProductRepository;
import com.ecommerce.shoppinghub.security.AuthTokenFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService
{

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final  ProductRepository productRepository;
    private final ProductMapper productMapper;


    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO)
    {
        logger.info("fetching product with adminId : {} ",productDTO.getAdmin_id());
       Product product= productRepository.save(productMapper.convertProductDTOToProduct(productDTO));
       return productMapper.convertProductToProductDTO(product);

    }

    @Override
    public ListProductDTO getAllProducts()
    {
        return new  ListProductDTO( productRepository.findAll()
                .stream()
                .map(product-> productMapper.convertProductToProductDTO(product))
                .collect(Collectors.toList()));
    }
}
