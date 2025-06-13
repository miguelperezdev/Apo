package map;

import structure.Edge;
import structure.Graph;
import structure.Node;

import java.util.ArrayList;
import java.util.List;

public class GeneratorGraphMap {
    private List<Node> nodes;
    private List<Node> houses;
    public GeneratorGraphMap() {
        nodes = new ArrayList<>();
        houses = new ArrayList<>();

        createNodes();
    }
    public void createNodes() {
        //esquinas
        nodes.add(new Node("Corner1", 433, 113));
        nodes.add(new Node("Corner2", 433, 266));
        nodes.add(new Node("Corner3", 849, 110));
        nodes.add(new Node("Corner4", 846, 273));
        nodes.add(new Node("Corner5", 272, 49));
        nodes.add(new Node("Corner6", 271, 84));
        nodes.add(new Node("Corner7", 237, 276));
        nodes.add(new Node("Corner8", 239, 404));
        nodes.add(new Node("Corner9", 431, 396 ));
        nodes.add(new Node("Corner10",  881, 402));
        nodes.add(new Node("Corner11", 401, 627));
        nodes.add(new Node("Corner12", 880, 654));
        nodes.add(new Node("Corner13", 272, 945));
        nodes.add(new Node("Corner14", 398, 946));
        nodes.add(new Node("Corner15", 400, 813));
        nodes.add(new Node("Corner16", 274, 1136));
        nodes.add(new Node("Corner17", 401, 1167));
        nodes.add(new Node("Corner18", 274, 1521));
        nodes.add(new Node("Corner19", 400, 1364));
        nodes.add(new Node("Corner20", 399, 1521));
        nodes.add(new Node("Corner21", 1905, 1202));
        nodes.add(new Node("Corner22", 1940, 946));
        nodes.add(new Node("Corner23", 1228, 786));
        nodes.add(new Node("Corner24", 1876, 658));
        nodes.add(new Node("Corner25", 1905, 433));
        nodes.add(new Node("Corner26", 2068, 656));
        nodes.add(new Node("Corner27", 2032, 434));
        nodes.add(new Node("Corner28", 1616, 279));
        nodes.add(new Node("Corner29", 1658, 146));
        nodes.add(new Node("Corner30", 1327, 111));
        nodes.add(new Node("Corner31", 1745, 112));
        nodes.add(new Node("Corner32", 1748, 269));
        nodes.add(new Node("Corner33", 2056, 823));
        nodes.add(new Node("Corner34", 2065, 1169));
        nodes.add(new Node("Corner35", 848, 817));
        nodes.add(new Node("Corner36", 239, 1170));
        nodes.add(new Node("Corner37", 844, 625));
        nodes.add(new Node("Corner38", 1610, 32));
        nodes.add(new Node("Corner39", 456, 32));
        nodes.add(new Node("Corner40", 272, 240));
        nodes.add(new Node("Corner41", 270, 425));
        nodes.add(new Node("Corner42", 431, 785));
        nodes.add(new Node("Corner43", 879, 779));

        //casas
        nodes.add(new Node("House1", 71, 141));
        nodes.add(new Node("House2", 125, 138));
        nodes.add(new Node("House3", 80, 199));
        nodes.add(new Node("House4", 134, 198));
        nodes.add(new Node("House5", 185, 180));
        nodes.add(new Node("House6", 511, 194));
        nodes.add(new Node("House7", 1545, 196));
        nodes.add(new Node("House8", 502, 493));
        nodes.add(new Node("House9", 566, 487));
        nodes.add(new Node("House10", 622, 485));
        nodes.add(new Node("House11", 678, 491));
        nodes.add(new Node("House12", 725, 467));
        nodes.add(new Node("House13", 800, 478));
        nodes.add(new Node("House14", 486, 547));
        nodes.add(new Node("House15", 536, 562));
        nodes.add(new Node("House16", 600, 566));
        nodes.add(new Node("House17", 663, 564));
        nodes.add(new Node("House18", 727, 951));
        nodes.add(new Node("House19", 808, 569));
        nodes.add(new Node("House20", 1208, 488));
        nodes.add(new Node("House21", 1287, 518));
        nodes.add(new Node("House22", 1141, 557));
        nodes.add(new Node("House23", 1191, 599));
        nodes.add(new Node("House24", 1242, 568));
        nodes.add(new Node("House25", 1287, 590));
        nodes.add(new Node("House26", 2128, 490));
        nodes.add(new Node("House27", 2190, 490));
        nodes.add(new Node("House28", 2253, 521));
        nodes.add(new Node("House29", 2102, 600));
        nodes.add(new Node("House30", 2151, 600));
        nodes.add(new Node("House31", 2202, 600));
        nodes.add(new Node("House32", 2238, 583));
        nodes.add(new Node("House33", 1127, 993));
        nodes.add(new Node("House34", 1177, 979));
        nodes.add(new Node("House35", 1272, 1002));
        nodes.add(new Node("House36", 1115, 1086));
        nodes.add(new Node("House37", 1173, 1085));
        nodes.add(new Node("House38", 1243, 1068));
        nodes.add(new Node("House39", 1280, 1068));
        nodes.add(new Node("House40", 1507, 1006));
        nodes.add(new Node("House41", 1613, 1008));
        nodes.add(new Node("House42", 1702, 1047));
        nodes.add(new Node("House43", 1752, 1057));
        nodes.add(new Node("House44", 1455, 1064));
        nodes.add(new Node("House45", 1508, 1068));
        nodes.add(new Node("House46", 1623, 1071));
        nodes.add(new Node("House47", 1502, 1122));
        nodes.add(new Node("House48", 1692, 1127));
        nodes.add(new Node("House49", 2137, 842));
        nodes.add(new Node("House50", 2232, 888));
        nodes.add(new Node("House51", 2151, 942));
        nodes.add(new Node("House52", 2197, 1009));
        nodes.add(new Node("House53", 2246, 999));
        nodes.add(new Node("House54", 2134, 1095));
        nodes.add(new Node("House55", 2191, 1131));
        nodes.add(new Node("House56", 545, 1520));
        nodes.add(new Node("House57", 694, 1419));
        nodes.add(new Node("House58", 691, 1484));
        nodes.add(new Node("House59", 676, 1545));
        nodes.add(new Node("House60", 760, 1476));
        nodes.add(new Node("House61", 814, 1416));
        nodes.add(new Node("House62", 752, 1547));
        nodes.add(new Node("House63", 848, 1483));
        nodes.add(new Node("House64", 831, 1538));
        nodes.add(new Node("House65", 1048, 1417));
        nodes.add(new Node("House66", 1111, 1409));
        nodes.add(new Node("House67", 1211, 1477));
        nodes.add(new Node("House68", 1065, 1528));
        nodes.add(new Node("House69", 1127, 1521));
        nodes.add(new Node("House70", 1195, 1544));
        nodes.add(new Node("House71", 1254, 1547));
        nodes.add(new Node("House72", 1533, 1418));
        nodes.add(new Node("House73", 1532, 1483));
        nodes.add(new Node("House74", 1734, 1481));
        nodes.add(new Node("House75", 1886, 1409));
        nodes.add(new Node("House76", 1973, 1418));
        nodes.add(new Node("House77", 1946, 1474));
        nodes.add(new Node("House78", 128, 1379));
        nodes.add(new Node("House79", 1007, 1054));
        nodes.add(new Node("House80", 1444, 176));


    }
    public List<Node> getNodes() {
        return nodes;
    }
    public void createEdges(Graph graph){
        connectOneWay(graph,"Corner2", "Corner1");
        connectOneWay(graph,"Corner2", "Corner4");
        connectOneWay(graph, "Corner1", "Corner3");
        connectOneWay(graph,"Corner4", "Corner28");
        connectOneWay(graph,"Corner28", "Corner29");
        connectOneWay(graph,"Corner29", "Corner38");
        connectBidirectional(graph,"Corner38", "Corner5");
        connectBidirectional(graph,"Corner5", "Corner40");
        connectOneWay(graph,"Corner8", "Corner13");
        connectOneWay(graph,"Corner9", "Corner10");
        connectOneWay(graph,"Corner11", "Corner9");
        connectOneWay(graph,"Corner11", "Corner12");
        connectOneWay(graph, "Corner12", "Corner24");
        connectOneWay(graph, "Corner24", "Corner25");
        connectOneWay(graph, "Corner24", "Corner26");
        connectOneWay(graph, "Corner25", "Corner27");
        connectOneWay(graph, "Corner18", "Corner19");
        connectOneWay(graph, "Corner19", "Corner17");
        connectOneWay(graph, "Corner17", "Corner14");
        connectOneWay(graph, "Corner14", "Corner15");
        connectOneWay(graph,"Corner15", "Corner42");
        connectOneWay(graph, "Corner42", "Corner43");
        connectOneWay(graph, "Corner43", "Corner23");
        connectOneWay(graph,"Corner21", "Corner17");
        connectOneWay(graph,"Corner22", "Corner21");
        connectOneWay(graph,"Corner33", "Corner34");
        connectOneWay(graph, "Corner26", "Corner33");
        connectOneWay(graph, "Corner24", "Corner22");
        connectOneWay(graph, "Corner23", "Corner33");
        connectBidirectional(graph,"Corner24", "Corner25");
        connectBidirectional(graph,"Corner26", "Corner27");
        connectBidirectional(graph,"Corner32", "Corner31");
        connectBidirectional(graph,"Corner15", "Corner14");
        connectBidirectional(graph,"Corner16", "Corner18");
        connectBidirectional(graph,"Corner19", "Corner20");
        connectBidirectional(graph, "Corner35", "Corner37");
        connectBidirectional(graph, "Corner36", "Corner17");
        connectBidirectional(graph, "Corner8", "Corner9");
        connectBidirectional(graph, "Corner7", "Corner2");
        connectBidirectional(graph, "Corner10", "Corner4");
        connectBidirectional(graph, "Corner28", "Corner32");
        connectBidirectional(graph, "Corner34", "Corner21");
        connectBidirectional(graph, "Corner19", "Corner17");
        connectBidirectional(graph, "Corner37", "Corner11");
        for(Node house : houses) {
            Node nearest = graph.getClosestNode(house.getX(), house.getY());
            connectBidirectional(graph, house.getId(), nearest.getId());
        }

    }

    public Node findNodeByName(String name) {
        for (Node node : nodes) {
            if (node.getId().equals(name)) {
                return node;
            }
        }
        return null;
    }
    private void connectBidirectional(Graph graph, String nodeId1, String nodeId2) {
        Node node1 = findNodeByName(nodeId1);
        Node node2 = findNodeByName(nodeId2);
        if (node1 != null && node2 != null) {
            graph.addEdge(new Edge(node1, node2));
            graph.addEdge(new Edge(node2, node1));
        }
    }
    public List<Node> getHouseNodes() {
        List<Node> result = new ArrayList<>();
        for (Node node : nodes) {
            if (node.getId().startsWith("House")) {
                result.add(node);
            }
        }
        return result;
    }
    private void connectOneWay(Graph graph, String fromId, String toId) {
        Node from = findNodeByName(fromId);
        Node to = findNodeByName(toId);
        if (from != null && to != null) {
            graph.addEdge(new Edge(from, to));
        }
    }
}
