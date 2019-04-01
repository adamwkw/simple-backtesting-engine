package instruments;

import dataHandler.Reader;
import enums.IInstrumentType;
import interfaces.IBar;
import interfaces.IInstruments;
import interfaces.IReader;

import java.util.List;

public class Futures implements IInstruments {

   private IInstrumentType instrumentType;
   private String symbolName;
   private double bigPointValue;
   private double tickSize;
   private String fileName;

   public Futures() {
   }

   public Futures(String symbolName, double bigPointValue,
                  double tickSize) {
      this.instrumentType = IInstrumentType.FUTURES;
      this.symbolName = symbolName;
      this.bigPointValue = bigPointValue;
      this.tickSize = tickSize;
   }

   @Override
   public void setInstrumentType(IInstrumentType instrumentType) {
      this.instrumentType = instrumentType;
   }

   @Override
   public IInstrumentType getInstrumentType() {
      return instrumentType;
   }

   @Override
   public void setSymbolName(String symbolName) {
      this.symbolName = symbolName;
   }

   @Override
   public String getSymbolName() {
      return symbolName;
   }

   @Override
   public double getTickSize() {
      return tickSize;
   }

   @Override
   public void setTickSize(double tickSize) {
      this.tickSize = tickSize;
   }

   @Override
   public double getBigPointValue() {
      return bigPointValue;
   }

   @Override
   public void setBigPointValue(double bigPointValue) {
      this.bigPointValue = bigPointValue;
   }

   @Override
   public void setDataSource(String fileName) {
      this.fileName = fileName;
   }

   @Override
   public List<IBar> getData() {
      IReader reader = new Reader(fileName);
      return reader.bars();
   }
}
