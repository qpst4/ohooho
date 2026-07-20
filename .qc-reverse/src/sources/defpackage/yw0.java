package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yw0 {
    public oh1 a;
    public ArrayList b;

    public static long a(gt gtVar, long j) {
        oh1 oh1Var = gtVar.d;
        ArrayList arrayList = gtVar.k;
        if (oh1Var instanceof a80) {
            return j;
        }
        int size = arrayList.size();
        long jMin = j;
        for (int i = 0; i < size; i++) {
            et etVar = (et) arrayList.get(i);
            if (etVar instanceof gt) {
                gt gtVar2 = (gt) etVar;
                if (gtVar2.d != oh1Var) {
                    jMin = Math.min(jMin, a(gtVar2, ((long) gtVar2.f) + j));
                }
            }
        }
        gt gtVar3 = oh1Var.i;
        gt gtVar4 = oh1Var.h;
        if (gtVar != gtVar3) {
            return jMin;
        }
        long j2 = j - oh1Var.j();
        return Math.min(Math.min(jMin, a(gtVar4, j2)), j2 - ((long) gtVar4.f));
    }

    public static long b(gt gtVar, long j) {
        oh1 oh1Var = gtVar.d;
        ArrayList arrayList = gtVar.k;
        if (oh1Var instanceof a80) {
            return j;
        }
        int size = arrayList.size();
        long jMax = j;
        for (int i = 0; i < size; i++) {
            et etVar = (et) arrayList.get(i);
            if (etVar instanceof gt) {
                gt gtVar2 = (gt) etVar;
                if (gtVar2.d != oh1Var) {
                    jMax = Math.max(jMax, b(gtVar2, ((long) gtVar2.f) + j));
                }
            }
        }
        gt gtVar3 = oh1Var.h;
        gt gtVar4 = oh1Var.i;
        if (gtVar != gtVar3) {
            return jMax;
        }
        long j2 = oh1Var.j() + j;
        return Math.max(Math.max(jMax, b(gtVar4, j2)), j2 - ((long) gtVar4.f));
    }
}
