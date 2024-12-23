package browser;

public enum BrowserType {
    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge");

    private final String name;

    BrowserType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static BrowserType fromString(String browser) {
        for (BrowserType type : BrowserType.values()) {
            if (type.getName().equalsIgnoreCase(browser)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unsupported browser type: " + browser);
    }
}
