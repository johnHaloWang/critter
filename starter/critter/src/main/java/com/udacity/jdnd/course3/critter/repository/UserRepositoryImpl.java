package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.model.dto.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.model.entity.Customer;
import com.udacity.jdnd.course3.critter.model.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Customer saveCustomer(Customer customer) {
        entityManager.persist(customer);
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> list =entityManager.createQuery("Select c from Customer c", Customer.class).getResultList();
        return list;
    }

    @Override
    public Customer getOwnerByPet(long petId) {
        return null;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee getEmployee(long employeeId) {
        return null;
    }

    @Override
    public void setAvailability(Set<DayOfWeek> daysAvailable, long employeeId) {

    }

    @Override
    public List<Employee> findEmployeesForService(EmployeeRequestDTO employee) {
        return null;
    }
}
