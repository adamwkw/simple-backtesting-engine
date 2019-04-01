package interfaces;

import enums.IInstrumentType;

import java.util.List;

public interface IInstruments {
   void setInstrumentType(IInstrumentType instrumentType);
   IInstrumentType getInstrumentType();

   void setSymbolName(String symbolName);
   String getSymbolName();

   void setBigPointValue(double bigPointValue);
   double getBigPointValue();

   void setTickSize(double tickSize);
   double getTickSize();

   void setDataSource(String fileName);
   List<IBar> getData();

}
