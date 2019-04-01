package tradeHandler;

import enums.OrderType;
import interfaces.IOrderSettings;

import java.time.LocalDateTime;

public class OrderSettings implements IOrderSettings<LocalDateTime> {

   private LocalDateTime tradeTime;
   private int orderSize;
   private double tradePrice;
   private String tradeTag;
   private String strategyName;
   private OrderType orderType;

   public OrderSettings() { }

   public OrderSettings(LocalDateTime tradeTime, int orderSize, double tradePrice,
                        String tradeTag, String strategyName, OrderType orderType) {
      this.tradeTime = tradeTime;
      this.orderSize = orderSize;
      this.tradePrice = tradePrice;
      this.tradeTag = tradeTag;
      this.strategyName = strategyName;
      this.orderType = orderType;
   }

   @Override
   public void setTradeTime(LocalDateTime tradeTime) {
      this.tradeTime = tradeTime;
   }

   @Override
   public LocalDateTime getTradeTime() {
      return tradeTime;
   }

   @Override
   public void setOrderSize(int orderSize) {
      this.orderSize = orderSize;
   }

   @Override
   public int getOrderSize() {
      return orderSize;
   }

   @Override
   public void setTradePrice(double tradePrice) {
      this.tradePrice = tradePrice;
   }

   @Override
   public double getTradePrice() {
      return tradePrice;
   }

   @Override
   public void setTradeTag(String tradeTag) {
      this.tradeTag = tradeTag;
   }

   @Override
   public OrderType getOrderType() {
      return orderType;
   }

   @Override
   public void setOrderType(OrderType orderType) {
      this.orderType = orderType;
   }

   @Override
   public void setStrategyName(String strategyName) {
      this.strategyName = strategyName;
   }

   @Override
   public String getStrategyName() {
      return strategyName;
   }

   @Override
   public String toString() {
      return tradeTime + "," + orderSize + "," + tradePrice + "," + tradeTag + "," + strategyName
            + "," + orderType;
   }

}
