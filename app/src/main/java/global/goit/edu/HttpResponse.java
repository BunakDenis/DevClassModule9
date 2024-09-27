package global.goit.edu;

import lombok.Data;

import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

@Data
public class HttpResponse {
    private String protocol = "HTTP/1.1";
    private int statusCode;
    private String statusText;

    private Map<String, String> headers = new LinkedHashMap<>();

    private String body;

    @Override
    public String toString() {

        StringJoiner joiner = new StringJoiner("\n");

        joiner.add(protocol + " " + statusCode + " " + statusText + " ");

        for (Map.Entry<String, String> header : headers.entrySet()) {
            joiner.add(header.getKey() + " = " + header.getValue());
        }

        joiner.add("Content-Length: " + body.getBytes(StandardCharsets.UTF_8).length);
        joiner.add("Content-Type: text/html; charset=utf-8");
        joiner.add("Set-Cookie: yummy_cookie=choco");
        joiner.add("Set-Cookie: tasty_cookie=strawberry");
        //joiner.add("Access-Control-Allow-Origin: https://developer.mozilla.org");
        //joiner.add("Vary: Origin");
        joiner.add("Cross-Origin-Embedder-Policy: credentialless");
        joiner.add(" ");
        joiner.add(body);

        return joiner.toString();
    }
}
