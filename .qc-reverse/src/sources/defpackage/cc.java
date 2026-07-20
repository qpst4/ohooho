package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class cc implements kn0 {
    public static final cc a = new cc();
    public static final o10 b = o10.a("requestTimeMs");
    public static final o10 c = o10.a("requestUptimeMs");
    public static final o10 d = o10.a("clientInfo");
    public static final o10 e = o10.a("logSource");
    public static final o10 f = o10.a("logSourceName");
    public static final o10 g = o10.a("logEvent");
    public static final o10 h = o10.a("qosTier");

    @Override // defpackage.sy
    public final void a(Object obj, Object obj2) {
        ri0 ri0Var = (ri0) obj;
        ln0 ln0Var = (ln0) obj2;
        ln0Var.d(b, ((bd) ri0Var).a);
        bd bdVar = (bd) ri0Var;
        ln0Var.d(c, bdVar.b);
        ln0Var.a(d, bdVar.c);
        ln0Var.a(e, bdVar.d);
        ln0Var.a(f, bdVar.e);
        ln0Var.a(g, bdVar.f);
        ln0Var.a(h, fs0.b);
    }
}
