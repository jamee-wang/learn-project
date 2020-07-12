package org.jamee.learn.algorithm.hash;

/**
 * FNV1a 32 and 64 bit variant
 * 32 bit Java port of http://www.isthe.com/chongo/src/fnv/hash_32a.c
 * 64 bit Java port of http://www.isthe.com/chongo/src/fnv/hash_64a.c
 *
 * FNV hashes are designed to be fast while maintaining a low collision rate.
 * The FNV speed allows one to quickly hash lots of data while maintaining a reasonable collision rate.
 * The high dispersion of the FNV hashes makes them well suited for hashing nearly identical strings
 * such as URLs, hostnames, filenames, text, IP addresses, etc.
 */
public class FNV1a {
    private static final int FNV1_32_INIT = 0x811c9dc5;
    private static final int FNV1_PRIME_32 = 16777619;
    private static final long FNV1_64_INIT = 0xcbf29ce484222325L;
    private static final long FNV1_PRIME_64 = 1099511628211L;

    /**
     * FNV1a 32 bit variant.
     *
     * @param data   - input byte array
     * @return - hashcode
     */
    public static int hash32(byte[] data) {
        int hash = FNV1_32_INIT;
        for (byte datum : data) {
            hash ^= (datum & 0xff);
            hash *= FNV1_PRIME_32;
        }

        return hash;
    }
    /**
     * FNV1a 64 bit variant.
     *
     * @param data   - input byte array
     * @return - hashcode
     */
    public static long hash64(byte[] data) {
        long hash = FNV1_64_INIT;
        int length = data.length;
        for (byte datum : data) {
            hash ^= (datum & 0xff);
            hash *= FNV1_PRIME_64;
        }

        return hash;
    }

    public static void main(String[] args) {
        String url = "https://www.google.com/chrome/thank-you.html?brand=CHWL&statcb=0&installdataindex=empty&defaultbrowser=0";
        System.out.println("fnv1a: " + FNV1a.hash32(url.getBytes()));
        String ip = "172.16.96.17";
        System.out.println("fnv1a: " + FNV1a.hash32(ip.getBytes()));
        String hostName = "ubuntu18";
        System.out.println("fnv1a: " + FNV1a.hash64(hostName.getBytes()));
    }
}