package io.moqit.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.util.Collection;

@Data
@Value
@Builder
public class Schema {

  Collection<Table> tables;

}
