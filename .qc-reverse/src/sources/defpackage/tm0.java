package defpackage;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class tm0 {
    public static final SparseArray b;
    public static final /* synthetic */ tm0[] c;

    /* JADX INFO: Fake field, exist only in values array */
    tm0 EF1;

    static {
        tm0 tm0Var = new tm0("MOBILE", 0);
        tm0 tm0Var2 = new tm0("WIFI", 1);
        tm0 tm0Var3 = new tm0("MOBILE_MMS", 2);
        tm0 tm0Var4 = new tm0("MOBILE_SUPL", 3);
        tm0 tm0Var5 = new tm0("MOBILE_DUN", 4);
        tm0 tm0Var6 = new tm0("MOBILE_HIPRI", 5);
        tm0 tm0Var7 = new tm0("WIMAX", 6);
        tm0 tm0Var8 = new tm0("BLUETOOTH", 7);
        tm0 tm0Var9 = new tm0("DUMMY", 8);
        tm0 tm0Var10 = new tm0("ETHERNET", 9);
        tm0 tm0Var11 = new tm0("MOBILE_FOTA", 10);
        tm0 tm0Var12 = new tm0("MOBILE_IMS", 11);
        tm0 tm0Var13 = new tm0("MOBILE_CBS", 12);
        tm0 tm0Var14 = new tm0("WIFI_P2P", 13);
        tm0 tm0Var15 = new tm0("MOBILE_IA", 14);
        tm0 tm0Var16 = new tm0("MOBILE_EMERGENCY", 15);
        tm0 tm0Var17 = new tm0("PROXY", 16);
        tm0 tm0Var18 = new tm0("VPN", 17);
        tm0 tm0Var19 = new tm0("NONE", 18);
        c = new tm0[]{tm0Var, tm0Var2, tm0Var3, tm0Var4, tm0Var5, tm0Var6, tm0Var7, tm0Var8, tm0Var9, tm0Var10, tm0Var11, tm0Var12, tm0Var13, tm0Var14, tm0Var15, tm0Var16, tm0Var17, tm0Var18, tm0Var19};
        SparseArray sparseArray = new SparseArray();
        b = sparseArray;
        sparseArray.put(0, tm0Var);
        sparseArray.put(1, tm0Var2);
        sparseArray.put(2, tm0Var3);
        sparseArray.put(3, tm0Var4);
        sparseArray.put(4, tm0Var5);
        sparseArray.put(5, tm0Var6);
        sparseArray.put(6, tm0Var7);
        sparseArray.put(7, tm0Var8);
        sparseArray.put(8, tm0Var9);
        sparseArray.put(9, tm0Var10);
        sparseArray.put(10, tm0Var11);
        sparseArray.put(11, tm0Var12);
        sparseArray.put(12, tm0Var13);
        sparseArray.put(13, tm0Var14);
        sparseArray.put(14, tm0Var15);
        sparseArray.put(15, tm0Var16);
        sparseArray.put(16, tm0Var17);
        sparseArray.put(17, tm0Var18);
        sparseArray.put(-1, tm0Var19);
    }

    public static tm0 valueOf(String str) {
        return (tm0) Enum.valueOf(tm0.class, str);
    }

    public static tm0[] values() {
        return (tm0[]) c.clone();
    }
}
