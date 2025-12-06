package io.github.marrafon91.uri.repository;

import io.github.marrafon91.uri.entities.Lawyer;
import io.github.marrafon91.uri.projection.LawyerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {

    @Query(nativeQuery = true, value = """
            (SELECT name, customers_number AS customersNumber
            FROM lawyers
            ORDER BY customers_number DESC
            LIMIT 1)
                                    
            UNION ALL   
                                 
            (SELECT name, customers_number
            FROM lawyers
            ORDER BY customers_number ASC
            LIMIT 1)
                                    
            UNION ALL
                                   
            (SELECT 'Average', ROUND (AVG(customers_number), 0)
            FROM lawyers);
            """)
    List<LawyerMinProjection> search1();
}