package defpackage;

import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class aa1 implements ea1 {
    public final BitmapDrawable b;
    public final f91 c;
    public final db d;

    public aa1(f91 f91Var) {
        this.c = f91Var;
        this.d = f91Var.h();
        this.b = new BitmapDrawable(f91Var.d().g());
        b();
    }

    @Override // defpackage.s60
    public final boolean a() {
        return false;
    }

    @Override // defpackage.ea1
    public final void b() {
        db dbVar = this.d;
        this.b.setBounds(dbVar.d(), dbVar.e(), dbVar.f() + dbVar.d(), dbVar.c() + dbVar.e());
    }

    @Override // defpackage.s60
    public final boolean c() {
        return false;
    }

    @Override // defpackage.ea1
    public final void d(float f) {
        int i;
        f91 f91Var = this.c;
        e91 e91VarE = f91Var.e();
        e91 e91Var = e91.left;
        BitmapDrawable bitmapDrawable = this.b;
        db dbVar = this.d;
        if (e91VarE == e91Var || e91VarE == e91.right) {
            int iF = f91Var.h().f();
            int i2 = (int) (iF * f);
            i = e91VarE == e91.right ? iF - i2 : 0;
            bitmapDrawable.setBounds(dbVar.d() + i, dbVar.e(), dbVar.d() + i2 + i, dbVar.c() + dbVar.e());
            return;
        }
        int iC = f91Var.h().c();
        int i3 = (int) (iC * f);
        i = e91VarE == e91.bottom ? iC - i3 : 0;
        bitmapDrawable.setBounds(dbVar.d(), dbVar.e() + i, dbVar.f() + dbVar.d(), dbVar.e() + i3 + i);
    }

    @Override // defpackage.s60
    public final void draw(Canvas canvas) {
        this.b.draw(canvas);
    }

    @Override // defpackage.ea1
    public final void e(Integer num) {
        int iIntValue = num.intValue();
        db dbVar = this.d;
        int iC = iIntValue - dbVar.c();
        this.b.setBounds(dbVar.d(), iC, dbVar.f() + dbVar.d(), dbVar.c() + iC);
    }
}
