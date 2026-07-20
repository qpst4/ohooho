package defpackage;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class c1 implements cy {
    public final /* synthetic */ int b;
    public String c;

    public /* synthetic */ c1(c1 c1Var) {
        this.b = 3;
        this.c = c1Var.c;
    }

    public c1 b() {
        if (this.c != null) {
            return new c1(this);
        }
        zy.n("Product type must be set");
        return null;
    }

    @Override // defpackage.cy
    public boolean e(CharSequence charSequence, int i, int i2, uc1 uc1Var) {
        if (!TextUtils.equals(charSequence.subSequence(i, i2), this.c)) {
            return true;
        }
        uc1Var.c = (uc1Var.c & 3) | 4;
        return false;
    }

    public String toString() {
        switch (this.b) {
            case 4:
                return "<" + this.c + '>';
            default:
                return super.toString();
        }
    }

    public /* synthetic */ c1(int i) {
        this.b = i;
    }

    public /* synthetic */ c1(String str, int i) {
        this.b = i;
        this.c = str;
    }

    @Override // defpackage.cy
    public Object a() {
        return this;
    }
}
