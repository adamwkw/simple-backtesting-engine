import dataHandler.IntraDayBar;
import enums.OrderType;
import instruments.Futures;
import interfaces.IBar;
import interfaces.IInstruments;
import strategyHandler.BaseStrategy;
import tradeHandler.Order;
import tradeHandler.OrderSettings;
import tradeHandler.StrategyInfo;

import java.util.List;

public class Example extends BaseStrategy {

   // system variables
   private final IInstruments instruments;
   private final List<IBar> Bars;
   private final String strategyName = "Testing";

   // strategy variables
   private IntraDayBar lastBar;
   private final int numConatcts = 1;

   public Example() {

      // basic setup
      instruments = new Futures("HSI", 50, 1);
      StrategyInfo.getStrategyInfo().setInstrumentType(instruments);
      StrategyInfo.getStrategyInfo().setInitialCapital(1000000);
      StrategyInfo.getStrategyInfo().setStrategyName(strategyName);

      // if not setting SaveFileAs(), result will print out in console
      StrategyInfo.getStrategyInfo().SaveFileAs("");

      // data source settings
      instruments.setDataSource("");
      Bars = instruments.getData();
   }

   /*
   logic within a bar, you can simply skip this method,
   and code in StartStrategy(), to do the iteration as you prefer

   trade message will print out in Order.send() method
    */
   @Override
   protected void calculateBar(IBar bar) {
      IntraDayBar currentBar = (IntraDayBar) bar;
      int marketPosition = StrategyInfo.getStrategyInfo().getMarketPosition();

      if (lastBar == null) {
         lastBar = currentBar;
      } else {
         // new day
         if (!lastBar.getTime().toLocalDate().isEqual(currentBar.getTime().toLocalDate())) {
         } else {
            // open long position
            if (currentBar.getClose() > lastBar.getClose()) {
               if (marketPosition == 0)
                  Order.send(new OrderSettings(currentBar.getTime(), numConatcts, bar.getClose(),
                        "Normal Long", strategyName, OrderType.LONG));
               if (marketPosition < 0)
                  Order.send(new OrderSettings(currentBar.getTime(), numConatcts, bar.getClose(),
                        "Normal Long", strategyName, OrderType.BUYTOCOVER));
            }

            // open short position
            if (currentBar.getClose() < lastBar.getClose()) {
               if (marketPosition == 0)
                  Order.send(new OrderSettings(currentBar.getTime(), numConatcts, bar.getClose(),
                        "Normal Short", strategyName, OrderType.SELLSHORT));
               if (marketPosition > 0)
                  Order.send(new OrderSettings(currentBar.getTime(), numConatcts, bar.getClose(),
                        "Normal Short", strategyName, OrderType.SELL));
            }
         }
      }
      lastBar = currentBar;
   }

   @Override
   protected void startStrategy() {
      for (IBar bar : Bars) {
         calculateBar(bar);
      }

      // get the final capital runner
      StrategyInfo.getStrategyInfo().getCapitalRunner();
   }

   public static void main(String[] args) {
      new Example().startStrategy();
   }
}
