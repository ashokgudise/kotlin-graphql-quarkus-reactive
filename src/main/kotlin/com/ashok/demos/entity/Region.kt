package com.ashok.demos.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*


@Entity
@Cacheable
@Table(schema = "sysopsdb", name="region")
class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="region_id")
    var id: Long? = null

    @Column(name ="region_name")
    lateinit var name: String

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, mappedBy = "region")
    val azs: Set<Azone> = HashSet<Azone>()
}