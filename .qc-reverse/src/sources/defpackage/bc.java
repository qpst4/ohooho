package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bc implements kn0 {
    public static final bc a = new bc();
    public static final o10 b = o10.a("eventTimeMs");
    public static final o10 c = o10.a("eventCode");
    public static final o10 d = o10.a("eventUptimeMs");
    public static final o10 e = o10.a("sourceExtension");
    public static final o10 f = o10.a("sourceExtensionJsonProto3");
    public static final o10 g = o10.a("timezoneOffsetSeconds");
    public static final o10 h = o10.a("networkConnectionInfo");

    @Override // defpackage.sy
    public final void a(Object obj, Object obj2) {
        oi0 oi0Var = (oi0) obj;
        ln0 ln0Var = (ln0) obj2;
        ln0Var.d(b, ((ad) oi0Var).a);
        ad adVar = (ad) oi0Var;
        ln0Var.a(c, adVar.b);
        ln0Var.d(d, adVar.c);
        ln0Var.a(e, adVar.d);
        ln0Var.a(f, adVar.e);
        ln0Var.d(g, adVar.f);
        ln0Var.a(h, adVar.g);
    }
}
