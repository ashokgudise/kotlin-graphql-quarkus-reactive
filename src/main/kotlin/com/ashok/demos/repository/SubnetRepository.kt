package com.ashok.demos.repository

import com.ashok.demos.entity.Subnet
import io.quarkus.hibernate.reactive.panache.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class SubnetRepository: PanacheRepository<Subnet> {
    fun findByName(name: String) = find("name", name).firstResult<Subnet>()
    fun deleteInstance(id: Long) = delete("id", id)
}