package group.practices.java.goodsserver.repository.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Null;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

/**
 * description: Describe the feature.
 * date: 2025/3/23
 *
 * @author Al Elijah
 */
@Document(collection = "goods")
@Data
public class DetailedGoods {

    @Id
    @MongoId
    private String id; // 实体id

    @Field(name = "shopId")
    @Indexed(unique = true)
    @NotEmpty
    private String goodId; // 商品ID，唯一值

    @Field(name = "title")
    private String goodName;

    @Field(name = "real_wap_price")
    @NotEmpty
    private Float presetsPrice = 9999F; // 预设价格

    @Field(name = "good_desc")
    private String goodDescription; // 商品描述

    @Field(name = "good_brand")
    @Null
    private String goodBrand; // 商品品牌

    @Field(name = "good_category")
    private List<String> goodCategory; // 商品分类

    // 库存数量
    @Field(name = "inventory_quantity")
    @NotEmpty
    private Long inventory_quantity = 0L;
    // 库存状态
    @Field(name = "inventory_type")
    private Short inventory_type ;
    // 主图

    @Field(name = "main_photo_url")
    private String mainPhotoUrl;
    // 详情图
    @Field(name = "details_photo_url")
    private List<String> detailsPhotoUrl;
    // 评分
    @Field(name = "score")
    private Short score = 10;

    // 浏览量
    @Field(name = "review")
    private Long reviewCount = 0L;

    // 收藏量
    @Field(name ="collection")
    private Long collectionCount = 0L;

    //购买次数
    @Field(name = "purchased")
    private Long purchasedCount = 0L;

}
