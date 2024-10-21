package graph;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashMap;
import java.util.UUID;

public class MermaidParser {
    static public Graph<MermaidNode> parse(String input) {
        Pattern pattern = Pattern.compile("(\\w+(?:\\([\\w\\s]+\\))?)\\s*([<-]-+[>-])\\s*(\\w+(?:\\([\\w\\s]+\\))?)");
        Matcher matcher = pattern.matcher(input);

        HashMap<String, UUID> parsedNodes = new HashMap<String, UUID>();
        Graph<MermaidNode> result = new Graph<MermaidNode>();

        while (matcher.find()) {
            String from = matcher.group(1);
            String link = matcher.group(2);
            String to = matcher.group(3);

            MermaidNode fromNode = MermaidNode.parse(from);
            MermaidNode toNode = MermaidNode.parse(to);

            if (!parsedNodes.containsKey(fromNode.name)) {
                UUID id = result.addNode(fromNode);
                parsedNodes.put(fromNode.name, id);
            }

            if (!parsedNodes.containsKey(toNode.name)) {
                UUID id = result.addNode(toNode);
                parsedNodes.put(toNode.name, id);
            }

            UUID fromId = parsedNodes.get(fromNode.name);
            UUID toId = parsedNodes.get(toNode.name);

            if (link.contains(">")) {
                result.addLink(fromId, toId);
            }
            if (link.contains("<")) {
                result.addLink(toId, fromId);
            }
        }
        return result;
    }
}
