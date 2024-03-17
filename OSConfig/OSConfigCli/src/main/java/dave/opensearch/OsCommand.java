package dave.opensearch;

import dave.opensearch.commands.AliasCommands;
import dave.opensearch.commands.GetAliases;
import dave.opensearch.commands.GetIndices;
import dave.opensearch.commands.IndexCommand;
import picocli.CommandLine;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@CommandLine.Command(name = "OS",
subcommands = {AliasCommands.class, IndexCommand.class})
public class OsCommand {
    public static void main(String[] args) throws Exception{
        int exitCode = new CommandLine(new OsCommand()).execute(args);
        System.exit(exitCode);
    }
}