package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xo1 extends yo1 {
    public final int e;

    public xo1(int i, byte[] bArr) {
        super(bArr);
        yo1.e(0, i, bArr.length);
        this.e = i;
    }

    @Override // defpackage.yo1
    public final byte b(int i) {
        int i2 = this.e;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.c[i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(qq0.i("Index < 0: ", i));
        }
        throw new ArrayIndexOutOfBoundsException(qq0.h(i, i2, "Index > length: ", ", "));
    }

    @Override // defpackage.yo1
    public final byte c(int i) {
        return this.c[i];
    }

    @Override // defpackage.yo1
    public final int d() {
        return this.e;
    }
}
