package testdata.purchasing;

public enum ComputerSpec {

    PROCESSOR_SLOW("Slow", 0.0),
    PROCESSOR_MEDIUM("Medium", 15.0),
    PROCESSOR_FAST("Fast", 100.0),
    INTEL_22_GHZ("2.2 GHz Intel", 0.0),
    INTEL_25_GHZ("2.5 GHz Intel", 15.0),
    RAM_2GB("2 GB", 0.0),
    RAM_4GB("4 GB", 20.0),
    RAM_8GB("8 GB", 60.0),
    OS_UBUNTU("Ubuntu", 0.0),
    OS_WINDOWS_7("Windows 7", 50.0),
    OS_WINDOWS_10("Windows 10", 60.0),
    HDD_320GB("320 GB", 0.0),
    HDD_400GB("400 GB", 100.0),
    SOFTWARE_IMAGE_VIEWER("Image Viever", 5.0),
    SOFTWARE_OFFICE_SUITE("Office Suite", 100.0),
    SOFTWARE_OTHER_OFFICE_SUITE("Other Office Suite", 40.0),
    SOFTWARE_MICROSOFT_OFFICE("Microsoft Office", 50.0),
    SOFTWARE_ACROBAT_READER("Acrobat Reader", 10.0),
    SOFTWARE_TOTAL_COMMANDER("Total Commander", 5.0);

    private final String value;
    private final Double additionPrice;

    ComputerSpec(String value, Double additionPrice) {
        this.value = value;
        this.additionPrice = additionPrice;
    }

    public String value() {
        return value;
    }

    public Double additionPrice() {
        return additionPrice;
    }

}
