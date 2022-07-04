package com.deependra.estore.ProductService.core.data

import org.hibernate.annotations.Type
import java.io.Serializable
import java.math.BigDecimal
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="products")
class ProductEntity: Serializable {
    @Id
    @Type(type = "uuid-char")
    @Column(nullable = false)
    lateinit var productId:UUID
    lateinit var title:String
    lateinit var price:BigDecimal
    lateinit var quantity:Integer


}