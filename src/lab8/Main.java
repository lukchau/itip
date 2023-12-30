package lab8;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        DataManager dataManager = new DataManager();
        dataManager.registerDataProcessor(new DataProcessors());


        dataManager.loadData("C:\\Users\\honor\\IdeaProjects\\tasks\\src\\laba8\\input.txt");

        dataManager.processData();

        dataManager.saveData("C:\\Users\\honor\\IdeaProjects\\tasks\\src\\laba8\\output.txt");
    }
}
