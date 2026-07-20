package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class uf {
    public final Bitmap a;
    public final Uri b;
    public final Exception c;
    public final int d;

    public uf(Bitmap bitmap, Uri uri, Exception exc, int i) {
        this.a = bitmap;
        this.b = uri;
        this.c = exc;
        this.d = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof uf)) {
            return false;
        }
        uf ufVar = (uf) obj;
        return fc0.b(this.a, ufVar.a) && fc0.b(this.b, ufVar.b) && fc0.b(this.c, ufVar.c) && this.d == ufVar.d;
    }

    public final int hashCode() {
        Bitmap bitmap = this.a;
        int iHashCode = (bitmap == null ? 0 : bitmap.hashCode()) * 31;
        Uri uri = this.b;
        int iHashCode2 = (iHashCode + (uri == null ? 0 : uri.hashCode())) * 31;
        Exception exc = this.c;
        return Integer.hashCode(this.d) + ((iHashCode2 + (exc != null ? exc.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "Result(bitmap=" + this.a + ", uri=" + this.b + ", error=" + this.c + ", sampleSize=" + this.d + ")";
    }
}
