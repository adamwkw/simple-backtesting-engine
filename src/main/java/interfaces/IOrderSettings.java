package interfaces;

import enums.OrderType;

public interface IOrderSettings<T> {
   void setTradeTime(T tradeTime);

   T getTradeTime();

   void setOrderSize(int orderSize);

   int getOrderSize();

   void setTradePrice(double tradePrice);

   double getTradePrice();

   void setTradeTag(String tradeTag);

   String getStrategyName();

   void setStrategyName(String strategyName);

   OrderType getOrderType();

   void setOrderType(OrderType orderType);
}
