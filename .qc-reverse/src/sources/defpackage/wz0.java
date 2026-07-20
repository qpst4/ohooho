package defpackage;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wz0 {
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public final ArrayList f = new ArrayList();
    public final ArrayList g = new ArrayList();

    public wz0() {
        d(0.0f, 270.0f, 0.0f);
    }

    public final void a(float f) {
        float f2 = this.d;
        if (f2 == f) {
            return;
        }
        float f3 = ((f - f2) + 360.0f) % 360.0f;
        if (f3 > 180.0f) {
            return;
        }
        float f4 = this.b;
        float f5 = this.c;
        sz0 sz0Var = new sz0(f4, f5, f4, f5);
        sz0Var.f = this.d;
        sz0Var.g = f3;
        this.g.add(new qz0(sz0Var));
        this.d = f;
    }

    public final void b(Matrix matrix, Path path) {
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((uz0) arrayList.get(i)).a(matrix, path);
        }
    }

    public final void c(float f, float f2) {
        tz0 tz0Var = new tz0();
        tz0Var.b = f;
        tz0Var.c = f2;
        this.f.add(tz0Var);
        rz0 rz0Var = new rz0(tz0Var, this.b, this.c);
        float fB = rz0Var.b() + 270.0f;
        float fB2 = rz0Var.b() + 270.0f;
        a(fB);
        this.g.add(rz0Var);
        this.d = fB2;
        this.b = f;
        this.c = f2;
    }

    public final void d(float f, float f2, float f3) {
        this.a = f;
        this.b = 0.0f;
        this.c = f;
        this.d = f2;
        this.e = (f2 + f3) % 360.0f;
        this.f.clear();
        this.g.clear();
    }
}
