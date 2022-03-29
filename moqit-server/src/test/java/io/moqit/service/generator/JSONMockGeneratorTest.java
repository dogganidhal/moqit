package io.moqit.service.generator;

import java.util.List;

import io.moqit.domain.Column;
import io.moqit.domain.ContentType;
import io.moqit.domain.ColumnType;
import io.moqit.domain.Schema;
import io.moqit.domain.Table;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JSONMockGeneratorTest {

    private final JSONMockGenerator generator = new JSONMockGenerator();

    @Test
    void shouldGenerateSimpleJSONMock() {
        var request = Schema.builder()
            .tables(List.of(Table.builder()
                .columns(List.of(
                    Column.builder()
                        .name("first_name")
                        .contentType(ContentType.FIRST_NAME)
                        .type(ColumnType.STRING)
                        .build(),
                    Column.builder()
                        .name("last_name")
                        .contentType(ContentType.EMAIL)
                        .type(ColumnType.STRING)
                        .build(),
                    Column.builder()
                        .name("email")
                        .contentType(ContentType.EMAIL)
                        .type(ColumnType.STRING)
                        .build(),
                    Column.builder()
                        .name("birthdate")
                        .contentType(ContentType.BIRTH_DATE)
                        .type(ColumnType.TIMESTAMP)
                        .build()
                ))
                .build()
            ))
            .build();
        var json = generator.generate(request);
        Assertions.assertEquals("""
            """, json);
    }

}
