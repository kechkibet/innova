package com.application.innova.web.investorholdings;

import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.application.innova.entity.InvestorHoldings;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

public class InvestorHoldingsEdit extends AbstractEditor<InvestorHoldings> {
    @Named("fieldGroup.tradeValue")
    private TextField tradeValueField;
    @Inject
    private Datasource<InvestorHoldings> investorHoldingsDs;

    /**
     * Called by the framework after creation of all components and before showing the screen.
     * <br> Override this method and put initialization logic here.
     *
     * @param params parameters passed from caller's code, usually from
     *               {@link #openWindow(String, WindowManager.OpenType)} and similar methods, or set in
     *               {@code screens.xml} for this registered screen
     */
    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        investorHoldingsDs.addItemChangeListener(e -> {
            InvestorHoldings investorHoldings = e.getItem();
            //investorHoldings.setTradeValue(investorHoldings.getSecurity().get);\
            //check if security type is stock or tbond and set trade value accordingly
        });
    }
}