package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.model.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.model.entity.Customer;
import com.udacity.jdnd.course3.critter.model.entity.Employee;
import com.udacity.jdnd.course3.critter.utility.DTO_Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
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
        Customer customer = entityManager.find(Customer.class, id);
        return customer;
    }

    public Employee findEmployeeById(long id){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);
        query.select(root).where(cb.equal(root.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }

    public List<Employee> findAllEmployee(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        return entityManager.createQuery(query).getResultList();
    }

    @Transactional
    public Employee saveEmployee(Employee employee) {
        JpaEntityInformation<Employee, ?> entityInformation = JpaEntityInformationSupport.getEntityInformation(Employee.class, entityManager);
        if (entityInformation.isNew(employee)) {
            entityManager.persist(employee);
            return employee;
        } else {
            return entityManager.merge(employee);
        }
    }

    public List<Employee> findEmployeesByIds(List<Long> employeeIds){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);
        query.select(root).where(root.get("id").in(employeeIds));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Employee> getAllEmployeesByDaysAvailableContains(DayOfWeek dayOfWeek){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> root = criteria.from(Employee.class);
        criteria.select(root).where(cb.isMember(dayOfWeek, root.get("daysAvailable")));
        return entityManager.createQuery(criteria).getResultList();
    }
}
