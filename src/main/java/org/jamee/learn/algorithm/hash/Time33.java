package org.jamee.learn.algorithm.hash;

/**
 * Created by hai on 2018/4/15.
 */
public class Time33 {
    /**
     * This is the popular `times 33' hash algorithm which is used by
     * perl and also appears in Berkeley DB. This is one of the best
     * known hash functions for strings because it is both computed
     * very fast and distributes very well.
     * <p>
     * The originator may be Dan Bernstein but the code in Berkeley DB
     * cites Chris Torek as the source. The best citation I have found
     * is "Chris Torek, Hash function for text in C, Usenet message
     * <27038@mimsy.umd.edu> in comp.lang.c , October, 1990." in Rich
     * Salz's USENIX 1992 paper about INN which can be found at
     * <http://citeseer.nj.nec.com/salz92internetnews.html>.
     * <p>
     * The magic of number 33, i.e. why it works better than many other
     * constants, prime or not, has never been adequately explained by
     * anyone. So I try an explanation: if one experimentally tests all
     * multipliers between 1 and 256 (as I did while writing a low-level
     * data structure library some time ago) one detects that even
     * numbers are not useable at all. The remaining 128 odd numbers
     * (except for the number 1) work more or less all equally well.
     * They all distribute in an acceptable way and this way fill a hash
     * table with an average percent of approx. 86%.
     * <p>
     * If one compares the chi^2 values of the variants (see
     * Bob Jenkins ``Hashing Frequently Asked Questions'' at
     * http://burtleburtle.net/bob/hash/hashfaq.html for a description
     * of chi^2), the number 33 not even has the best value. But the
     * number 33 and a few other equally good numbers like 17, 31, 63,
     * 127 and 129 have nevertheless a great advantage to the remaining
     * numbers in the large set of possible multipliers: their multiply
     * operation can be replaced by a faster operation based on just one
     * shift plus either a single addition or subtraction operation. And
     * because a hash function has to both distribute good _and_ has to
     * be very fast to compute, those few numbers should be preferred.
     * <p>
     * -- Ralf S. Engelschall <rse@engelschall.com>
     */
    public static long time33(String str) {
        long hash = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            hash = ((hash << 5) + hash) + str.charAt(i);
        }
        return hash;
    }

    public static void main(String[] args) {
        String str = "This is the popular `times 33' hash algorithm which is used by\n" +
                "     * perl and also appears in Berkeley DB. This is one of the best\n" +
                "     * known hash functions for strings because it is both computed\n" +
                "     * very fast and distributes very well.";
        System.out.println("time33: " + time33(str));
    }
}
