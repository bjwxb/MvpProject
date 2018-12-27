package com.wxb.mvp.bean;

import java.util.List;

/**
 * Created by wuxiaobo on 2018/1/26.
 */

public class AllGroupBean {

    /**
     * code : string
     * responseBody : {"startRowNumber":0,"pageSize":0,"resultList":[{"producePlaceDesc":"string","instoreBarCode":"string","specValue":"string","discountAmount":0,"channelType":"string","shoppingCartId":0,"productPromotionTypeName":"string","promotionId":0,"merchantName":"string","storageName":"string","couponAmount":0,"payAmount":0,"promotionTypeName":"string","merchantId":"string","producerDesc":"string","commodityCode":"string","id":0,"giftIntegral":0,"skuId":0,"batchNumber":"string","brandCode":"string","validityDays":0,"unitPrice":0,"brandName":"string","shoppingCartProductPropertys":[{"createUserId":0,"updateUserId":0,"isDelete":0,"shoppingCartProductId":0,"updateTime":"2018-12-27T06:43:52.383Z","version":0,"productPropertyValue":"string","createTime":"2018-12-27T06:43:52.383Z","updateUserType":"string","createUserType":"string","id":0,"productPropertyUnit":"string","productPropertyId":0,"productPropertyName":"string"}],"promoTicketPrice":0,"skuDescription":"string","isChecked":0,"barCode":"string","singleWeightUnit":"string","taxRate":0,"unit":"string","specName":"string","warehouseId":0,"spuType":"string","brandId":0,"unitAmount":0,"isOrderNow":0,"giftOriginOrderItemId":0,"productPropertyFlag":0,"taxAmount":0,"skuCode":"string","merchantNo":"string","batchName":"string","erpItemCode":"string","productPromotionType":"string","spuName":"string","discountPrice":0,"itemDiscount":0,"batchId":"string","categoryName":"string","warehouseName":"string","skuName":"string","promotionName":"string","productionDate":"2018-12-27T06:43:52.384Z","erpItemNo":0,"imageUrl":"string","isGift":0,"spuCode":"string","storeName":"string","unitDiscount":0,"channelId":0,"channelCode":"string","expirationDate":"2018-12-27T06:43:52.384Z","storageId":0,"inventoryAmount":0,"amount":0,"orderSource":"string","promotionType":"string","storeType":"string","isDelete":0,"showNotice":0,"categoryCode":"string","storeId":0,"hasGift":0,"singleGrossWeight":0,"orderReturnStatus":"string","singleNetWeight":0,"discountTotal":0,"taxPrice":0,"channelName":"string","couponPrice":0,"spuId":0,"propertyContent":"string","categoryId":0,"inventoryPrice":0}],"totalCountOfResult":0}
     * detailMessages : ["string"]
     * message : string
     * status : SUCCESS
     */

