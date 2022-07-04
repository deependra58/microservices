package com.deependra.estore.ProductService.core.data

import com.deependra.estore.ProductService.core.data.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ProductRepository: JpaRepository<ProductEntity, UUID> {
    fun findByProductId(productId: UUID):ProductEntity;

}