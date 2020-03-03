package cn.panjin.shenxianbms.tool.dynamic;

import java.net.URI;
import javax.tools.SimpleJavaFileObject;

public class JavaSourceFromCodeString extends SimpleJavaFileObject {
    final String code;

    public JavaSourceFromCodeString(String name, String code) {
        super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
        this.code = code;
    }

    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return this.code;
    }
}