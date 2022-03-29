package io.moqit.domain;

import java.util.Collection;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Value
@Builder
public class Schema {

    Collection<Table> tables;

}
