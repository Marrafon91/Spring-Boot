package io.github.marrafon91.uri.repositories;

import io.github.marrafon91.uri.entities.Customer;
import io.github.marrafon91.uri.projections.CustomerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(nativeQuery = true, value = "SELECT name "
            + "FROM customers "
            + "WHERE state= :state ")
    List<CustomerMinProjection> search1(String state);
}
