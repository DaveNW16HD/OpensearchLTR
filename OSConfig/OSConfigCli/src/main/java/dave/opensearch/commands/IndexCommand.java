package dave.opensearch.commands;


import picocli.CommandLine;

@CommandLine.Command(name = "index", subcommands = { GetIndices.class, CreateIndex.class })
public class IndexCommand {
}
