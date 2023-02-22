package com.ashok.demos.repository

import com.ashok.demos.entity.VPC
import io.quarkus.hibernate.reactive.panache.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class VPCRepository: PanacheRepository<VPC> {
    fun findByName(name: String) = find("name", name).firstResult<VPC>()
    fun deleteInstance(id: Long) = delete("id", id)
}