package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class cl {
    public final byte[] a;
    public int b;
    public int c;
    public int d;
    public int e;
    public final int f;
    public int g = Integer.MAX_VALUE;
    public int h;

    public cl(byte[] bArr, int i, int i2, boolean z) {
        this.a = bArr;
        this.b = i2 + i;
        this.d = i;
        this.f = -i;
    }

    public final void a(int i) {
        if (this.e != i) {
            throw new ic0("Protocol message end-group tag did not match expected tag.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b() throws defpackage.ic0 {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cl.b():boolean");
    }

    public final zh c() throws ic0 {
        int iF = f();
        int i = this.b;
        int i2 = this.d;
        if (iF <= i - i2 && iF > 0) {
            zh zhVarC = zh.c(this.a, i2, iF);
            this.d += iF;
            return zhVarC;
        }
        if (iF == 0) {
            return zh.d;
        }
        byte[] bArrE = e(iF);
        zh zhVar = zh.d;
        return new zh(bArrE);
    }

    public final w50 d(q50 q50Var, w00 w00Var) throws ic0 {
        int iF = f();
        if (this.h >= 100) {
            throw new ic0("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        if (iF < 0) {
            throw new ic0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i = this.f + this.d + iF;
        int i2 = this.g;
        if (i > i2) {
            throw new ic0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.g = i;
        j();
        this.h++;
        w50 w50VarJ = w50.j(q50Var.a, this, w00Var);
        a(0);
        this.h--;
        this.g = i2;
        j();
        return w50VarJ;
    }

    public final byte[] e(int i) throws ic0 {
        if (i <= 0) {
            if (i == 0) {
                return ec0.b;
            }
            throw new ic0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i2 = this.d;
        int i3 = this.f;
        int i4 = i3 + i2 + i;
        if (i4 > 67108864) {
            throw new ic0("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }
        int i5 = this.g;
        if (i4 <= i5) {
            throw new ic0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        l((i5 - i3) - i2);
        throw new ic0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final int f() {
        int i;
        int i2 = this.d;
        int i3 = this.b;
        if (i3 != i2) {
            int i4 = i2 + 1;
            byte[] bArr = this.a;
            byte b = bArr[i2];
            if (b >= 0) {
                this.d = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    i = i6 ^ (-128);
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (i10 ^ (b2 << 28)) ^ 266354560;
                            if (b2 < 0) {
                                i9 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i9] < 0) {
                                        i9 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i9] < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i12;
                                                    i = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i11;
                            }
                            i = i11;
                        }
                        i5 = i9;
                    }
                    i5 = i7;
                }
                this.d = i5;
                return i;
            }
        }
        return (int) g();
    }

    public final long g() throws ic0 {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            int i2 = this.d;
            if (i2 == this.b) {
                m(1);
                throw new ic0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            this.d = i2 + 1;
            byte b = this.a[i2];
            j |= ((long) (b & 127)) << i;
            if ((b & 128) == 0) {
                return j;
            }
        }
        throw new ic0("CodedInputStream encountered a malformed varint.");
    }

    public final String h() throws ic0 {
        byte[] bArrE;
        int iF = f();
        int i = this.d;
        int i2 = this.b;
        if (iF <= i2 - i && iF > 0) {
            this.d = i + iF;
            bArrE = this.a;
        } else {
            if (iF == 0) {
                return "";
            }
            if (iF <= i2) {
                m(iF);
                throw new ic0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            bArrE = e(iF);
            i = 0;
        }
        if (zd1.a.x(bArrE, i, i + iF) == 0) {
            return new String(bArrE, i, iF, ec0.a);
        }
        throw new ic0("Protocol message had invalid UTF-8.");
    }

    public final int i() throws ic0 {
        if (this.d == this.b) {
            m(1);
            this.e = 0;
            return 0;
        }
        int iF = f();
        this.e = iF;
        if ((iF >>> 3) != 0) {
            return iF;
        }
        throw new ic0("Protocol message contained an invalid tag (zero).");
    }

    public final void j() {
        int i = this.b + this.c;
        this.b = i;
        int i2 = this.f + i;
        int i3 = this.g;
        if (i2 <= i3) {
            this.c = 0;
            return;
        }
        int i4 = i2 - i3;
        this.c = i4;
        this.b = i - i4;
    }

    public final boolean k(int i) throws ic0 {
        int i2;
        int i3 = i & 7;
        if (i3 != 0) {
            if (i3 == 1) {
                l(8);
                return true;
            }
            if (i3 == 2) {
                l(f());
                return true;
            }
            if (i3 != 3) {
                if (i3 == 4) {
                    return false;
                }
                if (i3 != 5) {
                    throw new ic0("Protocol message tag had invalid wire type.");
                }
                l(4);
                return true;
            }
            do {
                i2 = i();
                if (i2 == 0) {
                    break;
                }
            } while (k(i2));
            a(((i >>> 3) << 3) | 4);
            return true;
        }
        int i4 = this.b;
        int i5 = this.d;
        int i6 = i4 - i5;
        byte[] bArr = this.a;
        if (i6 >= 10) {
            int i7 = 0;
            while (i7 < 10) {
                int i8 = i5 + 1;
                if (bArr[i5] >= 0) {
                    this.d = i8;
                    return true;
                }
                i7++;
                i5 = i8;
            }
        }
        for (int i9 = 0; i9 < 10; i9++) {
            int i10 = this.d;
            if (i10 == this.b) {
                m(1);
                throw new ic0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            this.d = i10 + 1;
            if (bArr[i10] >= 0) {
                return true;
            }
        }
        throw new ic0("CodedInputStream encountered a malformed varint.");
    }

    public final void l(int i) throws ic0 {
        int i2 = this.b;
        int i3 = this.d;
        if (i <= i2 - i3 && i >= 0) {
            this.d = i3 + i;
            return;
        }
        if (i < 0) {
            throw new ic0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i4 = this.f;
        int i5 = i4 + i3 + i;
        int i6 = this.g;
        if (i5 > i6) {
            l((i6 - i4) - i3);
            throw new ic0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.d = i2;
        m(1);
        throw new ic0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final void m(int i) {
        if (this.d + i > this.b) {
            return;
        }
        throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
    }
}
