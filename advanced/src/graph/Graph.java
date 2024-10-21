package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Graph<T> {
    private HashMap<UUID, ArrayList<UUID>> links;
    private HashMap<UUID, T> nodes;

    Graph() {
        nodes = new HashMap<UUID, T>();
        links = new HashMap<UUID, ArrayList<UUID>>();
    }

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

    public ArrayList<UUID> getRootNodesIds() {
        ArrayList<UUID> result = new ArrayList<>();
        for (UUID nodeId : nodes.keySet()) {
            boolean isRoot = true;
            for (ArrayList<UUID> entry : links.values()) {
                if (entry.contains(nodeId)) {
                    isRoot = false;
                    break;
                }
            }
            if (isRoot) {
                result.add(nodeId);
            }
        }
        return result;
    }

    public ArrayList<UUID> getLeafNodeIds() {
        ArrayList<UUID> result = new ArrayList<>();
        for (UUID nodeId : nodes.keySet()) {
            if (!links.containsKey(nodeId)) {
                result.add(nodeId);
            }
        }
        return result;
    }

    public ArrayList<T> getNodesFromIds(ArrayList<UUID> ids) {
        ArrayList<T> result = new ArrayList<>();
        for (UUID id : ids) {
            result.add(nodes.get(id));
        }
        return result;
    }

    // Return Path as UUID array
    public ArrayList<UUID> BFS(UUID source, UUID destination) {
        LinkedList<UUID> queue = new LinkedList<>();
        ArrayList<UUID> visited = new ArrayList<>();
        HashMap<UUID, UUID> parentMap = new HashMap<>();

        queue.addFirst(source);
        visited.add(source);
        parentMap.put(source, null);

        while (!queue.isEmpty()) {
            UUID currentNode = queue.removeFirst();
            if (currentNode.equals(destination)) {
                ArrayList<UUID> path = new ArrayList<>();
                UUID current = destination;

                while (current != null) {
                    path.add(0, current);
                    current = parentMap.get(current);
                }

                return path;
            }
            for (UUID neighbor : getChildren(currentNode)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    parentMap.put(neighbor, currentNode);
                }
            }
        }
        return new ArrayList<>();
    }

    public ArrayList<UUID> DFS(UUID source, UUID destination) {
        return DFSRecursive(new ArrayList<>(Collections.singletonList(source)),
                new ArrayList<>(Collections.singletonList(source)), source, destination);
    }

    private ArrayList<UUID> DFSRecursive(ArrayList<UUID> path, ArrayList<UUID> visited, UUID current,
            UUID destination) {
        for (UUID id : links.get(current)) {
            if (id == destination) {
                path.add(id);
                return path;
            } else if (!visited.contains(id)) {
                path.add(id);
                return DFSRecursive(path, visited, current, destination);
            }
        }
        return new ArrayList<>();
    }
}