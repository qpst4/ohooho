package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bg {
    public final Uri a;
    public final Bitmap b;
    public final int c;
    public final int d;
    public final boolean e;
    public final boolean f;
    public final Exception g;

    public bg(Uri uri, Bitmap bitmap, int i, int i2, boolean z, boolean z2, Exception exc) {
        this.a = uri;
        this.b = bitmap;
        this.c = i;
        this.d = i2;
        this.e = z;
        this.f = z2;
        this.g = exc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bg)) {
            return false;
        }
        bg bgVar = (bg) obj;
        return this.a.equals(bgVar.a) && fc0.b(this.b, bgVar.b) && this.c == bgVar.c && this.d == bgVar.d && this.e == bgVar.e && this.f == bgVar.f && fc0.b(this.g, bgVar.g);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Bitmap bitmap = this.b;
        int iHashCode2 = (Boolean.hashCode(this.f) + ((Boolean.hashCode(this.e) + l11.g(this.d, l11.g(this.c, (iHashCode + (bitmap == null ? 0 : bitmap.hashCode())) * 31, 31), 31)) * 31)) * 31;
        Exception exc = this.g;
        return iHashCode2 + (exc != null ? exc.hashCode() : 0);
    }

    public final String toString() {
        return "Result(uri=" + this.a + ", bitmap=" + this.b + ", loadSampleSize=" + this.c + ", degreesRotated=" + this.d + ", flipHorizontally=" + this.e + ", flipVertically=" + this.f + ", error=" + this.g + ")";
    }
}
