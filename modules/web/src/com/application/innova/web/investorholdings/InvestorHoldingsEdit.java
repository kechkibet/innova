package com.application.innova.web.investorholdings;

import com.application.innova.entity.*;
import com.haulmont.cuba.core.app.DataService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

public class InvestorHoldingsEdit extends AbstractEditor<InvestorHoldings> {
    @Inject
    private Datasource<InvestorHoldings> investorHoldingsDs;
    @Inject
    private DataManager dataManager;

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
        investorHoldingsDs.addItemPropertyChangeListener(e -> {
            InvestorHoldings investorHoldings = e.getItem();
            //set the default trade status here...
            investorHoldings.setTradeStatus(TradeStatus.Order_Received);

            if (investorHoldings.getSecurity()!=null && investorHoldings.getPrice()!= null && investorHoldings.getQuantity()!=null){

                if (investorHoldings.getSecurity() instanceof Stock) {
                    //Stock stock = (Stock) investorHoldings.getSecurity();
                    LoadContext<Stock> stockLoadContext = LoadContext.create(Stock.class).setId(investorHoldings.getSecurity().getId()).setView("_local");

                    Stock stock = dataManager.load(stockLoadContext);
                    //stocks can be sold in units of one
                    investorHoldings.setTradeValue(investorHoldings.getQuantity()*investorHoldings.getPrice());
                }
                if (investorHoldings.getSecurity() instanceof TreasuryBond) {
                    //TreasuryBond treasuryBond = (TreasuryBond) investorHoldings.getSecurity();
                    LoadContext<TreasuryBond> treasuryBondLoadContext = LoadContext.create(TreasuryBond.class).setId(investorHoldings.getSecurity().getId()).setView("_local");

                     TreasuryBond treasuryBond= dataManager.load(treasuryBondLoadContext);
                     //tbonds can only be sold  in qty of 100s so we have to mult by 100(takes care of sale and buy in one go)!
                    investorHoldings.setTradeValue(treasuryBond.getFaceValue()*investorHoldings.getPrice()*investorHoldings.getQuantity()*100);
                }
            }
        });
    }

    /**
     * Hook to be implemented in subclasses. Called by the framework when all validation is done and datasources are
     * going to be committed.
     *
     * @return true to continue, false to abort
     */
    @Override
    protected boolean preCommit() {
        showNotification(investorHoldingsDs.getItem().getTradeValue().toString());

        return super.preCommit();
    }
}