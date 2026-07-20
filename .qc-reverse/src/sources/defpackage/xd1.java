package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xd1 extends tk0 {
    public final /* synthetic */ int l;

    public /* synthetic */ xd1(int i) {
        this.l = i;
    }

    public static int b0(long j, byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            tk0 tk0Var = zd1.a;
            if (i > -12) {
                return -1;
            }
            return i;
        }
        if (i2 == 1) {
            return zd1.c(i, md1.c(bArr, j));
        }
        if (i2 == 2) {
            return zd1.d(i, md1.c(bArr, j), md1.c(bArr, j + 1));
        }
        throw new AssertionError();
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x018e  */
    @Override // defpackage.tk0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int g(java.lang.String r26, byte[] r27, int r28, int r29) {
        /*
            Method dump skipped, instruction units count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xd1.g(java.lang.String, byte[], int, int):int");
    }

    @Override // defpackage.tk0
    public final int x(byte[] bArr, int i, int i2) {
        int i3;
        int i4 = i;
        switch (this.l) {
            case 0:
                break;
            default:
                if ((i4 | i2 | (bArr.length - i2)) < 0) {
                    throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i4), Integer.valueOf(i2)));
                }
                long j = md1.d;
                long j2 = ((long) i4) + j;
                int i5 = (int) ((j + ((long) i2)) - j2);
                long j3 = 1;
                if (i5 < 16) {
                    i3 = 0;
                } else {
                    int i6 = ((int) j2) & 7;
                    int i7 = i6;
                    long j4 = j2;
                    while (true) {
                        if (i7 > 0) {
                            long j5 = j4 + 1;
                            if (md1.c(bArr, j4) < 0) {
                                i3 = i6 - i7;
                            } else {
                                i7--;
                                j4 = j5;
                            }
                        } else {
                            int i8 = i5 - i6;
                            while (i8 >= 8 && (md1.d(bArr, j4) & (-9187201950435737472L)) == 0) {
                                j4 += 8;
                                i8 -= 8;
                            }
                            i3 = i5 - i8;
                        }
                    }
                }
                int i9 = i5 - i3;
                long j6 = j2 + ((long) i3);
                while (true) {
                    byte bC = 0;
                    while (true) {
                        if (i9 > 0) {
                            long j7 = j6 + j3;
                            bC = md1.c(bArr, j6);
                            if (bC >= 0) {
                                i9--;
                                j6 = j7;
                            } else {
                                j6 = j7;
                            }
                        }
                    }
                    if (i9 == 0) {
                        return 0;
                    }
                    int i10 = i9 - 1;
                    if (bC < -32) {
                        if (i10 == 0) {
                            return bC;
                        }
                        i9 -= 2;
                        if (bC >= -62) {
                            long j8 = j6 + j3;
                            if (md1.c(bArr, j6) <= -65) {
                                j6 = j8;
                                j3 = 1;
                            }
                        }
                    } else if (bC < -16) {
                        if (i10 < 2) {
                            return b0(j6, bArr, bC, i10);
                        }
                        i9 -= 3;
                        long j9 = j6 + j3;
                        byte bC2 = md1.c(bArr, j6);
                        if (bC2 <= -65 && ((bC != -32 || bC2 >= -96) && (bC != -19 || bC2 < -96))) {
                            j6 += 2;
                            if (md1.c(bArr, j9) <= -65) {
                                j3 = 1;
                            }
                        }
                    } else {
                        if (i10 < 3) {
                            return b0(j6, bArr, bC, i10);
                        }
                        i9 -= 4;
                        long j10 = j6 + j3;
                        byte bC3 = md1.c(bArr, j6);
                        if (bC3 <= -65) {
                            if ((((bC3 + 112) + (bC << 28)) >> 30) == 0) {
                                long j11 = j6 + 2;
                                if (md1.c(bArr, j10) <= -65) {
                                    j6 += 3;
                                    if (md1.c(bArr, j11) <= -65) {
                                        j3 = 1;
                                    }
                                }
                            }
                        }
                    }
                }
                return -1;
        }
        while (i4 < i2 && bArr[i4] >= 0) {
            i4++;
        }
        if (i4 < i2) {
            while (i4 < i2) {
                int i11 = i4 + 1;
                byte b = bArr[i4];
                if (b < 0) {
                    if (b < -32) {
                        if (i11 >= i2) {
                            return b;
                        }
                        if (b >= -62) {
                            i4 += 2;
                            if (bArr[i11] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b < -16) {
                        if (i11 >= i2 - 1) {
                            return zd1.a(bArr, i11, i2);
                        }
                        int i12 = i4 + 2;
                        byte b2 = bArr[i11];
                        if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                            i4 += 3;
                            if (bArr[i12] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (i11 >= i2 - 2) {
                        return zd1.a(bArr, i11, i2);
                    }
                    int i13 = i4 + 2;
                    byte b3 = bArr[i11];
                    if (b3 <= -65) {
                        if ((((b3 + 112) + (b << 28)) >> 30) == 0) {
                            int i14 = i4 + 3;
                            if (bArr[i13] <= -65) {
                                i4 += 4;
                                if (bArr[i14] > -65) {
                                }
                            }
                        }
                    }
                    return -1;
                }
                i4 = i11;
            }
        }
        return 0;
    }
}
