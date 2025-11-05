import java.util.*;

class DAA2Huff {

    static class Node {
        char c;
        int f;
        Node l, r;

        Node(char c, int f) {
            this.c = c;
            this.f = f;
        }

        Node(int f, Node l, Node r) {
            this.f = f;
            this.l = l;
            this.r = r;
        }
    }

    static void print(Node root, String s) {
        if (root == null) return;

        if (root.l == null && root.r == null) {
            System.out.println(root.c + ": " + s);
            return;
        }

        print(root.l, s + "0");
        print(root.r, s + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter characters: ");
        char[] ch = sc.next().toCharArray();

        int[] f = new int[ch.length];
        System.out.print("Enter frequencies: ");
        for (int i = 0; i < f.length; i++) {
            f[i] = sc.nextInt();
        }

        long start = System.nanoTime();

        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.f));

        for (int i = 0; i < ch.length; i++) {
            q.add(new Node(ch[i], f[i]));
        }

        while (q.size() > 1) {
            Node a = q.poll();
            Node b = q.poll();
            q.add(new Node(a.f + b.f, a, b));
        }

        System.out.println("\nHuffman Codes:");
        print(q.peek(), "");

        long end = System.nanoTime();
        System.out.println("\nExecution Time: " + (end - start) / 1e6 + " ms");
    }
}
