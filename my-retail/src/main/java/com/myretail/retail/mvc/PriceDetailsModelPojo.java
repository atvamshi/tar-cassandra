package com.myretail.retail.mvc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;

/**
 * Project: tar-cassandra-parent
 * Package: com.myretail.retail.mvc
 * <p>
 * User: vthalapu
 * Date: 3/17/18
 * Time: 2:53 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@AllArgsConstructor
@NoArgsConstructor
@Component
@Getter
@Setter
@ToString
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PriceDetailsModelPojo implements Serializable {
    private UUID cassandraId;

    private Long itemId;

    private String itemName;

    private float itemPrice;

    private String itemCurrencyType;
}
