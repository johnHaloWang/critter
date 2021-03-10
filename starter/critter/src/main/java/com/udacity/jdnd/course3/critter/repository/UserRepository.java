package com.udacity.jdnd.course3.critter.repository;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.jdnd.course3.critter.model.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.model.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.model.dto.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.model.dto.EmployeeSkill;
import com.udacity.jdnd.course3.critter.model.entity.Customer;
import com.udacity.jdnd.course3.critter.model.entity.Employee;
import com.udacity.jdnd.course3.critter.view.Views;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

//@Slf4j
@Repository
//@Transactional
//public class UserRepository {
public interface UserRepository extends JpaRepository<Customer, Long>{
//    private final static String TAG_ = "UserRepository";
//
//    @PersistenceContext
//    EntityManager entityManager;
//
//    public Customer getCusomterById(Long cid){
//        log.info(TAG_ + "-> calling getCusomterById function before with " + cid);
//        Customer customer = entityManager.createQuery("select c from Customer c where c.id = '" + cid + "'", Customer.class).getSingleResult();
//
//        //Customer customer = entityManager.createQuery("select Customer from Customer C where c.user.id = :id", Customer.class).getSingleResult();
//        log.info(TAG_ + "-> result of saveCustomer function = " + customer);
//        return customer;
//    }
//
//    public Customer saveCustomer(Customer customer){
//        log.info(TAG_ + "-> calling saveCustomer function before with " + customer);
//        entityManager.persist(customer);
//        log.info(TAG_ + "-> result of saveCustomer function = " + customer);
//        return customer;
//    }
//
//    public Customer updateCustomer(Customer customer){
//        log.info(TAG_ + "-> calling updateCustomer function before with " + customer);
//        //entityManager.getTransaction();
//        entityManager.merge(customer);
//        //entityManager.getTransaction().commit();
//        log.info(TAG_ + "-> result of updateCustomer function = " + customer);
//        return customer;
//    }
//
//    public List<Customer> getAllCustomer(){
//        log.info(TAG_ + "-> calling getAllCustomer function");
//        List<Customer> list = entityManager.createQuery("select c from Customer C", Customer.class).getResultList();
//        log.info(TAG_ + "-> result of getAllCustomer function = " + list.toString());
//        return list;
//    }
//
//    public Customer getOwnerByPet(long petId){
//        log.info(TAG_ + "-> calling getOwnerByPet function: " + petId);
//        Customer customer = entityManager.createQuery("select c from Customer C where c.petIds = :petId", Customer.class).getSingleResult();
//        log.info(TAG_ + "-> result of getAllCustomer function = " + customer);
//        return customer;
//    }
//
//    public Employee saveEmployee(Employee employee){
//        log.info(TAG_ + "-> calling saveEmployee function before with " + employee);
//        entityManager.persist(employee);
//        log.info(TAG_ + "-> result of saveEmployee function " + employee);
//        return employee;
//    }
//
//    public Employee getEmployee(long employeeId){
//        log.info(TAG_ + "-> calling getEmployee function before with " + employeeId);
//        Employee employee = entityManager.createQuery("select e from Employee e where e.id = :employeeId", Employee.class).getSingleResult();
//        log.info(TAG_ + "-> result of getEmployee function = " + employee);
//        return employee;
//    }
//
//    public void setAvailability(Set<DayOfWeek> daysAvailable, long employeeId){
//        log.info(TAG_ + "-> calling setAvailability function with days: " + daysAvailable + ", employeeId: " + employeeId);
//        Employee employee = getEmployee(employeeId);
//        entityManager.persist(employee);
//        employee.setDaysAvailable(daysAvailable);
//        entityManager.merge(employee);
//        log.info(TAG_ + "-> result of setAvailability function = " + employee);
//    }
//
//    public List<Employee> findEmployeesForService(EmployeeRequestDTO employeeRequestDTO){
//        log.info(TAG_ + "-> calling findEmployeesForService function with skills: " + employeeRequestDTO.getSkills() + ", date: " + employeeRequestDTO.getDate());
//        LocalDate date = employeeRequestDTO.getDate();
//        Set<EmployeeSkill> skills = employeeRequestDTO.getSkills();
//        List<Employee> list = null;
//        list = entityManager
//                .createQuery(                              //e.skills is a subset of skill         //containing
//                        "select e from Employee e where e.skills members of :skills",
//                        Employee.class
//                ).getResultList();
//        log.info(TAG_ + "-> result of findEmployeesForService function = " + list);
//        return list;
//    }
}
