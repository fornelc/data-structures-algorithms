package com.algorithms.datastructures.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaesarCypherEncryptorTest {
    @Test
    public void caesarCypherEncryptor_returnStringModified() {
        assertEquals("zab", CaesarCypherEncryptor.caesarCypherEncryptor("xyz", 2));
    }

    @Test
    public void caesarCypherEncryptorUsingAlphabet_returnStringModified() {
        assertEquals("zab", CaesarCypherEncryptor.caesarCypherEncryptorUsingAlphabet("xyz", 2));
    }
}
