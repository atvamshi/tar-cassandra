package com.myretail.retail.mvc;


import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

/**
 * Project: myretail-parent
 * Package: com.myretail.retail.mvc
 * <p>
 * User: vthalapu
 * Date: 3/12/18
 * Time: 9:56 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
public interface PriceDetailsRepo extends CrudRepository<PriceDetailsModel, UUID> {
    //    PriceDetailsModel findAllByItemNameAndItemId(String itemName, Long itemId);
//    List<PriceDetailsModel> findAllByItemNameAndItemId(String itemName, Long itemId);

    void deleteByItemId(Long itemId);

    // NOTE, be very careful about ALLOW FILTERING in real world apps, this
    // may affect scalability quite a lot. Filtering is efficient over primary
    // keys, not on all generic columns
    @Query("SELECT * FROM ItemsPriceDetails WHERE itemName = ?0 AND itemId= ?1 ALLOW FILTERING")
    List<PriceDetailsModel> findAllByItemNameAndItemId(String itemName, Long itemId);

}
