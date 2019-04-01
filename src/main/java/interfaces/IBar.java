package interfaces;

public interface IBar<T> {

   T getTime();

   void setTime(T time);

   double getOpen();

   void setOpen(double open);

   double getHigh();

   void setHigh(double high);

   double getLow();

   void setLow(double low);

   double getClose();

   void setClose(double close);

   long getVolume();

   void setVolume(long volume);
}
