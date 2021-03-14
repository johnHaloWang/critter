package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.model.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.model.entity.Customer;
import com.udacity.jdnd.course3.critter.model.entity.Employee;
import com.udacity.jdnd.course3.critter.utility.DTO_Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.util.List;

@Slf4j
@Repository
@Transactional
public class UserRepository {
    private final static String TAG_ = "UserRepository";
    @PersistenceContext
    EntityManager entityManager;

    public List<Customer> getAllCustomers(){
        return entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }

    public Customer saveCustomer(Customer customer){
        entityManager.persist(customer);
        return customer;
    }

    public Customer findCustomerById(long id){
        //Customer customer = entityManager.createQuery("select c from Customer c where c.id = '" + cid + "'", Customer.class).getSingleResult();
        Customer customer = entityManager.find(Customer.class, id);
        return customer;
    }


//    public void findExample(Long id) {
//        Person p = entityManager.find(Person.class, id); //retrieve an instance by its key
//        p.setFavoriteComposer("Sir Malcolm Arnold"); // will update database
//    }


    //    public Customer getCusomterById(Long cid){
//        log.info(TAG_ + "-> calling getCusomterById function before with " + cid);
//        Customer customer = entityManager.createQuery("select c from Customer c where c.id = '" + cid + "'", Customer.class).getSingleResult();
//
//        //Customer customer = entityManager.createQuery("select Customer from Customer C where c.user.id = :id", Customer.class).getSingleResult();
//        log.info(TAG_ + "-> result of saveCustomer function = " + customer);
//        return customer;
//    }


}
