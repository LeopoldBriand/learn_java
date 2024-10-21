package graph;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Optional;

public class MermaidNode {
    public String name;
    public Optional<String> label;

    MermaidNode(String n, Optional<String> l) {
        name = n;
        label = l;
    }

    public static MermaidNode parse(String data) {
        Pattern pattern = Pattern.compile("^(\\w+)(?:\\(([\\w\\s]+)\\))?$");
        Matcher matcher = pattern.matcher(data);
        matcher.find();
        String name = matcher.group(1);
        Optional<String> label = Optional.ofNullable(matcher.group(2));
        return new MermaidNode(name, label);
    }
}