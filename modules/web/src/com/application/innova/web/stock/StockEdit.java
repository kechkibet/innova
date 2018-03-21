package com.application.innova.web.stock;

import com.application.innova.entity.Security;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.application.innova.entity.Stock;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

public class StockEdit extends AbstractEditor<Stock> {

    @Inject
    private Datasource<Stock> stockDs;


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
        stockDs.addItemPropertyChangeListener(e -> {
            Stock stock = e.getItem();
            stock.setName("Security Type: Stock, Symbol: "+stock.getCompany().getSymbol()+" Company: "+stock.getCompany().getName());
        });
    }
}