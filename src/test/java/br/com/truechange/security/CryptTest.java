package br.com.truechange.security;
import br.com.truechange.security.impl.Aes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.WithAssertions;

public class CryptTest implements WithAssertions{

    @Test
    void givenPassword_whenEncrypt_thenSuccess()
            throws Exception{
        Aes crypt = new Aes(256);
        //given
        String encryp1 = crypt.encrypt("truechange","12312312312");
        String decryp1 = crypt.decrypt(encryp1,"12312312312");
        System.out.println(encryp1);
        //then
        Assertions.assertEquals("truechange",decryp1);
    }
}
