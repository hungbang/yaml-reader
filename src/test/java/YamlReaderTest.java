import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class YamlReaderTest {

    @Test
    public void getContentByKey() throws IOException {
        String s = new ClassPathResource("sample.yaml").getPath();
        Object o = YamlReader.readByKey("key", s);
        if(o instanceof String && "key2".equalsIgnoreCase(o.toString())){
            System.out.println(YamlReader.readByKey("content", s));
        }

    }
}