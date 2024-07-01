import org.example.UnionFind;
import org.example.UnionFindHelper;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class UnionFindHelperTest {
    Set<Integer> vertices = Set.of(4, 3, 1, 5, 6);
    List<int[]> connections = List.of(new int[]{4,3}, new int[]{1,4}, new int[]{5,6});

    @Test
    public void testGraphsNumber() {
        int maxVertice = Collections.max(vertices);
        UnionFind uf = new UnionFind(maxVertice + 1);
        UnionFindHelper.createUnions(connections, uf);
        int graphsNumber = UnionFindHelper.getSeperatedGraphsNumber(vertices, uf);
        Assertions.assertEquals(2, graphsNumber);
    }
}
