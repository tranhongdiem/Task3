package testdata.url;

public enum URL {

    HOMEPAGE("/"),
    CART("/cart"),
    CHEAP_COMP_DETAILS("/build-your-cheap-own-computer"),
    STANDARD_COMP_DETAILS("/build-your-own-computer");

    private final String path;

    URL(String path) {
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
}
