package dave.opensearch.commands;

import dave.opensearch.services.HttpUtil;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.indices.CreateIndexRequest;
import picocli.CommandLine;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@CommandLine.Command(name = "add")
public class CreateIndex implements Runnable{

    @CommandLine.Parameters(index = "0", arity = "1")
    String indexName;

    @CommandLine.Parameters(index = "1", arity = "0..1")
    String templateName;

    @Override
    public void run() {

        try {

            OpenSearchClient openSearchClient = HttpUtil.BuildOpenSearchTransport();
            var response = openSearchClient.indices().create(new CreateIndexRequest.Builder()
                    .index(indexName)
                    .build());

            if(response.acknowledged()){
                System.out.println(response.index() + " created");
            }else{
                System.out.println(this.getClass() + " failed");
                System.out.println(response.toString());
                System.exit(1);
            }

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (KeyStoreException e) {
            throw new RuntimeException(e);
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
