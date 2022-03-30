package io.moqit.service.content;

import io.moqit.domain.ContentType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Stream;

public interface ContentSource {

  String getOne();

  default Collection<String> getMultiple(int count) {
    return Stream
      .generate(this::getOne)
      .limit(count)
      .toList();
  }

  @Component
  @AllArgsConstructor
  final class Registry {

    private static final String BEAN_SUFFIX = "_content_source";

    private final ConfigurableBeanFactory beanFactory;

    public void register(ContentType type, ContentSource source) {
      beanFactory.registerSingleton(type.name().toLowerCase() + BEAN_SUFFIX, source);
    }

    public ContentSource resolve(ContentType type) {
      return beanFactory.getBean(type.name().toLowerCase() + BEAN_SUFFIX, ContentSource.class);
    }

  }

}
