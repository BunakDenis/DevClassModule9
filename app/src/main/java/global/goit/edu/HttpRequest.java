package global.goit.edu;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

@Data
public class HttpRequest {

    private Method method;
    private String path;
    private String protocol;
    private Map<String, String> headers = new LinkedHashMap<>();
    private String body;


    public enum Method {
        GET,
        POST
    }

    public static HttpRequest of(String text) {

        HttpRequest request = new HttpRequest();

        String[] lines = text.split("\n");

        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].replace("\r", "");
        }

        //System.out.println("text = " + text);
        //System.out.println("Arrays.toString(lines) = " + Arrays.toString(lines));
        if (lines.length > 1) {
            String startLine = lines[0];

            String[] startLineParts = startLine.split(" ");
            //System.out.println(startLineParts[0]);

            if (!startLineParts[0].equals(" ")) {
                request.setMethod(Method.valueOf(startLineParts[0]));
                request.setPath(startLineParts[1]);
                request.setProtocol(startLineParts[2]);

                for (int i = 1; i < lines.length; i++) {
                    String line = lines[i];
                    //System.out.println("line = " + line);

                    if (line.equals("")) {
                        StringJoiner bodyStringJoiner = new StringJoiner("\n");

                        for (int j = i + 1; j < lines.length; j++) {
                            bodyStringJoiner.add(lines[j]);
                        }

                        request.setBody(bodyStringJoiner.toString());

                    } else {

                        String[] keyValue = line.split(": ");
                        //System.out.println("Arrays.toString(keyValue) = " + Arrays.toString(keyValue));

                        if (keyValue.length > 1) {
                            request.getHeaders().put(
                                    keyValue[0].strip(),
                                    keyValue[1].strip()
                            );
                        }
                    }
                }
            }
        }

        System.out.println("headers.size() = " + request.getHeaders().size());
        return request;

    }

    @Override
    public String toString() {

        StringBuilder mapAsString = new StringBuilder();

        System.out.println("headers.size() = " + headers.size());
        if (headers.size() > 1) {
            mapAsString.append("{");
            for (String key : headers.keySet()) {
                mapAsString.append(key + " = " + headers.get(key) + " ,");
            }

            mapAsString.delete(mapAsString.length() - 2, mapAsString.length());
            mapAsString.append("}");
        }

        return "HttpRequest{" +
                "method=" + method +
                ", path='" + path + '\'' +
                ", protocol='" + protocol + '\'' +
                ", headers=" +
                mapAsString
                +
                ", body='" + body + '\'' +
                '}';
    }
}
