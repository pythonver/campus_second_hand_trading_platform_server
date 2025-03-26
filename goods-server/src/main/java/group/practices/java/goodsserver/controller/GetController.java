package group.practices.java.goodsserver.controller;

import group.practices.java.goodsserver.repository.entity.DetailedGoods;
import group.practices.java.goodsserver.service.GoodServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description: Describe the feature.
 * date: 2025/3/25
 *
 * @author Al Elijah
 */
@RestController
public class GetController {

    @Autowired
    private GoodServer goodServer;

    @GetMapping("/get-all")
    public Page<DetailedGoods> getAllGoods(@Param("page") Integer page) {
        System.out.println("分页数据：" + page);
        return goodServer.findAllGoods(page);
    }
}
