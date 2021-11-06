package testdata.purchasing;

public class CheapComputerBuilder {

    private final String processorType;
    private final String ram;
    private final String hdd;
    private final String os;
    private final String software;

    private CheapComputerBuilder(Builder builder){
        this.processorType = builder.processorType;
        this.ram = builder.ram;
        this.os = builder.os;
        this.hdd = builder.hdd;
        this.software = builder.software;
    }

    public String processorType() {
        return processorType;
    }

    public String ram() {
        return ram;
    }

    public String os() {
        return os;
    }

    public String hdd() {
        return hdd;
    }

    public String software() {
        return software;
    }

    public static class Builder {
        private String processorType;
        private String ram;
        private String os;
        private String hdd;
        private String software;

        public void processorType(String processorType) {
            this.processorType = processorType;
        }

        public void ram(String ram) {
            this.ram = ram;
        }

        public void os(String ram) {
            this.ram = ram;
        }

        public void hdd(ComputerSpec hdd) {
            this.hdd = hdd.value();
        }

        public void software(String software) {
            this.software = software;
        }

        public CheapComputerBuilder build(){
            return new CheapComputerBuilder(this);
        }
    }

}
