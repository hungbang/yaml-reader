import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Map;

public class YamlReaderTest {

    @Test
    public void getContentByKey() throws IOException {
        String s = new ClassPathResource("sample.yaml").getPath();
        Map<String, Object> map = YamlReader.getMapByRoot("key", "key1", s);
        System.out.println(map.get("content"));
    }
}