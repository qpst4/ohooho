package defpackage;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fs0 {
    public static final fs0 b;
    public static final /* synthetic */ fs0[] c;

    static {
        fs0 fs0Var = new fs0("DEFAULT", 0);
        b = fs0Var;
        fs0 fs0Var2 = new fs0("UNMETERED_ONLY", 1);
        fs0 fs0Var3 = new fs0("UNMETERED_OR_DAILY", 2);
        fs0 fs0Var4 = new fs0("FAST_IF_RADIO_AWAKE", 3);
        fs0 fs0Var5 = new fs0("NEVER", 4);
        fs0 fs0Var6 = new fs0("UNRECOGNIZED", 5);
        c = new fs0[]{fs0Var, fs0Var2, fs0Var3, fs0Var4, fs0Var5, fs0Var6};
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, fs0Var);
        sparseArray.put(1, fs0Var2);
        sparseArray.put(2, fs0Var3);
        sparseArray.put(3, fs0Var4);
        sparseArray.put(4, fs0Var5);
        sparseArray.put(-1, fs0Var6);
    }

    public static fs0 valueOf(String str) {
        return (fs0) Enum.valueOf(fs0.class, str);
    }

    public static fs0[] values() {
        return (fs0[]) c.clone();
    }
}
