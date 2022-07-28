package br.com.truechange.security.impl;

import br.com.truechange.security.Crypt;
import br.com.truechange.utils.AesUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Aes implements Crypt {

    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";

    public  Aes(){}
    public  Aes(int bits) {
        setSize(bits);
    }
    @Override
    public void setSize(int bits) {
        AesUtil.setSize(bits);
    }

    @Override
    public void setSalt(String salt) {
        AesUtil.setSalt(salt);
    }

    @Override
    public String encrypt(String strToEncrypt) {

        try {
            return AesUtil.encrypt(ALGORITHM, strToEncrypt);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String encrypt(String strToEncrypt, String password) throws Exception {
        try {
            return AesUtil.encryptPasswordBased(strToEncrypt, password);
        } catch (Exception e) {
            throw new Exception("Error while encrypting:"+e);
        }
    }

    @Override
    public String decrypt(String strToDecrypt) {
        try {
            return AesUtil.decrypt(ALGORITHM, strToDecrypt);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String decrypt(String strToDecrypt, String password) throws Exception{
        try {
            return AesUtil.decryptPasswordBased(strToDecrypt, password);
        } catch (Exception e) {
            throw new Exception("Error while decrypting:"+e);
        }

    }
}
