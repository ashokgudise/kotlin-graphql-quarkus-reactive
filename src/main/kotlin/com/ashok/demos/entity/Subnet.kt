package com.ashok.demos.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Cacheable
@Table(schema = "sysopsdb", name="subnet")
class Subnet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="subnet_id")
    var id: Long? = null

    @Column(name ="subnet_name")
    lateinit var name: String

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "vpc_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    val vpc: VPC? = null

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "az_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    val azone: Azone? = null

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, mappedBy = "subnet")
    val ec2s: Set<EC2> = HashSet<EC2>()
}