package com.application.innova.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum TradeStatus implements EnumClass<Integer> {

    Order_Received(10),
    Ticket_Generated(20),
    Settled(30),
    Complete(40);

    private Integer id;

    TradeStatus(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static TradeStatus fromId(Integer id) {
        for (TradeStatus at : TradeStatus.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}