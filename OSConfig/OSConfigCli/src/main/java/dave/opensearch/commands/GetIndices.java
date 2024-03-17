package dave.opensearch.commands;

import dave.opensearch.services.HttpUtil;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.core.IndexRequest;
import org.opensearch.client.opensearch.indices.*;
import picocli.CommandLine;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@CommandLine.Command(name = "get")
public class GetIndices implements Runnable {

    @CommandLine.Parameters(index = "0", arity = "0..1")
    String indexName;

    @Override
    public void run() {
        try {

            OpenSearchClient openSearchClient = HttpUtil.BuildOpenSearchTransport();

            if (indexName == null || indexName.isEmpty()) {
                var response = openSearchClient.cat().indices();

                for (var item : response.valueBody()) {
                    System.out.println(item.index());
                }
            } else {

                var mappingResponse = openSearchClient.indices().getMapping(
                        new GetMappingRequest.Builder()
                                .index(indexName)
                                .build());

                for(var key : mappingResponse.result().keySet()){
                    System.out.println(mappingResponse.result().get(key).mappings().fieldNames().);
                }

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
