package com.ecommerce.shoppinghub.bootstrap;

import com.ecommerce.shoppinghub.domain.Type;
import com.ecommerce.shoppinghub.repositories.TypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner
{
    private final TypeRepository typeRepository;

    public DataLoader(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Type t=new Type();
        t.setValue("Admin");
        typeRepository.save(t);
        Type t1=new Type();
        t1.setValue("User");
        typeRepository.save(t1);

        System.out.println("Data Loaded = " + typeRepository.count() );
    }
}
