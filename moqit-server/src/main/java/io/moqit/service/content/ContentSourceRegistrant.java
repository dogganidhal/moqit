package io.moqit.service.content;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static io.moqit.domain.ContentType.*;

@Slf4j
@Component
@AllArgsConstructor
public class ContentSourceRegistrant implements ApplicationRunner {

  private final ContentSource.Registry registry;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    try {
      registry.register(FIRST_NAME, new ResourceContentSource(FIRST_NAME));
      registry.register(LAST_NAME, new ResourceContentSource(LAST_NAME));
      registry.register(ADDRESS, new ResourceContentSource(ADDRESS));
      registry.register(PHONE_NUMBER, new ResourceContentSource(PHONE_NUMBER));
    } catch (IOException e) {
      log.error(e.getMessage(), e);
      return;
    }
    registry.register(EMAIL, new EmailContentSource(registry.resolve(FIRST_NAME), registry.resolve(LAST_NAME)));
    registry.register(IP_ADDRESS, new IPAddressContentSource());
    registry.register(ANY_DATE, DateTimeContentSource.random());
    registry.register(FUTURE_DATE, DateTimeContentSource.future());
    registry.register(PAST_DATE, DateTimeContentSource.past());
  }

}
