package advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Graph<T> {
    private HashMap<UUID, ArrayList<UUID>> links;
    private HashMap<UUID, T> nodes;

    public void addLink(UUID from, UUID to) {
        if (links.containsKey(from)) {
            links.get(from).add(to);
        } else {
            links.put(from, new ArrayList<>(Collections.singletonList(to)));
        }
    }

    public void addBidirectionalLinks(UUID from, UUID to) {
        addLink(from, to);
        addLink(to, from);
    }

    public void removeLink(UUID from, UUID to) {
        links.get(from).remove(to);
        if (links.get(from).isEmpty()) {
            links.remove(from);
        }
    }

    public void removeBidirectionalLinks(UUID from, UUID to) {
        removeLink(from, to);
        removeLink(to, from);
    }

    public UUID addNode(T data) {
        UUID id = UUID.randomUUID();
        nodes.put(id, data);
        return id;
    }

    public UUID addChild(UUID parent, T data) {
        UUID id = addNode(data);
        addLink(parent, id);
        return id;
    }

    public ArrayList<UUID> getChildren(UUID node) {
        return links.get(node);
    }

    public ArrayList<UUID> getParents(UUID node) {
        ArrayList<UUID> result = new ArrayList<>();
        for (Map.Entry<UUID, ArrayList<UUID>> link : links.entrySet()) {
            if (link.getValue().contains(node)) {
                result.add(link.getKey());
            }
        }
        return result;
    }

    public ArrayList<UUID> getNodeLinks(UUID node) {
        ArrayList<UUID> parents = getParents(node);
        ArrayList<UUID> childs = getChildren(node);
        ArrayList<UUID> result = new ArrayList<>(parents);
        result.addAll(childs);
        return result;
    }
}