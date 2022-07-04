package com.deependra.estore.ProductService.command.rest

import com.deependra.estore.ProductService.command.CreateProductCommand
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Random
import java.util.UUID
import javax.validation.Valid

@RestController
@RequestMapping("/products")
class ProductCommandController( @Autowired val commandGateway: CommandGateway) {

    @PostMapping
    fun createProducts(@Valid @RequestBody model: CreateProductRestModel): Any {

        var returnValue:Any?=null;
        var productId =UUID.randomUUID();
        try {
            returnValue = commandGateway.sendAndWait<Any>(CreateProductCommand(productId,model.title,model.price,model.quantity));
        } catch (ex: Exception) {
            return ex.getLocalizedMessage();
        }
        return returnValue
    }


}