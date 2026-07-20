package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class es {
    public static final /* synthetic */ int a = 0;

    static {
        String property;
        int i = v31.a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (!(property != null ? Boolean.parseBoolean(property) : false)) {
            ds dsVar = ds.l;
            return;
        }
        rs rsVar = iu.a;
        q70 q70Var = dj0.a;
        q70 q70Var2 = q70Var.f;
        if (q70Var == null) {
            ds dsVar2 = ds.l;
        }
    }
}
