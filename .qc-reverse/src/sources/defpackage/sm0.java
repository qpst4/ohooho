package defpackage;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class sm0 {
    public static final SparseArray b;
    public static final /* synthetic */ sm0[] c;

    /* JADX INFO: Fake field, exist only in values array */
    sm0 EF1;

    static {
        sm0 sm0Var = new sm0("UNKNOWN_MOBILE_SUBTYPE", 0);
        sm0 sm0Var2 = new sm0("GPRS", 1);
        sm0 sm0Var3 = new sm0("EDGE", 2);
        sm0 sm0Var4 = new sm0("UMTS", 3);
        sm0 sm0Var5 = new sm0("CDMA", 4);
        sm0 sm0Var6 = new sm0("EVDO_0", 5);
        sm0 sm0Var7 = new sm0("EVDO_A", 6);
        sm0 sm0Var8 = new sm0("RTT", 7);
        sm0 sm0Var9 = new sm0("HSDPA", 8);
        sm0 sm0Var10 = new sm0("HSUPA", 9);
        sm0 sm0Var11 = new sm0("HSPA", 10);
        sm0 sm0Var12 = new sm0("IDEN", 11);
        sm0 sm0Var13 = new sm0("EVDO_B", 12);
        sm0 sm0Var14 = new sm0("LTE", 13);
        sm0 sm0Var15 = new sm0("EHRPD", 14);
        sm0 sm0Var16 = new sm0("HSPAP", 15);
        sm0 sm0Var17 = new sm0("GSM", 16);
        sm0 sm0Var18 = new sm0("TD_SCDMA", 17);
        sm0 sm0Var19 = new sm0("IWLAN", 18);
        sm0 sm0Var20 = new sm0("LTE_CA", 19);
        c = new sm0[]{sm0Var, sm0Var2, sm0Var3, sm0Var4, sm0Var5, sm0Var6, sm0Var7, sm0Var8, sm0Var9, sm0Var10, sm0Var11, sm0Var12, sm0Var13, sm0Var14, sm0Var15, sm0Var16, sm0Var17, sm0Var18, sm0Var19, sm0Var20, new sm0("COMBINED", 20)};
        SparseArray sparseArray = new SparseArray();
        b = sparseArray;
        sparseArray.put(0, sm0Var);
        sparseArray.put(1, sm0Var2);
        sparseArray.put(2, sm0Var3);
        sparseArray.put(3, sm0Var4);
        sparseArray.put(4, sm0Var5);
        sparseArray.put(5, sm0Var6);
        sparseArray.put(6, sm0Var7);
        sparseArray.put(7, sm0Var8);
        sparseArray.put(8, sm0Var9);
        sparseArray.put(9, sm0Var10);
        sparseArray.put(10, sm0Var11);
        sparseArray.put(11, sm0Var12);
        sparseArray.put(12, sm0Var13);
        sparseArray.put(13, sm0Var14);
        sparseArray.put(14, sm0Var15);
        sparseArray.put(15, sm0Var16);
        sparseArray.put(16, sm0Var17);
        sparseArray.put(17, sm0Var18);
        sparseArray.put(18, sm0Var19);
        sparseArray.put(19, sm0Var20);
    }

    public static sm0 valueOf(String str) {
        return (sm0) Enum.valueOf(sm0.class, str);
    }

    public static sm0[] values() {
        return (sm0[]) c.clone();
    }
}
