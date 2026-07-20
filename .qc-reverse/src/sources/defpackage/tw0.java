package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class tw0 extends fc0 {
    @Override // defpackage.fc0
    public final void t(wz0 wz0Var, float f, float f2) {
        wz0Var.d(f2 * f, 180.0f, 90.0f);
        float f3 = f2 * 2.0f * f;
        sz0 sz0Var = new sz0(0.0f, 0.0f, f3, f3);
        sz0Var.f = 180.0f;
        sz0Var.g = 90.0f;
        wz0Var.f.add(sz0Var);
        qz0 qz0Var = new qz0(sz0Var);
        wz0Var.a(180.0f);
        wz0Var.g.add(qz0Var);
        wz0Var.d = 270.0f;
        float f4 = (0.0f + f3) * 0.5f;
        float f5 = (f3 - 0.0f) / 2.0f;
        wz0Var.b = (((float) Math.cos(Math.toRadians(270.0d))) * f5) + f4;
        wz0Var.c = (f5 * ((float) Math.sin(Math.toRadians(270.0d)))) + f4;
    }
}
