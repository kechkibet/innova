package com.application.innova.core;

import com.application.innova.InnovaTestContainer;
import com.application.innova.entity.Security;
import com.application.innova.entity.Stock;
import com.application.innova.entity.TreasuryBond;
import com.haulmont.cuba.core.*;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.security.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SampleIntegrationTest {

    @ClassRule
    public static InnovaTestContainer cont = InnovaTestContainer.Common.INSTANCE;

    private Metadata metadata;
    private Persistence persistence;
    private DataManager dataManager;

    @Before
    public void setUp() throws Exception {
        metadata = cont.metadata();
        persistence = cont.persistence();
        dataManager = AppBeans.get(DataManager.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testLoadUser() {
        try (Transaction tx = persistence.createTransaction()) {
            EntityManager em = persistence.getEntityManager();
            TypedQuery<User> query = em.createQuery(
                    "select u from sec$User u where u.login = :userLogin", User.class);
            query.setParameter("userLogin", "admin");
            List<User> users = query.getResultList();
            tx.commit();
            assertEquals(1, users.size());
        }
    }

    @Test
    public void testStockInstanceOfSecurity() throws Exception {
        try {
            assertTrue(new Stock() instanceof Security);
            assertTrue(new  TreasuryBond() instanceof Security);
        }catch (Exception e){

        }
    }

    @Test
    public void getSecurityTotals() throws Exception {
        try (Transaction tx = persistence.createTransaction()) {
            EntityManager em = persistence.getEntityManager();
            Query query = em.createQuery(
                    "select coalesce(sum(s.quantity),0) from innova$InvestorHoldings s where s.investor.id = :investorId", Security.class);
            //query.setParameter("investorId", "a678511338e940c7956ce15d84732ebe");
            query.setParameter("investorId", UUID.fromString("084fe4c7-ad68-44aa-a7d7-97281141607c"));
            double balance = (double)query.getFirstResult();
            tx.commit();
            assertEquals(0, balance,0.1);
        }
    }
}