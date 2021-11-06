package testdata.purchasing;

public class ComputerDataObject {

    private String processorType;
    private String ram;
    private String hdd;
    private String os;
    private String software;

    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    @Override
    public String toString() {
        return "CheapComputer{" +
                "processorType='" + processorType + '\'' +
                ", ram='" + ram + '\'' +
                ", hdd='" + hdd + '\'' +
                ", os='" + os + '\'' +
                ", software='" + software + '\'' +
                '}';
    }

}
