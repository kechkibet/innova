package com.application.innova.web.investorholdings;

import com.application.innova.entity.InvestorCashDeposit;
import com.application.innova.entity.InvestorHoldings;
import com.application.innova.entity.TradeStatus;
import com.application.innova.entity.TradeType;
import com.application.innova.service.AddCashDepositService;
import com.application.innova.service.GetStockBalanceService;
import com.application.innova.service.UpdateInvestorBalanceService;
import com.haulmont.cuba.core.app.PersistenceManagerService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.actions.EditAction;
import com.haulmont.cuba.gui.data.GroupDatasource;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;
import java.util.UUID;

public class InvestorHoldingsBrowse extends EntityCombinedScreen {
    @Inject
    private GroupTable<InvestorHoldings> table;

    @Inject
    private Button btnNextAction;
    @Named("table.generateTicket")
    private Action tableGenerateTicket;
    @Named("table.settleOrder")
    private Action tableSettleOrder;
    @Named("table.completeOrder")
    private Action tableCompleteOrder;

    @Inject
    private GetStockBalanceService getStockBalanceService;
    @Inject
    private AddCashDepositService addCashDepositService;
    @Inject
    private UpdateInvestorBalanceService updateInvestorBalanceService;


    @Inject
    private GroupDatasource<InvestorHoldings, UUID> investorHoldingsesDs;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        investorHoldingsesDs.addItemChangeListener(e -> {

            if (e==null) return;

            InvestorHoldings investorHoldings = table.getSingleSelected();
            btnNextAction.setEnabled(true);
            //showNotification("selected!!"+investorHoldings.getTradeValue());
            if (investorHoldings.getTradeStatus()== TradeStatus.Order_Received){
                btnNextAction.setAction(tableGenerateTicket);
                btnNextAction.setCaption("Generate Ticket");
            }
            if (investorHoldings.getTradeStatus()== TradeStatus.Ticket_Generated){
                btnNextAction.setAction(tableSettleOrder);
                btnNextAction.setCaption("Settle Order");
            }
            if (investorHoldings.getTradeStatus()== TradeStatus.Settled){
                btnNextAction.setAction(tableCompleteOrder);
                btnNextAction.setCaption("Complete Order");
            }
            if (investorHoldings.getTradeStatus()== TradeStatus.Complete){
                btnNextAction.setEnabled(false);
                btnNextAction.setCaption("Order Completed");
            }
        });
    }

    public void onGenerateTicket(Component source) {
        showOptionDialog(
                "Generate Ticket",
                "Are you sure you want to generate ticket for selected order?",
                MessageType.CONFIRMATION,
                new Action[] {
                        new DialogAction(DialogAction.Type.YES) {
                            @Override
                            public void actionPerform(Component component) {
                                investorHoldingsesDs.getItem().setTradeStatus(TradeStatus.Ticket_Generated);
                                investorHoldingsesDs.commit();
                            }
                        },
                        new DialogAction(DialogAction.Type.NO)
                }
        );

    }

    public void onSettleOrder(Component source) {
        showOptionDialog(
                "Settle Order",
                "Are you sure you want to settle Selected order?",
                MessageType.CONFIRMATION,
                new Action[] {
                        new DialogAction(DialogAction.Type.YES) {
                            @Override
                            public void actionPerform(Component component) {
                                InvestorHoldings investorHoldings = investorHoldingsesDs.getItem();
                                double cashBalance = investorHoldings.getInvestor().getCashAccountBalance();
                                double tradeValue = investorHoldings.getTradeValue();
                                if (investorHoldings.getTradeType()== TradeType.Purchase){
                                    //Check if investor has enough mooney to purchase item
                                    if (investorHoldings.getInvestor().getCashAccountBalance()>=investorHoldings.getTradeValue()){
                                        //we are good here just add the cash transaction amount
                                        addCashDepositService.addCashDeposit(investorHoldings.getInvestor().getId(),"Purchase for trade id: "+ investorHoldings.getId(), investorHoldings.getTradeValue()*-1);
                                        investorHoldingsesDs.getItem().setTradeStatus(TradeStatus.Settled);
                                        //update investor ac
                                        updateInvestorBalanceService.updateInvestorBalance(investorHoldings.getInvestor().getId(),cashBalance-tradeValue);
                                        investorHoldingsesDs.commit();

                                    }
                                    else{
                                        showNotification("Not enough deposits to effect trade");
                                    }
                                }
                                if (investorHoldings.getTradeType()== TradeType.Sale){
                                    //Check if investor has enough stocks to sell item
                                    Double stockBalance = getStockBalanceService.getStockBalance(investorHoldings.getInvestor().getId(),investorHoldings.getSecurity().getId());
                                    if (stockBalance>=investorHoldings.getTradeValue()){
                                        //we are good here just add the cash transaction amount
                                        addCashDepositService.addCashDeposit(investorHoldings.getInvestor().getId(),"Deposit for trade id: "+ investorHoldings.getId(), investorHoldings.getTradeValue());
                                        investorHoldingsesDs.getItem().setTradeStatus(TradeStatus.Settled);
                                        //update investor account
                                        updateInvestorBalanceService.updateInvestorBalance(investorHoldings.getInvestor().getId(),cashBalance+tradeValue);
                                        investorHoldingsesDs.commit();

                                    }
                                    else{
                                        showNotification("Not enough securities to effect trade: "+ stockBalance);
                                    }
                                }
                            }
                        },
                        new DialogAction(DialogAction.Type.NO)
                }
        );
    }

    public void onCompleteOrder(Component source) {
        showOptionDialog(
                "Complete Order",
                "Are you sure you want to complete selected order?",
                MessageType.CONFIRMATION,
                new Action[] {
                        new DialogAction(DialogAction.Type.YES) {
                            @Override
                            public void actionPerform(Component component) {
                                investorHoldingsesDs.getItem().setTradeStatus(TradeStatus.Complete);
                                investorHoldingsesDs.commit();
                            }
                        },
                        new DialogAction(DialogAction.Type.NO)
                }
        );

    }
}