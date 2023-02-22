package com.ashok.demos.repository

import com.ashok.demos.entity.*
import io.quarkus.hibernate.reactive.panache.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class EC2Repository: PanacheRepository<EC2> {
    fun findByName(name: String) = find("name", name).firstResult<EC2>()
    fun deleteInstance(id: Long) = delete("id", id)
}







