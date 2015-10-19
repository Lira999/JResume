package com.softserveinc.ita.jresume.persistence.dao.impl.jpa;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.jresume.common.entity.Ordering;
import com.softserveinc.ita.jresume.persistence.dao.impl.OrderingDAO;

/**
 * Implementation of Ordering DAO.
 */
@Repository
public class JPAOrderingDAO extends JPAGenericDAO<Ordering, Long>
        implements OrderingDAO {
    
}
