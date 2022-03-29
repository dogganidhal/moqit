package io.moqit.service.content;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import io.moqit.domain.ContentType;
import lombok.Getter;
import org.springframework.core.io.ClassPathResource;


@Getter
public class ResourceContentSource implements ContentSource {

    private final List<String> content;

    public ResourceContentSource(ContentType contentType) throws IOException {
        var resource = new ClassPathResource("content/" + contentType.name().toLowerCase() + ".txt");
        content = Files.lines(Path.of(resource.getPath())).toList();
    }

    @Override
    public String getOne() {
        return content.get((int) (Math.random() * content.size()));
    }

    @Override
    public Collection<String> getMultiple(int count) {
        if (count > content.size()) {
            throw new IllegalArgumentException("Requested count is greater than available content");
        }
        Collections.shuffle(content);
        return content.subList(0, count);
    }

}