    private String code;
    private ResponseBodyBean responseBody;
    private String message;
    private String status;
    private List<String> detailMessages;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ResponseBodyBean getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(ResponseBodyBean responseBody) {
        this.responseBody = responseBody;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getDetailMessages() {
        return detailMessages;
    }

    public void setDetailMessages(List<String> detailMessages) {
        this.detailMessages = detailMessages;
    }

    public static class ResponseBodyBean {
        /**
         * startRowNumber : 0
         * pageSize : 0
         * resultList : [{"producePlaceDesc":"string","instoreBarCode":"string","specValue":"string","discountAmount":0,"channelType":"string","shoppingCartId":0,"productPromotionTypeName":"string","promotionId":0,"merchantName":"string","storageName":"string","couponAmount":0,"payAmount":0,"promotionTypeName":"string","merchantId":"string","producerDesc":"string","commodityCode":"string","id":0,"giftIntegral":0,"skuId":0,"batchNumber":"string","brandCode":"string","validityDays":0,"unitPrice":0,"brandName":"string","shoppingCartProductPropertys":[{"createUserId":0,"updateUserId":0,"isDelete":0,"shoppingCartProductId":0,"updateTime":"2018-12-27T06:43:52.383Z","version":0,"productPropertyValue":"string","createTime":"2018-12-27T06:43:52.383Z","updateUserType":"string","createUserType":"string","id":0,"productPropertyUnit":"string","productPropertyId":0,"productPropertyName":"string"}],"promoTicketPrice":0,"skuDescription":"string","isChecked":0,"barCode":"string","singleWeightUnit":"string","taxRate":0,"unit":"string","specName":"string","warehouseId":0,"spuType":"string","brandId":0,"unitAmount":0,"isOrderNow":0,"giftOriginOrderItemId":0,"productPropertyFlag":0,"taxAmount":0,"skuCode":"string","merchantNo":"string","batchName":"string","erpItemCode":"string","productPromotionType":"string","spuName":"string","discountPrice":0,"itemDiscount":0,"batchId":"string","categoryName":"string","warehouseName":"string","skuName":"string","promotionName":"string","productionDate":"2018-12-27T06:43:52.384Z","erpItemNo":0,"imageUrl":"string","isGift":0,"spuCode":"string","storeName":"string","unitDiscount":0,"channelId":0,"channelCode":"string","expirationDate":"2018-12-27T06:43:52.384Z","storageId":0,"inventoryAmount":0,"amount":0,"orderSource":"string","promotionType":"string","storeType":"string","isDelete":0,"showNotice":0,"categoryCode":"string","storeId":0,"hasGift":0,"singleGrossWeight":0,"orderReturnStatus":"string","singleNetWeight":0,"discountTotal":0,"taxPrice":0,"channelName":"string","couponPrice":0,"spuId":0,"propertyContent":"string","categoryId":0,"inventoryPrice":0}]
         * totalCountOfResult : 0
         */

        private int startRowNumber;
        private int pageSize;
        private int totalCountOfResult;
        private List<ResultListBean> resultList;

        public int getStartRowNumber() {
            return startRowNumber;
        }

        public void setStartRowNumber(int startRowNumber) {
            this.startRowNumber = startRowNumber;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getTotalCountOfResult() {
            return totalCountOfResult;
        }

        public void setTotalCountOfResult(int totalCountOfResult) {
            this.totalCountOfResult = totalCountOfResult;
        }

        public List<ResultListBean> getResultList() {
            return resultList;
        }

        public void setResultList(List<ResultListBean> resultList) {
            this.resultList = resultList;
        }

        public static class ResultListBean {
            /**
             * producePlaceDesc : string
             * instoreBarCode : string
             * specValue : string
             * discountAmount : 0
             * channelType : string
             * shoppingCartId : 0
             * productPromotionTypeName : string
             * promotionId : 0
             * merchantName : string
             * storageName : string
             * couponAmount : 0
             * payAmount : 0
             * promotionTypeName : string
             * merchantId : string
             * producerDesc : string
             * commodityCode : string
             * id : 0
             * giftIntegral : 0
             * skuId : 0
             * batchNumber : string
             * brandCode : string
             * validityDays : 0
             * unitPrice : 0
             * brandName : string
             * shoppingCartProductPropertys : [{"createUserId":0,"updateUserId":0,"isDelete":0,"shoppingCartProductId":0,"updateTime":"2018-12-27T06:43:52.383Z","version":0,"productPropertyValue":"string","createTime":"2018-12-27T06:43:52.383Z","updateUserType":"string","createUserType":"string","id":0,"productPropertyUnit":"string","productPropertyId":0,"productPropertyName":"string"}]
             * promoTicketPrice : 0
             * skuDescription : string
             * isChecked : 0
             * barCode : string
             * singleWeightUnit : string
             * taxRate : 0
             * unit : string
             * specName : string
             * warehouseId : 0
             * spuType : string
             * brandId : 0
             * unitAmount : 0
             * isOrderNow : 0
             * giftOriginOrderItemId : 0
             * productPropertyFlag : 0
             * taxAmount : 0
             * skuCode : string
             * merchantNo : string
             * batchName : string
             * erpItemCode : string
             * productPromotionType : string
             * spuName : string
             * discountPrice : 0
             * itemDiscount : 0
             * batchId : string
             * categoryName : string
             * warehouseName : string
             * skuName : string
             * promotionName : string
             * productionDate : 2018-12-27T06:43:52.384Z
             * erpItemNo : 0
             * imageUrl : string
             * isGift : 0
             * spuCode : string
             * storeName : string
             * unitDiscount : 0
             * channelId : 0
             * channelCode : string
             * expirationDate : 2018-12-27T06:43:52.384Z
             * storageId : 0
             * inventoryAmount : 0
             * amount : 0
             * orderSource : string
             * promotionType : string
             * storeType : string
             * isDelete : 0
             * showNotice : 0
             * categoryCode : string
             * storeId : 0
             * hasGift : 0
             * singleGrossWeight : 0
             * orderReturnStatus : string
             * singleNetWeight : 0
             * discountTotal : 0
             * taxPrice : 0
             * channelName : string
             * couponPrice : 0
             * spuId : 0
             * propertyContent : string
             * categoryId : 0
             * inventoryPrice : 0
             */

            private String producePlaceDesc;
            private String instoreBarCode;
            private String specValue;
            private int discountAmount;
            private String channelType;
            private int shoppingCartId;
            private String productPromotionTypeName;
            private int promotionId;
            private String merchantName;
            private String storageName;
            private int couponAmount;
            private int payAmount;
            private String promotionTypeName;
            private String merchantId;
            private String producerDesc;
            private String commodityCode;
            private int id;
            private int giftIntegral;
            private int skuId;
            private String batchNumber;
            private String brandCode;
            private int validityDays;
            private int unitPrice;
            private String brandName;
            private int promoTicketPrice;
            private String skuDescription;
            private int isChecked;
            private String barCode;
            private String singleWeightUnit;
            private int taxRate;
            private String unit;
            private String specName;
            private int warehouseId;
            private String spuType;
            private int brandId;
            private int unitAmount;
            private int isOrderNow;
            private int giftOriginOrderItemId;
            private int productPropertyFlag;
            private int taxAmount;
            private String skuCode;
            private String merchantNo;
            private String batchName;
            private String erpItemCode;
            private String productPromotionType;
            private String spuName;
            private int discountPrice;
            private int itemDiscount;
            private String batchId;
            private String categoryName;
            private String warehouseName;
            private String skuName;
            private String promotionName;
            private String productionDate;
            private int erpItemNo;
            private String imageUrl;
            private int isGift;
            private String spuCode;
            private String storeName;
            private int unitDiscount;
            private int channelId;
            private String channelCode;
            private String expirationDate;
            private int storageId;
            private int inventoryAmount;
            private int amount;
            private String orderSource;
            private String promotionType;
            private String storeType;
            private int isDelete;
            private int showNotice;
            private String categoryCode;
            private int storeId;
            private int hasGift;
            private int singleGrossWeight;
            private String orderReturnStatus;
            private int singleNetWeight;
            private int discountTotal;
            private int taxPrice;
            private String channelName;
            private int couponPrice;
            private int spuId;
            private String propertyContent;
            private int categoryId;
            private int inventoryPrice;
            private List<ShoppingCartProductPropertysBean> shoppingCartProductPropertys;

            public String getProducePlaceDesc() {
                return producePlaceDesc;
            }

            public void setProducePlaceDesc(String producePlaceDesc) {
                this.producePlaceDesc = producePlaceDesc;
            }

            public String getInstoreBarCode() {
                return instoreBarCode;
            }

            public void setInstoreBarCode(String instoreBarCode) {
                this.instoreBarCode = instoreBarCode;
            }

            public String getSpecValue() {
                return specValue;
            }

            public void setSpecValue(String specValue) {
                this.specValue = specValue;
            }

            public int getDiscountAmount() {
                return discountAmount;
            }

            public void setDiscountAmount(int discountAmount) {
                this.discountAmount = discountAmount;
            }

            public String getChannelType() {
                return channelType;
            }

            public void setChannelType(String channelType) {
                this.channelType = channelType;
            }

            public int getShoppingCartId() {
                return shoppingCartId;
            }

            public void setShoppingCartId(int shoppingCartId) {
                this.shoppingCartId = shoppingCartId;
            }

            public String getProductPromotionTypeName() {
                return productPromotionTypeName;
            }

            public void setProductPromotionTypeName(String productPromotionTypeName) {
                this.productPromotionTypeName = productPromotionTypeName;
            }

            public int getPromotionId() {
                return promotionId;
            }

            public void setPromotionId(int promotionId) {
                this.promotionId = promotionId;
            }

            public String getMerchantName() {
                return merchantName;
            }

            public void setMerchantName(String merchantName) {
                this.merchantName = merchantName;
            }

            public String getStorageName() {
                return storageName;
            }

            public void setStorageName(String storageName) {
                this.storageName = storageName;
            }

            public int getCouponAmount() {
                return couponAmount;
            }

            public void setCouponAmount(int couponAmount) {
                this.couponAmount = couponAmount;
            }

            public int getPayAmount() {
                return payAmount;
            }

            public void setPayAmount(int payAmount) {
                this.payAmount = payAmount;
            }

            public String getPromotionTypeName() {
                return promotionTypeName;
            }

            public void setPromotionTypeName(String promotionTypeName) {
                this.promotionTypeName = promotionTypeName;
            }

            public String getMerchantId() {
                return merchantId;
            }

            public void setMerchantId(String merchantId) {
                this.merchantId = merchantId;
            }

            public String getProducerDesc() {
                return producerDesc;
            }

            public void setProducerDesc(String producerDesc) {
                this.producerDesc = producerDesc;
            }

            public String getCommodityCode() {
                return commodityCode;
            }

            public void setCommodityCode(String commodityCode) {
                this.commodityCode = commodityCode;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getGiftIntegral() {
                return giftIntegral;
            }

            public void setGiftIntegral(int giftIntegral) {
                this.giftIntegral = giftIntegral;
            }

            public int getSkuId() {
                return skuId;
            }

            public void setSkuId(int skuId) {
                this.skuId = skuId;
            }

            public String getBatchNumber() {
                return batchNumber;
            }

            public void setBatchNumber(String batchNumber) {
                this.batchNumber = batchNumber;
            }

            public String getBrandCode() {
                return brandCode;
            }

            public void setBrandCode(String brandCode) {
                this.brandCode = brandCode;
            }

            public int getValidityDays() {
                return validityDays;
            }

            public void setValidityDays(int validityDays) {
                this.validityDays = validityDays;
            }

            public int getUnitPrice() {
                return unitPrice;
            }

            public void setUnitPrice(int unitPrice) {
                this.unitPrice = unitPrice;
            }

            public String getBrandName() {
                return brandName;
            }

            public void setBrandName(String brandName) {
                this.brandName = brandName;
            }

            public int getPromoTicketPrice() {
                return promoTicketPrice;
            }

            public void setPromoTicketPrice(int promoTicketPrice) {
                this.promoTicketPrice = promoTicketPrice;
            }

            public String getSkuDescription() {
                return skuDescription;
            }

            public void setSkuDescription(String skuDescription) {
                this.skuDescription = skuDescription;
            }

            public int getIsChecked() {
                return isChecked;
            }

            public void setIsChecked(int isChecked) {
                this.isChecked = isChecked;
            }

            public String getBarCode() {
                return barCode;
            }

            public void setBarCode(String barCode) {
                this.barCode = barCode;
            }

            public String getSingleWeightUnit() {
                return singleWeightUnit;
            }

            public void setSingleWeightUnit(String singleWeightUnit) {
                this.singleWeightUnit = singleWeightUnit;
            }

            public int getTaxRate() {
                return taxRate;
            }

            public void setTaxRate(int taxRate) {
                this.taxRate = taxRate;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public String getSpecName() {
                return specName;
            }

            public void setSpecName(String specName) {
                this.specName = specName;
            }

            public int getWarehouseId() {
                return warehouseId;
            }

            public void setWarehouseId(int warehouseId) {
                this.warehouseId = warehouseId;
            }

            public String getSpuType() {
                return spuType;
            }

            public void setSpuType(String spuType) {
                this.spuType = spuType;
            }

            public int getBrandId() {
                return brandId;
            }

            public void setBrandId(int brandId) {
                this.brandId = brandId;
            }

            public int getUnitAmount() {
                return unitAmount;
            }

            public void setUnitAmount(int unitAmount) {
                this.unitAmount = unitAmount;
            }

            public int getIsOrderNow() {
                return isOrderNow;
            }

            public void setIsOrderNow(int isOrderNow) {
                this.isOrderNow = isOrderNow;
            }

            public int getGiftOriginOrderItemId() {
                return giftOriginOrderItemId;
            }

            public void setGiftOriginOrderItemId(int giftOriginOrderItemId) {
                this.giftOriginOrderItemId = giftOriginOrderItemId;
            }

            public int getProductPropertyFlag() {
                return productPropertyFlag;
            }

            public void setProductPropertyFlag(int productPropertyFlag) {
                this.productPropertyFlag = productPropertyFlag;
            }

            public int getTaxAmount() {
                return taxAmount;
            }

            public void setTaxAmount(int taxAmount) {
                this.taxAmount = taxAmount;
            }

            public String getSkuCode() {
                return skuCode;
            }

            public void setSkuCode(String skuCode) {
                this.skuCode = skuCode;
            }

            public String getMerchantNo() {
                return merchantNo;
            }

            public void setMerchantNo(String merchantNo) {
                this.merchantNo = merchantNo;
            }

            public String getBatchName() {
                return batchName;
            }

            public void setBatchName(String batchName) {
                this.batchName = batchName;
            }

            public String getErpItemCode() {
                return erpItemCode;
            }

            public void setErpItemCode(String erpItemCode) {
                this.erpItemCode = erpItemCode;
            }

            public String getProductPromotionType() {
                return productPromotionType;
            }

            public void setProductPromotionType(String productPromotionType) {
                this.productPromotionType = productPromotionType;
            }

            public String getSpuName() {
                return spuName;
            }

            public void setSpuName(String spuName) {
                this.spuName = spuName;
            }

            public int getDiscountPrice() {
                return discountPrice;
            }

            public void setDiscountPrice(int discountPrice) {
                this.discountPrice = discountPrice;
            }

            public int getItemDiscount() {
                return itemDiscount;
            }

            public void setItemDiscount(int itemDiscount) {
                this.itemDiscount = itemDiscount;
            }

            public String getBatchId() {
                return batchId;
            }

            public void setBatchId(String batchId) {
                this.batchId = batchId;
            }

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
            }

            public String getWarehouseName() {
                return warehouseName;
            }

            public void setWarehouseName(String warehouseName) {
                this.warehouseName = warehouseName;
            }

            public String getSkuName() {
                return skuName;
            }

            public void setSkuName(String skuName) {
                this.skuName = skuName;
            }

            public String getPromotionName() {
                return promotionName;
            }

            public void setPromotionName(String promotionName) {
                this.promotionName = promotionName;
            }

            public String getProductionDate() {
                return productionDate;
            }

            public void setProductionDate(String productionDate) {
                this.productionDate = productionDate;
            }

            public int getErpItemNo() {
                return erpItemNo;
            }

            public void setErpItemNo(int erpItemNo) {
                this.erpItemNo = erpItemNo;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public int getIsGift() {
                return isGift;
            }

            public void setIsGift(int isGift) {
                this.isGift = isGift;
            }

            public String getSpuCode() {
                return spuCode;
            }

            public void setSpuCode(String spuCode) {
                this.spuCode = spuCode;
            }

            public String getStoreName() {
                return storeName;
            }

            public void setStoreName(String storeName) {
                this.storeName = storeName;
            }

            public int getUnitDiscount() {
                return unitDiscount;
            }

            public void setUnitDiscount(int unitDiscount) {
                this.unitDiscount = unitDiscount;
            }

            public int getChannelId() {
                return channelId;
            }

            public void setChannelId(int channelId) {
                this.channelId = channelId;
            }

            public String getChannelCode() {
                return channelCode;
            }

            public void setChannelCode(String channelCode) {
                this.channelCode = channelCode;
            }

            public String getExpirationDate() {
                return expirationDate;
            }

            public void setExpirationDate(String expirationDate) {
                this.expirationDate = expirationDate;
            }

            public int getStorageId() {
                return storageId;
            }

            public void setStorageId(int storageId) {
                this.storageId = storageId;
            }

            public int getInventoryAmount() {
                return inventoryAmount;
            }

            public void setInventoryAmount(int inventoryAmount) {
                this.inventoryAmount = inventoryAmount;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public String getOrderSource() {
                return orderSource;
            }

            public void setOrderSource(String orderSource) {
                this.orderSource = orderSource;
            }

            public String getPromotionType() {
                return promotionType;
            }

            public void setPromotionType(String promotionType) {
                this.promotionType = promotionType;
            }

            public String getStoreType() {
                return storeType;
            }

            public void setStoreType(String storeType) {
                this.storeType = storeType;
            }

            public int getIsDelete() {
                return isDelete;
            }

            public void setIsDelete(int isDelete) {
                this.isDelete = isDelete;
            }

            public int getShowNotice() {
                return showNotice;
            }

            public void setShowNotice(int showNotice) {
                this.showNotice = showNotice;
            }

            public String getCategoryCode() {
                return categoryCode;
            }

            public void setCategoryCode(String categoryCode) {
                this.categoryCode = categoryCode;
            }

            public int getStoreId() {
                return storeId;
            }

            public void setStoreId(int storeId) {
                this.storeId = storeId;
            }

            public int getHasGift() {
                return hasGift;
            }

            public void setHasGift(int hasGift) {
                this.hasGift = hasGift;
            }

            public int getSingleGrossWeight() {
                return singleGrossWeight;
            }

            public void setSingleGrossWeight(int singleGrossWeight) {
                this.singleGrossWeight = singleGrossWeight;
            }

            public String getOrderReturnStatus() {
                return orderReturnStatus;
            }

            public void setOrderReturnStatus(String orderReturnStatus) {
                this.orderReturnStatus = orderReturnStatus;
            }

            public int getSingleNetWeight() {
                return singleNetWeight;
            }

            public void setSingleNetWeight(int singleNetWeight) {
                this.singleNetWeight = singleNetWeight;
            }

            public int getDiscountTotal() {
                return discountTotal;
            }

            public void setDiscountTotal(int discountTotal) {
                this.discountTotal = discountTotal;
            }

            public int getTaxPrice() {
                return taxPrice;
            }

            public void setTaxPrice(int taxPrice) {
                this.taxPrice = taxPrice;
            }

            public String getChannelName() {
                return channelName;
            }

            public void setChannelName(String channelName) {
                this.channelName = channelName;
            }

            public int getCouponPrice() {
                return couponPrice;
            }

            public void setCouponPrice(int couponPrice) {
                this.couponPrice = couponPrice;
            }

            public int getSpuId() {
                return spuId;
            }

            public void setSpuId(int spuId) {
                this.spuId = spuId;
            }

            public String getPropertyContent() {
                return propertyContent;
            }

            public void setPropertyContent(String propertyContent) {
                this.propertyContent = propertyContent;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public int getInventoryPrice() {
                return inventoryPrice;
            }

            public void setInventoryPrice(int inventoryPrice) {
                this.inventoryPrice = inventoryPrice;
            }

            public List<ShoppingCartProductPropertysBean> getShoppingCartProductPropertys() {
                return shoppingCartProductPropertys;
            }

            public void setShoppingCartProductPropertys(List<ShoppingCartProductPropertysBean> shoppingCartProductPropertys) {
                this.shoppingCartProductPropertys = shoppingCartProductPropertys;
            }

            public static class ShoppingCartProductPropertysBean {
                /**
                 * createUserId : 0
                 * updateUserId : 0
                 * isDelete : 0
                 * shoppingCartProductId : 0
                 * updateTime : 2018-12-27T06:43:52.383Z
                 * version : 0
                 * productPropertyValue : string
                 * createTime : 2018-12-27T06:43:52.383Z
                 * updateUserType : string
                 * createUserType : string
                 * id : 0
                 * productPropertyUnit : string
                 * productPropertyId : 0
                 * productPropertyName : string
                 */

                private int createUserId;
                private int updateUserId;
                private int isDelete;
                private int shoppingCartProductId;
                private String updateTime;
                private int version;
                private String productPropertyValue;
                private String createTime;
                private String updateUserType;
                private String createUserType;
                private int id;
                private String productPropertyUnit;
                private int productPropertyId;
                private String productPropertyName;

                public int getCreateUserId() {
                    return createUserId;
                }

                public void setCreateUserId(int createUserId) {
                    this.createUserId = createUserId;
                }

                public int getUpdateUserId() {
                    return updateUserId;
                }

                public void setUpdateUserId(int updateUserId) {
                    this.updateUserId = updateUserId;
                }

                public int getIsDelete() {
                    return isDelete;
                }

                public void setIsDelete(int isDelete) {
                    this.isDelete = isDelete;
                }

                public int getShoppingCartProductId() {
                    return shoppingCartProductId;
                }

                public void setShoppingCartProductId(int shoppingCartProductId) {
                    this.shoppingCartProductId = shoppingCartProductId;
                }

                public String getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(String updateTime) {
                    this.updateTime = updateTime;
                }

                public int getVersion() {
                    return version;
                }

                public void setVersion(int version) {
                    this.version = version;
                }

                public String getProductPropertyValue() {
                    return productPropertyValue;
                }

                public void setProductPropertyValue(String productPropertyValue) {
                    this.productPropertyValue = productPropertyValue;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getUpdateUserType() {
                    return updateUserType;
                }

                public void setUpdateUserType(String updateUserType) {
                    this.updateUserType = updateUserType;
                }

                public String getCreateUserType() {
                    return createUserType;
                }

                public void setCreateUserType(String createUserType) {
                    this.createUserType = createUserType;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getProductPropertyUnit() {
                    return productPropertyUnit;
                }

                public void setProductPropertyUnit(String productPropertyUnit) {
                    this.productPropertyUnit = productPropertyUnit;
                }

                public int getProductPropertyId() {
                    return productPropertyId;
                }

                public void setProductPropertyId(int productPropertyId) {
                    this.productPropertyId = productPropertyId;
                }

                public String getProductPropertyName() {
                    return productPropertyName;
                }

                public void setProductPropertyName(String productPropertyName) {
                    this.productPropertyName = productPropertyName;
                }
            }
        }
    }
}
