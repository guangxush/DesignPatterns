package strategy.example;

import java.io.File;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public interface EncryptStrategy {
    void encryptFile(File file);
    String decryptFile(File file);
}
