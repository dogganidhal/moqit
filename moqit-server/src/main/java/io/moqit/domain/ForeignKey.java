package io.moqit.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Value
@Builder
public class ForeignKey {
    String table;
    String column;
}
