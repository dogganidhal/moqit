package io.moqit.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Value
@Builder
public class Column {
    String name;
    @Builder.Default
    boolean primary = false;
    @Builder.Default
    boolean nullable = false;
    @Builder.Default
    boolean unique = false;
    ColumnType type;
    ContentType contentType;
    ForeignKey references;
}
