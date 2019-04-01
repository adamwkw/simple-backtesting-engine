package dataHandler;

import interfaces.IBar;
import interfaces.IReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reader implements IReader<LocalDateTime> {

   private final String fileName;
   private List<LocalDateTime> timeIndex;

   public Reader(String fileName) {
      this.fileName = fileName;
      timeIndex = new LinkedList<>();
   }

   public List<IBar> bars() {
      List<IBar> dataMap = new LinkedList<>();

      try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
         List<List<String>> values = lines
               .map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());

         for (List<String> cols : values) {
            dataMap.add(new IntraDayBar(LocalDateTime.parse(cols.get(0)), Double.parseDouble(cols.get(1)),
                  Double.parseDouble(cols.get(2)), Double.parseDouble(cols.get(3)),
                  Double.parseDouble(cols.get(4)), Long.parseLong(cols.get(5)), Double.parseDouble(cols.get(6)),
                  Long.parseLong(cols.get(7)), cols.get(8), Double.parseDouble(cols.get(9))));
            timeIndex.add(LocalDateTime.parse(cols.get(0)));
         }

      } catch (IOException e) {
      }
      return dataMap;
   }

   public List<LocalDateTime> timeIndex() {
      return timeIndex;
   }
}
