import java.util.PriorityQueue;

class Node {
    int freq;
    char symbol;
    Node left, right;

    public Node(int freq, char symbol, Node left, Node right) {
        this.freq = freq;
        this.symbol = symbol;
        this.left = left;
        this.right = right;
    }
}

public class HuffmanCoding {

    public static void printNodes(Node node, String code) {
        if (node.left == null && node.right == null) {
            System.out.println(node.symbol + " -> " + code);
            return;
        }
        printNodes(node.left, code + "0");
        printNodes(node.right, code + "1");
    }

    public static void main(String[] args) {
        char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] freq = { 5, 9, 12, 13, 16, 45 };

        PriorityQueue<Node> nodes = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        for (int i = 0; i < chars.length; i++)
            nodes.add(new Node(freq[i], chars[i], null, null));

        while (nodes.size() > 1) {
            Node left = nodes.poll();
            Node right = nodes.poll();
            nodes.add(new Node(left.freq + right.freq, '-', left, right));
        }

        printNodes(nodes.peek(), "");
    }
}
f -> 0
c -> 100
d -> 101
a -> 1100
b -> 1101
e -> 111