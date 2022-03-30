package io.moqit.service;

import io.moqit.domain.ContentType;
import io.moqit.service.content.ContentSource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContentGenerator {

  private final ContentSource.Registry contentSourceRegistry;

  public Object generate(ContentType contentType) {
    return contentSourceRegistry.resolve(contentType).getOne();
  }

}
