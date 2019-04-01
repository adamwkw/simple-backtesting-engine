package tradeHandler;

import interfaces.IOrderSettings;

public class Order {
   public static void send (IOrderSettings orderSettings) {
      System.out.println(orderSettings);
      StrategyInfo.getStrategyInfo().updateTradeMap(orderSettings.getStrategyName(), orderSettings);
   }
}
