package group.practices.java.goodsserver.repository;

import group.practices.java.goodsserver.repository.entity.DetailedGoods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description: Describe the feature.
 * date: 2025/3/25
 *
 * @author Al Elijah
 */
@Repository
public interface GoodRepository extends MongoRepository<DetailedGoods, String> {

    @Query("{}")
    Page<DetailedGoods> findAll(Pageable pageable);
}
