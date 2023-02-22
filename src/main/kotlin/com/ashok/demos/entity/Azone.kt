package com.ashok.demos.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Cacheable
@Table(schema = "sysopsdb", name="azone")
class Azone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="az_id")
    var id: Long? = null

    @Column(name ="az_name")
    lateinit var name: String

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "region_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var region: Region? = null

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, mappedBy = "azone")
    var subnets: Set<Subnet> = HashSet<Subnet>()

}