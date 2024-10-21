package graph;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class MermaidParserTest {
    @Test
    public void mermaidParser() {
        String data = """
                flowchart LR
                    A(WinLogBeat) <--> B(Logstash)
                    F(WinLogBeat) --> B(Logstash)
                    B --> C(ElasticSearch)
                    D --> C
                    E(Client) --> D
                """;
        Graph<MermaidNode> graph = MermaidParser.parse(data);
        ArrayList<MermaidNode> rootNodes = graph.getNodesFromIds(graph.getRootNodesIds());
        Assert.assertTrue(rootNodes.size() == 2);
    }
}
