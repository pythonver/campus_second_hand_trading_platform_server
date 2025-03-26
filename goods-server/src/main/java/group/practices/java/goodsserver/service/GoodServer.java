package group.practices.java.goodsserver.service;

import group.practices.java.goodsserver.repository.GoodRepository;
import group.practices.java.goodsserver.repository.entity.DetailedGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: Describe the feature.
 * date: 2025/3/25
 *
 * @author Al Elijah
 */
@Service
public class GoodServer {

    @Autowired
    private GoodRepository goodRepository;

    public Page<DetailedGoods> findAllGoods(Integer page){
        Pageable pageable = PageRequest.of(page, 25);
        return goodRepository.findAll(pageable);
    }

}
