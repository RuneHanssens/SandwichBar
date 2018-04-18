package be.ucll.sandwichbar.db;

import be.ucll.sandwichbar.domain.SandwichGraphData;
import java.util.ArrayList;

public class SandwichHistoryDbInMemory implements SandwichHistoryDb {
    private ArrayList<SandwichGraphData> popularSandwiches;

    public SandwichHistoryDbInMemory() {
        popularSandwiches = new ArrayList<>();
        generateContent();
    }

    @Override
    public ArrayList<SandwichGraphData> getPopularSandwiches() {
        return popularSandwiches;
    }

    private void generateContent(){
        popularSandwiches.add(new SandwichGraphData("broodje1", 10));
        popularSandwiches.add(new SandwichGraphData("broodje3", 9));
        popularSandwiches.add(new SandwichGraphData("broodje2", 4));
    }
}
