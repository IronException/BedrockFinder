package net.daporkchop.bedrock.mode;

import net.daporkchop.bedrock.Bedrock;

/**
 * @author DaPorkchop_
 */
public class Super {
    public static boolean super_sub_chunk_match(byte[] sub, char rows, char cols, long x, long z) {
        byte[] bchunk = fill3x3(x, z);

        boolean match;
        for (int m = 0; m <= 48 - rows; m++) {
            for (int n = 0; n <= 48 - cols; n++) {
                match = true;
                for (int i = 0; match && i < rows; i++) {
                    for (int j = 0; match && j < cols; j++) {
                        if (sub[i * cols + j] != bchunk[(m + i) * 48 + (n + j)]) {
                            match = false;
                        }
                    }
                }
                if (match) {
                    Bedrock.sub_match_x = m;
                    Bedrock.sub_match_z = n;

                    return true;
                }
            }
        }

        return false;
    }

    public static byte[] fill3x3(long x, long z) {
        byte[] bchunk = Bedrock.chunkPattern_super.get();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                long seed = ((x + j) * 341873128712L + (z + i) * 132897987541L) ^ 0x5DEECE66DL;
                for (int a = 0; a < 16; ++a) {
                    for (int b = 0; b < 16; ++b) {
                        seed = seed * 709490313259657689L + 1748772144486964054L;
                        seed = seed & ((1L << 48L) - 1L);

                        if (4 <= (seed >> 17) % 5) {
                            bchunk[(16 * (i + 1) + a) * 48 + (16 * (j + 1) + b)] = 1;
                        } else {
                            bchunk[(16 * (i + 1) + a) * 48 + (16 * (j + 1) + b)] = 0;
                        }

                        seed = seed * 5985058416696778513L + -8542997297661424380L;
                    }
                }
            }
        }

        return bchunk;
    }
}
