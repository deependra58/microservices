package com.deependra.estore.ProductService.command.interceptor;

import com.deependra.estore.ProductService.command.CreateProductCommand;
import com.deependra.estore.ProductService.core.data.ProductEntity;
import com.deependra.estore.ProductService.core.data.ProductLookupEntity;
import com.deependra.estore.ProductService.core.data.ProductLookupRepository;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.BiFunction;

@Component
public class CreateProductCommandInterceptor implements MessageDispatchInterceptor<CommandMessage<?>> {

    private final ProductLookupRepository productLookupRepository;

    public CreateProductCommandInterceptor(ProductLookupRepository productLookupRepository){
        this.productLookupRepository=productLookupRepository;
    }

    private static final Logger LOGGER= LoggerFactory.getLogger(CreateProductCommandInterceptor.class);
    @Override
    public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(List<? extends CommandMessage<?>> list) {
        return (index,command)->{
            LOGGER.info("Intercepted command:"+command.getPayloadType());
            if(CreateProductCommand.class.equals(command.getPayloadType())){
                CreateProductCommand createProductCommand=(CreateProductCommand)command.getPayload();
                ProductLookupEntity productLookupEntity=productLookupRepository.findByProductIdOrTitle(createProductCommand.getProductId(),createProductCommand.getTitle());
                if(productLookupEntity!=null)
                    throw new IllegalStateException("Product with productId ot title already exist ");

            }
            return command;
        };

    }
}
