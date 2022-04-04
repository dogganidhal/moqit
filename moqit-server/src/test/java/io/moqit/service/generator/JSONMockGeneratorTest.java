package io.moqit.service.generator;

import io.moqit.domain.Column;
import io.moqit.domain.ColumnType;
import io.moqit.domain.Schema;
import io.moqit.domain.Table;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static io.moqit.domain.ContentType.ANY_DATE;
import static io.moqit.domain.ContentType.EMAIL;
import static io.moqit.domain.ContentType.FIRST_NAME;
import static io.moqit.domain.ContentType.LAST_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@DisplayName("JSON mock generator test")
public class JSONMockGeneratorTest {

  @Autowired
  private JSONMockGenerator generator;

  @Test
  @DisplayName("should generate simple JSON mock")
  void shouldGenerateSimpleJSONMock() {
    var request = Schema.builder()
      .tables(List.of(Table.builder()
        .columns(List.of(
          Column.builder()
            .name("first_name")
            .contentType(FIRST_NAME)
            .type(ColumnType.STRING)
            .build(),
          Column.builder()
            .name("last_name")
            .contentType(LAST_NAME)
            .type(ColumnType.STRING)
            .build(),
          Column.builder()
            .name("email")
            .contentType(EMAIL)
            .type(ColumnType.STRING)
            .build(),
          Column.builder()
            .name("birthdate")
            .contentType(ANY_DATE)
            .type(ColumnType.TIMESTAMP)
            .build()
        ))
        .build()
      ))
      .build();
    var json = generator.generate(request);
    assertEquals("""
      something""", json);
  }

}
