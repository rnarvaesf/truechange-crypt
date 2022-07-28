package br.com.truechange.security;

public interface Crypt {
    void setSize(int bits);
    void setSalt(String salt);
    String encrypt(String strToEncrypt) ;
    String encrypt(String strToEncrypt,String password) throws Exception;
    String decrypt(String strToDecrypt);
    String decrypt(String strToDecrypt,String password) throws Exception;
}
