import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.http.client.utils.URIBuilder;

public class GetApi {

    public static void main(String[] args) {

                try {
                    String clientId = myapi.clientId; //api
                    String wordToSearch = "이름"; // 검색할 단어

                    URIBuilder builder = new URIBuilder("https://opendict.korean.go.kr/api/search")
                            .setParameter("certkey_no", "6977")
                            .setParameter("key", clientId)
                            .setParameter("target_type", "search")
                            .setParameter("req_type", "json")
                            .setParameter("part", "word")
                            .setParameter("q", wordToSearch)
                            .setParameter("sort", "dict")
                            .setParameter("start", "1")
                            .setParameter("num", "10");

                    String url = builder.build().toString();
                    System.out.println(url); // 최종 URL 출력

                    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                        HttpGet request = new HttpGet(url);
                        HttpResponse response = httpClient.execute(request);

                        // 응답 처리
                        if (response.getStatusLine().getStatusCode() == 200) {
                            String jsonResponse = EntityUtils.toString(response.getEntity());
                            logger.info("Response: {}", jsonResponse); // 결과 출력
                        } else {
                            logger.error("Error: HTTP status code {}", response.getStatusLine().getStatusCode());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


}