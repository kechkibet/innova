package com.application.innova.web.treasurybond;

import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.application.innova.entity.TreasuryBond;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import java.util.Map;

public class TreasuryBondEdit extends AbstractEditor<TreasuryBond> {
    @Inject
    private Datasource<TreasuryBond> treasuryBondDs;

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
        treasuryBondDs.addItemChangeListener(e -> {
            TreasuryBond treasuryBond = e.getItem();

            treasuryBond.setName("Security type: Tbond, Currency:"+treasuryBond.getBondType().getCurrency()+" Face value: "+treasuryBond.getFaceValue());
        });
    }
}