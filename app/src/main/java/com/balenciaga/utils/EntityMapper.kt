package com.balenciaga.utils

interface EntityMapper<Entity, Domain> {
    fun mapFromEntity(entity: Entity) : Domain
    fun mapToEntity(domain: Domain) : Entity
}