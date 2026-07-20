package defpackage;

import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yy0 extends ai {
    public final transient byte[][] g;
    public final transient int[] h;

    public yy0(mh mhVar, int i) {
        super(null);
        ce1.a(mhVar.c, 0L, i);
        wy0 wy0Var = mhVar.b;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = wy0Var.c;
            int i6 = wy0Var.b;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            wy0Var = wy0Var.f;
        }
        this.g = new byte[i4][];
        this.h = new int[i4 * 2];
        wy0 wy0Var2 = mhVar.b;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.g;
            bArr[i7] = wy0Var2.a;
            int i8 = wy0Var2.c;
            int i9 = wy0Var2.b;
            int i10 = (i8 - i9) + i2;
            i2 = i10 > i ? i : i10;
            int[] iArr = this.h;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            wy0Var2.d = true;
            i7++;
            wy0Var2 = wy0Var2.f;
        }
    }

    @Override // defpackage.ai
    public final byte d(int i) {
        byte[][] bArr = this.g;
        int length = bArr.length - 1;
        int[] iArr = this.h;
        ce1.a(iArr[length], i, 1L);
        int iN = n(i);
        return bArr[iN][(i - (iN == 0 ? 0 : iArr[iN - 1])) + iArr[bArr.length + iN]];
    }

    @Override // defpackage.ai
    public final String e() {
        return o().e();
    }

    @Override // defpackage.ai
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ai)) {
            return false;
        }
        ai aiVar = (ai) obj;
        return aiVar.i() == i() && h(aiVar, i());
    }

    @Override // defpackage.ai
    public final boolean g(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0 && i <= i() - i3 && i2 >= 0 && i2 <= bArr.length - i3) {
            int iN = n(i);
            while (i3 > 0) {
                int[] iArr = this.h;
                int i4 = iN == 0 ? 0 : iArr[iN - 1];
                int iMin = Math.min(i3, ((iArr[iN] - i4) + i4) - i);
                byte[][] bArr2 = this.g;
                int i5 = (i - i4) + iArr[bArr2.length + iN];
                byte[] bArr3 = bArr2[iN];
                Charset charset = ce1.a;
                for (int i6 = 0; i6 < iMin; i6++) {
                    if (bArr3[i6 + i5] == bArr[i6 + i2]) {
                    }
                }
                i += iMin;
                i2 += iMin;
                i3 -= iMin;
                iN++;
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.ai
    public final boolean h(ai aiVar, int i) {
        if (i() - i >= 0) {
            int iN = n(0);
            int i2 = 0;
            int i3 = 0;
            while (i > 0) {
                int[] iArr = this.h;
                int i4 = iN == 0 ? 0 : iArr[iN - 1];
                int iMin = Math.min(i, ((iArr[iN] - i4) + i4) - i2);
                byte[][] bArr = this.g;
                if (aiVar.g(i3, bArr[iN], (i2 - i4) + iArr[bArr.length + iN], iMin)) {
                    i2 += iMin;
                    i3 += iMin;
                    i -= iMin;
                    iN++;
                }
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.ai
    public final int hashCode() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        byte[][] bArr = this.g;
        int length = bArr.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr2 = bArr[i2];
            int[] iArr = this.h;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr2[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.c = i3;
        return i3;
    }

    @Override // defpackage.ai
    public final int i() {
        return this.h[this.g.length - 1];
    }

    @Override // defpackage.ai
    public final ai j() {
        return o().j();
    }

    @Override // defpackage.ai
    public final ai k() {
        return o().k();
    }

    @Override // defpackage.ai
    public final String l() {
        return o().l();
    }

    @Override // defpackage.ai
    public final void m(mh mhVar) {
        byte[][] bArr = this.g;
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.h;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            wy0 wy0Var = new wy0(bArr[i], i3, (i3 + i4) - i2);
            wy0 wy0Var2 = mhVar.b;
            if (wy0Var2 == null) {
                wy0Var.g = wy0Var;
                wy0Var.f = wy0Var;
                mhVar.b = wy0Var;
            } else {
                wy0Var2.g.b(wy0Var);
            }
            i++;
            i2 = i4;
        }
        mhVar.c += (long) i2;
    }

    public final int n(int i) {
        int iBinarySearch = Arrays.binarySearch(this.h, 0, this.g.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    public final ai o() {
        byte[][] bArr = this.g;
        int length = bArr.length - 1;
        int[] iArr = this.h;
        byte[] bArr2 = new byte[iArr[length]];
        int length2 = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length2) {
            int i3 = iArr[length2 + i];
            int i4 = iArr[i];
            System.arraycopy(bArr[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return new ai(bArr2);
    }

    @Override // defpackage.ai
    public final String toString() {
        return o().toString();
    }
}
