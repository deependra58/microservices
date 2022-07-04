package com.deependra.estore.ProductService.command;

import com.deependra.estore.ProductService.core.data.ProductLookupEntity;
import com.deependra.estore.ProductService.core.data.ProductLookupRepository;
import com.deependra.estore.ProductService.core.events.ProductCreatedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("product-group")
public class ProductLookupEventHandler {

    private final ProductLookupRepository productLookupRepository;

    public ProductLookupEventHandler(ProductLookupRepository productLookupRepository){
        this.productLookupRepository=productLookupRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent event){
        ProductLookupEntity productLookupEntity=new ProductLookupEntity(event.getProductId(),event.getTitle());
        productLookupRepository.saveAndFlush(productLookupEntity);

    }
}
