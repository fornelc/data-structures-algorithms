package com.algorithms.datastructures.strings;

import java.util.ArrayList;

/**
 * Source: https://www.algoexpert.io/questions/Valid%20IP%20Addresses
 */
public class ValidIPAddresses {
    public ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> ipAddresses = new ArrayList<>();
        for (int i = 1; i < Math.min(string.length(), 4); i++) { // to avoid an index error we calculate the min between 4 and the length of the string
            String[] ipElements = new String[]{"", "", "", ""};

            ipElements[0] = string.substring(0, i);

            if (!isValidString(ipElements[0])) {
                continue;
            }

            for (int j = i + 1; j < Math.min(string.length(), i + 4); j++) {
                ipElements[1] = string.substring(i, j);

                if (!isValidString(ipElements[1])) {
                    continue;
                }

                for (int k = j + 1; k < Math.min(string.length(), j + 4); k++) {
                    ipElements[2] = string.substring(j, k);
                    ipElements[3] = string.substring(k);

                    if (!isValidString(ipElements[2]) || !isValidString(ipElements[3])) {
                        continue;
                    }

                    ipAddresses.add(String.join(".", ipElements));
                }
            }
        }

        return ipAddresses;
    }

    private boolean isValidString(final String stringIpElement) {
        int ipElement = Integer.parseInt(stringIpElement);
        if (ipElement > 255) {
            return false;
        }
        return stringIpElement.equals(String.valueOf(ipElement)); // will return false if the input string contains leading zeros
    }
}
