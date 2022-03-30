package io.moqit.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContentType {

  FIRST_NAME(ColumnType.STRING),
  LAST_NAME(ColumnType.STRING),
  EMAIL(ColumnType.STRING),
  IP_ADDRESS(ColumnType.STRING),
  PHONE_NUMBER(ColumnType.STRING),
  ADDRESS(ColumnType.STRING),
  ANY_DATE(ColumnType.TIMESTAMP),
  FUTURE_DATE(ColumnType.TIMESTAMP),
  PAST_DATE(ColumnType.TIMESTAMP);

  private final ColumnType columnType;

}
