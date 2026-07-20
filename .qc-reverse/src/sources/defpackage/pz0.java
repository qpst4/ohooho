package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class pz0 extends vz0 {
    public final /* synthetic */ ArrayList c;
    public final /* synthetic */ Matrix d;

    public pz0(ArrayList arrayList, Matrix matrix) {
        this.c = arrayList;
        this.d = matrix;
    }

    @Override // defpackage.vz0
    public final void a(Matrix matrix, kz0 kz0Var, int i, Canvas canvas) {
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((vz0) obj).a(this.d, kz0Var, i, canvas);
        }
    }
}
