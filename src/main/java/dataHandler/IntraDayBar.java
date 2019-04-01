package dataHandler;

import interfaces.IBar;

import java.time.LocalDateTime;

public class IntraDayBar implements IBar<LocalDateTime> {

   private LocalDateTime time;
   private double open;
   private double high;
   private double low;
   private double close;
   private long volume;
   private double wap;
   private double count;
   private String symbol;
   private double pClose;

   public IntraDayBar() { }

   public IntraDayBar(LocalDateTime time, double open, double high, double low, double close,
                  long volume, double wap, double count, String symbol, double pClose) {
      this.time = time;
      this.open = open;
      this.high = high;
      this.low = low;
      this.close = close;
      this.volume = volume;
      this.wap = wap;
      this.count = count;
      this.symbol = symbol;
      this.pClose = pClose;
   }

   @Override
   public LocalDateTime getTime() {
      return time;
   }

   @Override
   public void setTime(LocalDateTime time) {
      this.time = time;
   }
   @Override
   public double getOpen() {
      return open;
   }

   @Override
   public void setOpen(double open) {
      this.open = open;
   }

   @Override
   public double getHigh() {
      return high;
   }

   @Override
   public void setHigh(double high) {
      this.high = high;
   }

   @Override
   public double getLow() {
      return low;
   }

   @Override
   public void setLow(double low) {
      this.low = low;
   }

   @Override
   public double getClose() {
      return close;
   }

   @Override
   public void setClose(double close) {
      this.close = close;
   }

   @Override
   public long getVolume() {
      return volume;
   }

   @Override
   public void setVolume(long volume) {
      this.volume = volume;
   }

   public double getWap() {
      return wap;
   }

   public void setWap(double wap) {
      this.wap = wap;
   }

   public double getCount() {
      return count;
   }

   public void setCount(double count) {
      this.count = count;
   }

   public String getSymbol() {
      return symbol;
   }

   public void setSymbol(String symbol) {
      this.symbol = symbol;
   }

   public double getpClose() {
      return pClose;
   }

   public void setpClose(double pClose) {
      this.pClose = pClose;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();

      builder.append(time).append(",").append(open).append(",").append(high).append(",")
            .append(low).append(",").append(close).append(",").append(volume).append(",")
            .append(wap).append(",").append(count).append(",").append(symbol).append(",").append(pClose);

      return builder.toString();
   }

}
