package a2_2201040061;

public class PCFactory {
    // Singleton instance
    private static PCFactory instance;

    // Private constructor to prevent instantiation
    private PCFactory() {

    }

    // Factory method to create PCs
    public static PCFactory getInstance() {
        if (instance == null) {
            instance = new PCFactory();
        }
        return instance;
    }

    // Method to create PC instances
    public PC createPC(String model, int year, String manufacturer, Set<String> comps) throws Exception{
        return new PC(model, year, manufacturer, comps);
    }
}
