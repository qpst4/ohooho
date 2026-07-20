package defpackage;

import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ke1 extends le1 {
    public final Matrix a;
    public final ArrayList b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public final Matrix j;
    public String k;

    public ke1(ke1 ke1Var, kb kbVar) {
        me1 ie1Var;
        this.a = new Matrix();
        this.b = new ArrayList();
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 1.0f;
        this.g = 1.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        Matrix matrix = new Matrix();
        this.j = matrix;
        this.k = null;
        this.c = ke1Var.c;
        this.d = ke1Var.d;
        this.e = ke1Var.e;
        this.f = ke1Var.f;
        this.g = ke1Var.g;
        this.h = ke1Var.h;
        this.i = ke1Var.i;
        String str = ke1Var.k;
        this.k = str;
        if (str != null) {
            kbVar.put(str, this);
        }
        matrix.set(ke1Var.j);
        ArrayList arrayList = ke1Var.b;
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof ke1) {
                this.b.add(new ke1((ke1) obj, kbVar));
            } else {
                if (obj instanceof je1) {
                    je1 je1Var = (je1) obj;
                    je1 je1Var2 = new je1(je1Var);
                    je1Var2.e = 0.0f;
                    je1Var2.g = 1.0f;
                    je1Var2.h = 1.0f;
                    je1Var2.i = 0.0f;
                    je1Var2.j = 1.0f;
                    je1Var2.k = 0.0f;
                    je1Var2.l = Paint.Cap.BUTT;
                    je1Var2.m = Paint.Join.MITER;
                    je1Var2.n = 4.0f;
                    je1Var2.d = je1Var.d;
                    je1Var2.e = je1Var.e;
                    je1Var2.g = je1Var.g;
                    je1Var2.f = je1Var.f;
                    je1Var2.c = je1Var.c;
                    je1Var2.h = je1Var.h;
                    je1Var2.i = je1Var.i;
                    je1Var2.j = je1Var.j;
                    je1Var2.k = je1Var.k;
                    je1Var2.l = je1Var.l;
                    je1Var2.m = je1Var.m;
                    je1Var2.n = je1Var.n;
                    ie1Var = je1Var2;
                } else {
                    if (!(obj instanceof ie1)) {
                        s1.f("Unknown object in the tree!");
                        throw null;
                    }
                    ie1Var = new ie1((ie1) obj);
                }
                this.b.add(ie1Var);
                Object obj2 = ie1Var.b;
                if (obj2 != null) {
                    kbVar.put(obj2, ie1Var);
                }
            }
        }
    }

    @Override // defpackage.le1
    public final boolean a() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.b;
            if (i >= arrayList.size()) {
                return false;
            }
            if (((le1) arrayList.get(i)).a()) {
                return true;
            }
            i++;
        }
    }

    @Override // defpackage.le1
    public final boolean b(int[] iArr) {
        int i = 0;
        boolean zB = false;
        while (true) {
            ArrayList arrayList = this.b;
            if (i >= arrayList.size()) {
                return zB;
            }
            zB |= ((le1) arrayList.get(i)).b(iArr);
            i++;
        }
    }

    public final void c() {
        Matrix matrix = this.j;
        matrix.reset();
        matrix.postTranslate(-this.d, -this.e);
        matrix.postScale(this.f, this.g);
        matrix.postRotate(this.c, 0.0f, 0.0f);
        matrix.postTranslate(this.h + this.d, this.i + this.e);
    }

    public String getGroupName() {
        return this.k;
    }

    public Matrix getLocalMatrix() {
        return this.j;
    }

    public float getPivotX() {
        return this.d;
    }

    public float getPivotY() {
        return this.e;
    }

    public float getRotation() {
        return this.c;
    }

    public float getScaleX() {
        return this.f;
    }

    public float getScaleY() {
        return this.g;
    }

    public float getTranslateX() {
        return this.h;
    }

    public float getTranslateY() {
        return this.i;
    }

    public void setPivotX(float f) {
        if (f != this.d) {
            this.d = f;
            c();
        }
    }

    public void setPivotY(float f) {
        if (f != this.e) {
            this.e = f;
            c();
        }
    }

    public void setRotation(float f) {
        if (f != this.c) {
            this.c = f;
            c();
        }
    }

    public void setScaleX(float f) {
        if (f != this.f) {
            this.f = f;
            c();
        }
    }

    public void setScaleY(float f) {
        if (f != this.g) {
            this.g = f;
            c();
        }
    }

    public void setTranslateX(float f) {
        if (f != this.h) {
            this.h = f;
            c();
        }
    }

    public void setTranslateY(float f) {
        if (f != this.i) {
            this.i = f;
            c();
        }
    }

    public ke1() {
        this.a = new Matrix();
        this.b = new ArrayList();
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 1.0f;
        this.g = 1.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = new Matrix();
        this.k = null;
    }
}
