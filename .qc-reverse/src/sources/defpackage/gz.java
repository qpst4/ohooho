package defpackage;

import android.content.res.TypedArray;
import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gz {
    public final SparseArray a = new SparseArray();
    public final hz b;
    public final int c;
    public final int d;

    public gz(hz hzVar, ra raVar) {
        this.b = hzVar;
        TypedArray typedArray = (TypedArray) raVar.c;
        this.c = typedArray.getResourceId(28, 0);
        this.d = typedArray.getResourceId(52, 0);
    }
}
