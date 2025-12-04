package io.github.marrafon91.uri.repositories;

import io.github.marrafon91.uri.dto.CategorySumDTO;
import io.github.marrafon91.uri.entities.Category;
import io.github.marrafon91.uri.projection.CategorySumProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(nativeQuery = true, value = """
            SELECT categories.name, SUM(products.amount)
            FROM categories
            INNER JOIN products ON products.id_categories = categories.id
            GROUP BY categories.name
            """)
    List<CategorySumProjection> search1();

    @Query("""
            SELECT new io.github.marrafon91.uri.dto.CategorySumDTO(obj.category.name, SUM(obj.amount))
            FROM Product obj
            GROUP BY obj.category.name
            """)
    List<CategorySumDTO> search2();
}
