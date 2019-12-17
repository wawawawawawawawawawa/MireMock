import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class Application {
    //定义mock服务的端口
    private static final int POST = 9090;
    //定义mock服务的地址
    private static final String LOCALHOST = "localhost";
    //定义mapping文件目录
    private static final String MOCK_DIR = "mock";

    //main方法中的内容为启动mock服务的固定写法
    public static void main(String[] args){
        final WireMockConfiguration config = wireMockConfig().port(POST)
                .usingFilesUnderClasspath(MOCK_DIR);
        final WireMockServer wireMockServer = new WireMockServer(config);
        wireMockServer.start();
        WireMock.configureFor(LOCALHOST,POST);
    }
}
