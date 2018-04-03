package com.myretail.retail.mvc;

import com.datastax.driver.core.DataType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.stereotype.Component;

import java.io.Serializable;
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
//@Entity
//@Table(name = "ItemsPriceDetails")
//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Component
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
//public class PriceDetailsModel implements Serializable {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long itemId;
//
//    @Column(name = "Item_Name")
//    private String itemName;
//
//    @Column(name = "Item_Price")
//    private float itemPrice;
//
//    @Column(name = "Item_Currency_Type")
//    private String itemCurrencyType;
//
//}

@Table("ItemsPriceDetails")
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@AllArgsConstructor
@Component
@Getter
@Setter
@ToString
public class PriceDetailsModel implements Serializable {


    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID cassandraId;

    private Integer itemId;

    private String itemName;

    private float itemPrice;

    private String itemCurrencyType;

    public PriceDetailsModel() {
        cassandraId = UUID.randomUUID();
    }
}
