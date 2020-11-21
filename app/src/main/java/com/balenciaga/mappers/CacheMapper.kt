package com.balenciaga.mappers

import com.balenciaga.databases.ProductEntity
import com.balenciaga.domains.Product
import com.balenciaga.utils.EntityMapper
import javax.inject.Inject

// Converts an Entity Object to a Domain Object
class CacheMapper @Inject constructor() : EntityMapper<ProductEntity, Product> {
    override fun mapFromEntity(entity: ProductEntity): Product {
        return Product(
            id = entity.id,
            name = entity.name,
            price = entity.price,
            description = entity.description,
            colors = entity.colors.split(",").map { it.trim() },
            sizes = entity.sizes.split(",").map { it.trim() },
            dimensions = entity.dimensions,
            composition = entity.composition,
            details = entity.details.split(",").map { it.trim() }
        )
    }

    override fun mapToEntity(domain: Product): ProductEntity {
        return ProductEntity(
            id = domain.id,
            name = domain.name,
            price = domain.price,
            description = domain.description,
            colors = domain.colors.joinToString(),
            sizes = domain.sizes.joinToString(),
            dimensions = domain.dimensions,
            composition = domain.composition,
            details = domain.details.joinToString()
        )
    }

    fun mapFromEntityList(entities: List<ProductEntity>) : List<Product> {
        return entities.map { mapFromEntity(it) }
    }
}