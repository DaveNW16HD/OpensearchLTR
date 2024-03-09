package dave.opensearch.schema;

import org.joda.time.DateTime;

public record SimpleSchema(
        String Id,
        String AuthorId,
        String Title,
        String Body,
        DateTime timestamp
) {


}
