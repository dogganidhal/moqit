package io.moqit.service.content;


import lombok.AllArgsConstructor;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
public class DateTimeContentSource implements ContentSource {

  private static final LocalDateTime MIN = LocalDateTime.of(1970, 1, 1, 0, 0, 0);
  private static final LocalDateTime MAX = LocalDateTime.of(2099, 12, 31, 23, 59, 59);

  @Nullable
  private final LocalDateTime upperBound;

  @Nullable
  private final LocalDateTime lowerBound;

  public static DateTimeContentSource after(LocalDateTime lowerBound) {
    return new DateTimeContentSource(null, lowerBound);
  }

  public static DateTimeContentSource before(LocalDateTime upperBound) {
    return new DateTimeContentSource(upperBound, null);
  }

  public static DateTimeContentSource between(LocalDateTime lowerBound, LocalDateTime upperBound) {
    return new DateTimeContentSource(upperBound, lowerBound);
  }

  public static DateTimeContentSource random() {
    return new DateTimeContentSource(null, null);
  }

  public static DateTimeContentSource past() {
    return before(LocalDateTime.now());
  }

  public static DateTimeContentSource future() {
    return after(LocalDateTime.now());
  }

  @Override
  public String getOne() {
    var upper = upperBound == null ? MAX : upperBound;
    var lower = lowerBound == null ? MIN : lowerBound;
    var epochSecond = ThreadLocalRandom
      .current()
      .nextLong(lower.toEpochSecond(ZoneOffset.UTC), upper.toEpochSecond(ZoneOffset.UTC));
    return LocalDateTime.ofEpochSecond(epochSecond, 0, ZoneOffset.UTC).toString();
  }

}
