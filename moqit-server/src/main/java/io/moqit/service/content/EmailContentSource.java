package io.moqit.service.content;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class EmailContentSource implements ContentSource {

  private final static List<String> EMAIL_DOMAINS = List.of(
    "gmail.com",
    "yahoo.com",
    "hotmail.com"
  );

  private final ContentSource firstNameSource;
  private final ContentSource lastNameSource;

  @Override
  public String getOne() {
    return firstNameSource.getOne() + "." + lastNameSource.getOne() + getRandomEmailDomain();
  }

  private String getRandomEmailDomain() {
    return EMAIL_DOMAINS.get((int) (Math.random() * EMAIL_DOMAINS.size()));
  }

}
