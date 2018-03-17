package com.myretail.retail.mvc;

import com.myretail.converters.ItemsConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Project: myretail-parent
 * Package: com.myretail.retail.mvc
 * <p>
 * User: vthalapu
 * Date: 3/12/18
 * Time: 10:04 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ItemsServiceImpl implements ItemsService, DataBaseService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemsConverter itemsConverter;

    @Autowired
    private PriceDetailsRepo priceDetailsRepo;

    @Autowired
    private GetNamesFromExternalServiceImpl getNamesFromExternalServiceImpl;

    //    public PriceDetailsModel getItemsPrice() throws JSONException {
    public List<PriceDetailsModel> getItemsPrice(Long itemId) throws JSONException {
        List<PriceDetailsModel> priceDetailsModelList = new ArrayList<>();
        Set<String> jsonObject = getNamesFromExternalServiceImpl.getNames();
        logger.info(jsonObject.toString());
        try {
            jsonObject.forEach(name -> {
                if (priceDetailsRepo.findTopByItemNameAndItemId(name, itemId) != null) {
                    priceDetailsModelList.add(priceDetailsRepo.findTopByItemNameAndItemId(name, itemId));
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return priceDetailsModelList;
    }

    @Override
    public void saveItemInfo(Object priceDetailsPojo) {
        PriceDetailsModel priceDetailsModel = itemsConverter.convert((PriceDetailsModelPojo) priceDetailsPojo);
        priceDetailsRepo.save(priceDetailsModel);
    }

    @Override
    public void updateItemInfo(Object priceDetailsPojo) {
        saveItemInfo(priceDetailsPojo);
    }

    @Override
    public void deleteItemInfo(Object uUid) {
        priceDetailsRepo.deleteAllByCassandraId((UUID) uUid);
    }

    public List<PriceDetailsModel> getAllItems() {
        return (List<PriceDetailsModel>) priceDetailsRepo.findAll();
    }

}
