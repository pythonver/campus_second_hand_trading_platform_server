package group.practices.java.goodsserver.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * description: Describe the feature.
 * date: 2025/3/23
 *
 * @author Al Elijah
 */
@Entity(name = "goods")
@Data
public class SimpleGoods {
    @Id
    private Long id;

    @Column(name = "good_name")
    private String name;

    @Column(name = "presets_price")
    private String presetsPrice; // 预设价格
}
