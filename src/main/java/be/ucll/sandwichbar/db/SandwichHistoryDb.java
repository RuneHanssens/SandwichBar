package be.ucll.sandwichbar.db;

import be.ucll.sandwichbar.domain.SandwichGraphData;
import java.util.ArrayList;

public interface SandwichHistoryDb {
    ArrayList<SandwichGraphData> getPopularSandwiches();
}
