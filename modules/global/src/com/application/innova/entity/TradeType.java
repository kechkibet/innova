package com.application.innova.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum TradeType implements EnumClass<Integer> {

    Sale(10),
    Purchase(20);

    private Integer id;

    TradeType(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static TradeType fromId(Integer id) {
        for (TradeType at : TradeType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}