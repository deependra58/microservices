package com.deependra.estore.ProductService.aggregate

import com.deependra.estore.ProductService.command.CreateProductCommand
import com.deependra.estore.ProductService.core.events.ProductCreatedEvent
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateCreationPolicy
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.modelling.command.CreationPolicy
import org.axonframework.spring.stereotype.Aggregate
import java.math.BigDecimal
import java.util.UUID

@Aggregate
class ProductAggregate {

    @AggregateIdentifier
    var productId:UUID?=null
    var title:String?=null
    var price:BigDecimal?=null
    var quantity:Integer?=null

    constructor()

    @CommandHandler
    @CreationPolicy(AggregateCreationPolicy.CREATE_IF_MISSING)
    fun handle(command: CreateProductCommand){
        if(command.price.compareTo(BigDecimal.ZERO)<=0)
            throw IllegalStateException("Price cannot be less or equal to zero");
        if(command.title==null || command.title.isBlank())
            throw IllegalStateException("Title cannot be empty");
        with(command){
            AggregateLifecycle.apply(ProductCreatedEvent(productId,title,price,quantity));
        }
    }

    @EventSourcingHandler
    fun on(event:ProductCreatedEvent){
        this.productId=event.productId
        this.price=event.price
        this.title=event.title
        this.quantity=event.quantity
    }

}