package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.model.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Repository
@Transactional
public class UserRepository {
    private final static String TAG_ = "UserRepository";
    @PersistenceContext
    EntityManager entityManager;

    public List<Customer> getAllCustomers(){
        log.info(TAG_ + "-> calling getAllCustomer function");
        //entityManager.createQuery("select c from Cocktail c join c.recipeList");
//        entityManager.createQuery("select c "
//                + "from Cocktail c join MultipleRecipe mr "
//                + "on mr.cocktail = c.name");

        List<Customer> list = entityManager.createQuery("select c from Customer c join c.pets", Customer.class).getResultList();
        log.info(TAG_ + "-> result of getAllCustomer function = " + list.toString());
        return list;
    }

}
