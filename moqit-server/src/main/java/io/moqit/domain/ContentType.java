package io.moqit.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContentType {

    FIRST_NAME(ColumnType.STRING, ContentSourceType.RESOURCE),
    LAST_NAME(ColumnType.STRING, ContentSourceType.RESOURCE),
    EMAIL(ColumnType.STRING, ContentSourceType.FUNCTION),
    IP_ADDRESS(ColumnType.STRING, ContentSourceType.FUNCTION),
    PHONE_NUMBER(ColumnType.STRING, ContentSourceType.FUNCTION),
    ADDRESS(ColumnType.STRING, ContentSourceType.RESOURCE),
    BIRTH_DATE(ColumnType.TIMESTAMP, ContentSourceType.FUNCTION),
    FUTURE_DATE(ColumnType.TIMESTAMP, ContentSourceType.FUNCTION),
    PAST_DATE(ColumnType.TIMESTAMP, ContentSourceType.FUNCTION);

    private final ColumnType columnType;
    private final ContentSourceType sourceType;

}
