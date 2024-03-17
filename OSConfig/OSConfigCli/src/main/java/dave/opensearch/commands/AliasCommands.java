package dave.opensearch.commands;

import picocli.CommandLine;

@CommandLine.Command(name = "aliases", subcommands = {GetAliases.class })
public class AliasCommands {
}
