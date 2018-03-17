package com.myretail.converters;

import com.myretail.retail.mvc.PriceDetailsModel;
import com.myretail.retail.mvc.PriceDetailsModelPojo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


/**
 * Project: tar-cassandra-parent
 * Package: com.myretail.converters
 * <p>
 * User: vthalapu
 * Date: 3/17/18
 * Time: 2:50 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ItemsConverter implements Converter<PriceDetailsModelPojo, PriceDetailsModel>, BeanFactoryAware {

    private BeanFactory beanFactory;
    private PriceDetailsModel priceDetailsModel;

    @Nullable
    @Override
    public PriceDetailsModel convert(PriceDetailsModelPojo priceDetailsModelPojo) {
        priceDetailsModel = beanFactory.getBean(PriceDetailsModel.class);

        if (priceDetailsModelPojo.getItemId() == null && StringUtils.isEmpty(priceDetailsModelPojo.getItemId())) {
            priceDetailsModel.setItemId(9999999l);
        }

        if (priceDetailsModelPojo.getCassandraId() != null && !StringUtils.isEmpty(priceDetailsModelPojo.getCassandraId())) {
            priceDetailsModel.setCassandraId(priceDetailsModel.getCassandraId());
        }

        priceDetailsModel.setItemCurrencyType(priceDetailsModelPojo.getItemCurrencyType());
        priceDetailsModel.setItemName(priceDetailsModelPojo.getItemName());
        priceDetailsModel.setItemPrice(priceDetailsModelPojo.getItemPrice());

        return priceDetailsModel;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
