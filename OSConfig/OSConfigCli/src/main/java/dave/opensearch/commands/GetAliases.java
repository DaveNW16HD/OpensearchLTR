package dave.opensearch.commands;

import dave.opensearch.services.HttpUtil;
import org.opensearch.client.opensearch.OpenSearchClient;
import picocli.CommandLine;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@CommandLine.Command(name="get")
public class GetAliases implements Runnable{
    @Override
    public void run() {
        try {
            OpenSearchClient openSearchClient = HttpUtil.BuildOpenSearchTransport();
            var response = openSearchClient.indices().getAlias();

            for(var item : response.result().keySet() ){
                System.out.println(item);
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (KeyStoreException e) {
            throw new RuntimeException(e);
        } catch (KeyManagementException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
