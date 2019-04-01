package tradeHandler;

import enums.OrderType;
import interfaces.IInstruments;
import interfaces.IOrderSettings;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class StrategyInfo {

   private int marketposition;
   private double entryPrice;
   private OrderType orderType;
   private double exitPrice;
   private double capitalRunner;
   private double currentPnl;
   private String strategyName;

   private IInstruments instrument;

   private Map<String, IOrderSettings> tradeMap = new LinkedHashMap<>();

   private StrategyInfo() { }

   private static StrategyInfo strategyInfo = new StrategyInfo();

   public static StrategyInfo getStrategyInfo() {
      return strategyInfo;
   }

   public IOrderSettings getStrategyTradeMap(String strategyName) {
      return tradeMap.get(strategyName);
   }

   public Map<String, IOrderSettings> getFullTradeMap() {
      return tradeMap;
   }

   public void updateTradeMap(String strategyName, IOrderSettings orderSettings) {
      tradeMap.put(strategyName, orderSettings);

      if (orderSettings.getOrderType() == OrderType.LONG) {
         marketposition = orderSettings.getOrderSize();
         entryPrice = orderSettings.getTradePrice();
         orderType = orderSettings.getOrderType();
         exitPrice = 0;
         currentPnl = 0;
      }

      if (orderSettings.getOrderType() == OrderType.SELLSHORT) {
         marketposition = orderSettings.getOrderSize() * -1;
         entryPrice = orderSettings.getTradePrice();
         orderType = orderSettings.getOrderType();
         exitPrice = 0;
         currentPnl = 0;
      }

      // need to add pnl calculation!!!
      if (orderSettings.getOrderType() == OrderType.SELL) {
         if (marketposition > 0) {
            marketposition -= orderSettings.getOrderSize();
            exitPrice = orderSettings.getTradePrice();
            currentPnl = orderSettings.getOrderSize() * instrument.getBigPointValue()
                  * (exitPrice - entryPrice);
            capitalRunner += currentPnl;

            if (marketposition == 0) {
               marketposition = 0;
               entryPrice = 0.0;
               exitPrice = 0.0;
               orderType = null;
            }
         } else {
            System.out.println("[ Warning ]: There are no Long position to close!!");
         }
      }

      if (orderSettings.getOrderType() == OrderType.BUYTOCOVER) {
         if(marketposition < 0) {
            marketposition += orderSettings.getOrderSize();
            exitPrice = orderSettings.getTradePrice();
            currentPnl = orderSettings.getOrderSize() * instrument.getBigPointValue()
                  * (entryPrice - exitPrice);
            capitalRunner += currentPnl;

            if(marketposition == 0) {
               marketposition = 0;
               entryPrice = 0.0;
               exitPrice = 0.0;
               orderType = null;
            }
         }else {
            System.out.println("[ Warning ]: There are no Short position to close!!");
         }
      }
   }

   public double getCapitalRunner() {
      return capitalRunner;
   }

   public void setInitialCapital(double capitalRunner) {
      this.capitalRunner = capitalRunner;
   }

   public IInstruments getInstrument() {
      return instrument;
   }

   public void setInstrumentType(IInstruments instrumentType) {
      this.instrument = instrumentType;
   }

   public String getStrategyName() {
      return strategyName;
   }

   public void setStrategyName(String strategyName) {
      this.strategyName = strategyName;
   }

   public int getMarketPosition() {
      return marketposition;
   }

   public double getPnl() { return currentPnl; }

   public void SaveFileAs(String saveFileAs) {
      String outputPath = String.format(saveFileAs);
      try {
         System.setOut(new PrintStream(new FileOutputStream(outputPath)));
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   }
}
