package alvintest.filetype;

/**
 * Created by 001620 on 2014/10/18.
 */
public enum FileType {
    JPEG("FFDBFF"),
    PNG("89504E47"),
    GIF("47494638"),
    TIFF("49492A00"),
    BMP("424D"),
    DWG("41433130"),
    PSD("38425053"),
    XML("3C3F786D6C"),
    HTML("68746D6C3E"),
    PDF("255044462D312E"),
    ZIP("504B0304"),
    RAR("52617221"),
    WAV("57415645"),
    AVI("41564920");

    private String value = "";

    private FileType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
