package co.r.example.formsendexample;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class SampleController {

    private String endpoint = "http://localhost:9999/index";

    private final RestTemplate restTemplate;

    public SampleController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("")
    public String index() {

        final MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.set("multibyte-character", "とてもつらい");

        final HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=windows-31j");

        return restTemplate.postForObject(endpoint, new HttpEntity<>(form, headers), String.class);
    }
}
