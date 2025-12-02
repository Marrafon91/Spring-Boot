package io.github.marrafon91.uri.repositories;

import io.github.marrafon91.uri.dto.CustomerMinDTO;
import io.github.marrafon91.uri.entities.Customer;
import io.github.marrafon91.uri.projections.CustomerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(nativeQuery = true, value = "SELECT name "
            + "FROM customers "
            + "WHERE UPPER(state) = UPPER(:state) ")
    List<CustomerMinProjection> search1(String state);

    @Query("SELECT new io.github.marrafon91.uri.dto.CustomerMinDTO(obj.name) "
            + "FROM Customer obj "
            + "WHERE UPPER(obj.state) = UPPER(:state) ")
    List<CustomerMinDTO> search2(String state);
}
