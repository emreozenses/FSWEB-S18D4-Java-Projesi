package com.workintech.FSWEBS18D4JavaProjesi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Address",schema = "fsweb")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "street")
    private String street;

    @Column(name = "no")
    private int no;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    //Column definition yazmak yerine @Lob da yazılabilir!
    @Column(name = "description",columnDefinition = "TEXT",nullable = true)
    private String description;

    @OneToOne(cascade = {CascadeType.DETACH ,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},mappedBy = "address")
    private Customer customer;



}
