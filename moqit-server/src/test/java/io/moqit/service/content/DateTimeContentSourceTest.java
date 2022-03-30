package io.moqit.service.content;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Nidhal Dogga
 * @created 3/30/2022 8:47 PM
 */


@DisplayName("DateTime content source test")
class DateTimeContentSourceTest {

  @Test
  @DisplayName("should generate a date between the given range")
  void shouldGenerateDatesInTheGivenRange() {
    DateTimeContentSource.past()
      .getMultiple(100)
      .stream().map(LocalDateTime::parse)
      .forEach(dateTime -> assertTrue(dateTime.isBefore(LocalDateTime.now())));
    DateTimeContentSource.future()
      .getMultiple(100)
      .stream().map(LocalDateTime::parse)
      .forEach(dateTime -> assertTrue(dateTime.isAfter(LocalDateTime.now())));
  }

  @Test
  @DisplayName("should generate different dates")
  void shouldGenerateDifferentDates() {
    var dates = DateTimeContentSource.random().getMultiple(100);
    var filteredDoubles = dates.stream()
      .filter(dateTime -> Collections.frequency(dates, dateTime) == 1)
      .map(LocalDateTime::parse)
      .toList();
    assertEquals(100, filteredDoubles.size());
  }

}
