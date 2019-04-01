package interfaces;

import enums.OrderType;
import tradeHandler.StrategyInfo;

public interface IOrder {

   static void sendOrder(IOrderSettings orderSettings) {
      StrategyInfo.getStrategyInfo().updateTradeMap(orderSettings.getStrategyName(), orderSettings);
      System.out.println(orderSettings);
   }

   OrderType getTradeType();
}
