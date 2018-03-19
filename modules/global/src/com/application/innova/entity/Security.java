package com.application.innova.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.DiscriminatorValue;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorType;
import javax.persistence.Inheritance;
import javax.persistence.DiscriminatorColumn;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("S")
@NamePattern("%s|name")
@Table(name = "INNOVA_SECURITY")
@Entity(name = "innova$Security")
public class Security extends StandardEntity {
    private static final long serialVersionUID = -5499844469890361118L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}