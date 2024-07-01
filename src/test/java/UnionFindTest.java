import org.example.UnionFind;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnionFindTest {

    @Test
    public void testInitialization() {
        UnionFind uf = new UnionFind(10);
        for (int i = 0; i < 10; i++) {
            assertEquals(i, uf.find(i));
        }
    }

    @Test
    public void testUnionAndFind() {
        UnionFind uf = new UnionFind(10);
        uf.union(1, 2);
        uf.union(3, 4);
        uf.union(1, 4);

        assertEquals(uf.find(2), uf.find(4));
        assertEquals(uf.find(1), uf.find(3));
        assertNotEquals(uf.find(0), uf.find(1));
        assertNotEquals(uf.find(5), uf.find(4));
    }

    @Test
    public void testUnionByRank() {
        UnionFind uf = new UnionFind(10);
        uf.union(1, 2);
        uf.union(3, 4);
        uf.union(1, 4);
        uf.union(5, 6);
        uf.union(5, 7);
        uf.union(8, 9);
        uf.union(8, 6);

        assertEquals(uf.find(6), uf.find(9));
        assertEquals(uf.find(2), uf.find(3));
        assertNotEquals(uf.find(1), uf.find(5));
    }

    @Test
    public void testPathCompression() {
        UnionFind uf = new UnionFind(10);
        uf.union(1, 2);
        uf.union(2, 3);
        uf.union(3, 4);
        uf.union(4, 5);

        int originalParent = uf.find(5);
        int newParent = uf.find(1);
        assertEquals(originalParent, newParent);

        // After path compression, all nodes should point directly to the root
        assertEquals(uf.find(2), newParent);
        assertEquals(uf.find(3), newParent);
        assertEquals(uf.find(4), newParent);
    }
}
