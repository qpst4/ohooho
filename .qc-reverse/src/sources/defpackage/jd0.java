package defpackage;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class jd0 implements gb1 {
    public static final id0 d = new id0(0);
    public final c70 b;
    public final ConcurrentHashMap c = new ConcurrentHashMap();

    static {
        new id0(0);
    }

    public jd0(c70 c70Var) {
        this.b = c70Var;
    }

    @Override // defpackage.gb1
    public final fb1 a(i70 i70Var, mc1 mc1Var) {
        hd0 hd0Var = (hd0) mc1Var.a().getAnnotation(hd0.class);
        if (hd0Var == null) {
            return null;
        }
        return b(this.b, i70Var, mc1Var, hd0Var, true);
    }

    public final fb1 b(c70 c70Var, i70 i70Var, mc1 mc1Var, hd0 hd0Var, boolean z) {
        fb1 fb1VarA;
        Object objH = c70Var.i(new mc1(hd0Var.value()), true).h();
        boolean zNullSafe = hd0Var.nullSafe();
        if (objH instanceof fb1) {
            fb1VarA = (fb1) objH;
        } else {
            if (!(objH instanceof gb1)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objH.getClass().getName() + " as a @JsonAdapter for " + mc1Var.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            gb1 gb1Var = (gb1) objH;
            if (z) {
                gb1 gb1Var2 = (gb1) this.c.putIfAbsent(mc1Var.a(), gb1Var);
                if (gb1Var2 != null) {
                    gb1Var = gb1Var2;
                }
            }
            fb1VarA = gb1Var.a(i70Var, mc1Var);
        }
        return (fb1VarA == null || !zNullSafe) ? fb1VarA : fb1VarA.a();
    }
}
